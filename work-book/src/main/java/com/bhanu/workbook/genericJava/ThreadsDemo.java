package com.bhanu.workbook.genericJava;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsDemo {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println("Hey");
        };
        Thread t = new Thread(r);
        t.start();

        ExecutorService e = Executors.newFixedThreadPool(2);
        CompletableFuture<Boolean> completableFuture = CompletableFuture.supplyAsync(() -> foo(), e);
        completableFuture.join();

    }

    public static boolean foo() {
        return true;
    }
}
