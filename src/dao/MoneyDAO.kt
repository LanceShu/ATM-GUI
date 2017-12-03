package dao

import idao.IMoney
import model.Money
import util.ConnectionManager
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.util.ArrayList

class MoneyDAO : IMoney {


    override fun delete(moneyId: Int): Boolean {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        var result = false
        if (moneyId == 0)
            return result

        val con = ConnectionManager.getInstance().connection
        var pstmt: PreparedStatement? = null
        try {
            // 删除子某个用户
            val sql = "delete from money where emp_no=?"
            pstmt = con!!.prepareStatement(sql)
            pstmt!!.setInt(1, moneyId)
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

    override fun update(money: Money): Boolean {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var result = false
        if (money == null)
            return result

        val con = ConnectionManager.getInstance().connection
        var pstmt: PreparedStatement? = null
        try {
            val sql = "update money set balance=? where emp_no=?"
            pstmt = con!!.prepareStatement(sql)
            pstmt!!.setString(2, money.emp_no)
            pstmt.setDouble(1, money.balance)

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

    override fun findMoneyAll(): ArrayList<Money> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val list = ArrayList<Money>()
        var info: Money

        val con = ConnectionManager.getInstance().connection
        var pstmt: PreparedStatement? = null
        var rs: ResultSet? = null
        try {
            // 获取所有用户数据
            pstmt = con!!.prepareStatement("select * from money")
            rs = pstmt.executeQuery()


            while (rs.next()) {
                var name=rs.getString("emp_no")
                var balance=rs.getDouble("balance")
                info = Money(name,balance)

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

    override fun findMoneyByName(moneyName: String): ArrayList<Money>? {

        var list= ArrayList<Money>()
        var info: Money
        var con: Connection = ConnectionManager.getInstance().connection
        var pstmt: PreparedStatement
        var rs: ResultSet

        pstmt=con.prepareStatement("select * from money where emp_no like ?")
        pstmt.setString(1,"%"+moneyName+"%")
        rs=pstmt.executeQuery()
        while (rs.next()){
            info= Money(rs.getString("emp_no"),rs.getDouble("balance"))
            list.add(info)
        }
        ConnectionManager.close(rs,pstmt,con)
        return list
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun insert(money: Money): Boolean {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var result = false
        if (money == null)
            return result

        // 获取Connection
        val con = ConnectionManager.getInstance().connection
        var pstmt: PreparedStatement? = null
        try {
            val sql = "insert into money(emp_no, balance) values(?,?)"
            pstmt = con!!.prepareStatement(sql)
            pstmt!!.setString(1, money.emp_no)
            pstmt.setDouble(2, money.balance)

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
