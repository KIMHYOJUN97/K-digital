package HwangJeongHwan;
import java.sql.*;
import java.util.*;
public class Control {
    Connection conn;
    ResultSet rs;
    PreparedStatement pstmt;
    String sql;
    public Control(){
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
    public Student selectStudent(int hakbun){
        this.sql = "select * from student where hakbun = ?";
        Student s = null;
        int [] score = new int[4];
        try{

            this.pstmt = conn.prepareStatement(sql);
            this.pstmt.setInt(1, hakbun);
            this.rs = pstmt.executeQuery();
            if(rs.next()) {
                score[0] = rs.getInt("korean");
                score[1] = rs.getInt("english");
                score[2] = rs.getInt("math");
                score[3] = rs.getInt("science");

                s = new Student(rs.getInt("hakbun"), rs.getString("sname"),
                        rs.getString("gender"), score);
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
        return s;
    }
    public int selectHakbun(int hakbun){
        this.sql = "select hakbun from student where hakbun = ?";
        Student s = null;
        int result = 0;
        try{

            this.pstmt = conn.prepareStatement(sql);
            this.pstmt.setInt(1, hakbun);
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
        ArrayList<Student> s = new ArrayList<>();
        int [] score = new int[4];
        try{
            this.pstmt = conn.prepareStatement(sql);
            this.rs = pstmt.executeQuery();
            while(rs.next()) {
                score[0] = rs.getInt("korean");
                score[1] = rs.getInt("english");
                score[2] = rs.getInt("math");
                score[3] = rs.getInt("science");


                s.add(new Student(rs.getInt("hakbun"), rs.getString("sname"),
                        rs.getString("gender"), score));
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
        return s;
    }
    public int deleteStudent(int hakbun){
        this.sql = "delete from student where hakbun = ?";
        int rowCount = 0;
        try{
            this.pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, hakbun);
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
            pstmt.setInt(1, s.getHakbun());
            pstmt.setString(2, s.getName());
            pstmt.setString(3, s.getMaleFemale());
            int[] scores = s.getScore();

            System.out.println(s.getHakbun() + " " + s.getName() + " " + s.getMaleFemale());
            System.out.println(Arrays.toString(scores));
            for(int i = 0; i < scores.length; i++){
                pstmt.setInt(i + 4,scores[i]);
            }
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
    public int updateStudent(int hakbun, int[] score){
        int rowCount = 0;
        sql = "update student set korean = ? , english = ? , math = ? , science = ? where hakbun = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            for(int i = 0; i < 4; i++){
                pstmt.setInt(i + 1, score[i]);
            }
            pstmt.setInt(5,hakbun);
            rowCount = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowCount;
    }
    public int updateStudent(int hakbun, String subject, int score){
        int rowCount = 0;
//        System.out.println("sub " + subject);
//        System.out.println("score" + score);
        sql = "update student set "+ subject + " = ? where hakbun = ?";
        System.out.println(sql);
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, score);
            pstmt.setInt(2,hakbun);
            rowCount = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowCount;
    }

}
