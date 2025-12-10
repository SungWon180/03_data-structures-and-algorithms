package org.ho.section01.sorting;

import java.util.Arrays;

/* 삽입 정렬
 * - 이미 정렬된 부분에 새로운 요소를 적절한 위치에 삽입하는 정렬
 * - 왼쪽 부터 차례대로 확장하며,
 *   새로운 요소가 들어갈 위치를 찾기 위해 비교하면서 이동함.
 * - 시간복잡도
 *  -- 평균 : O(n^2)
 *  -- 최저 : O(n) -> 이미 정렬된 상태일 경우다 뿅 ♥
 * */
public class C_InsertSort {

  /* 문제 : n개의 정수가 주어졌을 때
   *        삽입 정렬 알고리즘을 사용하여 오름차순 정렬하는 프로그램 작성하기
   * */
  public static void solution(int[] arr) {

    System.out.println("초기 값 : " + Arrays.toString(arr));

    for (int i = 1; i < arr.length; i++) {

      int temp = arr[i]; // 삽입될 값을 임시 변수에 저장, 이거 안하면 뒤로 미룰때 넣을 값 덮어씌워져버림


      int j;

      for (j = i - 1; j >= 0; j--) {
        //기존값 > 넣을값
        if(arr[j] > temp){
          arr[j+1]=arr[j];  //=> 한칸씩 뒤로 미루기
        }else{
          break;
        }
      }

      arr[j+1] = temp; //여태 기존 값들 뒤로 미뤄서 그냥 넣으면 됨

      System.out.println((i + 1) + "번째 : " + Arrays.toString(arr));
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
