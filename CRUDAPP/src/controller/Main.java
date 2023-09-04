package controller;

import java.sql.SQLException;
import java.util.Scanner;

import dao.LoginDAO;
import dao.ProductDAO;
import model.Login;
import model.product;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		int choice;
		
		Login l = new Login();
		LoginDAO ldao = new LoginDAO(); 
		product p=new product();
		ProductDAO pdao = new ProductDAO();
		do 
		{
			System.out.println("1. Admin\n2. Agent\n3. Exit\n **************************************************************************\n Enter Your Choice");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Admin Login");
				System.out.println("Enter the username");
				String username = sc.next();
				System.out.println("Enter the password");
				String pass = sc.next();
				l.setUsername(username);
				l.setPassword(pass);
				if(ldao.checkCredential(l))
				{
					System.out.println("Login Successful!");
					int option ;
					do
					{
						System.out.println("1. Add Product\n2. Display product\n3. Update product\n4 .Delete product\n5. Logout\n **************************************************************************\n Enter Your Choice");
						option=sc.nextInt();
						switch(option)
						{
						case 1:
							System.out.println("Add Product");
							System.out.println("Enter the ProductID");
							int ProductID=sc.nextInt();
							sc.nextLine();
							System.out.println("Enter the productName");
							String productName=sc.nextLine();
							System.out.println("Enter the minimum sell Quantity");
							int minSellQuantity=sc.nextInt();
							System.out.println("Enter the Price");
							int price=sc.nextInt();
							System.out.println("Enter the Quantity");
							int quantity=sc.nextInt();
							p.setProductId(ProductID);
							p.setProductName(productName);
							p.setProductMinQuantity(minSellQuantity);;
							p.setProductPrice(price);
							p.setProductQuantity(quantity);
							pdao.addProduct(p);
							System.out.println("Products Added Successfully");
							break;
						case 2:
							System.out.println("Display Product");
							System.out.println("These are the Products");
							pdao.display();
							break;
						case 3:
							 System.out.println("Update Product");
							 System.out.println("Enter the productId");
							 int ProductID1=sc.nextInt();
							 sc.nextLine();
							 System.out.println("Enter the productName");
							 String productName1=sc.nextLine();
							 System.out.println("Enter the minimum sell Quantity");
							 int minSellQuantity1=sc.nextInt();
							 System.out.println("Enter the Price");
							 int price1=sc.nextInt();
							 System.out.println("Enter the Quantity");
							 int quantity1=sc.nextInt();
							 p.setProductId(ProductID1);
							 p.setProductName(productName1);
							 p.setProductMinQuantity(minSellQuantity1);
							 p.setProductPrice(price1);
							 p.setProductQuantity(quantity1);
							 pdao.updateProduct(p);
							 System.out.println("Updated Successfully");
							 break;
						case 4:
							System.out.println("Delete Product");
							System.out.println("Enter ProductID Which You Want To Delete");
							int ProductID2=sc.nextInt();
							p.setProductId(ProductID2);
							pdao.deleteProduct(p);
							System.out.println("Deleted Successfully");
						case 5:
							System.out.println("Logout");
							break;
						}
					}while(option!=5);
				}
				else
					System.out.println("Incorrect Username/Password");
				break;
			case 2:
				System.out.println("Agent Login");
				System.out.println("Enter the username");
				String username1 = sc.next();
				System.out.println("Enter the password");
				String pass1 = sc.next();
				l.setUsername(username1);
				l.setPassword(pass1);
				if(ldao.checkCredential(l))
				{
					System.out.println("Login Successful!");
					int option ;
					do
					{
						System.out.println("1. Display product\n2. Logout\n **************************************************************************\n Enter Your Choice");
						option=sc.nextInt();
						switch(option)
						{
						case 1:
							System.out.println("Display Product");
							System.out.println("These are the Products");
							pdao.display();
							break;
						case 2:
							System.out.println("Logout");
							break;
						}
					}while(option!=2);
				}
				else
					System.out.println("Incorrect Username/Password");
				break;
			case 3:
				System.out.println("Exit");
				break;
			}
		}while(choice!=3);
		sc.close();
	}

}
