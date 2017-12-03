package View;

import Service.UserServer;
import idao.DAOFactory;
import idao.IMoney;
import model.Money;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuView {

    /**
     * ATM机的功能界面
     * */
    private static JFrame frame;

    public MenuView(){

        /**
         * 字体的样式
         * */
        Font font = new Font("黑体",Font.PLAIN,20);
        /**
         * 初始化GUI界面；
         * 大小为600*540
         * */
        frame = new JFrame("欢迎使用ATM机");
        frame.setSize(600,540);

        /**
         * 界面的背景图案；
         * 背景图片大小为600*600
         * */
        ImageIcon imageIcon = new ImageIcon("E:/Java/ATM/back.png");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(600
                ,600,Image.SCALE_DEFAULT));

        /**
         * 标签显示区；
         * */
        JLabel label = new JLabel();
        label.setIcon(imageIcon);

        /**
         * 内容显示部分；
         * 显示边框为450*150
         * */
        JTextField content = new JTextField();
        content.setText("欢迎使用ATM机");
        content.setBounds(60,60,450,150);
        content.setFont(new Font("黑体",Font.PLAIN,24));

        /**
         * 存款按钮;
         * */
        JButton deposit = new JButton("存款");
        deposit.setFont(font);
        deposit.setBounds(80,240,150,50);
        deposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int inputValue = Integer.parseInt(JOptionPane.showInputDialog("请输入您要存款的金额（单位：100）："));
                if(inputValue % 100 != 0 ){
                    JOptionPane.showMessageDialog(null,
                            "您输入存款金额有误，请重新存款~",
                            "信息提示",JOptionPane.ERROR_MESSAGE);
                }else{
                    UserServer server = new UserServer();
                    server.saveMoney(inputValue);
                    JOptionPane.showMessageDialog(null,
                            "存款成功~",
                            "信息提示",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        /**
         * 取款按钮;
         * */
        JButton draw = new JButton("取款");
        draw.setFont(font);
        draw.setBounds(340,240,150,50);
        draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserServer server = new UserServer();
                IMoney money = DAOFactory.createMoneyDAO();
                String[] type = {"自定义","100元","200元","500元","1000元","5000元"};
                String choose = (String) JOptionPane.showInputDialog(null
                        ,"请选择您的取款金额:"
                        ,"温馨提示："
                        ,JOptionPane.PLAIN_MESSAGE
                        ,null,type,"自定义");
                if(choose.equals(type[0])){
                    int inputValue = Integer.parseInt(JOptionPane.showInputDialog("请输入您要取款的金额（单位：100）："));
                    server.takeMoney(inputValue);
                    JOptionPane.showMessageDialog(null,
                            "取款成功~",
                            "信息提示",JOptionPane.INFORMATION_MESSAGE);
                    ArrayList<Money> monies = money.findMoneyByName(User.getInstance().getEmp_no());
                    for (Money money1 : monies) {
                        content.setText("您的账户余额为：" + money1.getBalance() + "元" );
                    }
                }else if(choose.equals("100元")){
                    server.takeMoney(100);
                    JOptionPane.showMessageDialog(null,
                            "取款成功~",
                            "信息提示",JOptionPane.INFORMATION_MESSAGE);
                    ArrayList<Money> monies = money.findMoneyByName(User.getInstance().getEmp_no());
                    for (Money money1 : monies) {
                        content.setText("您的账户余额为：" + money1.getBalance() + "元" );
                    }
                }else if(choose.equals("200元")){
                    server.takeMoney(200);
                    JOptionPane.showMessageDialog(null,
                            "取款成功~",
                            "信息提示",JOptionPane.INFORMATION_MESSAGE);
                    ArrayList<Money> monies = money.findMoneyByName(User.getInstance().getEmp_no());
                    for (Money money1 : monies) {
                        content.setText("您的账户余额为：" + money1.getBalance() + "元" );
                    }
                }else if(choose.equals("500元")){
                    server.takeMoney(500);
                    JOptionPane.showMessageDialog(null,
                            "取款成功~",
                            "信息提示",JOptionPane.INFORMATION_MESSAGE);
                    ArrayList<Money> monies = money.findMoneyByName(User.getInstance().getEmp_no());
                    for (Money money1 : monies) {
                        content.setText("您的账户余额为：" + money1.getBalance() + "元" );
                    }
                }else if(choose.equals("1000元")){
                    server.takeMoney(1000);
                    JOptionPane.showMessageDialog(null,
                            "取款成功~",
                            "信息提示",JOptionPane.INFORMATION_MESSAGE);
                    ArrayList<Money> monies = money.findMoneyByName(User.getInstance().getEmp_no());
                    for (Money money1 : monies) {
                        content.setText("您的账户余额为：" + money1.getBalance() + "元" );
                    }
                }else if(choose.equals("5000元")){
                    server.takeMoney(5000);
                    JOptionPane.showMessageDialog(null,
                            "取款成功~",
                            "信息提示",JOptionPane.INFORMATION_MESSAGE);
                    ArrayList<Money> monies = money.findMoneyByName(User.getInstance().getEmp_no());
                    for (Money money1 : monies) {
                        content.setText("您的账户余额为：" + money1.getBalance() + "元" );
                    }
                }
            }
        });

        /**
         * 查询按钮;
         * */
        JButton query = new JButton("查询余额");
        query.setFont(font);
        query.setBounds(80,320,150,50);
        query.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IMoney money = DAOFactory.createMoneyDAO();
                ArrayList<Money> monies = money.findMoneyByName(User.getInstance().getEmp_no());
                for (Money money1 : monies) {
                    content.setText("您的账户余额为：" + money1.getBalance() + "元" );
                }
            }
        });

        /**
         * 退出按钮;
         * */
        JButton exit = new JButton("注销");
        exit.setFont(font);
        exit.setBounds(340,320,150,50);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choose = JOptionPane.showConfirmDialog(null
                        ,"是否确认注销该用户？"
                        ,"温馨提示："
                        ,JOptionPane.YES_NO_OPTION);
                if(choose == JOptionPane.YES_OPTION){
                    new MainView();
                    frame.dispose();
                    User.setNull();
                    return;
                }
            }
        });

        /**
         * 显示区添加元素；
         * */
        label.add(content);
        label.add(deposit);
        label.add(draw);
        label.add(query);
        label.add(exit);
        /**
         * 主框架添加显示区；
         * 使主框架可显示出来
         * 并且主框架能进行关闭设置；
         * */
        frame.add(label);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(300,100);
    }

}
