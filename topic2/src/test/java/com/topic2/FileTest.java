package com.topic2;

import lombok.Getter;
import lombok.Setter;


import java.io.File;
import java.util.ArrayDeque;

public class FileTest {

    @Getter
    @Setter
    private ArrayDeque ListT;

    public FileTest(){
        this.ListT = new ArrayDeque();
    }

    ///Making sure...
    public void addToArrayFirst(String somethingAdd){
        this.ListT.addFirst(somethingAdd);
    }

    ///Encapsulation
    public void doesItExistAndAdd(String name){
        if (this.ListT.contains(name)){
            ListT.remove(name);
            ListT.addFirst(name);
        } else {
            ListT.addFirst(name);
        }
    }

}
