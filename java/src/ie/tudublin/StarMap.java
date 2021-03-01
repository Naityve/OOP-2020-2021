package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet {
    
    ArrayList<Star> stars = new ArrayList<Star>();

    void drawGrid()
    {
        float border = 0.05f * width;
        for(int i = -5; i < 5; i++)
        {
            float x = map(i, -5, 5, border, width - border);
            float y = map(1, -5, 5, border, height - border);
            stroke(0, 0, 255);
            line(x, border, x, height - border);
            line(border, y, width - border, y);
            fill(255);
            text(1, x, border / 2);
            text( 1, border / 2, y);
        }
    }

    void printStars()
    {
        for(Star s: stars)
        {
            println(s);
        }
    }

    void loadStars()
    {
        Table table = loadTable("HabHYG15ly.csv", "header");
        for(TableRow row:table.rows())
        {
            Star s = new Star(row);
            stars.add(s);
        }
    }

    public void settings() {
        size(500, 500);
    }

    public void mouseClicked()
    {
        println("Mouse clicked");
    }

    public void setup() {
        colorMode(RGB);
        loadStars();
        printStars();
    }

    public void draw() {
        background(0);
        drawGrid();
    }
}
