package View;

import dao.UserDAO;
import idao.DAOFactory;
import idao.IUser;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainView {

    private static JButton bt_log;
    private static JButton bt_exit;
    private static JTextField jt_num;
    private static JPasswordField jt_pass;
    public static JFrame bodyFrame;

    public static void main(String[] args) {
        new MainView();

        /**
         * 登录按钮的点击事件；
         * */
        bt_log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /**
                 * 获取框的卡号密码；
                 * */
                String num = jt_num.getText().toString();
                char[] password = jt_pass.getPassword();
                String pass = String.valueOf(password);

                /**
                 * 卡号密码的逻辑判断；
                 * 1.卡号密码不能为null；
                 * 2.卡号不能小于19位，银行卡的卡号都为19位；
                 * 3.卡号密码与数据库的匹配是否成功；
                 * */
                if(num.length() == 0 || pass.length() == 0){
                    JOptionPane.showMessageDialog(null,
                            "您输入的银行卡号或密码不能为空~",
                            "信息提示",JOptionPane.ERROR_MESSAGE);
                } else if(num.length() != 19){
                    JOptionPane.showMessageDialog(null,
                            "您输入的银行卡号格式有误，请重新输入~",
                            "信息提示",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    System.out.println("num=" + num + ",pass=" + pass);
                    IUser user = DAOFactory.creatUserDAO();
                    ArrayList<User> userList = user.findEmployeeByName(num);
                    for (User user1 : userList) {
                        if(user1.getEmp_pass().equals(pass)){
                            User.getInstance().setEmp_no(num);
                            User.getInstance().setEmp_pass(pass);
                            new MenuView();
                            bodyFrame.dispose();
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null,
                            "您输入的密码不正确~",
                            "信息提示",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        /**
         * 退出按钮的点击事件；
         * */
        bt_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public MainView(){

        /**
         * 设置字体样式；
         * */
        Font font = new Font("黑体",Font.PLAIN,20);

        /**
         * 初始化主框架；
         * 并设置大小为600*540；
         * */
        bodyFrame = new JFrame("ATM登录界面");
        bodyFrame.setMinimumSize(new Dimension(600,540));

        /**
         * 设置背景；
         * 背景图片大小为600*600；
         * */
        ImageIcon imageIcon = new ImageIcon("E:/Java/ATM/back.png");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(600
                ,600,Image.SCALE_DEFAULT));

        /**
         * 初始化显示区；
         * */
        JLabel label1 = new JLabel();
        label1.setIcon(imageIcon);

        /**
         * 设置标题；
         * */
        JLabel title = new JLabel("欢迎使用ATM机");
        title.setBounds(200,60,300,40);
        title.setFont(new Font("黑体",Font.PLAIN,28));

        JLabel num = new JLabel("银行卡号：");
        num.setBounds(100,180,150,24);
        num.setFont(font);

        JLabel pass = new JLabel("银行密码：");
        pass.setBounds(100,240,150,24);
        pass.setFont(font);

        /**
         * 账号输入框；
         * */
        jt_num = new JTextField();
        jt_num.setBounds(220,180,300,24);
        jt_num.setFont(font);

        /**
         * 密码输入框；
         * */
        jt_pass = new JPasswordField();
        jt_pass.setBounds(220,240,300,24);
        jt_num.setFont(font);

        /**
         * 确认按钮；
         * */
        bt_log = new JButton("确认");
        bt_log.setBounds(160,350,100,30);
        bt_log.setFont(font);

        /**
         * 退出按钮
         * */
        bt_exit = new JButton("退出");
        bt_exit.setBounds(320,350,100,30);
        bt_exit.setFont(font);

        /**
         * 显示区添加元素；
         * */
        label1.add(title);
        label1.add(num);
        label1.add(pass);
        label1.add(jt_num);
        label1.add(jt_pass);
        label1.add(bt_log);
        label1.add(bt_exit);
        /**
         * 主框架添加显示区；
         * 设置主框架为可显示的；
         * 主框架可关闭；
         * 位置为x=300，y=100；
         * */
        bodyFrame.add(label1);
        bodyFrame.setVisible(true);
        bodyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bodyFrame.setLocation(300,100);
    }
}
