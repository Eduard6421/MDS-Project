/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

public class Meeting extends Entity {

    private int IdClient;
    private int IdEmployee;
    private int IdCompany;
    private Date MeetingDate;
    private double Feedback;
    private String Description;
    private boolean IsOpen;

    public Meeting(int id, int idClient, int idCompany, int idEmployee, Date meetingDate, double feedback, String description, boolean isOpen) {
        this.Id = id;
        this.IdClient = idClient;
        this.IdCompany = idCompany;
        this.IdEmployee = idEmployee;
        this.MeetingDate = meetingDate;
        this.Feedback = feedback;
        this.Description = description;
        this.IsOpen = isOpen;
    }
    
    public Meeting(int idClient, int idCompany, int idEmployee, Date meetingDate, double feedback, String description, boolean isOpen) {
        this.IdClient = idClient;
        this.IdCompany = idCompany;
        this.IdEmployee = idEmployee;
        this.MeetingDate = meetingDate;
        this.Feedback = feedback;
        this.Description = description;
        this.IsOpen = isOpen;
    }

    public int getIdCompany() {
        return IdCompany;
    }

    public void setIdCompany(int IdCompany) {
        this.IdCompany = IdCompany;
    }

    public int getIdClient() {
        return IdClient;
    }

    public void setIdClient(int idClient) {
        this.IdClient = idClient;
    }

    public int getIdEmployee() {
        return IdEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.IdEmployee = idEmployee;
    }

    public Date getMeetingDate() {
        return MeetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.MeetingDate = meetingDate;
    }

    public double getFeedback() {
        return Feedback;
    }

    public void setFeedback(double feedback) {
        this.Feedback = feedback;
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
