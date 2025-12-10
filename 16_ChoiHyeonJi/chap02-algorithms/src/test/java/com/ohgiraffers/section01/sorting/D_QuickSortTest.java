package com.ohgiraffers.section01.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class D_QuickSortTest {
  static int[] act1, exp1, act2, exp2, act3, exp3; // act 실제 실행 exp 예상 결과

  @BeforeAll
  static void setUp(){
    act1 = new int[]{34, 23, 5, 24, 1, 9, 12};
    exp1 = new int[]{1, 5, 9, 12, 23, 24, 34};
    act2 = new int[]{35, 18, 1, 24, 8, 9, 20, 5};
    exp2 = new int[]{1, 5, 8, 9, 18, 20, 24, 35};
    act3 = new int[]{306, 99, 267, 21, 196, 56, 319, 131, 233, 305};
    exp3 = new int[]{21, 56, 99, 131, 196, 233, 267, 305, 306, 319};

  }


  static Stream<Arguments> provideAscendingSource() {
    return Stream.of(
        Arguments.of(act1,exp1),
        Arguments.of(act2, exp2),
        Arguments.of(act3, exp3)
    );
  }

  @DisplayName("퀵 정렬 테스트")
  @ParameterizedTest
  @MethodSource("provideAscendingSource")
  void testQuickSort(int[] act, int[] exp){
      D_QuickSort.solution(act);
      Assertions.assertArrayEquals(act, exp);
  }

}