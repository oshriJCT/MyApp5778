package com.example.coshri.myapp5778.model.entities;
import java.util.Date;

/**
 * Created by mailo on 26/11/2016.
 */

    public class Student extends  Person{



    private Year year;

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }


    @Override
    public String toString() {
        return "["+getId()+"] "+getName() ;
    }
}
