package ie.tudublin;

import processing.core.PApplet;

public class Fuel extends PApplet
{
    private UI ui;
    private float fuel;
    private float currentFuel;
    private float fuelCapacity;
    

    public Fuel(UI ui, float fuel)
    {
        this.ui = ui;
        this.fuel = fuel;
    }
    
    public void render()
    {
        float measurement = 8;
        float gap = ((ui.height - ui.border * 2) - (ui.height - ui.border * 7)) / measurement;
        float current = 0;

        ui.strokeWeight(3);
        ui.noFill();
        ui.stroke(255);

        ui.line(ui.width - ui.border * 3, ui.height - ui.border * 2, ui.width - ui.border*3, ui.height - ui.border*7);
        ui.line(ui.width - ui.border * 5, ui.height - ui.border * 2, ui.width - ui.border*5, ui.height - ui.border*7);
        ui.line(ui.width - ui.border * 3, ui.height - ui.border * 2, ui.width - ui.border * 5, ui.height - ui.border * 2);
        ui.line(ui.width - ui.border * 3, ui.height - ui.border*7, ui.width - ui.border*5, ui.height - ui.border*7);

        ui.fill(153,0,0);
        ui.rect(ui.width - ui.border*5, ui.height - ui.border*7, ui.border*2, (ui.height - ui.border * 2) - (ui.height - ui.border * 7));

        ui.fill(0);
        ui.rect(ui.width - ui.border*5, ui.height - ui.border*7, ui.border*2, currentFuel);
        ui.noFill();

        current = gap;
        for(int i = 0; i < measurement; i++)
        {
            ui.strokeWeight(2);
            ui.line(ui.width - ui.border * 5, ui.height - ui.border * 7 + gap, ui.width - ui.border * 5 + 15, ui.height - ui.border * 7 + gap);
            gap = gap + current;
        }
        
    }


    public void update()
    {
        fuelCapacity = 250;
        if(currentFuel < 250)
        {
        currentFuel += 0.8;
        }
        else
        {
            currentFuel = 250;
        }
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

    /**
     * @return the currentFuel
     */
    public float getCurrentFuel() {
        return currentFuel;
    }

    /**
     * @param currentFuel the currentFuel to set
     */
    public void setCurrentFuel(float currentFuel) {
        this.currentFuel = currentFuel;
    }

    
}