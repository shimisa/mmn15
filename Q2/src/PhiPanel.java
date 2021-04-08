/**
 * The PhiPanel class take care of the panel that hold the circles that represents the philosophers
 * and the lines that represents the eating sticks
 *
 * @author  Shimi Sadaka
 * @version 1.0
 * @since   2020-12-01
 *
 */

import java.awt.Color;
import java.awt.*;
import javax.swing.JPanel;

public class PhiPanel extends JPanel {

    private boolean[] phiNumber;

    public PhiPanel(){
        phiNumber = new boolean[5];
    }

    /**
     * paint all the panel that contain the table, the Philosophers and the sticks
     * @param g the Graphics obj
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        int w = getWidth();
        int h = getHeight();
        g.setColor(Color.BLACK);
        g.drawOval(w / 2 - 275, h / 2 - 275, 550, 550);
        g.drawOval(w / 2 - 50, h / 2 - 190, 50, 50);
        g.drawOval(w / 2 - 200, h / 2 - 25, 50, 50);
        g.drawOval(w / 2 - 80, h / 2 + 140, 50, 50);
        g.drawOval(w / 2 + 140, h / 2 - 80, 50, 50);
        g.drawOval(w / 2 + 110, h / 2 + 90, 50, 50);

        g.drawLine(w / 2 - 70, h / 2 - 70, w / 2 - 120, h / 2 - 120);
        g.drawLine(w / 2 + 70, h / 2 - 70, w / 2 + 120, h / 2 - 120);
        g.drawLine(w / 2 - 70, h / 2 + 70, w / 2 - 120, h / 2 + 120);
        g.drawLine(w / 2 + 120, h / 2 + 30, w / 2 + 190, h / 2 + 50);
        g.drawLine(w / 2 + 40, h / 2 + 110, w / 2 + 40, h / 2 + 190);
        g.setColor(Color.RED);


        if(phiNumber[0]) {
            g.fillOval(w / 2 - 50, h / 2 - 190, 50, 50);
            g.drawLine(w / 2 + 70, h / 2 - 70, w / 2 + 120, h / 2 - 120);
            g.drawLine(w / 2 - 70, h / 2 - 70, w / 2 - 120, h / 2 - 120);
        }


        if(phiNumber[1]) {
            g.fillOval(w / 2 - 200, h / 2 - 25, 50, 50);
            g.drawLine(w / 2 - 70, h / 2 - 70, w / 2 - 120, h / 2 - 120);//
            g.drawLine(w / 2 - 70, h / 2 + 70, w / 2 - 120, h / 2 + 120);
        }

        if(phiNumber[2]) {
            g.fillOval(w / 2 - 80, h / 2 + 140, 50, 50);
            g.drawLine(w / 2 - 70, h / 2 + 70, w / 2 - 120, h / 2 + 120);//
            g.drawLine(w / 2 + 40, h / 2 + 110, w / 2 + 40, h / 2 + 190);//
        }

        if(phiNumber[3]) {
            g.fillOval(w / 2 + 110, h / 2 + 90, 50, 50);
            g.drawLine(w / 2 + 120, h / 2 + 30, w / 2 + 190, h / 2 + 50);
            g.drawLine(w / 2 + 40, h / 2 + 110, w / 2 + 40, h / 2 + 190);
        }

        if(phiNumber[4]) {
            g.fillOval(w / 2 + 140, h / 2 - 80, 50, 50);
            g.drawLine(w / 2 + 70, h / 2 - 70, w / 2 + 120, h / 2 - 120);
            g.drawLine(w / 2 + 120, h / 2 + 30, w / 2 + 190, h / 2 + 50);
        }

        g.setColor(Color.BLACK);

    }

    /**
     * set the eating status of each Philosopher
     * @param num the Philosopher number
     * @param eat true = eating, false = not eating
     */
    public void changePnelPhilNum(int num, boolean eat){
        phiNumber[num - 1] = eat;
    }
}
