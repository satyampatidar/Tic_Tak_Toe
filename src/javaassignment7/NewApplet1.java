package javaassignment7;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.*;

public class NewApplet1 extends Applet {

    int x = 0, y = 0;
    String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Rectangle r[] = new Rectangle[40];
    char sty[] = new char[40];

    public void init() {
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 5; j++) {
                r[i] = new Rectangle((30 + (30 * i)), (30 + (30 * j)), (30), (30));
            }
        }
        for (int p = 0; p < 40; p++) {
            sty[p] = 'A';

        }
        addMouseListener(new A());

    }

    public void paint(Graphics s) {
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 5; j++) {
                s.drawRect((30 + (30 * i)), (30 + (30 * j)), (30), (30));
            }
            System.out.println();
        }
        for (int i = 0; i < 40; i++) {
            if (sty[i] != 'A') {
                s.drawString(String.valueOf(sty),(int) r[i].getX()+20,(int) r[i].getY()+20);
            
            } else {
                continue;
            }
        }
    }

    class A extends MouseAdapter {

        public void MouseClicked(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            int z = getShape(x, y);

            if (sty[z] == 'A') {
                sty[z] = str.charAt((int) (Math.random() * 26));
            }
        }

        public int getShape(int x, int y) {
            for (int i = 0; i < 40; i++) {
                if (r[i].contains(x, y)) {
                    return i;
                }
            }
            return -1;
        }
    }
}
