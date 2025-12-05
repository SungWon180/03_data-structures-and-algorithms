package com.mycompany.section04.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1158 {
  public static void main(String[] args) {

  }
  public static String solution(int N, int K){

    Queue<Integer> queue = new LinkedList<>();

    // 1부터 N만큼의 사람을 추가
    for (int i = 1; i <= N; i++) {
      queue.offer(i);
    }

    // 결과 문자열 만들기용 가변 문자열 객체
    StringBuilder sb = new StringBuilder();

    sb.append("<");
    // 큐에 사람이 남아 있으면 반복 == 모든 사람이 나가면 반복 종료
    while(!queue.isEmpty()){

      // K-1번 반복 하여 Queue 앞의 사람을 뒤로 옮기는 작업
      for (int i = 0; i < K-1; i++) {
        queue.offer(queue.poll());
      }

      // K번째 사람을 꺼내고 StringBuilder에 추가
      sb.append(queue.poll());

      // 아직 큐에 남은사람이 있을경우
      if(!queue.isEmpty()) {
        sb.append(", ");} // 쉼표 + 공백 추가
    }
    sb.append(">");
    return sb.toString(); // <3, 6, 2, 7, 5, 1, 4>
  }
}
