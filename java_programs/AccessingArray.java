package com.zak.Exception;

import java.util.Scanner;

class MaxRetries extends Exception {
    @Override
    public String toString() {
        return "error you have reached max tries";

    }

    @Override
    public String getMessage() {
        return "error";
    }

}


public class AccessingArray {
    static void ArrayPrinter(int[] a) throws MaxRetries {
        int j = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter index of array :");
        for (int i = 0; i < 5; i++) {
            try {
                int n = sc.nextInt();
                System.out.println("elment of index" + n + " is " + a[n]);
                break;

            } catch (Exception e) {
                System.out.println("Invalid Index input");
                j++;
            }

        }


        if (j >= 5) {
            try {
                throw new MaxRetries();
            } catch (Exception e) {
                System.out.println(e);
                System.out.println(e.getMessage());
            }

        }
    }

    public static void main(String[] args) {
        int[] a = new int[5];
        a[0] = 12;
        a[1] = 13;
        a[2] = 14;
        a[3] = 15;
        a[4] = 16;
        //    AccessingArray d=new AccessingArray();
        try {
            ArrayPrinter(a);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
