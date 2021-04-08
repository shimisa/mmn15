/**
 * The PrimeThread class take care of the logic of each thread
 * It is responsible for calculating the prime numbers
 *
 * @author  Shimi Sadaka
 * @version 1.0
 * @since   2020-12-01
 */

public class PrimeThread extends Thread {
    private final Controller cont;
    private int number;

    /**
     * Constructor for building the prime thread - each thread calculate specific number
     * @param num the number to check if it is a prime
     * @param c the controller for managing the calculation process
     */
    public PrimeThread(int num, Controller c) {
        cont = c;
        number = num;
    }

    /**
     * the run method for execute the prime algo
     */
    @Override
    public void run() {
        int i;
        for (i = 2 ; i < number ; i++) {
            if (number % i == 0)
                break;
        }
        if (i == number)
            cont.itsPrime(number);

        cont.finished(); // updating the thread finished
    }
}
