package com.topic3.Topic3.Controllers;


import com.topic3.Topic3.Models.UserListModel;
import com.topic3.Topic3.Models.UserModel;
import com.topic3.Topic3.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;


    public UserController(){
        this.userService = new UserService();
    }

    @RequestMapping(value = "/addUser" , method = RequestMethod.GET , produces = "application/json")
    public void newUser(String mail, String pass){
        this.userService.newUser(mail,pass);
    }

    @RequestMapping(value = "/searchUserByMail" , method = RequestMethod.GET , produces = "application/json")
    public UserModel searchMail(String mail){
        return this.userService.searchUserByMail(mail);
    }

    @RequestMapping(value = "/deleteUserMail" , method = RequestMethod.GET , produces = "application/json")
    public void deleteUserByMail(String mail){
        this.userService.deleteUserByMail(mail);
    }

    @RequestMapping(value = "/getAllUsers" , method = RequestMethod.GET , produces = "application/json")
    public UserListModel getAllUsers(){
        return this.userService.getAllUsers();
    }

    @RequestMapping(value = "/updateUserMail" , method = RequestMethod.GET , produces = "application/json")
    public UserModel updateUserMail(String oldMail, String newMail){
        return this.userService.updateUserMail(newMail,oldMail);
    }

    @RequestMapping(value = "/updateUserPass" , method = RequestMethod.GET , produces = "application/json")
    public UserModel updateUserPass(String mail, String newPass){
        return this.userService.updateUserPassword(mail,newPass);
    }

}
