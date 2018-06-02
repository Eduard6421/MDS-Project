/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

public class Meeting extends Entity {

    private Integer IdClient;
    private Integer IdEmployee;
    private Integer IdCompany;
    private Date MeetingDate;
    private Float Rating;
    private String Description;
    private boolean IsOpen;

    public Meeting(Integer id, Integer idClient, Integer idCompany, Integer idEmployee, Date meetingDate, Float rating, String description, boolean isOpen) {
        super(id);
        this.IdClient = idClient;
        this.IdCompany = idCompany;
        this.IdEmployee = idEmployee;
        this.MeetingDate = meetingDate;
        this.Rating = rating;
        this.Description = description;
        this.IsOpen = isOpen;
    }

    public Integer getIdCompany() {
        return IdCompany;
    }

    public void setIdCompany(Integer IdCompany) {
        this.IdCompany = IdCompany;
    }

    public Integer getIdClient() {
        return IdClient;
    }

    public void setIdClient(Integer idClient) {
        this.IdClient = idClient;
    }

    public Integer getIdEmployee() {
        return IdEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.IdEmployee = idEmployee;
    }

    public Date getMeetingDate() {
        return MeetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.MeetingDate = meetingDate;
    }

    public Float getRating() {
        return Rating;
    }

    public void setRating(Float rating) {
        this.Rating = rating;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public boolean getIsOpen() {
        return IsOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.IsOpen = isOpen;
    }

}
