package main.java.com.netcracker.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;

/**
 * Created by Lizzi on 13.04.2017.
 */
public class Exam implements Serializable, IsSerializable {
    private String group;
    private String subject;
    private String date;
    private String time;



    private String room;
    private String teacher;

    public Exam(String group, String subject, String date, String time, String room, String teacher) {
        this.group = group;
        this.subject = subject;
        this.date = date;
        this.time = time;
        this.room = room;
        this.teacher = teacher;
    }

    public Exam() {
    }

    @Override
    public String toString() {
        return "Exam{" +
                "group='" + group + '\'' +
                ", subject='" + subject + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", room='" + room + '\'' +
                ", teacher='" + teacher + '\'' +
                '}';
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
