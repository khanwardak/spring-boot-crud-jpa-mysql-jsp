package com.practiceAPI4.practice4RestAPI.services;

import com.practiceAPI4.practice4RestAPI.entity.Users;
import com.practiceAPI4.practice4RestAPI.exception.UserNotFoundException;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class UserDoaService {
  public static List<Users> users = new ArrayList<>();
  public  static  int countId;
  static {
      users.add(new  Users(++countId,"khan",LocalDate.now().minusYears(26)));
      users.add(new  Users(++countId,"Imran Khan",LocalDate.now().minusYears(27)));
      users.add(new  Users(++countId,"Imran",LocalDate.now().minusYears(28)));
  }
  public List<Users> findAll(){
      return users;
  }
  public  List<Users> findById(int id) throws UserNotFoundException{

          List<Users> usersList = new ArrayList<>();
          for (int i = 0; i < users.size(); i++) {
              Users user = users.get(i);
              if (user.getId() == id) {
                  usersList.add(user);
              }
          }

          if (usersList.isEmpty()){
              throw  new UserNotFoundException("this user with id "+id+"not found");
          }
      return usersList;
  }
  // save the users
    public Users save(Users user){
      users.add(user);
      user.setId(countId);
      return user;
    }
}
