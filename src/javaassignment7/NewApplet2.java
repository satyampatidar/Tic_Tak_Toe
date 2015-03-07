package javaassignment7;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.Rectangle;

public class NewApplet2 extends Applet {

    int a, b;
    String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Rectangle r[] = new Rectangle[40];
    char sty[] = new char[40];

    @Override
    public void init() {
        for (int x = 50, i = 0; x <= 250; x += 50) {
            for (int y = 50; y <= 400; y += 50) {
                r[i] = new Rectangle(y, x, 50, 50);
                i++;

            }
        }
        for (int i = 0; i < 40; i++) {
            sty[i] = 'a';

        }
        addMouseListener(new A());

    }

  public  class A extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            a = e.getX();
            b = e.getY();
            int z = getShape(a, b);

            if (sty[z] == 'a') {
                sty[z] = str.charAt((int) (Math.random() * 26));
            }
            repaint();
        }

        private int getShape(int a, int b) {
            for (int i = 0; i < 40; i++) {
                if (r[i].contains(a, b)) {
                    return i;
                }
            }
            return -1;
        }
    }

    @Override
    public void paint(Graphics s) {
        for (int x = 50, i = 0; x <= 250; x += 50) {
            for (int y = 50; y <= 400; y += 50) {
                s.drawRect(y, x, 50, 50);
                i++;

            }
        }
        s.setColor(Color.red);
        s.setFont(new Font("Ariel", Font.BOLD, 20));
        for (int i = 0; i < 40; i++) {
            if (sty[i] != 'a') {
                s.drawString(String.valueOf(sty[i]), (int) r[i].getX() + 20, (int) r[i].getY() + 30);

            } else {
                continue;
            }
        }
    }
}
