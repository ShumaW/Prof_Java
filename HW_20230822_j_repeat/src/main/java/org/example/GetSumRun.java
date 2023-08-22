package org.example;

public class GetSumRun implements Runnable {
    private final int start;
    private final int finish;

    public int result;

    public GetSumRun(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public void run() {
        for (int i = start; i <= finish; i++) {
            result += i;
        }
    }
}
