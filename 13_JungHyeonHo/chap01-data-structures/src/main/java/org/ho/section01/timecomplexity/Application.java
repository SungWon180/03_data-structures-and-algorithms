package org.ho.section01.timecomplexity;

import java.util.Arrays;
import java.util.stream.IntStream;

/* ** 시간 복잡도를 이해할 수 있다 **
*
시간 복잡도란?
- 알고리즘(로직) 해결하는데 걸리는 시간의 양을 나타내는 척도
- 입력 크기(n)에 대한 함수로 표현
- Big-O 표기법을 사용하여 최악의 경우를 나타냄
- 특정 알고리즘이 대규모 데이터 셋에서 얼마나 잘 동작할지 예측하는데 중요함
*  */
public class Application {
  public static void main(String[] args) {

    int[] arr={3,1,2,15,4,9,10,7};
    System.out.println("상수 시간 O(1) 결과 : "+getFirst(arr));

    System.out.println("선형 시간 O(n) 결과 : "+ Arrays.toString(reverse(arr)));

    System.out.println("로그 시간 O(log n) 결과 인덱스 : " + binarySearch(arr,1));

    System.out.println("지수 시간 O(2^n) 결과 : "+fibonacci(8));
  }

/*
상수 시간 O(1)
- 입력된 크기와 관련 없이 코드 실행 시간이 일정한 경우를 의미
* */
  private static int getFirst(int[] arr){
    int[] arr2 = new int[10]; // 배열의 시작 arr[idx] => idx는 0부터시작해. 1이아니라
    int[] arr3 = {1,2,3,4,5,6};
    for(int i=1;i<=10;i++){
      arr2[i-1]=i;
      /* i = 1   arr2[1]=1;
      *  i = 2   arr2[2]=2;
      *  ...
      *  i = 10  arr2[10]=10;*/
    }
    // 입력된 배열의 크기가 아무리 커지더라도
    // 연산은 딱 한 번(덧셈)만 수행됨
    // == 입력 크기가 실행 시간에 영향을 주지 않는다
    return arr[0]+arr[1];
  }

/*
선형 시간 O(n)
- 입력된 크기(n)에 비례하여 실행 시간이 증가하는 경우를 의미
- 흔한 예시 : 배열/리스트 순회
- 이점 : 입력 크기에 따라 예측 가능한 성능을 제공한다.
* */
  private static int[] reverse(int[] arr){

//    for (int i = 0; i < arr.length/2; i++) {
//      int tmp=arr[i];
//      arr[i]=arr[arr.length-i-1];
//      arr[arr.length-i-1]=tmp;
//    }
    int[] reversed = IntStream.range(0,arr.length)
        .map(i -> arr[arr.length-1-i])
        .toArray();
    return reversed;
  }
  /* 로그 시간 O(log n)
   *  - 입력 크기(n)가 증가할 때, 실행 시간이 로그 함수적으로 증가하는 경우를 의미
   *  - 주로 탐색 공간을 절반씩 줄여 나가며 탐색하는 알고리즘에서 나타남
   *  - 이점 : 입력이 커져도 효율적인 성능을 유지함
   * */
  private static int binarySearch(int[] arr, int target){

    /* 초기 세팅
    *  - 배열 내 요소가 오름차순 정렬이 되어있어야 한다
    * */

    // Arays.sort(arr)
    // - 배열 원본 정렬
    // - Arays.sort()는 일반적으로 O(n log n)의 시간복잡도를 가진다
    // -> 정렬 시간은 제외하고 생각하자!
    Arrays.sort(arr); // 배열 원본 정렬

    // 탐색 시작(left), 끝(right) 인덱스를 가리키는 포인터
    int left = 0;
    int right = arr.length - 1;

    while (left<=right){
      // 중간 찾기
//      int mid = left + (right - left) / 2;
      int mid = (left+right)/2;

      // 1. 찾으려는 target이 mid와 같다면
      if(target == arr[mid]) return mid; // 가운데를 나타내는 인덱스 반환

      // 2. 찾으려는 target이 중간보다 왼쪽에 있는가? 오른쪽에 있는가?
      if(target > arr[mid]) left = mid +1;
      else right = mid -1;
    }
    // 3. 결과값이 -1이면 못찾은거
    return -1;
  }
  /*
 지수 시간 O(2^n)
 - 입력 크기(n)이 증가할 때 마다 2의 n제곱에 비례하여
   시간이 기하급수적으로 증가하는 경우를 의미
   */
  private static int fibonacci(int n){
    if(n <= 1) return n;
    return fibonacci(n-1)+fibonacci(n-2);
  }
}
