package ie.tudublin;

import processing.core.PApplet;

public class UI extends PApplet
{
    public float starSpeed;
    public float starsPassed;

    Button b;
    Radar radar;
    MovingCircle mc;
    Star[] stars = new Star[400];
    Planet planet;



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
        //fullScreen(P3D); 
    }

    public void setup()
    {
        for(int i = 0; i < stars.length; i++)
        {
            stars[i] = new Star(this, random(-width,width), random(-height, height), random(150));
            
        }

        planet = new Planet(this, random(-width,width), random(-height, height), random(100));

        radar = new Radar(this, 1, width - border*4, border*4, 100);

        b = new Button(this, border*2, border*2, 200, 50, "Click Here To Refuel");


        // mc = new MovingCircle(this, width / 2, height * .75f, 50);
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
        for(int i = 0; i < stars.length; i++)
        {
            stars[i].update(map(mouseX, 0, width, 0, 10));
            stars[i].render();
        }
        popMatrix();
    }

    public void drawPlanets()
    {
        pushMatrix();
        translate(width/2, height/2);
        planet.update(map(mouseX, 0, width, 0, 1));
        planet.render();
        popMatrix();
    }
 
    public void draw()
    {
        background(0);
        drawStars();
        drawPlanets();
        drawUI();
        
        radar.update();
        radar.render();

        b.update();
        b.render();



        //mc.update();
        //mc.render();

        // if (checkKey(LEFT))
        // {
        //     System.out.println("Left arrow key pressed");
        // }
    }

}

