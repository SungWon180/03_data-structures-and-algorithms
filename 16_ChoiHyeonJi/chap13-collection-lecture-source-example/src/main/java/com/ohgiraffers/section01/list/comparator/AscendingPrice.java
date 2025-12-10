package com.ohgiraffers.section01.list.comparator;

import com.ohgiraffers.section01.list.dto.BookDTO;

import java.util.Comparator;

public class AscendingPrice implements Comparator<BookDTO> {

  // 전달 받은 두 객체의 비교 방법을 정의해서 정렬 기준을 만듦
  // 결과 양수 O -> 뒤로
  // 결과 양수 X -> 앞으로

  @Override
  public int compare(BookDTO o1, BookDTO o2) {
    return o2.getPrice() - o1.getPrice(); // o1 - o2 o2 - o1
  }

}
