import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Update {

    public static void main(String[] args) {
        //防止sql注入，所以查询不到数据
//        queryById("唐三藏' or '1'='1");
        updateById("唐三藏", 99);
    }

    public static void updateById(String stuName, int updateMath) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            try {
                // 创建数据库连接Connection
                connection = DBUtil.getConnection2();
                // 根据数据库连接创建操作命令对象Statement
                String sql = "update exam_result set math=?" +
                        " where name=?";
                statement = connection.prepareStatement(sql);
                statement.setInt(1, updateMath);
                statement.setString(2, stuName);
                // SQL新增、修改、删除操作，都使用executeUpdate()方法
                int num = statement.executeUpdate();
                if(num>0)
                    System.out.println("修改成功");
                else
                    System.out.println("修改失败");
            } finally {
                // 释放资源
                DBUtil.close(connection, statement, null);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
