package bid;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;


@ManagedBean 
public class MainBidBean {

    public String user;
    public String destination;
    public Date date;
    
    public Double bid;
  
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    String SQL;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
        
    }

   

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
     public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
        
    }
    public String addNew() throws ClassNotFoundException, SQLException{
        
        Class.forName("com.mysql.jdbc.Driver");
        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/vacation","itp246","itp246");
        
        statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String firstLetter  = "";
        firstLetter=String.valueOf(destination.charAt(0));
        
        statement.executeUpdate("insert into bid (userID,destination,deptdate,bidAmt)values ('"+ user +"','"+ firstLetter +"','"+ new SimpleDateFormat("yyyy-MM-dd").format(date)+"','"+bid+"')");
        

        statement.close();
        connection.close();
        
        
        return "summary";
        
    }
    

   

}
