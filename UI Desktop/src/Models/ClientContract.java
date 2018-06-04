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
public class ClientContract extends Entity {

    private int IdClient;
    private int IdCompany;
    private Date StartDate;
    private Date EndDate;

    public ClientContract(int idClient, int idCompany, Date startDate, Date endDate) {

        this.Id = -1;
        this.IdClient = idClient;
        this.IdCompany = idCompany;
        this.StartDate = startDate;
        this.EndDate = endDate;

    }

    public ClientContract(int Id, int idClient, int idCompany, Date startDate, Date endDate) {
        this.Id = Id;
        this.IdClient = idClient;
        this.IdCompany = idCompany;
        this.StartDate = startDate;
        this.EndDate = endDate;

    }

    public int getIdClient() {
        return IdClient;
    }

    public void setIdClient(int idClient) {
        this.IdClient = idClient;
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
        return "(" + IdClient + IdCompany + StartDate + EndDate + ")";
    }
}
