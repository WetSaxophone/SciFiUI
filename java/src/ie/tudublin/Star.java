package ie.tudublin;

import processing.core.PApplet;

public class Star extends PApplet
{
    UI ui;
    private float x;
    private float y;
    private float z;
    private float starSpeed;
    
    public Star(UI ui, float x, float y, float z)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void update(float starSpeed)
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
        float r = map(z, 0, width, 6, 0);
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
     * @return the starSpeed
     */
    public float getStarSpeed() {
        return starSpeed;
    }

    /**
     * @param starSpeed the starSpeed to set
     */
    public void setStarSpeed(float starSpeed) {
        this.starSpeed = starSpeed;
    }

  

}