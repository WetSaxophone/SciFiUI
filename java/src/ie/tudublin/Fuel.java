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

        ui.strokeWeight(3);
        ui.noFill();
        ui.stroke(255);

        ui.line(ui.width - ui.border * 2, ui.height - ui.border * 2, ui.width - ui.border*2, ui.height - ui.border*7);
        ui.line(ui.width - ui.border * 4, ui.height - ui.border * 2, ui.width - ui.border*4, ui.height - ui.border*7);
        ui.line(ui.width - ui.border * 2, ui.height - ui.border * 2, ui.width - ui.border * 4, ui.height - ui.border * 2);

        
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