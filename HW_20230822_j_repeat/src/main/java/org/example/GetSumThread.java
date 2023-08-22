package org.example;

public class GetSumThread extends Thread {

    private final int start;
    private final int finish;
    private int sum;

    public GetSumThread(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public void run(){
        for (int i = start; i <= finish ; i++) {
            sum += i;
        }
    }

    public int getSum() {
        return sum;
    }
}
