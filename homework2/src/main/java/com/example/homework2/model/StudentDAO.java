package com.example.homework2.model;

import com.example.homework2.model.StudentDAO;
import com.example.homework2.model.StudentDO;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {

	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = null;

	public StudentDAO() {
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String pwd = "tiger";
		
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, user, pwd);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public StudentDO selectStudnet(int id) {
		this.sql =
				"select * from student where id = ?";
		StudentDO studentDO = null;
		try {
			this.pstmt = conn.prepareStatement(sql);
			this.pstmt.setInt(1, id);
			this.rs = pstmt.executeQuery();

			if (rs.next()) {
				studentDO = new StudentDO();

				studentDO.setId(rs.getInt("id"));
				studentDO.setName(rs.getString("name"));
				studentDO.setGender(rs.getString("gender"));
				studentDO.setKor(rs.getInt("kor"));
				studentDO.setEng(rs.getInt("eng"));
				studentDO.setMath(rs.getInt("math"));
				studentDO.setSci(rs.getInt("sci"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (!pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return studentDO;
	}

	public ArrayList<StudentDO> selectAll() {
		this.sql = "select * from student";
		StudentDO studentDO = null;
		ArrayList<StudentDO> studentDOS = new ArrayList<>();

		try {
			this.stmt = conn.createStatement();
			this.rs = stmt.executeQuery(sql);
			while (rs.next()) {
				studentDO = new StudentDO();
				studentDO.setId(rs.getInt("id"));
				studentDO.setName(rs.getString("name"));
				studentDO.setKor(rs.getInt("kor"));
				studentDO.setEng(rs.getInt("eng"));
				studentDO.setSci(rs.getInt("sci"));
				studentDO.setMath(rs.getInt("math"));
				studentDOS.add(studentDO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (!pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return studentDOS;
	}

	public int deleteStudent(StudentDO student){
		this.sql = "delete from student where id = ?";
		int rowCount = 0;
		try{
			this.pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, student.getId());
			rowCount = pstmt.executeUpdate();

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(!pstmt.isClosed()){
					pstmt.close();
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return rowCount;
	}

 	public void closeConnection() {
		try {
			if(!conn.isClosed()) {
				conn.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public int insertStudent(StudentDO studentDO){
		int rowCount = 0;
		sql = "insert into student values(?, ?, ?, ?, ?, ?, ?)";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, studentDO.getId());
			pstmt.setString(2, studentDO.getName());
			pstmt.setString(3, studentDO.getGender());
			pstmt.setInt(4, studentDO.getKor());
			pstmt.setInt(5, studentDO.getEng());
			pstmt.setInt(6, studentDO.getMath());
			pstmt.setInt(7, studentDO.getSci());
			;
			rowCount = pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(!pstmt.isClosed()){
					pstmt.close();
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return rowCount;
	}
	public int updateStudentAll(StudentDO studentDO){
		int rowCount = 0;
		sql = "update student set korean = ? , english = ? , math = ? , science = ? where id = ?";
		System.out.println(sql);
		System.out.println("after");
		System.out.println(studentDO.getKor());
		System.out.println(studentDO.getEng());
		System.out.println(studentDO.getMath());
		System.out.println(studentDO.getSci());
		System.out.println(studentDO.getId());
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, studentDO.getKor());
			pstmt.setInt(2, studentDO.getEng());
			pstmt.setInt(3, studentDO.getMath());
			pstmt.setInt(4, studentDO.getSci());
			pstmt.setInt(5, studentDO.getId());
			rowCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(rowCount);
		return rowCount;
	}
	public int updateStudentOne(int id, String subject, int score){
		int rowCount = 0;
		sql = "update student set "+ subject + " = ? where id = ?";
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, score);
			pstmt.setInt(2, id);
			rowCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowCount;
	}
}
