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

    String firstName;
    String lastName;
    String userName;
    String userPassword;
    String address;
    String phone;
    String email;

    /**
     * Id, firstName , lastName , userName , user Password, address , phone ,
     * email
     *
     */
    public Employee(String firstName, String lastName, String userName, String userPassword, String address, String phone, String email) {
        this.Id = -1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.userPassword = userPassword;
        this.address = address;
        this.phone = phone;
        this.email = email;

    }

    public Employee(int Id, String firstName, String lastName, String userName, String userPassword, String address, String phone, String email) {

        this.Id = Id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.userPassword = userPassword;
        this.address = address;
        this.phone = phone;
        this.email = email;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

}
