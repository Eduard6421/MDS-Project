/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

public class Report extends Entity {

    int meetingID;
    String description;
    
    public Report(int meetingID, String description) {
        this.meetingID = meetingID;
        this.description = description;
    }
    
    public Report(int Id,int meetingID, String description) {
        this.Id = Id;
        this.meetingID = meetingID;
        this.description = description;
    }
    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getMeetingID() {
        return meetingID;
    }

    public void setMeetingID(int meetingID) {
        this.meetingID = meetingID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    

}
