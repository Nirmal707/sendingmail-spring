package com.example.Auth.service;

import java.util.List;

import com.example.Auth.model.User;

public interface RegisterService {
   public List<User> getAll();
    public User saveRegister (User register);
  public void updateRegister (User register , long id);
   public User findOne(long id);
  public void delete (long id);
}