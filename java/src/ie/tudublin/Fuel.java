package ie.tudublin;

import processing.core.PApplet;

public class Fuel extends PApplet
{
    private UI ui;
    

    public Fuel(UI ui)
    {
        this.ui = ui;
        
    }


    public void render()
    {
        ui.noFill();
        ui.stroke(255);
        
    }


    public void update()
    {

    }

    
}