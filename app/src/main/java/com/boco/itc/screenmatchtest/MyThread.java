package com.boco.itc.screenmatchtest;

public class MyThread extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                System.out.println("test");
                Thread.sleep(10000);
            }
            catch (InterruptedException e){
                System.out.println("InterruptedException");
                Thread.currentThread().interrupt();
            }
            System.out.println("stop");
        }
    }

    public void cancel(){
        interrupt();
    }
}
