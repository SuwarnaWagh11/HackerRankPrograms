package com.walg.model;

public class A {
    int a = 5, b = 10;

    A(int a){
        this.a = a;
        System.out.println(this.a + "in parametrized constructor(int a)"+ a);
    }

    public A() {

    }

    int A(int a, int b){
        System.out.println(a+b + "is total \n" + this.a + "in parametrized constructor(int a)"+ this.b);
        return a+b;
    }

    boolean A(B b){
        b.testMethod1();
        return true;
    }

    public void testMethod1(){
        System.out.println("in testMethod");
    }
    public static String testMethod2(){
        return "Nothing to show in testMethod2";
    }
}
class B extends A{
    A b1 = new A();
    B b = new B();
    A b2 = new B();
}
