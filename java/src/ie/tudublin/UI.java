package ie.tudublin;

import processing.core.PApplet;

public class UI extends PApplet
{
    public float starSpeed;
    Button b;
    MovingCircle mc;
    Star[] stars = new Star[400];
    Planets[] planets = new Planets[2];



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

        for(int i = 0; i < planets.length; i++)
        {
            planets[i] = new Planets(this, random(-width,width), random(-height, height), random(150));
        }

        radar = new Radar(this, 1, width - border*4, border*4, 100);

        //b = new Button(this, 50, 50, 100, 50, "I am a button");
        // mc = new MovingCircle(this, width / 2, height * .75f, 50);
    }

    float border = 50;
    float circle1 = 300;
    float circle2 = 420;
    float circle3 = 435;

    public void drawUI()
    {
        stroke(255);

        fill(0);
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
        translate(width/2, height/2);
        for(int i = 0; i < stars.length; i++)
        {
            stars[i].update();
            stars[i].render();
        }
    }

    public void drawPlanets()
    {
        translate(width/2, height/2);
        for(int i = 0; i < planets.length; i++)
        {
            planets[i].update();
            planets[i].render();
        }
    }
    
    Radar radar;

    public void draw()
    {
        background(0);
        drawUI();
        radar.update();
        radar.render();
        drawStars();
        drawPlanets();

        // b.render();

        //mc.update();
        //mc.render();

        // if (checkKey(LEFT))
        // {
        //     System.out.println("Left arrow key pressed");
        // }
    }

}

