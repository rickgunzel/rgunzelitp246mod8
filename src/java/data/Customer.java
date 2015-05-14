/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.util.Date;
 
public class Customer{
 
	public String userID;
	public String destination;
        public Date deptdate;
	public Float bidAmt;
	
 
	//getter and setter methods 

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDeptdate() {
        return deptdate;
    }

    public void setDeptdate(Date deptdate) {
        this.deptdate = deptdate;
    }

    public Float getBidAmt() {
        return bidAmt;
    }

    public void setBidAmt(Float bidAmt) {
        this.bidAmt = bidAmt;
    }
}
