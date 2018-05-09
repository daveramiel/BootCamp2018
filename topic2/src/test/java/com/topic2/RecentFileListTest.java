package com.topic2;


import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;

import org.junit.rules.TemporaryFolder;

import java.io.File;

import java.io.IOException;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RecentFileListTest {

    private FileTest recentList;


    ///Rules allow very flexible addition or redefinition of the behavior of each test method in a test class.
        ///The TemporaryFolder Rule allows creation of files and folders that should
        ///be deleted when the test method finishes (whether it passes or fails).
    @Rule
    public TemporaryFolder tFolder = new TemporaryFolder();

    @Before
    public void setUp(){
        this.recentList = new FileTest();
    }

    ///Simple if it's empty will be GREEN!
    @Test
    public void FirstTimeRun(){
        assertTrue(recentList.getListT().isEmpty());
    }


    ///First did it in a way, after reading and learning new things... optimized
    ///Left the old code so you can view progress
    @Test
    public void FileOpenedAddRecentFile() throws IOException {
        ///At first

        ///File testing = new File("C:\\Users\\David\\Desktop\\BootCamp\\topic2\\Files\\Test.txt");

        ///After reading

        File testing = tFolder.newFile("test.txt");

        /*try {
            if (testing.createNewFile()){
                System.out.println("Created correctly");
            }else{
                System.out.println("Already Exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        recentList.addToArrayFirst(testing.getName());

        /*  NOT ANYMORE
        recentList.addToArrayFirst("reloaded.txt");
        recentList.addToArrayFirst("Matrix.txt");
        Iterator it= recentList.getListT().iterator();
        while (it.hasNext()){
            System.out.print(it.next() + " ");
        }
        */

        assertEquals(testing.getName(),recentList.getListT().getFirst());
    }


    ///Tried to create a new subFolder with archives on it, can't create Files with the same name
    ///need to ask how to do it
    @Test
    public void AlreadyExistsToTheTopYouGo() throws IOException {
        File test1 = tFolder.newFile("charles.txt");
        recentList.doesItExistAndAdd(test1.getName());
        File test2 = tFolder.newFile("logan.txt");
        recentList.doesItExistAndAdd(test2.getName());
        File test4 = tFolder.newFile("jean.txt");
        recentList.doesItExistAndAdd(test4.getName());

        File newF = tFolder.newFolder("subFolder");

        File test3 = new File(tFolder.getRoot()+"\\charles.txt");
        recentList.doesItExistAndAdd(test3.getName());
        assertEquals(test1.getName(),recentList.getListT().getFirst());
    }


    ///Playing with numbers
    @Test
    public void listFullRemoveOlder(){

        ///Setting the array with a size of 7
        int size = 7;

        for (int i=0; i < size;i++){
            recentList.addToArrayFirst(Math.random()+".txt");
        }
        ///String lastFile= (String) recentList.getListT().getLast();

        if (recentList.getListT().size() == 7 ){
            ///Removes tails from ArrayDeque in this case, the oldest file
            recentList.getListT().removeLast();
        }
        ///since we took out one of the files, should be 6... size-1
        assertEquals(size-1,recentList.getListT().size());
    }

}
