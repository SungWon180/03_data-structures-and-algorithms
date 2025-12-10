package com.my.section01.sorting;

import java.util.Arrays;

/* 삽입 정렬
*  - 이미 정렬된 부분에 새로운 요소를 적절한 위치에 삽입하는 정렬
*  - 왼쪽부터 차례대로 확장하며,
*    새로운 요소가 들어갈 위치를 찾기 위해 비교하면서 이동함.
*  - 시간 복잡도
* -> 평균: O(n^2)
* -> 최저: O(n)
* */
public class C_InsertionSort {
  public static void solution(int[] arr) {
    /* 문제
    *   n개의 정수가 주어졌을때, 
    *   삽입 정렬 알고리즘을 사용하여 오름차순 정렬하는 프로그램 작성하기
    * */

    System.out.println("초기값 : " + Arrays.toString(arr));

    // 32 42 | 24 60 15
    // i = 2
    for(int i = 1; i < arr.length; i++){
      int temp = arr[i]; // 삽입될 값을 임시 변수에 저장
      // 24
      int j; // for문이 끝나도 j를 사용해야함
      // i(2) - 1 = 1
      // j-- -> 0
      // j-- -> -1
      for(j = i-1;  j >= 0; j--){
        // j = 1;
        // j = 0;
        // j = -1; false
        if(arr[j] > temp){
        // arr[1](42) > 24
        // arr[0](32) > 24
          arr[j+1] = arr[j];
          // arr[2] = arr[1](42), j = 0
          // arr[1] = arr[0](32), j = -1
        }else{
          break;
        }
      }
      arr[j+1] = temp;
      // arr[0] = 24

      System.out.println((i+1) + "번째 : " + Arrays.toString(arr));
    }
  }
}
