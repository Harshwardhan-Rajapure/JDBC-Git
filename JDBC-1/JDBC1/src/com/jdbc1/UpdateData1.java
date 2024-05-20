package com.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateData1 {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection cnt = DriverManager.getConnection("jdbc:mysql://localhost:3309/my_company", "root", "root");

			double salary = 55000;
			int id = 1;

			PreparedStatement stm = cnt.prepareStatement(" update employee set salary=? where id=?");

			stm.setDouble(1, salary);
			stm.setInt(2, id);

			int status = stm.executeUpdate();

			if (status > 0) {
				System.out.println("Update Successfully...");
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
