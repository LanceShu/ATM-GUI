package idao


import model.Money
import java.util.ArrayList

interface IMoney{
    abstract fun insert(money: Money): Boolean

    // 删
    abstract fun delete(moneyId: Int): Boolean

    // 改
    abstract fun update(money: Money): Boolean

    // 查所有用户(一般用于和界面交互)
    abstract fun findMoneyAll(): ArrayList<Money>

    // 根据用户名查(一般用于和界面交互)
    abstract fun findMoneyByName(moneyName: String): ArrayList<Money>?
}