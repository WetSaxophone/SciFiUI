package ie.tudublin;

import processing.core.PApplet;

public class Planet extends PApplet
{
    UI ui;
    private float x;
    private float y;
    private float z;


    public Planet(UI ui, float x, float y, float z)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void update()
    {
        z = (float) (z - 0.2);
        if(z < 1)
        {
            z = width;
            x = random(random(-width, width/(float)3.5), random(width/(float)1.5, width));
            y = random(-height/3, height);
        }
    }
    
    public void render()
    {
        ui.fill(random(20,25),random(20,25),random(20,25));
        ui.noStroke();

        float sx = map(x / z, 0, 1, 0, width);
        float sy = map(y / z, 0, 1, 0, height);
        float r = map(z, 0, width, 850, 4);
        ui.ellipse(sx, sy, r, r);

	}

}