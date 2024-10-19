package org.lld;

import org.lld.threads.PrintingThread;

import java.util.concurrent.Semaphore;

public class SemaphoreTestClient {
  public static void main(String[] args) {
    Semaphore semaphore = new Semaphore(2);
    PrintingThread p1 = new PrintingThread(semaphore, "p1");
    PrintingThread p2 = new PrintingThread(semaphore, "p2");
    PrintingThread p3 = new PrintingThread(semaphore, "p3");
    PrintingThread p4 = new PrintingThread(semaphore, "p4");
    PrintingThread p5 = new PrintingThread(semaphore, "p4");
    PrintingThread p6 = new PrintingThread(semaphore, "p4");

    p1.start();
    p2.start();
    p3.start();
    p4.start();
    p5.start();
    p6.start();
  }
}
