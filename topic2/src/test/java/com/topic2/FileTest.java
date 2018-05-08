package com.topic2;

import lombok.Getter;
import lombok.Setter;


import java.util.ArrayDeque;

public class FileTest {

    @Getter
    @Setter
    private ArrayDeque ListT;

    public FileTest(){
        this.ListT = new ArrayDeque();
    }

    public void addToArrayFirst(String somethingAdd){
        this.ListT.addFirst(somethingAdd);
    }

}
