package com.example.library_management.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library_management.repository.UserRepository;
import com.example.library_management.dao.UserDao;
import com.example.library_management.model.Book;
import com.example.library_management.model.User;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public User serviceGetUserById(Long id){
        Optional<User>  optional=userRepository.findById(id);
        return optional.isPresent()? optional.get():null;
    }

    @Transactional
    public User serviceCreateUser(UserDao userDao){
        User user=new User(userDao.firstName,userDao.lastName,userDao.userName,userDao.password);
        user.setEnrollDate(LocalDate.now());
        user.setBookHistory(null);

        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> serviceGetAllUsers(){
        return userRepository.findAll();
    }

    @Transactional
    public void serviceRemoveUser(User user){

        userRepository.delete(user);
    }

    @Transactional
    public void serviceAddBookToUser(Long id, Book book){

        User user =userRepository.findById(id).get();
        user.userAddBook(book);

    }

    public void serviceRemoveBook(Long id, Book book){

        User user=userRepository.findById(id).get();
        user.userRemoveBook(book);
    }
    
}
