/**
 * The Stick class starts the threads and execute the general algo
 *
 * @author  Shimi Sadaka
 * @version 1.0
 * @since   2020-12-01
 *
 */

public class Stick {

    private boolean inUse;
    private Philosopher phi;
    private Waiter waiter;

    public Stick(Waiter w){
        waiter = w;
        phi = null;
        inUse = false;
    }

    /**
     * check if a stick is available
     * @return boolean
     */
    public synchronized boolean isAvailable() {
        if (inUse)
            return false;
        return true;
    }

    /**
     * set the status of a stick to be unavailable
     * @param p the Philosopher that going to use it
     */
    public synchronized void inUse(Philosopher p){
        phi = p;
        inUse = true;
    }

    /**
     * set the status of a stick to be available
     */
    public synchronized void available(){
        inUse = false;
        phi = null;
    }

}
