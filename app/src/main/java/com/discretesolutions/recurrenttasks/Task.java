package com.discretesolutions.recurrenttasks;

import java.util.Date;

public class Task {
    private Schedule taskSchedule;
    private String name;
    private String description;
    private Date taskDate;

    private Schedule getSchedule(){return this.taskSchedule;}
    private String getName(){return this.name;}
    private String getDescription(){return this.description;}
    private Date getTaskDate(){return this.taskDate;}
    private void setSchedule(Schedule schedule){this.taskSchedule =schedule;}
    private void setName(String name){this.name=name;}
    private void setDescription(String description){this.description=description;}
    private void setDate(Date date){this.taskDate = date;}
}
