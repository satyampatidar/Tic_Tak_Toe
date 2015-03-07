package javaassignment7;

import java.applet.Applet;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TicTakTo extends Applet {

    Rectangle r[] = new Rectangle[9];
    char ans[] = {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'};
    int win[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {6, 4, 7}, {0, 4, 8}};
    String msg = "x its your turn";
    char player = 'x';
    int z;

    public void init() {
        for (int x = 50, i = 0; x <= 150; x += 50) {
            for (int y = 50; y <= 150; y += 50) {
                r[i] = new Rectangle(y, x, 50, 50);
                i++;
            }
        }
        addMouseListener(new A());
    }

    class A extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent m) {
            int x = m.getX();
            int y = m.getY();
            z = getShape(x, y);
            if (z != -1) {
                if (player == 'x' && ans[z] == 'a' && !(msg.equals("x you wins") || msg.equals("o you wins"))) {
                    ans[z] = 'x';
                    player = 'o';
                    msg = "o its your turn";
                } else if (player == 'o' && ans[z] == 'a' && !(msg.equals("x you win") || msg.equals("o you win"))) {

                    ans[z] = 'o';
                    player = 'x';
                    msg = "x its your turn";
                }
            }
            checkWin();
            repaint();
        }

        public int getShape(int x, int y) {
            for (int i = 0; i < 9; i++) {
                if (r[i].contains(x, y)) {
                    return i;
                }
            }
            return -1;
        }

        public void checkWin() {
            for (int i = 0; i < win.length; i++) {
                if (ans[win[i][0]] == 'x' && ans[win[i][1]] == 'x' && ans[win[i][2]] == 'x') {
                    msg = "x you win";
                } else if (ans[win[i][0]] == 'o' && ans[win[i][1]] == 'o' && ans[win[i][2]] == 'o') {
                    msg = "o you win";


                }
            }

            for (int j = 0; j < ans.length; j++) {
                if (ans[j] == 'a') {
                    break;
                }
                if (ans[j] == ans.length && !(msg.equals("x you win") || msg.equals("o you win"))) {
                    msg = "GAME OVER >>> PRODUCT OF SATYAM TECHNOLOGIES";
                }
            }
        }

        public void paint(Graphics g) {
            for (int x = 50, i = 0; x <= 150; x += 50) {
                for (int y = 50; y <= 150; y += 50) {
                 g.drawRect(y, x, 50, 50);
                    i++;

                }
            }
            for (int j= 0; j < 9; j++) {
                if(ans[j]=='x'){
                g.setFont(new Font("Ariel",Font.BOLD,30));
            g.drawString("x",(int)r[j].getX()+20,(int)r[j].getY()+30);
                }
                else if(ans[j]=='o'){
g.setFont(new Font("Arial",Font.BOLD,30));
g.drawString("0",(int)r[j].getX()+20,(int)r[j].getY()+30);

                }
            }
            showStatus("A PRODUCT OF SATYAM TECHNOLOGIES");
        }
    }
}
