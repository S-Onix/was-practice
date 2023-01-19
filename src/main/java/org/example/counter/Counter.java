package org.example.counter;

public class Counter implements  Runnable{
    private int count = 0;

    public void increment(){
        this.count++;
    }

    public void decrement(){
        this.count--;
    }

    public int getCount(){
        return this.count;
    }
    //동기화 처리
    @Override
    public synchronized void run() {
        this.increment();
        System.out.println("Value for Thread After increment " + Thread.currentThread().getName() + " " + this.getCount());
        this.decrement();
        System.out.println("Value for Thread at last " + Thread.currentThread().getName() + " " + this.getCount());
    }
}
