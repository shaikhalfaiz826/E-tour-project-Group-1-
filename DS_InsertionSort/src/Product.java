import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Product {
	private int pid,qty;
	private double cost;
	private String pname;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Product(int pid, int qty, double cost, String pname) {
		super();
		this.pid = pid;
		this.qty = qty;
		this.cost = cost;
		this.pname = pname;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", qty=" + qty + ", cost=" + cost + ", pname=" + pname + "]";
	}


public static void main1(String args[])
{
  String ss="jdbc:mysql://localhost:3306/mydb?useSSL=false"	;
  try(Connection con=DriverManager.getConnection(ss,"root","root"))
  {
	  Product p1=new Product(1,100,5000,"Dio");
	  PreparedStatement pst=con.prepareStatement("insert into Product values(?,?,?,?)");
      pst.setInt(1,p1.getPid());
      pst.setInt(2,p1.getQty());
      pst.setDouble(3,p1.getCost());
      pst.setString(4,p1.getPname());
      pst.executeUpdate();
      p1=null;
      
      pst=con.prepareStatement("Select * from Product");
      ResultSet rs=pst.executeQuery();
      rs.next();
      
      Product p2=new Product(rs.getInt(1),rs.getInt(2),rs.getDouble(3),rs.getString(4));
      System.out.println(p2);
            
	  
  }
  catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}