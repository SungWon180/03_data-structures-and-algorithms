package com.ohgiraffers.section01.list.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 독자 정보를 저장하는 DTO 클래스.
 * - id, name, age, favoriteGenre(취향)
 * - rentedBookNumbers : 현재 대여 중인 도서 번호 목록(간단히 정수 리스트로 관리)
 */
public class ReaderDTO {
  private int id;
  private String name;
  private int age;
  private String favoriteGenre;
  private List<Integer> rentedBookNumbers;
  private String summary;  // 줄거리(독자 소개)

  public ReaderDTO() {
    this.rentedBookNumbers = new ArrayList<>();
  }

  public ReaderDTO(int id, String name, int age, String favoriteGenre,String summary) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.favoriteGenre = favoriteGenre;
    this.summary = summary;
    this.rentedBookNumbers = new ArrayList<>();
  }

  public String getSummary() {
    return summary;
  }
  public void setSummary(String summary) {
    this.summary = summary;
  }


  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public int getAge() { return age; }
  public void setAge(int age) { this.age = age; }

  public String getFavoriteGenre() { return favoriteGenre; }
  public void setFavoriteGenre(String favoriteGenre) { this.favoriteGenre = favoriteGenre; }

  public List<Integer> getRentedBookNumbers() { return rentedBookNumbers; }

  // 대여 목록에 추가
  public void rentBookNumber(int bookNum) {
    if(!rentedBookNumbers.contains(bookNum)) rentedBookNumbers.add(bookNum);
  }

  // 반납 시 목록에서 제거
  public void returnBookNumber(int bookNum) {
    rentedBookNumbers.remove(Integer.valueOf(bookNum));
  }

  @Override
  public String toString() {
    return "ReaderDTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", age=" + age +
        ", favoriteGenre='" + favoriteGenre + '\'' +
        ", rentedBookNumbers=" + rentedBookNumbers +
        '}';
  }
}
