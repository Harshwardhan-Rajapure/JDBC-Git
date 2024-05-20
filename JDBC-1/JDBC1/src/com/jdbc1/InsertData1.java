package com.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertData1 {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection cnt = DriverManager.getConnection("jdbc:mysql://localhost:3309/my_company", "root", "root");

			int id=4;
			String name="BNM";
			int salary=50000;
			
			PreparedStatement stm = cnt.prepareStatement("insert into employee(id,name,salary) values(?,?,?)");
			
			stm.setInt(1, id);
			stm.setString(2, name);
			stm.setInt(3, salary);
			int status = stm.executeUpdate();

			if (status > 0) {
				System.out.println("Data added successfully...");
			} else {
				System.out.println("Error!!!");
			}

			cnt.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
