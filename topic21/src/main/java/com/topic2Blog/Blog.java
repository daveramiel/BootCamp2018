package com.topic2Blog;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayDeque;
import java.util.Iterator;

public class Blog {

    ///Here goes my Blog

    @Getter
    @Setter
    private ArrayDeque<Post> bloggy;



    public Blog(){
        this.bloggy = new ArrayDeque<Post>();
    }


    ///Self explanatory
    public Boolean isEmpty(){
        return this.bloggy.isEmpty();
    }

    ///Adds a new Post on top of the ArrayDeque
    public void addNewPost(Post newP){
        this.bloggy.addFirst(newP);
    }

    ///Returns the newest Post Created
    public Post getNewestPost(){
        return this.bloggy.getFirst();
    }

    ///Gives us the latest post.
    public Post getOldestPost(){
        return this.bloggy.getLast();
    }

    ///Looks for the Title in ArrayDeque and vanishes it into the sky
    ///Returns True if it is found
    public Boolean deletePostByTitle(String titlePost){
        Boolean answer = false;
        for (Post searching: this.bloggy) {
            if(titlePost.equalsIgnoreCase(searching.getTitle())){
                this.bloggy.remove(searching);
                answer=true;
            }
        }
        return answer;
    }

    ///Creates and returns a new ArrayDeque with the lastest 10 posts
    public ArrayDeque getNewestTenPosts(){
        ArrayDeque<Post> newestPosts = new ArrayDeque<>();
        Iterator ite = this.bloggy.iterator();
        int i = 0;
        while(i<10 && ite.hasNext()){
            newestPosts.add((Post)ite.next());
            i++;
        }
        return newestPosts;
    }
}
