package com.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteData1 {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection cnt = DriverManager.getConnection("jdbc:mysql://localhost:3309/my_company", "root", "root");

			
			int id = 2;

			PreparedStatement stm = cnt.prepareStatement("delete from employee where id=?");
			
			stm.setInt(1, id);

			int status = stm.executeUpdate();

			if (status > 0) {
				System.out.println("deleted successfully...");
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
