import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class PlatePanel extends JPanel {
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        g.setColor(Color.BLACK);
        g.drawOval(25,25,25,25);

    }
}
