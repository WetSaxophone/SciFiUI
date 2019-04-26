package ie.tudublin;

import processing.core.PApplet;

public class Button extends PApplet
{
    UI ui;
    private float x;
    private float y;
    private float width;
    private float height;
    private String text;

    public Button(UI ui, float x, float y, float width, float height, String text)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }

    public void update()
    {
        if (mousePressed == true)
        {
        System.out.println("Hello World");
        ui.fill(255);
        }
    }


    public void render()
    {
        if (mousePressed == true)
        {
        System.out.println("Hello World");
        ui.fill(255);
        }
        ui.noFill();
        ui.stroke(255);
        ui.rect(x, y, width, height);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text(text, x + width * 0.5f, y + height * 0.5f);
    }

    
}