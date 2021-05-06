package com.bhanu.workbook.genericJava;

public class ThreadsDemo {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println("Hey");
        };
        Thread t = new Thread(r);
        t.start();
    }
}
