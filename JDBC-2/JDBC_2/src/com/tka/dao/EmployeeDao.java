package com.tka.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tka.entity.Employee;

public class EmployeeDao {
	
	final String DB_DriverName="com.mysql.cj.jdbc.Driver";
	final String DB_URL="jdbc:mysql://localhost:3309/my_company";
	final String DB_Username="root";
	final String DB_Password="root";
	
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	public void openDB() {
		try {
			
			Class.forName(DB_DriverName);
			
			con=DriverManager.getConnection(DB_URL, DB_Username, DB_Password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}


	public int insertData(Employee emp) {
		String query="insert into employee1(name,mobileno) values(?,?)";
		int status=0;
		
		try {
			
			openDB();
			pst=con.prepareStatement(query);
			
			pst.setString(1, emp.getName());
			pst.setString(2, emp.getMobileno());
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			closeDB();
		}
		return status;
	}


	public void closeDB() {
		try {
			if(con!=null) {
				con.close();
				con=null;
			}
			
			if(pst!=null) {
				pst.close();
				pst=null;
			}
			
			if(rs!=null) {
				rs.close();
				rs=null;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public int Updatedata(Employee emp) {
		// TODO Auto-generated method stub
		
		String query="update employee1 set name=? where id=?";
		int status=0;
		
		try {
			openDB();
			pst= con.prepareStatement(query);
			
			pst.setString(1, emp.getName());
			pst.setInt(2, emp.getId());
			
			status= pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeDB();
		}
		
		return status;
		
		
	}

	public int deleteData(int id) {
		
		String query="delete from employee1 where id=?";
		int status=0;
		try {
			openDB();
			pst= con.prepareStatement(query);
			
			pst.setInt(1, id);
			
			status= pst.executeUpdate();
			
				} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		
		return status;
	}
	
	public ArrayList<Employee> getAllRecord() {
		// TODO Auto-generated method stub
		
		String query="select * from employee1";
		ArrayList<Employee> list=new ArrayList<Employee>();
		
		try {
			openDB();
			pst= con.prepareStatement(query);
			
			rs= pst.executeQuery(query);
			
			while(rs.next()) {
				
				Employee emp=new Employee();
				
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setMobileno(rs.getString("mobileno"));				
				list.add(emp);				
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return list;
		}
	
	public Employee getparticularRecordById(int id) {
		// TODO Auto-generated method stub
		
		String query="select * from employee1 where id=?";
		Employee emp=null;
		
		try {
			openDB();
			pst= con.prepareStatement(query);
			
			pst.setInt(1, id);
			
			rs= pst.executeQuery();
			
			while(rs.next()) {
				emp=new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setMobileno(rs.getString("mobileno"));
				
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeDB();
		}
		
		return emp;
		
	}

}

