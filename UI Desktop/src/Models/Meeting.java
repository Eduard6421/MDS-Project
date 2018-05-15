/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

public class Meeting extends Entity {

    private int idClient;
    private int idEmployee;
    private Date meetingDate;
    private double feedback;
    private String description;

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public Meeting(int idClient, int idEmployee, Date meetingDate, double feedback, String description) {
        this.idClient = idClient;
        this.idEmployee = idEmployee;
        this.meetingDate = meetingDate;
        this.feedback = feedback;
        this.description = description;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }

    public double getFeedback() {
        return feedback;
    }

    public void setFeedback(double feedback) {
        this.feedback = feedback;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
