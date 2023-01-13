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
        foodReserveFrame.setTitle("�α��� ȭ��");
        setLayout(null);

        JLabel jLabel = new JLabel("�ȳ��ϼ���.");
        jLabel.setBounds(100, 50, 250, 50);
        add(jLabel);

        jLabel = new JLabel("�������б� �н� ���� ���α׷��Դϴ�.");
        jLabel.setBounds(100, 50, 250, 100);
        add(jLabel);

        jLabel = new JLabel("made by �ڷγ� ���� ������");
        jLabel.setBounds(100, 50, 250, 150);
        add(jLabel);

        jLabel = new JLabel("ID�Է� �� �α��� ��ư�� Ŭ���ϼ���.");
        jLabel.setBounds(100, 50, 250, 200);
        add(jLabel);

        jLabel = new JLabel("���̵�");
        jLabel.setBounds(30, 410, 70, 50);
        add(jLabel);

        idText = new JTextField("");
        idText.setBounds(100, 420, 200, 30);
        add(idText);

        JButton loginBtn = new JButton("�α���");
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

        jLabel = new JLabel("��й�ȣ");
        jLabel.setBounds(30, 460, 70, 50);
        add(jLabel);

        psText = new JPasswordField("");
        psText.setBounds(100, 470, 200, 30);
        add(psText);

        JButton signBtn = new JButton("ȸ������");
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

        checkBtn = new JButton("����Ȯ��");
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

