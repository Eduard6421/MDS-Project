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
public class CompanyContract extends Entity{
    
    private int idEmployee;
    private int idCompany;
    private Date startDate;
    private Date endDate;

    public void setIdEmployee(int IdEmployee) {
        this.idEmployee = IdEmployee;
    }

    public void setIdCompany(int IdCompany) {
        this.idCompany = IdCompany;
    }

    public void setStartDate(Date StartDate) {
        this.startDate = StartDate;
    }

    public void setEndDate(Date EndDate) {
        this.endDate = EndDate;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    
    
}
