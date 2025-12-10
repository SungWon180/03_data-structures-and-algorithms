package com.ohgiraffers.section01.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class A_BubbleSortTest {

    static int[] act1, exp1, act2, exp2;

    @BeforeAll
    static void setUp() {
        act1 = new int[]{9,8,7,6,5,4,3,2,1};
        exp1 = new int[]{1,2,3,4,5,6,7,8,9};

        act2 = new int[]{1,2,3,4,5,9,8,7,6};
        exp2 = new int[]{1,2,3,4,5,6,7,8,9};
    }

    static Stream<Arguments> provideAscendingSource() {
        return Stream.of(
                Arguments.of(act1, exp1),
                Arguments.of(act2, exp2)
        );
    }

    @DisplayName("버블 정렬 테스트")
    @ParameterizedTest
    @MethodSource("provideAscendingSource")
    void testBubbleSort(int[] act, int[] exp) {
        A_BubbleSort.solution(act); // 배열 원본 정렬
        Assertions.assertArrayEquals(act, exp); // 배열 요소 모두 같으면 성공
    }

}