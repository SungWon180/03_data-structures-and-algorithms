package com.ohgiraffers.section06.tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {


    static class Node<T> {
        T data; // 노드에 저장될 데이터
        Node<T> left; // 왼쪽 자식 노드
        Node<T> right; // 오른쪽 자식 노드

        Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    // 최상위 노드
    private Node<T> root;

    public BinarySearchTree() {
        this.root = null;
    }


    /**
     * 트리에 새로운 데이터를 삽입하는 메서드
     * @param data
     */
    public void insert(T data) {
        this.root = insertRec(this.root, data);
    }


    /**
     * 노드 삽입을 위한 재귀 헬퍼 메서드
     * @param node 현재 탐색 중인 노드
     * @param data 삽입할 데이터
     * @return Node<T> 삽입 후 서브 트리의 루트 노드
     */
    private Node<T> insertRec(Node<T> node, T data) {
        // 현재 노드가 null인 경우 새로운 노드 생성, 반환
        if (node == null) {
            return new Node<>(data);
        }
        // 현재 data가 node.data보다 작을 경우 -> 왼쪽 삽입
        if (data.compareTo(node.data) < 0) {
            node.left = insertRec(node.left, data);
        }
        // 현재 data가 node.data보다 큰 경우 -> 오른쪽 삽입
        else if (data.compareTo(node.data) > 0) {
            node.right = insertRec(node.right, data);
        }
        // 현재 data가 node.data와 같을 경우 -> 중복이라서 삽입X
        return node;
    }


    /* Tree traversal */

    /**
     * 전위 순회 : Root -> L -> R
     * @return
     */
    public List<T> preOrder() {
        List<T> result = new ArrayList<>();
        preOrderRec(this.root, result);
        return result;
    }

    /**
     * 재귀용 전위 순회 헬퍼 메서드
     * @param node
     * @param result
     */
    private void preOrderRec(Node<T> node, List<T> result) {
        if (node != null) {
            result.add(node.data); // 현재 노드 값 기록 -> Root Node 방문
            preOrderRec(node.left, result); // 왼쪽 순회
            preOrderRec(node.right, result); // 오른쪽 순회
        }
    }


    /**
     * 중위 순회 : L -> Root -> R
     * @return
     */
    public List<T> inOrder() {
        List<T> result = new ArrayList<>();
        inOrderRec(this.root, result);
        return result;
    }

    /**
     * 재귀용 중위 순회 헬퍼 메서드
     * @param node
     * @param result
     */
    private void inOrderRec(Node<T> node, List<T> result) {
        if (node != null) {
            inOrderRec(node.left, result); // 왼쪽 순회
            result.add(node.data); // 현재 노드 값 기록 -> Root Node 방문
            inOrderRec(node.right, result); // 오른쪽 순회
        }
    }


    /**
     * 후위 순회 : L -> R -> Root
     * @return
     */
    public List<T> postOrder() {
        List<T> result = new ArrayList<>();
        postOrderRec(this.root, result);
        return result;
    }

    /**
     * 재귀용 후위 순회 헬퍼 메서드
     * @param node
     * @param result
     */
    private void postOrderRec(Node<T> node, List<T> result) {
        if (node != null) {
            postOrderRec(node.left, result); // 왼쪽 순회
            postOrderRec(node.right, result); // 오른쪽 순회
            result.add(node.data); // 현재 노드 값 기록 -> Root Node 방문
        }
    }


    /**
     * 특정 데이터가 트리 내 있는지 검색
     * 시간 복잡도: O(logN) ~ O(N)
     * @param data
     * @return 존재하면 true, 없으면 false
     */
    public boolean search(T data) {
        return searchRec(this.root, data);
    }

    /**
     * 노드 탐색 헬퍼 메서드
     * @param node 현재 노드
     * @param data 찾을 값
     * @return 찾으면 true, 못찾으면 false
     */
    private boolean searchRec(Node<T> node, T data) {

        // 마지막 자식 노드의 왼쪽 또는 오른쪽이 null == 찾는 값이 없다.
        if (node == null) {
            return false;
        }

        // 찾을 값과 현재 노드 값이 같은 경우 == 찾음
        if (data.compareTo(node.data) == 0) {
            return true;
        }

        // 재귀 호출을 이용해서 왼쪽/오른쪽 반복 탐색
        return data.compareTo(node.data) < 0 ? searchRec(node.left, data) : searchRec(node.right, data);
    }

    /**
     * 트리에서 특정 데이터가 포함된 노드 삭제
     * @param data
     */
    public void delete(T data) {
        root = deleteRec(this.root, data);
    }

    /**
     * 노드 삭제 헬퍼 메서드
     * @param node
     * @param data
     * @return
     */
    private Node<T> deleteRec(Node<T> node, T data) {
        if (node == null) {
            return node; // 삭제할 데이터가 트리에 없음
        }
        if (data.compareTo(node.data) < 0) {
            node.left = deleteRec(node.left, data);
        }else if (data.compareTo(node.data) > 0) {
            node.right = deleteRec(node.right, data);
        }else {
            // 삭제할 노드를 찾았을 경우 (3가지 경우)

            // 1) 자식 노드가 왼쪽이 없을 때
            if (node.left == null) {
                return node.right;
            }
            // 2) 자식 노드가 오른쪽이 없을 때
            else if (node.right == null) {
                return node.left;
            }
            // 3) 자식 노드가 둘 다 있을 경우
            // -> 오른쪽 서브트리에서 가장 작은 값을 찾아 현재 노드의 데이터로 대체
            node.data = minValue(node.right);

            // 제일 작은 값을 가지는 노드를 삭제
            node.right = deleteRec(node.right, node.data);
        }
        return node;
    }

    /**
     * 특정 서브트리에서 가장 작은 값 찾는 헬퍼 메서드
     * @param node
     * @return
     */
    private T minValue(Node<T> node) {
        T minVal = node.data;
        while (node.left != null) { // 왼쪽 자식 노드가 있다면 반복
            node = node.left;
            minVal = node.data;
        }
        return minVal;
    }


    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("=============Tree traversal==============");
        System.out.println("PreOrder: " + bst.preOrder());
        System.out.println("InOrder: " + bst.inOrder());
        System.out.println("PostOrder: " + bst.postOrder());


        System.out.println("=============Search==============");
        System.out.println("Search(50): " + bst.search(50));
        System.out.println("Search(100): " + bst.search(100));

        System.out.println("=============Delete==============");
        bst.delete(20);
        System.out.println("After delete(50): " + bst.preOrder());



    }




}
