package test;

import java.sql.*;

public class jcbcUtils {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/school?characterEncoding=utf-8&serverTimezone=UTC";
    private static String user = "root";
    private static String password = "rootroot";
    static{
        try {
//注册驱动
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException{
//获得连接
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    public static void closeResource(Connection conn , Statement st , ResultSet rs){
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
