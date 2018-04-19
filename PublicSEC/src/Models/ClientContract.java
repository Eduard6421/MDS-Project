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

    private int idClient;
    private int idCompany;
    private Date startDate;
    private Date endDate;

    
    
    public ClientContract(int idClient, int idCompany, Date startDate, Date endDate) {

        this.Id = -1;
        this.idClient = idClient;
        this.idCompany = idCompany;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    public ClientContract(int Id, int idClient, int idCompany, Date startDate, Date endDate) {
        this.Id = Id;
        this.idClient = idClient;
        this.idCompany = idCompany;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
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
