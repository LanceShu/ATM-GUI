package Main.View;

import javafx.scene.control.PasswordField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView {

    public static void main(String[] args) {

        mainView();

    }

    private static void mainView(){

        ImageIcon imageIcon = new ImageIcon("E:/alback.png");
        JLabel label = new JLabel(imageIcon);

        label.setBounds(0,0,600,600);

        JFrame frame = new JFrame("ATM登陆界面");

        frame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.setOpaque(false);

        //设置可以关闭;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置是否可见;
        frame.setVisible(true);
        //设置宽度与高度;
        frame.setSize(600,600);
        //设置显示位置;
        frame.setLocation(300,100);

        //生成一个容器;
        Container container = frame.getContentPane();
        //容器的布局样式;
        container.setLayout(new GridLayout(7,1));

        //第一个版面;
        JPanel pane0 = new JPanel();
        pane0.setOpaque(false);
        container.add(pane0);

        //第二个版面;
        JPanel panel1 = new JPanel();
        //版面上的标题;
        JLabel title = new JLabel("欢迎登陆ATM系统");
        //标题的自体样式;
        title.setFont(new Font("宋体",Font.BOLD,24));
        panel1.add(title);
        panel1.setOpaque(false);
        container.add(panel1);

        JPanel panel2 = new JPanel();
        //文本框：银行卡号;
        JLabel num = new JLabel("银行卡号：");
        num.setFont(new Font("宋体",Font.BOLD,16));
        panel2.add(num);
        //文本输入框,长度为45;
        TextField tf_name = new TextField(45);
        panel2.add(tf_name);
        panel2.setOpaque(false);
        container.add(panel2);

        JPanel panel3 = new JPanel();
        //文本框：密码;
        JLabel pass = new JLabel("卡号密码：");
        pass.setFont(new Font("宋体",Font.BOLD,16));
        panel3.add(pass);
        //文本输入框,长度为45;
        TextField tf_pass = new TextField(45);
        panel3.add(tf_pass);
        panel3.setOpaque(false);
        container.add(panel3);

        JPanel panel4 = new JPanel();
        //确认按钮；
        JButton bt_log = new JButton("确认");
        bt_log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tf_name.getText().length() == 0 || tf_pass.getText().length() == 0){
                    JOptionPane.showMessageDialog(null,
                            "您输入的银行卡号或密码不能为空~",
                            "信息提示",JOptionPane.ERROR_MESSAGE);
                }else if(tf_name.getText().length() != 19){
                    System.out.println(tf_name.getText().length());
                    JOptionPane.showMessageDialog(null,
                            "您输入的银行卡号格式有误，请重新输入~",
                            "信息提示",JOptionPane.ERROR_MESSAGE);
                } else{

                }
            }
        });
        panel4.add(bt_log);
        //退出按钮;
        JButton bt_exit = new JButton("退出");
        bt_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel4.add(bt_exit);
        panel4.setOpaque(false);
        container.add(panel4);

    }

}
