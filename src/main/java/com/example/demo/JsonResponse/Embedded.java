/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.JsonResponse;

/**
 *
 * @author device02
 */
public class Embedded<T> {
    
    
    T[] arr;
//String arrName;
    public Embedded(){//String arrName) {
        //this.arrName=arrName;
    }

    public T[] getArr() {
        return arr;
    }

    public void setArr(T[] arr) {
        this.arr = arr;
    }
    
}
