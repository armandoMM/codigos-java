/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumertest;

/**
 *
 * @author leledezma
 */
class CubbyHole {
    private int contents;         // this is the condition variable.
    private boolean available = false;

    public synchronized int get() {
        while (available == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        available = false;
        notify();
        return contents;
    }

    public synchronized void put(int value) {
        while (available == true) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        contents = value;
        available = true;
        notify();
    }
}
