package com.ohgiraffers.section06.tree;


import com.sun.source.tree.Tree;

import java.util.TreeMap;

/*
* 자바 컬렉션의 TreeSet, TreeMap이 트리 구조를 활용하고 있음.
* 내부적으로 레드-블랙 트리로 구현되어 있음
* -> 데이터가 정렬된 상태를 유지하면서도 검색, 삽입, 삭제시 O(logN) 성능 보장
*
* */
public class Application {

    public static void main(String[] args) {

        /* TreeMap
        *   - Key를 기준으로 자동 정렬되는 맵
        * */

        // Key(String) 오름차순(기본정렬)으로 정렬되는 TreeMap 생성
        TreeMap<String, String> map = new TreeMap<>();

        map.put("apple", "사과");
        map.put("orange", "오렌지");
        map.put("banana", "바나나");
        map.put("grape", "포도");

        System.out.println("map = " + map);

        System.out.println("key == banana : " + map.get("banana"));
        System.out.println("key == melon : " + map.get("melon"));

        System.out.println(map.remove("orange"));
        System.out.println(map);
    }

}