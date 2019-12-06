import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Query2 {

    public static void main(String[] args) {
        //防止sql注入，所以查询不到数据
        queryById("唐三藏' or '1'='1");
        queryById("唐三藏");
    }

    public static void queryById(String stuName) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            try {
                // 创建数据库连接Connection
                connection = DBUtil.getConnection2();
                // 根据数据库连接创建操作命令对象Statement
                String sql = "select id,name,chinese,math,english from exam_result" +
                        " where name=?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, stuName);
                // 操作命令对象执行sql语句，返回结果集resultSet
                // resultSet类似  List<Map<String, Object>>
                resultSet = statement.executeQuery();
                while(resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    BigDecimal chinese = resultSet.getBigDecimal("chinese");
                    BigDecimal math = resultSet.getBigDecimal("math");
                    BigDecimal english = resultSet.getBigDecimal("english");
                    System.out.printf("id=%s, name=%s, chinese=%s, " +
                                    "math=%s, english=%s", id, name, chinese,
                            math, english);
                    System.out.println();
                }
            } finally {
                // 释放资源
                DBUtil.close(connection, statement, resultSet);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
