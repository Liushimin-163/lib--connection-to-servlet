package test;

import java.sql.*;

public class jdbcUtils {
    private static String drive="com.mysql.cj.jdbc.Driver";
    private static String urls="jdbc:mysql://localhost:3306/school?characterEncoding=utf-8&serverTimezone=UTC";
    //private static String urls1="jdbc:mysql://localhost:3306/student?characterEncoding=utf-8&serverTimezone=UTC";
    private static String username="root";
    private static String userPw="rootroot";


    static {
        try{
            Class.forName(drive);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConn() throws SQLException{
        Connection conn= DriverManager.getConnection(urls,username,userPw);
        return conn;
    }
   /* public static Connection getConnStu() throws SQLException{
        Connection conn= DriverManager.getConnection(urls1,username,userPw);
        return conn;
    }*/
    public static void closeR(Connection conn, Statement st, ResultSet rs){
        if(rs!=null){
            try{
                rs.close();
            }catch (SQLException e){

            };
        }if(st != null){
            try{
                st.close();
            }catch(SQLException e){

            }
        }if(conn !=null){
           try{
               conn.close();
           }catch(SQLException e){

           }
        }
    }
}
