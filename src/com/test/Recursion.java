package com.test;

public class Recursion {
    public static void main(String[] args) {
System.out.println(powerOf(2,5));
    }
    private static int powerOf(int no, int power){
        if(power==0){
            return 1;
        }
        return no*powerOf(no,power-1);
    }
    private static int sum(int no){
        if(no==0){
            return 0;
        }
        return no+sum(no-1);
    }
    public static int powerOf10(int n) {
        if (n == 0) {
            return 1;
        }
        return powerOf10(n-1) * 10;
    }
}
