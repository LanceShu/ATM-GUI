package idao

import model.User
import java.util.*

interface IUser{

    //插入用户
    abstract fun insert(user: User): Boolean

    // 删除用户
    abstract fun delete(userId: Int): Boolean

    // 更新用户
    abstract fun update(user: User): Boolean

    // 查所有用户(一般用于和界面交互)
    abstract fun findEmployeeAll(): ArrayList<User>

    // 根据用户名查(一般用于和界面交互)
    abstract fun findEmployeeByName(userName: String): ArrayList<User>?

}