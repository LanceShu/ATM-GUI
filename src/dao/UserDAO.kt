package dao

import idao.IUser
import model.User
import util.ConnectionManager
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.util.*
class UserDAO : IUser {


    override fun delete(userId: Int): Boolean {
        var result = false
        if (userId == 0)
            return result

        val con = ConnectionManager.getInstance().connection
        var pstmt: PreparedStatement? = null
        try {
            // 删除子某个用户
            val sql = "delete from user where emp_id=?"
            pstmt = con!!.prepareStatement(sql)
            pstmt!!.setInt(1, userId)
            pstmt.executeUpdate()
            ConnectionManager.close(null, pstmt, con)

            result = true
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            // 关闭连接
            ConnectionManager.close(null, pstmt, con)
            return result
        }
    }

    override fun update(user: User): Boolean {
        var result = false
        if (user == null)
            return result

        val con = ConnectionManager.getInstance().connection
        var pstmt: PreparedStatement? = null
        try {
            val sql = "update user set emp_pass=?,type=? where emp_no=?"
            pstmt = con!!.prepareStatement(sql)
            pstmt!!.setString(1, user.emp_no)
            pstmt.setString(2, user.emp_pass)
            pstmt.setInt(3, user.type)

            pstmt.executeUpdate()
            result = true
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            // 关闭连接
            ConnectionManager.close(null, pstmt, con)
            return result
        }
    }

    override fun findEmployeeAll(): ArrayList<User> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val list = ArrayList<User>()
        var info: User

        val con = ConnectionManager.getInstance().connection
        var pstmt: PreparedStatement? = null
        var rs: ResultSet? = null
        try {
            // 获取所有用户数据
            pstmt = con!!.prepareStatement("select * from user")
            rs = pstmt.executeQuery()


            while (rs.next()) {
                var name=rs.getString("emp_no")
                var psw=rs.getString("emp_pass")
                var type=rs.getInt("type")
                info = User(name,psw,type)

                // 加入列表
                list.add(info)
            }
        } catch (e: Exception) {
            println(e.toString()+"--"+e.cause.toString());
            //            e.printStackTrace();
        } finally {
            ConnectionManager.close(rs, pstmt, con)
            return list
        }
    }

    override fun findEmployeeByName(userName: String): ArrayList<User>? {

        var list=ArrayList<User>()
        var info:User
        var con:Connection=ConnectionManager.getInstance().connection
        var pstmt:PreparedStatement
        var rs:ResultSet

        pstmt=con.prepareStatement("select * from user where emp_no like ?")
        pstmt.setString(1,"%"+userName+"%")
        rs=pstmt.executeQuery()
        while (rs.next()){
            info= User(rs.getString("emp_no"),rs.getString("emp_pass"),rs.getInt("type"))
            list.add(info)
        }
        ConnectionManager.close(rs,pstmt,con)
        return list
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun insert(user: User): Boolean {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var result = false
        if (user == null)
            return result

        // 获取Connection
        val con = ConnectionManager.getInstance().connection
        var pstmt: PreparedStatement? = null
        try {
            val sql = "insert into user(emp_no, emp_pass, type) values(?,?,?)"
            pstmt = con!!.prepareStatement(sql)
            pstmt!!.setString(1, user.emp_no)
            pstmt.setString(2, user.emp_pass)
            pstmt.setInt(3, user.type)

            pstmt.executeUpdate()
            result = true
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            // 关闭连接
            ConnectionManager.close(null, pstmt, con)
            return result
        }
    }


}
