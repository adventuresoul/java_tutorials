package Tutorials;

// method for creating Threads -> extend Thread class for your class, now you have access to all functionalities of threads
class A extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hi");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class B extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// method for creating Threading -> implement Runnable interface for your class, create a custom Thread obj and fix the target as your class
class C implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("Runnable obj");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

// sample class with mutex
class Counter {
    int count;
    // public void increment() {
    //     count++;
    // }
    // use mutex, synchronized
    public synchronized void increment() {
        count++;
    }
}

public class Threading {
    public static void main(String[] args) {
        // without threading
        long startTime1 = System.nanoTime();

        A obj1 = new A();
        B obj2 = new B();

        obj1.run();
        obj2.run();

        long endTime1 = System.nanoTime();
        System.out.println("Time required (without threads): " + (endTime1 - startTime1));

        // with threading
        long startTime2 = System.nanoTime();

        A obj3 = new A();
        B obj4 = new B();
        obj3.start();
        obj4.start();

        // wait for both threads to complete execution
        try {
            obj3.join();
            obj4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime2 = System.nanoTime();
        System.out.println("Time required (with threads): " + (endTime2 - startTime2));

        // Thread Priority
        Thread highPriorityThread = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("High Priority Thread: " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread lowPriorityThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Low Priority Thread: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // set priority for thread -> [1, 10], 10 means high priority 
        highPriorityThread.setPriority(Thread.MAX_PRIORITY);
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);

        highPriorityThread.start();
        lowPriorityThread.start();

        try {
            highPriorityThread.join();
            lowPriorityThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Make any obj into threading obj just by implementing Runnable functional imterface
        Runnable obj5 = new C();
        Thread t = new Thread(obj5);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // or even shortly using lambda expression, no need for class C
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Lambda expression");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // mutex illustration
        Counter c = new Counter();
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                c.increment();
            }
        });
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                c.increment();
            }
        });

        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final value after running two threads: " + c.count);

    }    
}


/*
 * Thread states
 *  NEW – Created but not started (new Thread()).
    RUNNABLE – Ready to run or running.
    BLOCKED – Waiting for a lock.
    WAITING – Waiting indefinitely (wait(), join()).
    TIMED_WAITING – Waiting for a fixed time (sleep(), wait(time)).
    TERMINATED – Finished execution.

    Lifecycle: NEW → RUNNABLE → (BLOCKED / WAITING / TIMED_WAITING) → TERMINATED.

    State	        Transition Method (How it enters the state)
    NEW	            new Thread() (Thread created but not started)
    RUNNABLE	    start() (Thread is ready/running)
    RUNNING         execution
    BLOCKED	        Trying to enter a synchronized block/method while another thread holds the lock
    WAITING	        wait(), join(), LockSupport.park() (Thread waits indefinitely)
    TIMED_WAITING	sleep(time), wait(time), join(time), LockSupport.parkNanos() (Thread waits for a set time)
    TERMINATED	    Thread completes execution or stop() (Deprecated)
 */