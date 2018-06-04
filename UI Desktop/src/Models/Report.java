/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

public class Report extends Entity {

    int MeetingID;
    String Description;

    public Report(int meetingID, String description) {
        this.MeetingID = meetingID;
        this.Description = description;
    }

    public Report(int id, int meetingID, String description) {
        this.Id = id;
        this.MeetingID = meetingID;
        this.Description = description;
    }

    public int getMeetingID() {
        return MeetingID;
    }

    public void setMeetingID(int meetingID) {
        this.MeetingID = meetingID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }
    @Override
    public String toString() {
        return "("  + MeetingID  + Description + ")";
    }
    
}
