package com.example.jeonghwanhwang.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
public class StudentDAO {
    Connection conn;
    ResultSet rs;
    Statement stmt;
    PreparedStatement pstmt;
    String sql;
    public StudentDAO(){
        String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
        String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "scott";
        String pwd = "tiger";
        try{
            Class.forName(jdbc_driver);
            conn = DriverManager.getConnection(jdbc_url, user, pwd);
//            System.out.println();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void closeConnection(){
        try{
            if(!conn.isClosed()){
                conn.close();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public Student selectStudent(int id){
        this.sql = "select * from student where id = ?";
        System.out.println(id);
        Student student = null;
        int result = 0;
        try{

            this.pstmt = conn.prepareStatement(sql);
            this.pstmt.setInt(1, id);
            this.rs = pstmt.executeQuery();

            if(rs.next()) {
                student = new Student();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setKorean(rs.getInt("korean"));
                student.setEnglish(rs.getInt("english"));
                student.setMath(rs.getInt("math"));
                student.setScience(rs.getInt("science"));

            }

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

        return student;
    }
    public int selectId(int id){
        this.sql = "select hakbun from student where hakbun = ?";
        Student s = null;
        int result = 0;
        try{

            this.pstmt = conn.prepareStatement(sql);
            this.pstmt.setInt(1, id);
            this.rs = pstmt.executeQuery();
            if(rs.next()) {
                result = rs.getInt("hakbun");
            }
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
        return result;
    }
    public ArrayList<Student> selectAll(){
        this.sql = "select * from student";
        Student student;
        ArrayList<Student> result = new ArrayList<>();

        try{
            this.stmt = conn.createStatement();
            this.rs = stmt.executeQuery(sql);
            while(rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setKorean(rs.getInt("korean"));
                student.setEnglish(rs.getInt("english"));
                student.setMath(rs.getInt("math"));
                student.setScience(rs.getInt("science"));
                result.add(student);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                if(!stmt.isClosed()){
                    stmt.close();
                }
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
        return result;
    }
    public int deleteStudent(Student student){
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
    public int insertStudent(Student s){
        int rowCount = 0;
        sql = "insert into student values(?, ?, ?, ?, ?, ?, ?)";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, s.getId());
            pstmt.setString(2, s.getName());
            pstmt.setString(3, s.getGender());
            pstmt.setInt(4, s.getKorean());
            pstmt.setInt(5, s.getEnglish());
            pstmt.setInt(6, s.getMath());
            pstmt.setInt(7, s.getScience());
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
    public int updateStudentAll(Student student){
        int rowCount = 0;
        sql = "update student set korean = ? , english = ? , math = ? , science = ? where id = ?";
        System.out.println(sql);
        System.out.println("after");
        System.out.println(student.getKorean());
        System.out.println(student.getEnglish());
        System.out.println(student.getMath());
        System.out.println(student.getScience());
        System.out.println(student.getId());
        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, student.getKorean());
            pstmt.setInt(2, student.getEnglish());
            pstmt.setInt(3, student.getMath());
            pstmt.setInt(4, student.getScience());
            pstmt.setInt(5, student.getId());
            rowCount = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(rowCount);
        return rowCount;
    }
    public int updateStudentOne(int id, String subject, int score){
        int rowCount = 0;
//        System.out.println("sub " + subject);
//        System.out.println("score" + score);
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
