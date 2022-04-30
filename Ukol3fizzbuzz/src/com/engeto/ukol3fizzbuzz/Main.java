package com.engeto.ukol3fizzbuzz;

public class Main {

    public static void main(String[] args) {

        int number = 1;

        for (int i = 1; i <= 100; i++) {

            if (number % 3 == 0 && number % 5 ==0) {
                System.out.println("FizzBuzz");
            }
            else if (number % 3 == 0) {
                System.out.println("Fizz");
            }
            else if (number % 5 ==0) {
                System.out.println("Buzz");
            }
            else {
                System.out.println(number + " ");
            }
            number = number + 1;
        }
    }
}