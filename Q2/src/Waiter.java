/**
 * The Main class starts the threads and execute the general algo
 *
 * @author  Shimi Sadaka
 * @version 1.0
 * @since   2020-12-01
 *
 */

public class Waiter {
    private boolean twoSticksAvailble;

    public Waiter(){

    }

    /**
     * pick the sticks
     * @param p the Philosopher that pick the sticks
     * @param rStick right stick
     * @param lStick left stick
     */
    public synchronized void pickSticks(Philosopher p, Stick rStick, Stick lStick){
        rStick.inUse(p);
        lStick.inUse(p);
    }

    /**
     * release the sticks after finish to eat
     * @param rStick right stick
     * @param lStick left stick
     */
    public synchronized void releaseSticks(Stick rStick, Stick lStick){
        rStick.available();
        lStick.available();
        notifyAll();
    }

    /**
     * waits for a sticks when at least one of them is not available
     * @param rStick
     * @param lStick
     */
    public synchronized void waitForSticks(Stick rStick, Stick lStick){
        while (!(rStick.isAvailable() && lStick.isAvailable() )){
            try {
                wait();
            }
            catch (InterruptedException e) {}
        }
    }






}

