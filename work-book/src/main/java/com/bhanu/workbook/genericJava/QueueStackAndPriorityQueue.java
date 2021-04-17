package com.bhanu.workbook.genericJava;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class QueueStackAndPriorityQueue {
    public static void main(String[] args) {
        //Queue
        Queue<Integer> q = new ArrayDeque<>();
        q.add(5);
        q.add(6);

        //remove
        //poll
        //peek
        System.out.println(q.peek());

        //Stack
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(6);

        System.out.println(stack.peek());

        //Priority Queue -> Max Heap
        Queue<Integer> pq = new PriorityQueue<Integer>((i, j) -> Integer.compare(j, i));
        pq.add(7);
        pq.add(5);
        pq.add(8);

        System.out.println(pq.peek());
    }
}
