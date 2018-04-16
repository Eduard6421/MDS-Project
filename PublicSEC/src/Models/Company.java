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
    
    
    String name;
    Date contractStartDate;
    Date contractEndDate;
    String description;
    
    public void setName(String Name) {
        this.name = Name;
    }

    public void setContractStartDate(Date ContractStartDate) {
        this.contractStartDate = ContractStartDate;
    }

    public void setContractEndDate(Date ContractEndDate) {
        this.contractEndDate = ContractEndDate;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public String getName() {
        return name;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public String getDescription() {
        return description;
    }
    
}
