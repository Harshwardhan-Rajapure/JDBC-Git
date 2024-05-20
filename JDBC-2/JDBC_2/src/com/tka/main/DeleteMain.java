package com.tka.main;

import com.tka.dao.EmployeeDao;

public class DeleteMain {

	public static void main(String[] args) {
		
		int id=2;
		
		EmployeeDao dao=new EmployeeDao();
		int status= dao.deleteData(id);
		
		if(status>0) {
			System.out.println("Data is Deleted...");
		}else {
			System.out.println("Data is not Deleted...");
		}
		

	}

}