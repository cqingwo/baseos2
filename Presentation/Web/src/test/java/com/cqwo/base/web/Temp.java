package com.cqwo.base.web;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Temp {
    int count = 0;

    public void waiter() throws InterruptedException {
        synchronized (this) {
            System.out.println("等待");
            wait();
            System.out.println(this.count);
        }
    }

    public void notifyer() throws InterruptedException {
        synchronized (this) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("唤醒");
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread() + "notifyer:" + i);
                count += i;
            }
            notify();
        }
    }

    public class Waiter implements Runnable {
        private Temp temp;

        public Waiter(Temp temp) {
            this.temp = temp;
        }

        public void run() {
            try {
                temp.waiter();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public class Notifyer implements Runnable {
        private Temp temp;

        public Notifyer(Temp temp) {
            this.temp = temp;
        }

        public void run() {
            try {
                temp.notifyer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() {
        Temp temp = new Temp();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Waiter(temp));
        executorService.execute(new Notifyer(temp));
        executorService.shutdown();
    }
}