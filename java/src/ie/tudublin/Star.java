package ie.tudublin;

import processing.core.PApplet;

public class Star extends PApplet
{
    UI ui;
    private float x;
    private float y;
    private float z;
    private float starSpeed;

    public Star(UI ui, float x, float y, float z, float starSpeed)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.z = z;
        this.starSpeed = starSpeed;
    }

    public void update()
    {
        z = z - starSpeed;
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
        float r = map(z, 0, width, 8, 0);
        ui.ellipse(sx, sy, r, r);

	}

}