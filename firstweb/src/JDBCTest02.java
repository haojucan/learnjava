import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest02 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        //加载数据库驱动
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String username = "root";
            String password = "Axu19870318..";
            //创建应用程序与数据库连接的Connection对象
            conn = DriverManager.getConnection(url, username, password);
            //执行SQL语句
            String SQL = "INSERT INTO users(name,password,email,birthday) VALUES(?,?,?,?)";
            //1.创建执行SQL语句的PrepareStatement对象
            preStmt = conn.prepareStatement(SQL);
            // 2.为SQL语句中的参数赋值
            preStmt.setString(1, "zl");
            preStmt.setString(2, "13456");
            preStmt.setString(3, "zl@sina.com");
            preStmt.setString(4, "1988-12-05");
            //3.执行SQL
            preStmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (preStmt != null) {
                try {
                    preStmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                preStmt = null;
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conn = null;

            }
        }


    }

}
