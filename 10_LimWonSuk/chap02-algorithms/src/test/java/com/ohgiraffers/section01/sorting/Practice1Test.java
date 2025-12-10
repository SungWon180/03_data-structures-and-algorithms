package com.ohgiraffers.section01.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Practice1Test {
    static int[] act1, exp1, act2, exp2, act3, exp3;

    @BeforeAll // 다른 테스트가 하나도 시작하기 전에
    static void setUp(){
        act1 = new int[]{34, 23, 5, 24, 1, 9, 12};
        exp1 = new int[]{1, 5, 9, 12, 23, 24, 34};
        act2 = new int[]{22, 4, 2, 33, 51, 122, 31};
        exp2 = new int[]{2, 4, 22, 31, 33, 51, 122};
        act3 = new int[]{1, 2, 4, 6, 5, 7, 8};
        exp3 = new int[]{1, 2, 4, 5, 6, 7, 8};
    }
    static Stream<Arguments> provideAscendingSource(){
        return Stream.of(
                Arguments.of(act1, exp1),
                Arguments.of(act2, exp2),
                Arguments.of(act3, exp3)

        );
    }
    @DisplayName("최적화된 버블 정렬 테스트")
    @ParameterizedTest // provideAscendingSource 에서 참조
    @MethodSource("provideAscendingSource")
    void testBubbleSort(int[] act, int[] exp){
        Practice1.solution(act);
        Assertions.assertArrayEquals(act, exp); // 배열 요소가 모두 같으면 성공
    }
}
