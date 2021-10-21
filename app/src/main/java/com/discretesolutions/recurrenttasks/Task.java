package com.discretesolutions.recurrenttasks;

import java.util.Date;

public class Task {
    private Schedule taskSchedule;
    private String name;
    private String description;
    private Date taskDate;

    public Schedule getSchedule(){return this.taskSchedule;}
    public String getName(){return this.name;}
    public String getDescription(){return this.description;}
    public Date getTaskDate(){return this.taskDate;}
    public void setSchedule(Schedule schedule){this.taskSchedule =schedule;}
    public void setName(String name){this.name=name;}
    public void setDescription(String description){this.description=description;}
    public void setDate(Date date){this.taskDate = date;}

    public Task(){}
}
