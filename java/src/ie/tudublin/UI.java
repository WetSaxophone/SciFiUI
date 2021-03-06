package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class UI extends PApplet
{
    public float starSpeed;
    public float planetsPassed;

    Button b;
    Radar radar;
    Star[] stars = new Star[400];
    Planet planet;
    Fuel fuel;
    public int planetN = 0;



    boolean[] keys = new boolean[1024];

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    
    public void keyReleased()
    {
        keys[keyCode] = true;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    

    public void settings()
    {
        
        size(1500, 800);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen(); 
    }

    public void setup()
    {
        loadData();
        //printPlanets();

        for(int i = 0; i < stars.length; i++)
        {
            stars[i] = new Star(this, random(-width,width), random(-height, height), random(150));
            
        }

        radar = new Radar(this, 1, width - border*4, border*4, 100);

        b = new Button(this, border*2, border*2, 200, 50, "Click Here To Refuel");

        fuel = new Fuel(this);

    }

    public void loadData()
    {
        Table table = loadTable("Habitats.csv", "header");

        for (TableRow row : table.rows()) 
        {
            planet = new Planet(this, row, random(-width,width), random(-height, height), random(50));
            planets.add(planet);

        }
    }

    public void printPlanets() {
        for (Planet planet : planets) {
            System.out.println(planet);
        }
    }

    float border = 50;
    float circle1 = 300;
    float circle2 = 420;
    float circle3 = 435;

    public void drawUI()
    {
        stroke(255);

        noFill();
        strokeWeight((float) 1.5);
        ellipse(width/2, height/2, circle3, circle3);
        ellipse(width/2, height/2, circle2, circle2);
        ellipse(width/2, height/2, circle1, circle1);

        line(border, border, border*2, border);
        line(border, border, border, border*2);
        line(border, height - border, border*2, height - border);
        line(border, height - border, border, (height - border) - border);
        line(width - border, border, width - border, border*2);
        line(width - border, border, width - border*2, border);
        line(width - border, height - border, width - border*2, height - border);
        line(width - border, height - border, width - border, height - border*2);

        line(border, height/2, width - border, height/2);

        line(width/2 - border*(float)1.5, height/2 - border, width/2 - border*(float)1.5, height/2 + border);
        line(width/2 + border*(float)1.5, height/2 - border, width/2 + border*(float)1.5, height/2 + border);

        line(width/2 - border, height/2 - border, width/2 + border, height/2 - border);
        line(width/2 - border, height/2 + border, width/2 + border, height/2 + border);
    }

    public void drawStars()
    {
        pushMatrix();
        translate(width/2, height/2);
        if(fuel.getCurrentFuel() < 249)
        {
            for(int i = 0; i < stars.length; i++)
            {
                stars[i].update(map(mouseX, 0, width, 0, 10));
                stars[i].render();
            }
        }
        else
        {
            for(int i = 0; i < stars.length; i++)
            {
                stars[i].update((float)0.07);
                stars[i].render();
            }
        }
        
        popMatrix();
    }

    public void drawPlanets()
    {

        pushMatrix();
        translate(width/2, height/2);
        if(fuel.getCurrentFuel() < 249)
        {
            planet.update(map(mouseX, 0, width, 0, 1));
            planet.render();
        }
        else
        {
            planet.update(map(mouseX, 0, width, 0, (float)0.03));
            planet.render();
        }
        popMatrix();

    
        float x = border;
        float y = height/2 - border/2;
        fill(255);
        textSize(30);
        textAlign(LEFT, CENTER);
        text("Planets Passed: " + planet.getPlanetsPassed(), x, y);

        text("Planet Name: " + planets.get(planetN).getDisplayName(), x, y - border);

        textSize(14);

    }


    public void drawRadar()
    {
        fill(0);
        noStroke();
        //map planets to radar
        float sx = map(planet.getX() / planet.getZ(), 0, border, width - border*4, width - border*4 + radar.getRadius());
        float sy = map(planet.getY() / planet.getZ(), 0, border, border*4, border*4 + radar.getRadius());
        fill(0, 255, 50);
        ellipse(sx, sy, 12, 12);
        pushMatrix();
        radar.update();
        radar.render();
        popMatrix();
    }

    int value = 0;


    public void drawFuel()
    {
        
        fuel.update(map(mouseX, 0, width, 0, (float)0.5));
        fuel.render();
        fill(255);
        textSize(18);
        textAlign(CENTER, CENTER);
        if(fuel.getCurrentFuel() < 100)
        {
            text("Fuel Level: High", width - border * 4, height - border*(float)7.5);
        }
        if((fuel.getCurrentFuel() > 101) && (fuel.getCurrentFuel() < 199))
        {
            text("Fuel Level: Medium", width - border * 4, height - border*(float)7.5);
        }
        if((fuel.getCurrentFuel() > 200) && (fuel.getCurrentFuel() < 249))
        {
            textSize(22);
            fill(240,0,0);
            text("Fuel Level: Low", width - border * 4, height - border*(float)7.5);
        }
        if(fuel.getCurrentFuel() == 250)
        {
            textSize(22);
            fill(240,0,0);
            text("Fuel Level: Empty", width - border * 4, height - border*(float)7.5);
        }
        textSize(18);
        fill(255);

    }

    //b = new Button(this, border*2, border*2, 200, 50, "Click Here To Refuel");


    public void mousePressed()
    {
        if((fuel.currentFuel > 0) && (mouseX > border*2) && (mouseX < border*2 + 200) && (mouseY < border*2 + 50) && (mouseY > border*2))
        {
            fuel.currentFuel = 0;
            b.colour = 0;
        }
    }
        

 
    public void draw()
    {
        background(0);
        drawStars();
        drawPlanets();
        drawUI();
        textAlign(LEFT, CENTER);
        drawRadar();
        drawFuel();

        b.update();
        b.render();



        if (checkKey(LEFT))
        {

        }
    }
    private ArrayList<Planet> planets = new ArrayList<Planet>();

}

