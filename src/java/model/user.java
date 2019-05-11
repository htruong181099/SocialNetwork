/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author BaoPhuc
 */
public class User {
    private int user_id,gender;
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String date_of_birth;
    private String avatar;
    private String country;
    private String hobby;
    private String phone;
    private String email;

    public User(int user_id, String username,int gender, String password, String first_name, String last_name, String date_of_birth, String avatar, String country, String hobby, String phone, String email) {
        this.user_id = user_id;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.avatar = avatar;
        this.country = country;
        this.hobby = hobby;
        this.phone = phone;
        this.email = email;
    }

    public User(String username, String password, String email) {
        this.user_id=-1;
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender=0;
        this.first_name="";
        this.last_name="";
        this.date_of_birth="1970-1-1";
        this.avatar="";
        this.country="";
        this.hobby="";
        this.phone=""; 
    }
    

    public User() {
       
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
    
    @Override
    public String toString() {
        return "user{" + "user_id=" + user_id + ", username=" + username + ", password=" + password + ", first_name=" + first_name + ", last_name=" + last_name + ", date_of_birth=" + date_of_birth + ", avatar=" + avatar + ", country=" + country + ", hobby=" + hobby + ", phone=" + phone + ", email=" + email + '}';
    }
    
}

