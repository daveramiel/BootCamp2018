package com.topic3.Topic3.Services;

import com.topic3.Topic3.Models.UserListModel;
import com.topic3.Topic3.Models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;

public class UserService {

    @Autowired
    private UserModel user;
    private UserListModel userList;

    public UserService() {
        this.user = new UserModel();
        this.userList = new UserListModel();
    }

    public Boolean searchMail(String mailLogin) {
        Boolean mailFound = false;
        for (UserModel userMail : this.userList.getFullList()) {
            if (userMail.getMailLogin() == mailLogin) {
                mailFound = true;
            }
        }
        return mailFound;
    }

    public UserModel newUser(String mailLogin, String paswd) {
        if (!this.searchMail(mailLogin)) {
            if (!mailLogin.isEmpty()) {

                this.user.setMailLogin(mailLogin);

            }
            if (!paswd.isEmpty()) {
                this.user.setPassword(paswd);
            }
            if (userList.getUserList().isEmpty()) {
                this.user.setIdUser(0);
                this.userList.getUserList().add(this.user);
            } else {
                Iterator it = this.userList.getUserList().iterator();
                int i = 0;
                while (it.hasNext()) {
                    i++;
                }
                this.user.setIdUser(i);
                this.userList.addUser(this.user);
            }
        }
        return this.user;
    }

    public ArrayList<UserModel> getAllUsers() {
        return this.userList.getFullList();
    }

    public Boolean deleteUserByMail(String mailU){
        Boolean answer = false;
        if (this.searchMail(mailU)){
            this.userList.deleteUserByMail(mailU);
            answer = true;
        }
        return answer;
    }

    public UserModel searchUserByMail(String mail){
        UserModel userReturn = new UserModel();
        if(this.searchMail(mail)){
            for (UserModel userMail : this.userList.getFullList()) {
                if (userMail.getMailLogin() == mail) {
                    userReturn.setMailLogin(userMail.getMailLogin());
                    userReturn.setPassword(userMail.getPassword());
                    userReturn.setIdUser(userMail.getIdUser());
                }
            }
        }
        return userReturn;
    }

    public UserModel updateUserMail(String newMail, String oldMail){
        if (searchMail(oldMail)){
            for (UserModel userChange: this.userList.getFullList()) {
                if (userChange.getMailLogin() == oldMail){
                    userChange.setMailLogin(newMail);
                }
            }
        }
        return this.searchUserByMail(newMail);
    }

    public UserModel updateUserPassword(String mail, String newPass){
        if (searchMail(mail)){
            for (UserModel userChange: this.userList.getFullList()) {
                if (userChange.getMailLogin() == mail){
                    userChange.setPassword(newPass);
                }
            }
        }
        return this.searchUserByMail(mail);
    }
}
