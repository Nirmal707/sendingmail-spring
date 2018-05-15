package com.example.Auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
    public class User {
       @Id
       @GeneratedValue(strategy=GenerationType.AUTO)
       private Long id;
        
       @Column
        private String userName;
        @Column
        private String email;
        @Column
        private String password ;
        @Column
        private String confirmPassword;

        /**
         * @param id the id to set
         */
        public void setId(Long id) {
            this.id = id;
        }
        /**
         * @return the id
         */
        public Long getId() {
            return id;
        }
       
        public void setUserName(String userName) {
            this.userName = userName;
        }
       
        public String getUserName() {
            return userName;
        }
      
        public String getEmail() {
            return email;
        }
    
        public void setEmail(String email) {
            this.email = email;
        }
       
        public String getConfirmPassword() {
            return confirmPassword;
        }
       
        public void setConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
        }
       
        public String getPassword() {
            return password;
        }
       
        public void setPassword(String password) {
            this.password = password;
        }
   @Override
   public String toString() {
       return "name "+userName+" email"+email+" password"+password;
   }  
   }