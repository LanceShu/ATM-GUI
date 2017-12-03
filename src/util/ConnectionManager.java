package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * 数据库连接操作类
 */
public final class ConnectionManager
{
    private static ConnectionManager instance;
    private static ComboPooledDataSource ds;

    /**
     * 初始化,只执行一次
     *
     * MySQL数据库初始化，进行连接;
     * */
    static
    {
        ResourceBundle rb = ResourceBundle.getBundle("c3p0");
        ds = new ComboPooledDataSource();
        try
        {
            ds.setDriverClass(rb.getString("driver"));
        }
        catch(Exception e)
        {
            System.out.println(e.toString()+"asd");
            e.printStackTrace();
        }
        ds.setJdbcUrl(rb.getString("url"));
        ds.setUser(rb.getString("username"));
        ds.setPassword(rb.getString("password"));
    }

    /**
     * 获取数据库实例
     * 单例模式;
     */
    public synchronized static final ConnectionManager getInstance()
    {
        if(instance == null)
        {
            try
            {
                instance = new ConnectionManager();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
         return instance;
    }

    /**
     * 获取数据库连接
     */
    public synchronized final Connection getConnection()
    {
        try
        {
            // 查看活动链接数
            // System.out.println("------->busy connections: " + ds.getNumBusyConnections());
            return ds.getConnection();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭数据库连接
     */
    public static void close(ResultSet rs, Statement stmt, Connection con)
    {
        try
        {
            if(rs != null)
                rs.close();
            if(stmt != null)
                stmt.close();
            if(con != null)
                con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 释放数据库资源
     */
    @Override
    protected void finalize() throws Throwable
    {
        // 关闭datasource
        DataSources.destroy(ds);
        super.finalize();
    }

}
