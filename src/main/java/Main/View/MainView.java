package Main.View;

import javax.swing.*;
import java.awt.*;

public class MainView {

    public static void main(String[] args) {

        mainView();

    }

    private static void mainView(){
        JFrame frame = new JFrame("ATM登陆界面");
        //设置可以关闭;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置是否可见;
        frame.setVisible(true);
        //设置宽度与高度;
        frame.setSize(600,600);
        //设置显示位置;
        frame.setLocation(200,100);

        //生成一个容器;
        Container container = frame.getContentPane();
        //容器的布局样式;
        container.setLayout(new GridLayout(7,1));

        //第一个版面;
        JPanel panel0 = new JPanel();
        container.add(panel0);

        //第二个版面;
        JPanel panel1 = new JPanel();
        //版面上的标题;
        JLabel title = new JLabel("欢迎登陆ATM系统");
        //标题的自体样式;
        title.setFont(new Font("宋体",Font.BOLD,20));
        panel1.add(title);
        container.add(panel1);

        JPanel panel2 = new JPanel();
        //文本框：银行卡号;
        JLabel name = new JLabel("银行卡号：");
        name.setFont(new Font("宋体",Font.BOLD,16));
        panel2.add(name);
        //文本输入框,长度为45;
        TextField tf_name = new TextField(45);
        tf_name.setText("请在此处输入银行卡号");
        panel2.add(tf_name);
        container.add(panel2);


        JPanel panel3 = new JPanel();
        //文本框：密码;
        JLabel pass = new JLabel("卡号密码：");
        pass.setFont(new Font("宋体",Font.BOLD,16));
        panel3.add(pass);
        //文本输入框,长度为45;
        TextField tf_pass = new TextField(45);
        tf_pass.setText("请在此处输入银行卡密码");
        panel3.add(tf_pass);
        container.add(panel3);

        JPanel panel4 = new JPanel();
        //确认按钮；
        JButton bt_log = new JButton("确认");
        panel4.add(bt_log);
        //退出按钮;
        JButton bt_exit = new JButton("退出");
        panel4.add(bt_exit);
        container.add(panel4);


    }

}
