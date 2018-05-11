package com.topic2Blog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import java.util.ArrayDeque;
import java.util.Iterator;

public class BlogTest {

    private ArrayDeque<PostTest> postsList;

    @Before
    public void setUp() {
        this.postsList = new ArrayDeque<>();
    }

    @Test
    public void addNewPost() {
        PostTest post = mock(PostTest.class);
        when(post.getTitle()).thenReturn("First Post Dude");
        when(post.getPost()).thenReturn("This is my first post");
        this.postsList.addFirst(post);
        assertEquals(this.postsList.getFirst().getTitle(), post.getTitle());
    }

    @Test
    public void PostListIsEmpty() {
        assertTrue(this.postsList.isEmpty());
    }


    @Test
    public void deletePostByName() {
        Boolean answer = false;
        PostTest postD = mock(PostTest.class);
        when(postD.getTitle()).thenReturn("first for fun");
        PostTest postF = mock(PostTest.class);
        when(postF.getTitle()).thenReturn("second for fun");
        PostTest postX = mock(PostTest.class);
        when(postX.getTitle()).thenReturn("delete this one");

        this.postsList.add(postD);
        this.postsList.add(postF);
        this.postsList.add(postX);

        for (PostTest posty : this.postsList) {

            if (postX.getTitle().equalsIgnoreCase(posty.getTitle())) {
                this.postsList.remove(posty);
                answer = true;
            }

        }
        assertTrue(answer);
    }

    @Test
    public void bringMeTheTenMostRecent(){
        PostTest postD = mock(PostTest.class);
        for (int i=0;i < 15; i++){
            when(postD.getTitle()).thenReturn("Mocking Post" + i);
            this.postsList.add(postD);
        }
        int j= 0;
        Iterator ite = this.postsList.iterator();
        while (j<10 && ite.hasNext()){

        }
    }
}
