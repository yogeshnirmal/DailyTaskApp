package com.neosoft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String holidayName;
    private Date holidayDate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(Date holidayDate) {
        this.holidayDate = holidayDate;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    public Holiday() {

    }

    public Holiday(long id, Date holidayDate, String holidayName) {
        this.id = id;
        this.holidayDate = holidayDate;
        this.holidayName = holidayName;
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "id=" + id +
                ", holidayDate=" + holidayDate +
                ", holidayName='" + holidayName + '\'' +
                '}';
    }
}
