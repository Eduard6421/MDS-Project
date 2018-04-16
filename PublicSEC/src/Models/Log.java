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
public class Log extends Entity{

    private int idClient;
    private int idEmployee;
    private Date meetingDate;
    private int feedback;
    private String description;

    public void setIdClient(int IdClient) {
        this.idClient = IdClient;
    }

    public void setIdEmployee(int IdEmployee) {
        this.idEmployee = IdEmployee;
    }

    public void setMeetingDate(Date MeetingDate) {
        this.meetingDate = MeetingDate;
    }

    public void setFeedback(int Feedback) {
        this.feedback = Feedback;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public Date getMeetingDate() {
        return meetingDate;
    }

    public int getFeedback() {
        return feedback;
    }

    public String getDescription() {
        return description;
    }

    
    
    
}
