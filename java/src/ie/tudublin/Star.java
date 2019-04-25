package ie.tudublin;

import processing.core.PApplet;

public class Star extends PApplet
{
    UI ui;
    private float x;
    private float y;
    private float z;

    public Star(UI ui, float x, float y, float z)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void update()
    {
        z = z - 2;
        if(z < 1)
        {
            z = width;
            x = random(-width, width);
            y = random(-height, height);
        }
    }
    
    public void render()
    {
        ui.fill(255);
        ui.noStroke();

        float sx = map(x / z, 0, 1, 0, width);
        float sy = map(y / z, 0, 1, 0, height);
        float r = map(z, 0, width, 6, 0);
        ui.ellipse(sx, sy, r, r);

	}

}