package com.hyeonji.section3;

public class Application {

  static class Car {
    String model;
    int speed;

    void speedUp() {
      speed += 10;
    }
    void speedDown() {
      speed -= 10;
    }

  }
    public static void main(String[] args) {
      Car car = new Car();
      car.model = "소나타";
      car.speed = 0;

      car.speedUp();
      car.speedUp();
      car.speedDown();

      System.out.println("현재 속도: " + car.speed);
    }
}
