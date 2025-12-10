package com.ohgiraffers.section01.list.service;

import com.ohgiraffers.section01.list.comparator.AscendingPrice;
import com.ohgiraffers.section01.list.dto.BookDTO;
import com.ohgiraffers.section01.list.dto.ReaderDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BookService {

  private List<BookDTO> bookList;
  private List<ReaderDTO> readerList; // 독자 목록 추가



  public BookService(){
    bookList = new ArrayList<>();
    readerList = new ArrayList<>();

    /* 도서 정보 추가 */
    bookList.add(new BookDTO(1, "홍길동전", "허균", 50000));
    bookList.add(new BookDTO(2, "목민심서", "정약용", 30000));
    bookList.add(new BookDTO(3, "동의보감", "허준", 40000));
    bookList.add(new BookDTO(4, "삼국사기", "김부식", 46000));
    bookList.add(new BookDTO(5, "삼국유사", "일연", 58000));


    // 기본 독자 데이터 추가 (예시)
    readerList.add(new ReaderDTO(1, "김철수", 15, "역사","역사 좋아하는 학생"));
    readerList.add(new ReaderDTO(2, "박영희", 22, "철학","철학 서적 자주 읽음"));
    readerList.add(new ReaderDTO(3, "홍길동", 35, "의학","의학 관련 도서 즐겨봄"));
  }


  // getter
  public List<BookDTO> getBookList(){
    return bookList;
  }



  // 독자 메서드 추가
  /**
   * id로 독자 조회
   */
  public ReaderDTO getReaderById(int readerId){
    for(ReaderDTO reader : readerList){
      if(reader.getId() == readerId) return reader;
    }
    return null;
  }

  /**
   * (선택) 전체 독자 목록 반환 필요하면 추가
   */
  public List<ReaderDTO> getReaderList(){
    return readerList;
  }



  /**
   * 책 대여 처리
   * - 존재 여부, 대여중 여부, 연령 제한 체크
   * - 성공하면 BookDTO.isRented = true, ReaderDTO의 rentedBookNumbers에 추가
   */
  public boolean rentBook(int bookNumber, ReaderDTO reader){
    BookDTO book = selectBookNumber(bookNumber);

    if(book == null) return false;            // 책 없음
    if(book.isRented()) return false;         // 이미 대여중
    if(reader.getAge() < book.getAgeLimit()) return false; // 연령 제한

    book.setRented(true);
    reader.rentBookNumber(bookNumber);        // 독자의 대여 목록에 추가
    return true;
  }

  /**
   * 책 반납 처리
   * - 책이 존재하고 대여중인지 확인
   * - 반납하면 해당 대여기록을 가진 독자를 찾아서 독자 목록에서 제거
   */
  public boolean returnBook(int bookNumber){
    BookDTO book = selectBookNumber(bookNumber);

    if(book == null) return false;
    if(!book.isRented()) return false;

    // 책이 대여중이면 해당 책을 대여한 독자 찾기
    ReaderDTO renter = findReaderByRentedBook(bookNumber);
    if(renter != null){
      renter.returnBookNumber(bookNumber);
    }
    book.setRented(false);
    return true;
  }


  /**
   * bookNumber를 현재 대여중인 독자 찾기 (없으면 null)
   */
  private ReaderDTO findReaderByRentedBook(int bookNumber){
    for(ReaderDTO r : readerList){
      if(r.getRentedBookNumbers().contains(bookNumber)) return r;
    }
    return null;
  }

  /**
   * 독자 취향(장르) 기반 추천
   */
  public List<BookDTO> recommendByGenre(ReaderDTO reader){
    if(reader == null) return new ArrayList<>();
    String fav = reader.getFavoriteGenre();
    return bookList.stream()
        .filter(b -> fav != null && fav.equalsIgnoreCase(b.getGenre()))
        .collect(Collectors.toList());
  }

  /**
   * 책 목록에서 번호(number)가 일치하는 책을 찾아서 반환
   * @param bookNumber
   * @return BookDTO 또는 null
   */
  public BookDTO selectBookNumber(int bookNumber) {

    // 반복문을 이용해서 모든 책 인스턴스에 접근
    for(BookDTO book : bookList){
      if(book.getNumber() == bookNumber) return book;
    }

    return null; // 번호가 일치하는 책이 없음
  }


  /**
   * 책 목록에 새로운 책 추가
   * 단, "제목"이 중복되는 책은 추가 X
   * 반환되는 number는 마지막 number + 1
   * @param newBook
   * @return number 또는 0
   */
  public int addBook(BookDTO newBook) {

    // 제목 중복 체크
    for(BookDTO book : bookList){
      if(book.getTitle().equals(newBook.getTitle())) // 중복인 경우
        return 0;
    }

    // 다음 번호 생성
    int nextNumber = bookList.get(bookList.size()-1).getNumber() + 1;

    // 책 정보를 목록에 추가
    newBook.setNumber(nextNumber);
    bookList.add(newBook);

    return newBook.getNumber(); // 생성된 책 번호 반환
  }

  /**
   * 도서 목록에서 번호가 일치하는 책 제거
   * @param bookNumber
   * @return 제거된 BookDTO 또는 null
   */
  public BookDTO deleteBook(int bookNumber) {

    // 반복문을 이용해서 모든 책 인스턴스에 접근
    // -> 똑같은 번호의 책을 목록에서 제거 후 반환
    for(int i=0 ; i<bookList.size() ; i++){
      if(bookList.get(i).getNumber() == bookNumber){
        return bookList.remove(i);
      }
    }

    return null;
  }

  /**
   * 책 제목 중 일부라도 keyword와 일치하는 책을 모두 반환
   * @param keyword
   * @return searchBookList
   */
  public List<BookDTO> searchBook(String keyword) {
    List<BookDTO> searchBookList = new ArrayList<>();

    for(BookDTO book : bookList){
      // 제목에 keyword가 포함되어 있으면 true
      if(book.getTitle().contains(keyword)){
        searchBookList.add(book); // 검색된 책 목록에 keyword 포함 책 추가
      }
    }

    return searchBookList;
  }




  /**
   * List 복사본을 만들어서 정렬 후 반환
   * @param sortingNumber
   * @return sortedBookList
   */
  public List<BookDTO> sortBookList(int sortingNumber) {

    // Collections.sort() -> 원본 정렬

    // 스트림을 이용한 List 깊은 복사
    List<BookDTO> sortedList
        = bookList.stream().map(BookDTO::new).collect(Collectors.toList());

    if(sortingNumber == 1){ // 이름 오름차순(기본 정렬)
      Collections.sort(sortedList);
    } else{ // 가격 오름 차순(추가 정렬 기준)
      Collections.sort(sortedList, new AscendingPrice());
    }

    return sortedList;
  }

}