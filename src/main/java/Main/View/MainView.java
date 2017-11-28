package Main.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView {

    private static JButton bt_log;
    private static JButton bt_exit;
    private static JTextField jt_num;
    private static JPasswordField jt_pass;

    public static void main(String[] args) {
        new MainView();

        bt_log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num = jt_num.getText().toString();
                char[] password = jt_pass.getPassword();
                String pass = String.valueOf(password);

                if(num.length() == 0 || pass.length() == 0){
                    JOptionPane.showMessageDialog(null,
                            "您输入的银行卡号或密码不能为空~",
                            "信息提示",JOptionPane.ERROR_MESSAGE);
                }else if(num.length() != 19){
                    JOptionPane.showMessageDialog(null,
                            "您输入的银行卡号格式有误，请重新输入~",
                            "信息提示",JOptionPane.ERROR_MESSAGE);
                }else{
                    System.out.println("num=" + num + ",pass=" + pass);
                }
            }
        });

        bt_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public MainView(){

        Font font = new Font("黑体",Font.PLAIN,20);

        JFrame bodyFrame = new JFrame("ATM登录界面");
        bodyFrame.setSize(600,600);

        ImageIcon imageIcon = new ImageIcon("E:/alback.png");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(600
                ,600,Image.SCALE_DEFAULT));

        JLabel label1 = new JLabel();
        label1.setIcon(imageIcon);

        JLabel title = new JLabel("欢迎使用ATM系统");
        title.setBounds(200,60,300,40);
        title.setFont(new Font("黑体",Font.PLAIN,28));

        JLabel num = new JLabel("银行卡号：");
        num.setBounds(100,180,150,24);
        num.setFont(font);

        JLabel pass = new JLabel("银行密码：");
        pass.setBounds(100,240,150,24);
        pass.setFont(font);

        jt_num = new JTextField();
        jt_num.setBounds(220,180,300,24);
        jt_num.setFont(font);

        jt_pass = new JPasswordField();
        jt_pass.setBounds(220,240,300,24);
        jt_num.setFont(font);

        bt_log = new JButton("确认");
        bt_log.setBounds(160,350,100,30);
        bt_log.setFont(font);

        bt_exit = new JButton("退出");
        bt_exit.setBounds(320,350,100,30);
        bt_exit.setFont(font);

        label1.add(title);
        label1.add(num);
        label1.add(pass);
        label1.add(jt_num);
        label1.add(jt_pass);
        label1.add(bt_log);
        label1.add(bt_exit);
        bodyFrame.add(label1);
        bodyFrame.setVisible(true);
        bodyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bodyFrame.setLocation(300,100);
    }
}
