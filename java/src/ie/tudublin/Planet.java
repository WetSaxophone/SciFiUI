package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Planet extends PApplet
{
    UI ui;
    private String displayName;
    private float x;
    private float y;
    private float z;
    private float planetSpeed;
    private int planetsPassed;
    float r;
    float g;
    float b;



    public Planet(UI ui, TableRow row, float x, float y, float z)
    {
        this.ui = ui;
        displayName = row.getString("Display Name");
        this.x = x;
        this.y = y;
        this.z = z;
        this.r = random(25,50);
        this.g = random(25,50);
        this.b = random(25,50);

    }

    public void update(float planetSpeed)
    {
        z = z - planetSpeed;
        if(z < 2)
        {
            z = width;
            x = random(random(-width, width/(float)3.5), random(width/(float)1.5, width));
            y = random(-height/3, height);
            planetsPassed += 1;
            System.out.println(planetsPassed);
            
            this.r = random(25,50);
            this.g = random(25,50);
            this.b = random(25,50);

            ui.planetN ++;
        }


    }
    
    public void render()
    {
        ui.fill(r,g,b);
        ui.noStroke();

        float sx = map(x / z, 0, 1, 0, width);
        float sy = map(y / z, 0, 1, 0, height);
        float r = map(z, 0, width, 850, 4);
        ui.ellipse(sx, sy, r, r);

        // ui.textAlign(LEFT, CENTER);
        // ui.fill(255);
        // ui.text(displayName, sx, sy);


    }
    


    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    public String getDisplayName()
    {
        return displayName;
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
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * @return the z
     */
    public float getZ() {
        return z;
    }

    /**
     * @param z the z to set
     */
    public void setZ(float z) {
        this.z = z;
    }

    /**
     * @return the planetSpeed
     */
    public float getPlanetSpeed() {
        return planetSpeed;
    }

    /**
     * @param planetSpeed the planetSpeed to set
     */
    public void setPlanetSpeed(float planetSpeed) {
        this.planetSpeed = planetSpeed;
    }

    public String toString()
    {
        return displayName;  
    }

    /**
     * @return the planetsPassed
     */
    public int getPlanetsPassed() {
        return planetsPassed;
    }

    /**
     * @param planetsPassed the planetsPassed to set
     */
    public void setPlanetsPassed(int planetsPassed) {
        this.planetsPassed = planetsPassed;
    }



}