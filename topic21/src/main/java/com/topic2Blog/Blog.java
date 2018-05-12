package com.topic2Blog;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayDeque;
import java.util.Iterator;

public class Blog {


    @Getter
    @Setter
    private ArrayDeque<Post> bloggy;

    public Blog(){
        this.bloggy = new ArrayDeque<Post>();
    }

    public Boolean isEmpty(){
        return this.bloggy.isEmpty();
    }
    public void addNewPost(Post newP){
        this.bloggy.addFirst(newP);
    }

    public Post getNewestPost(){
        return this.bloggy.getFirst();
    }

    public Post getOldestPost(){
        return this.bloggy.getLast();
    }

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
