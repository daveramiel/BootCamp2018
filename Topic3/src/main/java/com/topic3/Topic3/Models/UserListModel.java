package com.topic3.Topic3.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserListModel {


    @Getter
    @Setter
    private ArrayList<UserModel> userList;


    public ArrayList<UserModel> getFullList(){
        return this.userList;
    }

    public Boolean isEmpty(){
        return this.userList.isEmpty();
    }

    public void addUser(UserModel newUser){
        this.userList.add(newUser);
    }

    public Boolean deleteUserByMail(String mailUser){
        Boolean answer = true;
        for (UserModel userR: this.userList) {
            if (userR.getMailLogin().equalsIgnoreCase(mailUser)){
                this.userList.remove(userR);
                answer = true;
            }
        }
        return answer;
    }

}
