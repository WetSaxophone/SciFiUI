package ie.tudublin;

import processing.core.PApplet;

public class Fuel extends PApplet
{
    private UI ui;
    private float fuel;
    

    public Fuel(UI ui, float fuel)
    {
        this.ui = ui;
        this.fuel = fuel;
        
    }

    
    public void render()
    {
        ui.noFill();
        ui.stroke(255);

        ui.line(2,3,4,ui.border);
        
    }


    public void update()
    {

    }

    /**
     * @return the ui
     */
    public UI getUi() {
        return ui;
    }

    /**
     * @param ui the ui to set
     */
    public void setUi(UI ui) {
        this.ui = ui;
    }

    /**
     * @return the fuel
     */
    public float getFuel() {
        return fuel;
    }

    /**
     * @param fuel the fuel to set
     */
    public void setFuel(float fuel) {
        this.fuel = fuel;
    }

    
}