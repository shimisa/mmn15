/**
 * The GUIPhilo class responsible for the user interface
 *
 * @author  Shimi Sadaka
 * @version 1.0
 * @since   2020-12-01
 *
 */

import javax.swing.JFrame;

public class GUIPhilo extends JFrame {
    PhiPanel p;

    public GUIPhilo(){
        p = new PhiPanel();
        //setLayout(null);

        add(p);

        setLocation(500, 225);
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    /**
     * set the eating status of each Philosopher
     * @param num the Philosopher number
     * @param bool true = eating, false = not eating
     */
    public void changePhilNum(int num, boolean bool){
        p.changePnelPhilNum(num, bool);
    }


    /**
     * main method that initialized the Philosophers and run the general algo and the GUI
     * @param args
     */
    public static void main(String [] args){
        GUIPhilo gui = new GUIPhilo();
        Waiter waiter = new Waiter();
        Stick[] sticks = new Stick[5];
        Philosopher[] p = new Philosopher[5];
        for (int i = 0; i < 5; i++) {
            sticks[i] = new Stick(waiter);
        }
        for (int i = 0; i < 5; i++) {
            if(i != 4)
                p[i] = new Philosopher(waiter,sticks[i],sticks[i + 1], i + 1, gui);
            else
                p[i] = new Philosopher(waiter,sticks[i],sticks[0], i + 1, gui);
            p[i].start();
        }
    }


}
