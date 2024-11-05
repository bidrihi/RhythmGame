package rhythm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame {
    private JTextField jtfID, jtfName, jtfEmail;
    private JPasswordField jtfPW;
    private JButton jbtnRegister, jbtnCancel;

    public RegisterFrame(LoginDAO loginDB) {
        JPanel jp = new JPanel();
        jp.setLayout(null);
        JLabel jlbID = new JLabel("ID");
        jlbID.setBounds(200, 50, 50, 20);
        jp.add(jlbID);
        JLabel jlbPW = new JLabel("Password");
        jlbPW.setBounds(160, 100, 60, 20);
        jp.add(jlbPW);
        JLabel jlbName = new JLabel("Name");
        jlbName.setBounds(180, 150, 60, 20);
        jp.add(jlbName);
        JLabel jlbEmail = new JLabel("Email");
        jlbEmail.setBounds(180, 200, 60, 20);
        jp.add(jlbEmail);
        jtfID = new JTextField();
        jtfID.setBounds(250, 50, 100, 20);
        jp.add(jtfID);
        jtfPW = new JPasswordField();
        jtfPW.setBounds(250, 100, 100, 20);
        jp.add(jtfPW);
        jtfName = new JTextField();
        jtfName.setBounds(250, 150, 100, 20);
        jp.add(jtfName);
        jtfEmail = new JTextField();
        jtfEmail.setBounds(250, 200, 100, 20);
        jp.add(jtfEmail);
        jbtnRegister = new JButton("등록");
        jbtnRegister.setBounds(180, 250, 100, 50);
        jbtnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MemberVO vo = new MemberVO(0, jlbID.getText(), jlbPW.getText(), jlbName.getText(), jlbEmail.getText());
                int result = loginDB.memberInsert(vo);

                if (result == 0) {
                    JOptionPane.showMessageDialog(jp, "회원가입 정보를 다시 확인해주세요.", "회원가입 실패", JOptionPane.ERROR_MESSAGE);
                } else {
                    dispose();
                    new LoginFrame().loginWindow();
                }
            }
        });
        jp.add(jbtnRegister);

        jbtnCancel = new JButton("취소");
        jbtnCancel.setBounds(310, 250, 100, 50);
        jbtnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginFrame().loginWindow();
            }
        });
        jp.add(jbtnCancel);

        add(jp);
        setTitle("Register");
        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setFocusable(true);
    }
}