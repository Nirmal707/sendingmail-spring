package com.example.Auth.controller;

import java.util.List;

import com.example.Auth.model.User;
import com.example.Auth.service.RegisterService;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.*;
import java.net.Authenticator;
import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/reguser")
public class RegisterController {

    @Autowired 
    public RegisterService registerService;

     @RequestMapping(value="/save", method=RequestMethod.POST)
       public ResponseEntity<?> saveRegister(@RequestBody User register, UriComponentsBuilder ucBuilder){
        System.out.println("++++++++++++sendmail+++++++++++");
        User reg=register;           
          String toMail= reg.getEmail();
             //static String  recipientAddress[];
    
        try {
            RegisterController javaEmail = new RegisterController();
           
         javaEmail.sendEmail(toMail); 
            System.out.println("Process Completed\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
   
        System. out.println("event registered successfully");
      
        registerService.saveRegister(register);

        return new ResponseEntity<User>(register,HttpStatus.OK);

    }

    @RequestMapping(value="/{id}", method =RequestMethod.DELETE)
    public void deleteRegister(@PathVariable long id ){
        registerService.delete(id);
    }

    
    @GetMapping("/getall")
    public @ResponseBody ResponseEntity<List<User>> all() {
        return new ResponseEntity<List<User>>(registerService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getRegister(@PathVariable long id) {
        return registerService.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)

    public ResponseEntity<?> updateRegister(@RequestBody User register, @PathVariable("id") long id) {
        User r1 = register;
        registerService.updateRegister(r1, id);
        return new ResponseEntity<User>(HttpStatus.OK);

    }
    @RequestMapping(value="/sendmail", method=RequestMethod.POST)
    public ResponseEntity<?> sendmail(@RequestBody User register, UriComponentsBuilder ucBuilder)
    {
        System.out.println("++++++++++++sendmail+++++++++++");
        User reg=register;           
          String toMail= reg.getEmail();
             //static String  recipientAddress[];
    
        try {
            RegisterController javaEmail = new RegisterController();
           
         javaEmail.sendEmail(toMail); 
            System.out.println("Process Completed\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
      System. out.println("event registered successfully");
    

        return new ResponseEntity<User>(register,HttpStatus.OK);
    } 

      static String  recipientAddress[];   

    public  void sendEmail(String to)
    {
    final String username = "baraneetharan.ramasamy@kgfsl.com";
    final String password = "Barani@1234";
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "false");
    props.put("mail.smtp.host", "webmail.kggroup.com");
    props.put("mail.smtp.port", "25");
    Session session = Session.getInstance(props,
    new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(username, password);
    }
    });
    try {        
    Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress("baraneetharan.ramasamy@kgfsl.com"));
    message.setRecipients(Message.RecipientType.TO,
    InternetAddress.parse(to));
    
    message.setSubject("A testing mail header !!!");
    message.setText("Dear candidate,"
    + "\n\n  Registration successful!");
    Transport.send(message);
    System.out.println("Done");
    }
    catch (MessagingException e) 
    {
    throw new RuntimeException(e);
    }
    }

}