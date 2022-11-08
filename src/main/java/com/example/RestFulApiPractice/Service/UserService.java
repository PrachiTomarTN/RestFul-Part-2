package com.example.RestFulApiPractice.Service;

import com.example.RestFulApiPractice.CustomisedException.CustomizedExceptionHandler;
import com.example.RestFulApiPractice.CustomisedException.UserNotFound;
import com.example.RestFulApiPractice.Entities.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Service

public class UserService {

    public static List<User> list = new ArrayList<>();

    static {
        list.add(new User(1, "Prachi", 22));
        list.add(new User(2, "Saloni", 20));
        list.add(new User(3, "Harman", 23));
        list.add(new User(4, "Muthu", 27));

    }

    public List<User> findallusers() {
        return list;
    }
    public User FindOne(int id) {
        User user= list.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        if(user==null){
            throw new UserNotFound("USER_NOT_FOUND");
        }
         return user;
    }
    public User saveuser(User user){
        user.setId(5);
        list.add(user);
       return user;
    }

    public void deleteUser(int id){
        list.removeIf(e->e.getId()==id);
    }

}
