package com.nimooli.mvc.model;

public class Trap extends Element {


    @Override
    public boolean move(DIRECTION dir, Element caller) {

        boolean isMouse = (caller instanceof Mouse);

        if (isMouse) {
            final Mouse m = (Mouse) caller;
            final Cell thisCell = getContainer();

            m.setTrapped(true);

            // wait and let the mouse escape after a while
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("Thread started");
                        Thread.currentThread().sleep(3000);
                        m.setTrapped(false);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            t.start();
            return true;
        }


        return false;
    }

    @Override
    public String toString() {
        return "t";

    }
}
