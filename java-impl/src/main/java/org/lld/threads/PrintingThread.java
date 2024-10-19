package org.lld.threads;

import java.text.MessageFormat;
import java.util.concurrent.Semaphore;

public class PrintingThread extends Thread {
  private final Semaphore semaphore;
  private final String name;

  /**
   * Initiate printing thread
   *
   * @param semaphore
   * @param name
   */
  public PrintingThread(final Semaphore semaphore, final String name) {
    this.semaphore = semaphore;
    this.name = name;
  }

  @Override
  public void run() {
    startProcess();
  }

  private void startProcess() {
    try {
      System.out.println(
          MessageFormat.format(
              "{0} acquiring lock of available {1}.",
              this.name, this.semaphore.availablePermits()));
      this.semaphore.acquire();
      try {
        System.out.println(
            MessageFormat.format(
                "{0} acquired lock, available {1}", this.name, this.semaphore.availablePermits()));
      } catch (Exception e) {
        System.out.println(
            MessageFormat.format("{0} error processing, {1}", this.name, e.getMessage()));
      } finally {
        this.semaphore.release();
        System.out.println(
            MessageFormat.format(
                "{0} released lock, available {1} ", this.name, this.semaphore.availablePermits()));
      }
    } catch (InterruptedException exception) {
      System.out.println(
          MessageFormat.format(
              "{0} could not process lock,{1}", this.name, exception.getMessage()));
    }
  }
}
