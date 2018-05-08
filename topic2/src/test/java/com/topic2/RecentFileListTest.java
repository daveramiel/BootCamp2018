package com.topic2;


import org.junit.Test;

import java.io.File;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertTrue;

public class RecentFileListTest {

    @Test
    public void FirstTimeRun(){
        FileTest newList = new FileTest();
        assertTrue(newList.getListT().isEmpty());
    }

    @Test
    public void FileOpenedAddRecentFile(){
        File newFile = new File
    }

}
