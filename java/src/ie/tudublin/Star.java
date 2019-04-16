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
        z = z - 1;
    }
    
    public void render()
    {
        ui.fill(255);
        ui.noStroke();

        float sx = map(x / z, 0, 1, 0, width);
        float sy = map(y / z, 0, 1, 0, height);

        ui.ellipse(sx, sy, 8, 8);

	}

}