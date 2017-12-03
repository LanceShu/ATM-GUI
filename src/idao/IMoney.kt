package idao


import model.Money
import java.util.ArrayList

interface IMoney{

    /*
    * 插入方法；
    * */
    abstract fun insert(money: Money): Boolean

    /*
    * 删除方法；
    * */
    abstract fun delete(moneyId: Int): Boolean

    /*
     *更新方法；
     * */
    abstract fun update(money: Money): Boolean

    /*
    * 查找所有用户余额的方法；
    * */
    abstract fun findMoneyAll(): ArrayList<Money>

    /*
    * 查找指定用户余额的方法；
    * */
    abstract fun findMoneyByName(moneyName: String): ArrayList<Money>?
}