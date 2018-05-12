package com.topic2Blog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;

import static org.mockito.Mockito.*;

public class BlogTest {

    private Blog postsList;

    ///Let's set up everything before we do anything
    @Before
    public void setUp(){this.postsList = new Blog();}


    ///Comparing using addNewPost() which inserts in the first place of the ArrayDeque with Mocking a new Post
    @Test
    public void addNewPost() {
        Post post = mock(Post.class);
        when(post.getTitle()).thenReturn("First Post Dude");
        when(post.getPost()).thenReturn("This is my first post");
        this.postsList.addNewPost(post);
        assertEquals(this.postsList.getNewestPost().getTitle(), post.getTitle());
    }

    ///Testing testing if it's empty
    @Test
    public void PostListIsEmpty() {
        assertTrue(this.postsList.isEmpty());
    }


    ///Using the method deletePostByTitle() which returns true or false on a blog, with mocking posts
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
                this.postsList.deletePostByTitle(posty.getTitle());
                answer = true;
            }

        }
        assertTrue(answer);
    }

    ///getNewestTenPosts() returns a new ArrayDeque with the latest 10 posts
    ///comparing the size of the new ArrayDeque "lastTen" with 10
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

    ///Don't know why using it again let's just leave it here commented
    /*
    @Test
    public void isEmpty(){
        assertTrue(this.postsList.isEmpty());
    }
    */

    ///Making sure that the method getOldestPost() returns the latest post using mocking post on my blog.
    @Test
    public void oldestPost(){
        Post postD = mock(Post.class);
        for (int i=0;i < 15; i++){
            when(postD.getTitle()).thenReturn("Mocking Post " + i);
            this.postsList.getBloggy().add(postD);
        }
        assertEquals("Mocking Post 14",this.postsList.getOldestPost().getTitle());
    }
}
