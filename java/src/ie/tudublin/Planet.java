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
    public int planetsPassed;


    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    public String getDisplayName()
    {
        return displayName;
    }


    public Planet(UI ui, TableRow row, float x, float y, float z)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void update(float planetSpeed)
    {
        z = z - planetSpeed;
        if(z < 1)
        {
            z = width;
            x = random(random(-width, width/(float)3.5), random(width/(float)1.5, width));
            y = random(-height/3, height);
            planetsPassed += 1;
            System.out.println(planetsPassed);
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

    public Planet(TableRow row)
    {
        displayName = row.getString("Display Name");
    }

}