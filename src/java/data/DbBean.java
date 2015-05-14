package data;

import data.Customer;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

 
@ManagedBean(name="customer")
@SessionScoped
public class DbBean implements Serializable{
 
	//resource injection
	
	private DataSource ds;
 
	//if resource injection is not support, you still can get it manually.
	public DbBean(){
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/vacation");
		} catch (NamingException e) {
			e.printStackTrace();
		}
 
	}
 
	//connect to DB and get customer list
	public List<Customer> getCustomerList() throws SQLException{
 
		if(ds==null)
			throw new SQLException("Can't get data source");
 
		//get database connection
		Connection con = ds.getConnection();
 
		if(con==null)
			throw new SQLException("Can't get database connection");
 
		PreparedStatement ps 
			= con.prepareStatement(
			   "select userID, destination, deptdate, bidAmt from bid"); 
 
		//get customer data from database
		ResultSet result =  ps.executeQuery();
 
		List<Customer> list = new ArrayList<Customer>();
 
		while(result.next()){
			Customer cust = new Customer();
 
			cust.setUserID(result.getString("userID"));
			cust.setDestination(result.getString("destination"));
			cust.setDeptdate(result.getDate("deptdate"));
			cust.setBidAmt(result.getFloat("bidAmt"));
 
			//store all data into a List
			list.add(cust);
		}
 
		return list;
	}
        
}