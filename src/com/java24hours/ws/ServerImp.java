package com.java24hours.ws;

import java.util.Date;

public class ServerImp implements Server {
    public double getSquare(double input){
        return Math.sqrt(input);
    }
    public String getTime(){
        Date now = new Date();
        return now.toString();
    }
}
