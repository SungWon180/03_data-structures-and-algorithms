package com.ohgiraffers.section01.sorting;


import java.util.Arrays;

/* 최적화된 버블 정렬 구현하기
*   - 버블 정렬은 인접한 두 요소를 비교하여 정렬하기 때문에 일반적으로 O(n^2)의 시간복잡도를 갖는다.
*   - 다만, 정렬이 어느 정도 되어있는 경우 불필요한 비교를 줄여서 O(n)까지 최적화(성능 개선)이 가능하다.
*
* */
public class Practice1 {

    public static void solution(int[] arr) {

        /* n개의 정수가 주어졌을 때
         * 버블 정렬 알고리즘을 사용하여 오름차순 정렬하는 프로그램 작성하기
         * */
        System.out.println("초기 값: " + Arrays.toString(arr));


        boolean swapped = false;
        // 버블이 처음 -> 끝 이동을 반복하는 루프
        for (int i = 0; i < arr.length-1; i++) {
            // 버블 이동 루프
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j+1);
                    swapped = true; // swap한적있음
                }
            }
            System.out.print(i+1 + "번째: " + Arrays.toString(arr) +"\n");

            if (!swapped) { // swap한적이 없는 경우
                break;
            }
        }

    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



}
