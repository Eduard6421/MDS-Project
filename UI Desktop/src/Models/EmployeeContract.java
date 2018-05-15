/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

public class EmployeeContract extends Entity {

    private int idEmployee;
    private int idCompany;
    private Date startDate;
    private Date endDate;

    public EmployeeContract(int Id, int idEmployee, int idCompany, Date startDate, Date endDate) {
        this.Id = Id;;
        this.idEmployee = idEmployee;
        this.idCompany = idCompany;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    public EmployeeContract(int idEmployee, int idCompany, Date startDate, Date endDate) {
        this.Id = -1;
        this.idEmployee = idEmployee;
        this.idCompany = idCompany;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
