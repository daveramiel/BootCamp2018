package com.topic2;


import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;

import org.junit.rules.TemporaryFolder;

import java.io.File;

import java.io.IOException;
import java.util.Iterator;

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
        FileTest recentList = new FileTest();
    }

    @Test
    public void FirstTimeRun(){
        assertTrue(recentList.getListT().isEmpty());
    }

    @Test
    public void FileOpenedAddRecentFile(){
        ///At first

        ///File testing = new File("C:\\Users\\David\\Desktop\\BootCamp\\topic2\\Files\\Test.txt");

        ///After reading
        File testing = tFolder.newFile("testing.txt");

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

        String nameFile = testing.getName();
        recentList.addToArrayFirst(nameFile);
        recentList.addToArrayFirst("reloaded.txt");
        recentList.addToArrayFirst("Matrix.txt");
        Iterator it= recentList.getListT().iterator();
        while (it.hasNext()){
            System.out.print(it.next() + " ");
        }
    }

    public void AlreadyExistsTotheTopYouGo(){


    }

}
