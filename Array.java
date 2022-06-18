package com.company;

import java.util.ArrayList;

public class Array {

    private int amountOfThreads;

    private static class countThread extends Thread {

        private ArrayList<Integer> list;
        private int result;
        private int startidx;
        private int endidx;

        public countThread(ArrayList<Integer> list, int result, int start, int end) {
            this.list = list;
            this.result = result;
            this.startidx = start;
            this.endidx = end;
        }

        @Override
        public void run() {
            //System.out.println("Считаю со строки " + startRow + " до строки " + endRow + " включительно");
            for (int r = this.startidx; r < list.size(); r++) {
                if (list.get(r) % 2 != 0) {
                    this.result += 1;
                }
            }
        }
    }




    public int calcOddNum(ArrayList<Integer> array, int theardNum) { // координатор потоков
        this.amountOfThreads = theardNum;
        if (amountOfThreads > array.size())
            this.amountOfThreads = array.size();

        int count = array.size() / this.amountOfThreads; // сколько строк будет высчитывать один поток
        int additional = array.size() % this.amountOfThreads; //если не делится на threadsCount, то добавим к первому потоку

        Thread[] threads = new Thread[this.amountOfThreads];

        int start = 0;
        int amountElForThread = 0;
        int countoddNumbers = 0;
        for (int i = 0; i < this.amountOfThreads; i++) {

            if (i == 0) {
                amountElForThread = count + additional;
                threads[i] = new countThread(array, countoddNumbers, start, start + amountElForThread - 1);
            } else {
                amountElForThread = count;
                threads[i] = new countThread(array, ((countThread) threads[i - 1]).result, start, start + amountElForThread - 1);
            }

            start += amountElForThread; // пересчитываем индекс для некст потока
            threads[i].start(); // запускаем поток
        }

        try {
            for (Thread thread : threads) {
                thread.join(); //риостоновить выполнение потока
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        int sum = 0;

        for(int i = 0; i < 1; i++) {
            sum += ((countThread)threads[i]).result;
        }
        return sum;
    }
}
