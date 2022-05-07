package sri.sai.bhavani.printers.website.model;
import javax.validation.constraints.Size;
import java.util.Date;

public class Todo {
 private int id;
 private String user;
 
 @Size(min=10,message="Enter atleast 10 characters")
 private String desc;
 private boolean isdone;
 private Date targetDate;
 
 public Todo() {
	 super();
 }
public Todo(int id, String user, String desc, boolean isdone, Date targetDate) {
	super();
	this.id = id;
	this.user = user;
	this.desc = desc;
	this.isdone = isdone;
	this.targetDate = targetDate;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public boolean isIsdone() {
	return isdone;
}
public void setIsdone(boolean isdone) {
	this.isdone = isdone;
}
public Date getTargetDate() {
	return targetDate;
}
public void setTargetDate(Date targetDate) {
	this.targetDate = targetDate;
}
@Override
public String toString() {
	return "Todo [id=" + id + ", user=" + user + ", desc=" + desc + ", isdone=" + isdone + ", targetDate=" + targetDate
			+ "]";
}


 
 
}
