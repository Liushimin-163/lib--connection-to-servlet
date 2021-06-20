package peixun;

import java.sql.*;

public class demo02 {
   private static String driver="com.mysql,jdbc.Driver";
   private static String url="jdbc:mysql://localhost:3306/category";
   private static String user="root";
   private static String password="rootroot";

   static{
       try{
           Class.forName(driver);
       }catch(Exception e){
           throw new RuntimeException(e);
       }
   }
     public static Connection getConnection() throws SQLException {
//获得连接
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
    /**
     用心辅导，技术改变人生 ——跟Tom学编程 公众号: 跟Tom学编程 微信: tompeixun QQ: 1445154666
     * 释放资源
     * @param conn
     * @param st
     * @param rs
     */
    public static void closeResource(Connection conn , Statement st , ResultSet
            rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }
}
