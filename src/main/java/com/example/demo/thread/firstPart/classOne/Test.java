package com.example.demo.thread.firstPart.classOne;

public class Test {
    private static long count = 0;

    private void vok(){
        int vc = 0;
        while (vc++ < 10000){
            count+=1;
        }
    }

    private static long calc() throws Exception{
        final Test test = new Test();
        Thread t1 = new Thread(()->{
            test.vok();;
        });
        Thread t2 = new Thread(()->{
            test.vok();;
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        return count;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Test.calc());

    }

}
