package Service

import idao.DAOFactory
import idao.IMoney
import idao.IUser
import model.Money
import model.User

class UserServer{
    private  var currentUser:User
    private var moneyDAO:IMoney = DAOFactory.createMoneyDAO()

    constructor(){
        currentUser = User.getInstance()
    }

    /**
     * 存款时，操作数据库；
     * */
    fun saveMoney(amount:Int){
        if (currentUser==null)
            return
        var money:Money = moneyDAO.findMoneyByName(currentUser.emp_no)!![0]
        money.balance = money.balance + amount
        moneyDAO.update(money)
    }

    /**
     * 取款时，操作数据库;
     * */
    fun takeMoney(amount: Int){
        if (currentUser==null)
            return
        var money:Money= moneyDAO.findMoneyByName(currentUser.emp_no)!![0]
        money.balance=money.balance - amount
        moneyDAO.update(money)
    }

}