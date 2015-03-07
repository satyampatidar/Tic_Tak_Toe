/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaassignment7;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class NewApplet extends Applet {

    String str = "NORMAL";
    Rectangle door, win, wall;
    Polygon roof;
    int x1 = 0, y1 = 0;
    int x[] = {200, 100, 300};
    int y[] = {200, 300, 300};

    @Override
    public void init() {

        door = new Rectangle(120, 350, 50, 100);
        win = new Rectangle(240, 320, 50, 50);
        roof = new Polygon(x, y, 3);
        wall = new Rectangle(100, 300, 200, 150);
        addMouseMotionListener(new A());

    }

    class A extends MouseAdapter {

        @Override
        public void mouseMoved(MouseEvent e) {

            x1 = e.getX();
            y1 = e.getY();

            if(wall.contains(x1, y1)){
            str="WALL";
            repaint();
            }
            if (door.contains(x1, y1)) {
                str = "THIS IS DOOR";
                repaint();
            }

            if (win.contains(x1, y1)) {
                str = "THIS IS WINDOW";
                repaint();
            }

            if (roof.contains(x1, y1)) {
                str = "THIS IS ROOF";
                repaint();
            }
            }
        }
    

    @Override
    public void paint(Graphics s) {
        s.drawPolygon(x, y, 3);
        s.drawRect(100, 300, 200, 150);
        s.drawRect(240, 320, 50, 50);
        s.drawRect(120, 350, 50, 100);
        s.drawString(str, x1, y1);

    }
}
