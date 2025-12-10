package com.ohgiraffers.section07.heap;

import java.util.PriorityQueue;

public class B11289 {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        minHeap.offer(13);
        maxHeap.offer(0);
        maxHeap.offer(1);
        maxHeap.offer(2);
        maxHeap.offer(0);
        maxHeap.offer(0);
        maxHeap.offer(3);
        maxHeap.offer(2);
        maxHeap.offer(1);
        maxHeap.offer(0);
        maxHeap.offer(0);
        maxHeap.offer(0);
        maxHeap.offer(0);
        maxHeap.offer(0);

        System.out.println("현재 최대 힙 : " + maxHeap);
        System.out.println("최대값 조회()) : " + maxHeap.peek());

        System.out.println("poll() 결과 : " + maxHeap.poll());
        System.out.println("현재 최대 힙 : " + maxHeap);

        System.out.println("poll() 결과 : " + maxHeap.poll());
        System.out.println("현재 최대 힙 : " + maxHeap);

        System.out.println("poll() 결과 : " + maxHeap.poll());
        System.out.println("현재 최대 힙 : " + maxHeap);

        System.out.println("poll() 결과 : " + maxHeap.poll());
        System.out.println("현재 최대 힙 : " + maxHeap);

        System.out.println("poll() 결과 : " + maxHeap.poll());
        System.out.println("현재 최대 힙 : " + maxHeap);

        System.out.println("poll() 결과 : " + minHeap.poll());
        System.out.println("현재 최소 힙 : " + minHeap);

        int[] heap = {0, 2, 1, 3, 2, 1, 0 , 0};


        int[] order = {0, 6, 1, 4, 7, 3, 2, 5};

        for (int i : order) {
            System.out.println(heap[i]);
        }



    }






    }

