/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Eduard
 */
public class Notification extends Entity {

    private int clientId;
    private int employeeId;
    private int meetingId;
    private boolean notifyClient;
    private boolean notifyEmployee;

    public Notification(int clientId, int employeeId, int meetingId, boolean notifyClient, boolean notifyEmployee) {
        this.clientId = clientId;
        this.employeeId = employeeId;
        this.meetingId = meetingId;
        this.notifyClient = notifyClient;
        this.notifyEmployee = notifyEmployee;
    }

    public Notification(int Id, int clientId, int employeeId, int meetingId, boolean notifyClient, boolean notifyEmployee) {
        super(Id);
        this.clientId = clientId;
        this.employeeId = employeeId;
        this.meetingId = meetingId;
        this.notifyClient = notifyClient;
        this.notifyEmployee = notifyEmployee;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public boolean isNotifyClient() {
        return notifyClient;
    }

    public void setNotifyClient(boolean notifyClient) {
        this.notifyClient = notifyClient;
    }

    public boolean isNotifyEmployee() {
        return notifyEmployee;
    }

    public void setNotifyEmployee(boolean notifyEmployee) {
        this.notifyEmployee = notifyEmployee;
    }

}
