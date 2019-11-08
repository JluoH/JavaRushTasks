package com.javarush.task.task24.task2401;

/* 
Создание своего интерфейса-маркера
*/
public class Solution {
    public static void main(String[] args) throws UnsupportedInterfaceMarkerException {
        SelfInterfaceMarkerImpl obj = new SelfInterfaceMarkerImpl();
        Util.testClass(obj);
    }
}

interface SelfInterfaceMarker {
}

class SelfInterfaceMarkerImpl implements SelfInterfaceMarker {
    public void method1() {
        System.out.println("qq1");
    }

    public void method2() {
        System.out.println("qq2");
    }
}

class UnsupportedInterfaceMarkerException extends Exception {

}