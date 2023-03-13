package com.example.twitter2;

import java.sql.*;
import java.util.ArrayList;

public class TwitterDAO {
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private String sql;


    public TwitterDAO(){
        String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
        String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "scott";
        String pwd = "tiger"; //원래는 외부파일로 빼서 파일 입출력으로 사용-> 보안상 민감하기 때문에

        try{
            Class.forName(jdbc_driver); // 클래스 notfound exception 발생시킬수 있다고 오류
            this.conn = DriverManager.getConnection(jdbc_url, user, pwd);

            // try catch로 감싸기
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public TwitterLoginDO checkLogin(TwitterLoginDO loginDO){
        TwitterLoginDO result = null;
        this.sql = "select * from twitter_login where id = ? and passwd = ?";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, loginDO.getId());
            pstmt.setString(2, loginDO.getPasswd());

            rs = pstmt.executeQuery();
            if(rs.next()){ // id가 pk이므로 반환될수 있는 행의 개수는 0 or 1 -> 반복문을 사용할 필요가 없음
                result = new TwitterLoginDO();
                result.setId(rs.getString("id"));
                result.setPasswd(rs.getString("passwd"));
                result.setName(rs.getString("Name"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if (!pstmt.isClosed()) {
                    pstmt.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        return result;
    }
    public ArrayList<TwitterDO> getAllTwitter(){
        ArrayList<TwitterDO> list = new ArrayList<>();
        TwitterDO tDO = null;
        this.sql = "select twitter.id || '@' || name as id_name, message," +
                " to_char(create_date, 'YYYY/MM/DD HH24:MM:SS') as cdatetime " +
                "from twitter inner join twitter_login on twitter.id = twitter_login.id order by no";
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                tDO = new TwitterDO();
                tDO.setId(rs.getString("id_name"));
                tDO.setMessage(rs.getString("message"));
                tDO.setCreateDate(rs.getString("cdatetime"));
                list.add(tDO);

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if (!stmt.isClosed()) {
                    stmt.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }


        return list;
    }
    public int insertTwitter(TwitterDO tDO) {
        int rowCount = 0;
        this.sql = "insert into twitter(no, id, message) values(twitter_seq.nextval, ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tDO.getId());
            pstmt.setString(2, tDO.getMessage());
            System.out.println(tDO.getId());
            System.out.println(tDO.getMessage());
            rowCount = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (!pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rowCount;
    }

    public void closeConnection(){
        try{
            if(!this.conn.isClosed()){
                conn.close();
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


}
