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
public class Clients extends Entity{
    
    
    String firstName;
    String lastName;
    String userName;
    String userPassword;
    String address;
    String phone;
    String email;

    public void setFirstName(String FirstName) {
        this.firstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.lastName = LastName;
    }

    public void setUserName(String UserName) {
        this.userName = UserName;
    }

    public void setUserPassword(String UserPassword) {
        this.userPassword = UserPassword;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public void setPhone(String Phone) {
        this.phone = Phone;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
    
    
}
