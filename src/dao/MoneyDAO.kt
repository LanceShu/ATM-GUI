package dao

import idao.IMoney
import model.Money
import util.ConnectionManager
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.util.ArrayList

/**
 * 数据库中的用户余额表数据进行操作；
 * */

class MoneyDAO : IMoney {

    /**
     * 删除操作；
     * */
    override fun delete(moneyId: Int): Boolean {

        /**
         * 判断删除操作是否成功；
         * */
        var result = false

        /**
         * 如果数据库中没有数据，则返回false;
         * */
        if (moneyId == 0)
            return result

        val con = ConnectionManager.getInstance().connection
        var pstmt: PreparedStatement? = null
        try {
            /**
             * 删除子某个用户操作；
             * */
            val sql = "delete from money where emp_no=?"
            pstmt = con!!.prepareStatement(sql)
            pstmt!!.setInt(1, moneyId)
            pstmt.executeUpdate()
            ConnectionManager.close(null, pstmt, con)

            result = true
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            /**
             * 关闭连接
             * */
            ConnectionManager.close(null, pstmt, con)
            return result
        }
    }

    /**
     *
     * 更新操作；
     * */
    override fun update(money: Money): Boolean {

        var result = false
        if (money == null)
            return result

        /**
         * 建立连接；
         * */
        val con = ConnectionManager.getInstance().connection
        var pstmt: PreparedStatement? = null
        try {
            /**
             * 更改对应的元素的数据；
             * */
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

    /**
     * 查找全部的用户的金额的操作；
     * */
    override fun findMoneyAll(): ArrayList<Money> {

        val list = ArrayList<Money>()
        var info: Money

        val con = ConnectionManager.getInstance().connection
        var pstmt: PreparedStatement? = null
        var rs: ResultSet? = null
        try {
            /**
             * 获取所有用户数据
             * */
            pstmt = con!!.prepareStatement("select * from money")
            rs = pstmt.executeQuery()

            /**
             * 逐个遍历查找；
             * */
            while (rs.next()) {
                var name=rs.getString("emp_no")
                var balance=rs.getDouble("balance")
                info = Money(name,balance)

                /**
                 * 加入列表
                 * */
                list.add(info)
            }
        } catch (e: Exception) {
            println(e.toString()+"--"+e.cause.toString())
        } finally {
            ConnectionManager.close(rs, pstmt, con)
            return list
        }
    }

    /**
     * 通过卡号查找到指定的余额数据；
     * */
    override fun findMoneyByName(moneyName: String): ArrayList<Money>? {

        var list= ArrayList<Money>()
        var info: Money
        var con: Connection = ConnectionManager.getInstance().connection
        var pstmt: PreparedStatement
        var rs: ResultSet

        /**
        * 查找操作；
        * */
        pstmt=con.prepareStatement("select * from money where emp_no like ?")
        pstmt.setString(1,"%"+moneyName+"%")
        rs=pstmt.executeQuery()
        while (rs.next()){
            info= Money(rs.getString("emp_no"),rs.getDouble("balance"))
            list.add(info)
        }
        ConnectionManager.close(rs,pstmt,con)
        return list

    }

    /**
     * 插入操作；
     * */
    override fun insert(money: Money): Boolean {

        var result = false
        if (money == null)
            return result

        /**
         * 连接数据库；
         * */
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
