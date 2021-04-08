/**
 * The Philosopher class starts the threads and execute the general algo of each thread
 *
 * @author  Shimi Sadaka
 * @version 1.0
 * @since   2020-12-01
 *
 */
import java.lang.Math;

public class Philosopher extends Thread {


    private Waiter waiter; // the waiter
    private Stick rightStick; // the stick that in right
    private Stick leftStick; // the stick that in left
    private int number; // the index of the Philosopher
    GUIPhilo gui;

    /**
     * constructor of the philosopher
     * @param w initialized the waiter
     * @param sr initialized the stick that in right
     * @param sl initialized the stick that in left
     * @param num initialized the index of the Philosopher
     */
    public Philosopher(Waiter w, Stick sr, Stick sl, int num, GUIPhilo g){
        waiter = w;
        rightStick = sr;
        leftStick = sl;
        number = num;
        gui = g;

    }

    @Override
    public void run() {
        while (true){
            waiter.waitForSticks(rightStick, leftStick);
            waiter.pickSticks(this, rightStick, leftStick);
            eat();
            waiter.releaseSticks(rightStick, leftStick);
            think();
        }


    }

    /**
     * eat random time
     */
    public synchronized void eat(){
        System.out.println("Philosopher " + number + " is eating...");
        gui.changePhilNum(number, true);
        gui.repaint();
        try {
            sleep((long)(Math.random() * 10000));
        }
        catch (InterruptedException e){}
        gui.changePhilNum(number, false);
        gui.repaint();

    }

    /**
     * think random time
     */
    public synchronized void think(){
        System.out.println("Philosopher " + number + " is thinking...");
        try {
            sleep((long)(Math.random() * 10000));
        }
        catch (InterruptedException e){}
    }
}
