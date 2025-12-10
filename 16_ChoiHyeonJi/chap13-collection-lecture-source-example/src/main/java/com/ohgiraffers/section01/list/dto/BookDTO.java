package com.ohgiraffers.section01.list.dto;

public class BookDTO implements Comparable<BookDTO> {

  /* 도서 정보를 저장할 DTO 클래스를 만들어보자 */
  private int number;
  private String title;
  private String author;
  private int price;
  /* 추가된 기능 필드 */
  private boolean isRented; // 책 대여 상태 확인 기능 추가
  private String genre;     // 독자의 취향 기반 추천을 위한 장르
  private String summary;   // 줄거리 요약 제공

  /* 나중에 연령제한 기능 추가하려면 여기서 관리 가능 */
  private int ageLimit; // 독자 연령 제한 기능을 위해 추가

  public BookDTO() {}

  public BookDTO(int number, String title, String author, int price) {
    this.number = number;
    this.title = title;
    this.author = author;
    this.price = price;


    // 기본값 설정
    this.isRented = false;
    this.genre = "기타";
    this.summary = "줄거리 정보 없음.";
    this.ageLimit = 0;
  }

  /* 객체 복사 생성자 */
  public BookDTO(BookDTO other){
    this.number = other.number;
    this.title = other.title;
    this.author = other.author;
    this.price = other.price;
    this.isRented = other.isRented;
    this.genre = other.genre;
    this.summary = other.summary;
    this.ageLimit = other.ageLimit;
  }



  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public boolean isRented() { return isRented; }

  public void setRented(boolean rented) { isRented = rented; }

  public String getGenre() { return genre; }

  public void setGenre(String genre) { this.genre = genre; }

  public String getSummary() { return summary; }

  public void setSummary(String summary) { this.summary = summary; }

  public int getAgeLimit() { return ageLimit; }

  public void setAgeLimit(int ageLimit) { this.ageLimit = ageLimit; }


  @Override
  public String toString() {
    return "BookDTO{" +
        "number=" + number +
        ", title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", price=" + price +
        ", isRented=" + isRented +
        ", genre='" + genre + '\'' +
        ", ageLimit=" + ageLimit +
        '}';
  }


  /* Comparable<T> 인터페이스
   * - 같은 인스턴스 끼리의 기본 비교 방법을 정의하는
   *   compareTo() 메서드 제공 인터페이스
   * */
  @Override
  public int compareTo(BookDTO o) {
    // 가격 순서
    // return this.price - o.price;

    // 이름 순서 (String의 compareTo() 활용)
    return this.title.compareTo(o.title);
  }
}