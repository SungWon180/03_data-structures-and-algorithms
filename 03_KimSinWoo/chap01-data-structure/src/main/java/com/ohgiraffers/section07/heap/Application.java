package com.ohgiraffers.section07.heap;

import java.util.PriorityQueue;

/*
* 자바 컬렉션 중 Heap을 직접 지원하는 클래스는 없지만
* Priority Queue(우선순위큐)를 이용하여 Heap을 쉽게 구현할 수 있다.
*   -> 기본적으로 최소 힙으로 동작
* 최소 힙: 낮은 숫자가 높은 우선순위를 갖는다
*
* */
public class Application {

    public static void main(String[] args) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        minheap.offer(10);
        minheap.offer(5);
        minheap.offer(8);
        System.out.println("minheap = " + minheap);
        System.out.println("minheap.peek() = " + minheap.peek());

        System.out.println("minheap.poll() = " + minheap.poll());
        System.out.println("minheap.poll() = " + minheap.poll());
        System.out.println("minheap.poll() = " + minheap.poll());

        System.out.println("----------------------------------------------------------------------------");

        /* 최대 힙(Max Heap)
        *   - PriorityQueue를 최대 힙으로 사용하기 위해선 생성자 매개변수로 comparator를 전달하여 요소의 우선 순위
        *     결정 방식을 변경해야 한다(내림차순)
        * */
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> b - a);

        maxheap.offer(10);
        maxheap.offer(5);
        maxheap.offer(8);
        System.out.println("minheap = " + maxheap);
        System.out.println("minheap.peek() = " + maxheap.peek());

        System.out.println("minheap.poll() = " + maxheap.poll());
        System.out.println("minheap.poll() = " + maxheap.poll());
        System.out.println("minheap.poll() = " + maxheap.poll());
    }
}
