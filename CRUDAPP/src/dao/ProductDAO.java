package dao;

import java.sql.*;

import connectionmanager.ConnectionManager;
import model.product;

public class ProductDAO {
	public void addProduct(product p) throws ClassNotFoundException, SQLException
	{
		ConnectionManager cm= new ConnectionManager();
		Connection con=cm.establishConnection();
		
		String que = "insert into product(productId,productName,productMinQuantity,productPrice,productQuantity) values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(que);
		ps.setInt(1, p.getProductId());
		ps.setString(2, p.getProductName());
		ps.setInt(3, p.getProductMinQuantity());
		ps.setInt(4, p.getProductPrice());
		ps.setInt(5, p.getProductQuantity());
		ps.executeUpdate();
		cm.closeConnection();
	}
	public void display() throws ClassNotFoundException, SQLException
	{
		//1. jdbc connection
		ConnectionManager cm=new ConnectionManager();
		Connection con = cm.establishConnection();
				
		//2. create the statement
		Statement st = con.createStatement();
				
		//3. write and execute the query
		ResultSet rt = st.executeQuery("select * from product");
				
		//4. print
		while(rt.next())
		{
			System.out.println(rt.getInt("productId")+" | "+rt.getString("productName")+"  |  "+rt.getInt("productMinQuantity")+"  |  "+rt.getInt("productPrice")+"  |  "+rt.getInt("productQuantity"));		
		}
		cm.closeConnection();
	}
	public void updateProduct(product p) throws ClassNotFoundException, SQLException
	{
		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.establishConnection();
		
		String que="update product set productName=?,productMinQuantity=?,productPrice=?,productQuantity=? where productId=?";
		PreparedStatement ps=con.prepareStatement(que);
		ps.setString(1, p.getProductName());
		ps.setInt(2, p.getProductMinQuantity());
		ps.setInt(3, p.getProductPrice());
		ps.setInt(4, p.getProductQuantity());
		ps.setInt(5, p.getProductId());
		ps.executeUpdate();
		cm.closeConnection();
		
	}
	public void deleteProduct(product p) throws ClassNotFoundException, SQLException
	{
		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.establishConnection();
		
		String que="delete from product where productId=?";
		PreparedStatement ps=con.prepareStatement(que);
		ps.setInt(1, p.getProductId());
		ps.executeUpdate();
		cm.closeConnection();
	}
}
