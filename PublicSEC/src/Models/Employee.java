/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author t-edpoes
 */
public class Employee extends Entity {

    String FirstName;
    String LastName;
    String Username;
    String Password;
    String Address;
    String Phone;
    String Email;
    Double Rating;

    public Employee(String firstName, String lastName, String username, String userPassword, String address, String phone, String email, double rating) {
        this.Id = -1;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Username = username;
        this.Password = userPassword;
        this.Address = address;
        this.Phone = phone;
        this.Email = email;
        this.Rating = rating;

    }

    public Employee(int Id, String firstName, String lastName, String username, String userPassword, String address, String phone, String email, double rating) {

        this.Id = Id;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Username = username;
        this.Password = userPassword;
        this.Address = address;
        this.Phone = phone;
        this.Email = email;
        this.Rating = rating;

    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getUserPassword() {
        return Password;
    }

    public void setUserPassword(String userPassword) {
        this.Password = userPassword;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public Double getRating() {
        return Rating;
    }

    public void setRating(Double rating) {
        this.Rating = rating;
    }
}
