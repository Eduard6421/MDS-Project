/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

public class EmployeeContract extends Entity {

    private int IdEmployee;
    private int IdCompany;
    private Date StartDate;
    private Date EndDate;

    public EmployeeContract(int Id, int idEmployee, int idCompany, Date startDate, Date endDate) {
        this.Id = Id;;
        this.IdEmployee = idEmployee;
        this.IdCompany = idCompany;
        this.StartDate = startDate;
        this.EndDate = endDate;

    }

    public EmployeeContract(int idEmployee, int idCompany, Date startDate, Date endDate) {
        this.Id = -1;
        this.IdEmployee = idEmployee;
        this.IdCompany = idCompany;
        this.StartDate = startDate;
        this.EndDate = endDate;
    }

    public int getIdEmployee() {
        return IdEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.IdEmployee = idEmployee;
    }

    public int getIdCompany() {
        return IdCompany;
    }

    public void setIdCompany(int idCompany) {
        this.IdCompany = idCompany;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        this.StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        this.EndDate = endDate;
    }

    @Override
    public String toString() {
        return "(" + IdEmployee + IdCompany + StartDate + EndDate + ")";
    }
}
