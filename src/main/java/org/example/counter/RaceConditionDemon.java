package org.example.counter;
/**
 * RaceCondition이란?
 *   - 여러 프로세스가 동시에 하나의 자원에 접근하기 위해 경쟁하는 상태
 *   - 멀티쓰레드일 경우 동기화 처리를 반드시 해야한다.
 *   - 동기화가 되지 않은경우 Thread Safety 하지 않음
 *   - 따라서 상태를 유지하도록 설계하면 안된다.
 * */
public class RaceConditionDemon {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(counter, "thread-1");
        Thread t2 = new Thread(counter, "thread-2");
        Thread t3 = new Thread(counter, "thread-3");

        t1.start();
        t2.start();
        t3.start();

    }
}
