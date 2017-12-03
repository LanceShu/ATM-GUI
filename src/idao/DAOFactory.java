package idao;

import dao.MoneyDAO;
import dao.UserDAO;

public class DAOFactory
{

    public static IUser creatUserDAO(){
        return new UserDAO();
    }

    public static IMoney createMoneyDAO(){
        return new MoneyDAO();
    }
}
