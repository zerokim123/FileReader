package jp.co.tecinfosys.L191_ERFileCreateSqlTool;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.lang3.StringUtils;

public class JFrameStart extends JFrame implements ActionListener {

    JLabel label1;
    JLabel label2;

    static JButton button1;
    static JButton button2;
    static JButton button3;

    static JPanel labelPanel;

    static JTextField fromPath;
    static JTextField toPath;

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
        JFrameStart frame = new JFrameStart();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        // コンポーネントの配置方法を設定
        frame.setLayout(new GridLayout(3,0));
        frame.setTitle("タイトル");
        frame.setVisible(true);
    }

    public JFrameStart(){
        button1 = new JButton("From");
        button1.addActionListener(e -> {
            actionPerformed1();
        });
        fromPath = new JTextField(20);
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.add(button1);
        p1.add(fromPath);

        button2 = new JButton("To");
        button2.addActionListener(e -> {
            actionPerformed2();
        });
        toPath = new JTextField(20);
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(button2);
        p2.add(toPath);

        button3 = new JButton("Change");
        button3.addActionListener(e -> {
            actionPerformed3();
        });
        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        p3.add(button3);

        getContentPane().add(p1);
        getContentPane().add(p2);
        getContentPane().add(p3);
    }

    public void actionPerformed1() {

        JFileChooser filechooser = new JFileChooser("");

        if(StringUtils.isNotBlank(fromPath.getText())) {
            filechooser = new JFileChooser(fromPath.getText());
        } else {
            filechooser = new JFileChooser("C:\\");
        }
        filechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int selected = filechooser.showSaveDialog(this);
        if (selected == JFileChooser.APPROVE_OPTION){
          File file = filechooser.getSelectedFile();
          fromPath.setText(file.getAbsolutePath().toString());
        }
    }

    public void actionPerformed2() {

        JFileChooser filechooser = new JFileChooser("");

        if(StringUtils.isNotBlank(toPath.getText())) {
            filechooser = new JFileChooser(toPath.getText());
        } else {
            filechooser = new JFileChooser("C:\\");
        }
        filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int selected = filechooser.showSaveDialog(this);
        if (selected == JFileChooser.APPROVE_OPTION){
          File file = filechooser.getSelectedFile();
          toPath.setText(file.getAbsolutePath());
        }
    }

    public void actionPerformed3() {
        String strFromPath = fromPath.getText();
        String strToPath = toPath.getText();

        if(StringUtils.isNotBlank(strFromPath) && StringUtils.isNotBlank(strToPath)) {
//            strFromPath = strFromPath + "\\";
            strToPath = strToPath + "\\";
            String[] args = new String[] {strFromPath, strToPath};
            App.main(args);
        }else {
            JOptionPane.showMessageDialog(null, "FromとToを入力してください。","エラー",0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO 自動生成されたメソッド・スタブ

    }

}
