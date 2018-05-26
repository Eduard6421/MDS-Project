/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author t-edpoes
 */
public class Company extends Entity{
    
    
    String Name;
    String Username;
    String Password;
    Date ContractStartDate;
    Date ContractEndDate;
    String Description;

    public Company(int Id, String name, Date contractStartDate, Date contractEndDate, String Description, String Username, String Password) {
     this.Id = Id;
     this.Name = name;
     this.ContractStartDate = contractStartDate;
     this.ContractEndDate   = contractEndDate;
     this.Description = Description;
     this.Username = Username;
     this.Password = Password;
    }
    
    public Company(String name, Date contractStartDate, Date contractEndDate, String Description, String Username, String Password) {
     this.Name = name;
     this.ContractStartDate = contractStartDate;
     this.ContractEndDate   = contractEndDate;
     this.Description = Description;
     this.Username = Username;
     this.Password = Password;
    } 
      
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public Date getContractStartDate() {
        return ContractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.ContractStartDate = contractStartDate;
    }

    public Date getContractEndDate() {
        return ContractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.ContractEndDate = contractEndDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
      
    
}
