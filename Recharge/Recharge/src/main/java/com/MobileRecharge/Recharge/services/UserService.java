package com.MobileRecharge.Recharge.services;

import com.MobileRecharge.Recharge.dao.UserDao;
import com.MobileRecharge.Recharge.models.Recharge;
import com.MobileRecharge.Recharge.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public ResponseEntity<String> userLogin(Long id, String password) {
        User user = userDao.findById(id).get();
        if (user!= null && user.getPassword().equals(password)) {

            return new ResponseEntity<>("login success",HttpStatus.OK);
        }
        return new ResponseEntity<>("login failed",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> userSignup(String name, String number, String password) {
    User user=new User();
    user.setName(name);
   user.setMobileNumber(number);
    user.setPassword(password);
        userDao.save(user);
        return new ResponseEntity<>("signUp success",HttpStatus.CREATED);
    }

    public User validateUser(String mobileNumber) {
        return userDao.findByMobileNumber(mobileNumber);
    }


    public User getUserById(Long id) {
        return userDao.findById(id).get();
    }

}
