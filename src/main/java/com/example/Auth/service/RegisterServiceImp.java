package com.example.Auth.service;

import java.util.List;

import com.example.Auth.Repository.RegisterRepository;
import com.example.Auth.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("registerService")
public class RegisterServiceImp implements RegisterService{

    @Autowired 
    private RegisterRepository registerrepository;

    @Override
    public List<User> getAll(){
        return registerrepository.findAll();
    }
    @Override
    public User saveRegister(User register){

        return registerrepository.saveAndFlush(register);
    }
    @Override
    public void updateRegister(User register , long id){
        register.setId(id);
        registerrepository.saveAndFlush(register);
       
    }

    @Override
    public User findOne(long id){
        return registerrepository.findOne(id);
    }

	@Override
	public void delete(long id) {
       registerrepository.delete(id);
        
	}
}