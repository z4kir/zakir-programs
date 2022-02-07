package com.zak;

class Mythr1 extends Thread {
    //    Mythr1(String name){
//        super(name);
//        int i=0;
//        while (i<2000) {
//            System.out.println("i am Mythr 1..... ");
//            i++;
//        }
//    }
    @Override
    public void run() {
        int i = 0;
        while (i < 10) {
            if (i == 5) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("i am Mythr 1 " + getName());
            i++;
        }
    }
}

class Mythr2 implements Runnable {
    @Override
    public void run() {
        int i = 0;
        while (i < 10) {
            System.out.println("i am Mythr 2 " + i);
            i++;
        }

    }
}

public class Main {

    public static void main(String[] args) {
        Mythr1 t1 = new Mythr1();

        t1.setName("Zak");


//        t1.setPriority(1);
//        t1.setName("zak");
//        System.out.println(t1.getState());
//        System.out.println(t1.getName());
//        System.out.println(t1.getPriority());
        t1.start();
//        t2.start();
//        t3.start();
//        t4.setPriority(Thread.MAX_PRIORITY);
//        t4.start();

//        System.out.println(t1.getState());
        Mythr2 t5 = new Mythr2();
        Thread t6 = new Thread(t5, "safiya");
        t6.start();

    }
}

