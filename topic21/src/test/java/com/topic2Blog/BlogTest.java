package com.topic2Blog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;

import static org.mockito.Mockito.*;

public class BlogTest {

    private Blog postsList;

    @Before
    public void setUp(){this.postsList = new Blog();}


    @Test
    public void addNewPost() {
        Post post = mock(Post.class);
        when(post.getTitle()).thenReturn("First Post Dude");
        when(post.getPost()).thenReturn("This is my first post");
        this.postsList.addNewPost(post);
        assertEquals(this.postsList.getNewestPost().getTitle(), post.getTitle());
    }

    @Test
    public void PostListIsEmpty() {
        assertTrue(this.postsList.isEmpty());
    }


    @Test
    public void deletePostByName() {
        Boolean answer = false;
        Post postD = mock(Post.class);
        when(postD.getTitle()).thenReturn("first for fun");
        Post postF = mock(Post.class);
        when(postF.getTitle()).thenReturn("second for fun");
        Post postX = mock(Post.class);
        when(postX.getTitle()).thenReturn("delete this one");

        this.postsList.addNewPost(postD);
        this.postsList.addNewPost(postF);
        this.postsList.addNewPost(postX);

        for (Post posty : this.postsList.getBloggy()) {

            if (postX.getTitle().equalsIgnoreCase(posty.getTitle())) {
                this.postsList.getBloggy().remove(posty);
                answer = true;
            }

        }
        assertTrue(answer);
    }

    @Test
    public void bringMeTheTenMostRecent(){
        Post postD = mock(Post.class);
        for (int i=0;i < 15; i++){
            when(postD.getTitle()).thenReturn("Mocking Post" + i);
            this.postsList.getBloggy().add(postD);
        }
        ArrayDeque<Post> lastTen = this.postsList.getNewestTenPosts();
        assertEquals(lastTen.size(),10);
    }
}
