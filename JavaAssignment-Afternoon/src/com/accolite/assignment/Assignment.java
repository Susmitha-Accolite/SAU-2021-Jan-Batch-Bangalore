package com.accolite.assignment;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class Assignment {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Random rand = new Random();
		
		FileOutputStream out = new FileOutputStream("RandomNumbers.txt");
		
		while(true) {
			int n = rand.nextInt(101);
			out.write(n);
			if(n % 5 == 0)
				break;
		}
		
		out.close();
		FileInputStream in = new FileInputStream("RandomNumbers.txt");
		ArrayList<Integer> nums = new ArrayList<>();
		
		int c;
		while((c = in.read()) != -1) {
//			System.out.println(c);
			nums.add(c);
		}
		
		int id = nums
				 .stream()
				 .filter(e -> e % 5 == 0)
				 .map(e -> e*2)
				 .reduce(1, (a,b) -> {return a*b;});
		
		System.out.println(id);
		in.close();
		
		Class.forName("com.mysql.jdbc.Driver"); 
		
		String url = "jdbc:mysql://remotemysql.com:3306/sMkXvyYxZM?characterEncoding=latin1";		
		String username = "sMkXvyYxZM";
		String	passoword = "8h9tWhCKws";
		
		Connection connection = DriverManager.getConnection(url, username, passoword);
		
		
		String sql = "insert into test values (?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2,"Susmitha");
		preparedStatement.execute();

		ResultSet result = preparedStatement.executeQuery("select * from test");
		while(result.next()) {
		    String resultId = result.getString("id");
		    String resultName = result.getString("name");
		    System.out.println("Name,id - " + resultName + "," + resultId); 
		}
		
	}

}
