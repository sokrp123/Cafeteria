//package ui;
package teamProject.ui;
import teamProject.model.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class LoginPanel extends JPanel {
    private JTextField idText;
    private JPasswordField psText;
    private JButton checkBtn;

    public LoginPanel(FoodReserveFrame foodReserveFrame) {
        foodReserveFrame.setTitle("로그인 화면");
        setLayout(null);

        JLabel jLabel = new JLabel("안녕하세요.");
        jLabel.setBounds(100, 50, 250, 50);
        add(jLabel);

        jLabel = new JLabel("명지대학교 학식 예약 프로그램입니다.");
        jLabel.setBounds(100, 50, 250, 100);
        add(jLabel);

        jLabel = new JLabel("made by 코로나 언제 끝나조");
        jLabel.setBounds(100, 50, 250, 150);
        add(jLabel);

        jLabel = new JLabel("ID입력 후 로그인 버튼을 클릭하세요.");
        jLabel.setBounds(100, 50, 250, 200);
        add(jLabel);

        jLabel = new JLabel("아이디");
        jLabel.setBounds(30, 410, 70, 50);
        add(jLabel);

        idText = new JTextField("");
        idText.setBounds(100, 420, 200, 30);
        add(idText);

        JButton loginBtn = new JButton("로그인");
        loginBtn.setBounds(310, 420, 90, 30);
        loginBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<String, Account> accounts = foodReserveFrame.getAccounts();
                if (accounts.containsKey(idText.getText())) {
                    Account account = accounts.get(idText.getText());
                    if (account.getPw().equals(String.valueOf(psText.getPassword()))) {
                        foodReserveFrame.setNowAccount(account);
                        foodReserveFrame.setOtherContentPane(1);
                        checkBtn.setEnabled(true);
                    }
                }
            }
        });
        add(loginBtn);

        jLabel = new JLabel("비밀번호");
        jLabel.setBounds(30, 460, 70, 50);
        add(jLabel);

        psText = new JPasswordField("");
        psText.setBounds(100, 470, 200, 30);
        add(psText);

        JButton signBtn = new JButton("회원가입");
        signBtn.setBounds(310, 470, 90, 30);
        signBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idText.getText();
                String pw = String.valueOf(psText.getPassword());
                if (id.equals("") || pw.equals("")) {
                    return;
                }
                Map<String, Account> accounts = foodReserveFrame.getAccounts();
                accounts.put(id, new Account(id, pw));
            }
        });
        add(signBtn);

        checkBtn = new JButton("예약확인");
        checkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foodReserveFrame.setOtherContentPane(10);
            }
        });
        checkBtn.setBounds(410, 430, 90, 60);
        checkBtn.setEnabled(false);
        add(checkBtn);
    }
}

