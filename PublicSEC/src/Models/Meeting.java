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
    private Date MeetingDate;
    private double Feedback;
    private String Description;
    
    public Meeting(int idClient, int idEmployee, Date meetingDate, double feedback, String description) {
        this.IdClient = idClient;
        this.IdEmployee = idEmployee;
        this.MeetingDate = meetingDate;
        this.Feedback = feedback;
        this.Description = description;
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

}
