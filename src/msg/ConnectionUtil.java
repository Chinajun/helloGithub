package msg;
import java.sql.*;

/**
 * 数据库连接
 */
public final class ConnectionUtil {
    private static String url = "jdbc:mysql:///cyj_message_board";
    private static String username = "root";
    private static String password = "root";
    private ConnectionUtil() {}
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (Exception e){
            System.out.println("加载驱动失败");
            e.printStackTrace();
        }
    }

    /**
     * 获得数据库连接
     * @return
     */
    public static Connection getConnection(){
        try {
            DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            System.out.println("创建数据库连接失败");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 释放数据库资源
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void release(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
