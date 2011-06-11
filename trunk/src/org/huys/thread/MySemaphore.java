package org.huys.thread;

import java.util.concurrent.Semaphore;

public class MySemaphore {
  public static void main(String args[]) throws Exception {
    Semaphore sem = new Semaphore(1, true);
    Thread thrdA = new Thread(new MyThread(sem, "Message 1"));
    Thread thrdB = new Thread(new MyThread(sem, "Message 2"));

    thrdA.start();
    thrdB.start();

    thrdA.join();
    thrdB.join();

  }
}

class MyThread implements Runnable {
	Semaphore sem;
	String msg;
	MyThread(Semaphore s, String m) {
		sem = s;
		msg = m;
	}
	public void run() {
		try {
			sem.acquire();
			System.out.println(msg);
			Thread.sleep(10);
			sem.release();
		} catch (Exception exc) {
			System.out.println("Error Writing File");
		}
	}
}
