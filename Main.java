package com.company;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws InterruptedException {

//        Random rand = new Random();
//        IMatrix us1 = new UsualMatrix(5,5);
//        IMatrix sm1 = new SparseMatrix(5,5);
//        for(int i = 0; i < 5; i++) {
//            int val = rand.nextInt(9) + 1;
//            int rowIdx = rand.nextInt(5 - 1);
//            int colIdx = rand.nextInt(5 - 1);
//            if (sm1.getElement(rowIdx, colIdx) == 0) {
//                sm1.setElement(rowIdx, colIdx, val);
//                us1.setElement(rowIdx, colIdx, val);
//            }
//        }
//        IMatrix us2 = new UsualMatrix(5,5);
//        IMatrix sm2 = new SparseMatrix(5,5);
//        for(int i = 0; i < 5; i++) {
//            int val = rand.nextInt(9) + 1;
//            int rowIdx = rand.nextInt(5 - 1);
//            int colIdx = rand.nextInt(5 - 1);
//            if (sm2.getElement(rowIdx, colIdx) == 0) {
//                sm2.setElement(rowIdx, colIdx, val);
//                us2.setElement(rowIdx, colIdx, val);
//            }
//        }
//        System.out.println((us1.sum(us2).equals(sm1.sum(sm2))));
//        System.out.println((us1.product(us2).equals(sm1.product(sm2))));


//        int size = 1500;
//        Random rand = new Random();
//        UsualMatrix firstMatrix = new UsualMatrix(size, size);
//        UsualMatrix secondMatrix = new UsualMatrix(size, size);
//
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                int valFirst = rand.nextInt(9) + 1;
//                int valSecond = rand.nextInt(9) + 1;
//                firstMatrix.setElement(i, j, valFirst);
//                secondMatrix.setElement(i, j, valSecond);
//            }
//        }
//        long timeMultiThreading = System.currentTimeMillis();
//
//        ParallelMatrixProduct parallelMatrixProduct = new ParallelMatrixProduct(1);
//        UsualMatrix resultMatrixThread = (UsualMatrix) parallelMatrixProduct.multiThreadingMultiply(firstMatrix, secondMatrix);
//        System.out.println("Time for multi threading multiplication of matrix: " + (System.currentTimeMillis() - timeMultiThreading));
//
//        long timeDefaultMultiplication = System.currentTimeMillis();
//
//        IMatrix resultMatrixDefault = firstMatrix.product(secondMatrix);
//        System.out.println("Time for default multiplication of matrix: " + (System.currentTimeMillis() - timeDefaultMultiplication));
//
//        System.out.println("Result of multithreading and default multiplication is equals: " + resultMatrixDefault.equals(resultMatrixThread));

        int size = 50;
        Random rand = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < size; i++)
        {
            int val = rand.nextInt(9) + 1;
            list.add(val);
        }

        Array array = new Array();
        long timeMultiThreading = System.currentTimeMillis();
        System.out.println("Amount off odd numbers(default algorithm): " + array.calcOddNum(list, 1));
//        array.calcOddNum(list, 1);
        //sleep(2000);
        System.out.println("time for default calculate amount off odd numbers: " + (System.currentTimeMillis() - timeMultiThreading));

        long timedefault = (System.currentTimeMillis());
        System.out.println("Amount off odd numbers(multithreading algorithm): " + array.calcOddNum(list, 2));
//        array.calcOddNum(list, 2);
        // sleep(2000);
        System.out.println("time for multithreading calculate amount off odd numbers: " + (System.currentTimeMillis() - timedefault));


    }
}
