package teamProject;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Stack;

// ���������� ��ȸ�ϱ� ���� �г�
public class PaymentHistoryPanel extends JPanel {

   private JButton backButton;
   private JComboBox comboBox;
   private JButton inquireButton;
   private JLabel totalPaymentLabel;
   private JLabel numberOfPayLabel;
   private JLabel divisionLabel1;
   private JLabel divisionLabel2;
   private JTextArea resultTextArea;
   private JScrollPane scrollPane;
   private String[] cafeList;

   private static int cafe1TotalPayment; // �����翡�� �� ������ �ݾ�
   private static int cafe2TotalPayment; // �л�ȸ������ �� ������ �ݾ�

   private static Stack<History> paymentHistoryStack; // ��� �Ĵ翡 ���� ����
   private static Stack<History> cafe1PaymentHistoryStack; // �����翡 ���� ����
   private static Stack<History> cafe2PaymentHistoryStack; // �л�ȸ���� ���� ����

   // �г��� �����
   public PaymentHistoryPanel() {

      this.setSize(776, 600);

      backButton = new JButton("�ڷ�");
      totalPaymentLabel = new JLabel("����������");
      numberOfPayLabel = new JLabel("��  ��");
      divisionLabel1 = new JLabel("������������������������������������������������������������������������������������������������������������������������");
      divisionLabel2 = new JLabel("������������������������������������������������������������������������������������������������������������������������");

      cafeList = new String[] { "��ü", "������", "�л�ȸ��" };
      comboBox = new JComboBox(cafeList);
      comboBox.setSelectedIndex(0);

      inquireButton = new JButton("��ȸ");
      resultTextArea = new JTextArea(" �Ĵ��� ������ �� ��ȸ�� �����ּ���.");
      scrollPane = new JScrollPane(resultTextArea);

      this.setLayout(null);
      // this.setBackground(Color.WHITE);
      this.add(backButton);
      this.add(comboBox);
      this.add(inquireButton);
      this.add(totalPaymentLabel);
      this.add(divisionLabel1);
      this.add(numberOfPayLabel);
      this.add(divisionLabel2);
      this.add(scrollPane);

      // �� ��ҵ� ��ġ ����
      // (x��ġ,y��ġ,����ũ��,����ũ��)
      backButton.setBounds(10, 10, 79, 39);
      backButton.setFont(new Font("����", Font.BOLD, 20));

      comboBox.setBounds(300, 70, 77, 40);
      inquireButton.setBounds(390, 70, 60, 40);

      totalPaymentLabel.setBounds(300, 120, 250, 70);
      totalPaymentLabel.setFont(new Font("", Font.BOLD, 40)); // �۾�ü �Ӽ� ����

      divisionLabel1.setBounds(0, 160, 800, 80);

      numberOfPayLabel.setBounds(10, 190, 100, 50);
      numberOfPayLabel.setFont(new Font("", Font.BOLD, 15));

      divisionLabel2.setBounds(0, 200, 800, 80);

      resultTextArea.setLineWrap(true); // �� �ѱ�� ��� �ѱ�
      resultTextArea.setEditable(false); // �ؽ�Ʈ���� �Ұ��� : false

      scrollPane.setBounds(10, 255, 740, 270);

      MyActionListener listener = new MyActionListener();

      backButton.addActionListener(listener);
      comboBox.addActionListener(listener);
      inquireButton.addActionListener(listener);

      // ������������
      paymentHistoryStack = new Stack<History>(); // ��ü�� ���������� ���� ����
      cafe1PaymentHistoryStack = new Stack<History>(); // �����翡 ���� ����
      cafe2PaymentHistoryStack = new Stack<History>(); // �л�ȸ���� ���� ����

   }

   // ���� Ŭ����
   private class MyActionListener implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent event) {

         // ��ȸ��ư �̺�Ʈ ó��
         if (event.getSource() == inquireButton) {

            resultTextArea.setText(""); // ���ȭ�� �ʱ�ȭ
            Stack<History> copyStack = null;
            History tempHistoryObj = null;

            // �޺��ڽ� �����ۿ� ���� �ʵ� ���� ���� ����
            if (comboBox.getSelectedIndex() == 0) { // 0 : ��ü

               totalPaymentLabel.setText((cafe1TotalPayment + cafe2TotalPayment) + "��");
               numberOfPayLabel.setText("��" + paymentHistoryStack.size() + "��");

               printHistory(copyStack, paymentHistoryStack, tempHistoryObj);

            } else if (comboBox.getSelectedIndex() == 1) { // 1 : ������

               totalPaymentLabel.setText(cafe1TotalPayment + "��");
               numberOfPayLabel.setText("��" + cafe1PaymentHistoryStack.size() + "��");

               printHistory(copyStack, cafe1PaymentHistoryStack, tempHistoryObj);

            } else if (comboBox.getSelectedIndex() == 2) { // 2 : �л�ȸ��

               totalPaymentLabel.setText(cafe2TotalPayment + "��");
               numberOfPayLabel.setText("��" + cafe2PaymentHistoryStack.size() + "��");

               printHistory(copyStack, cafe2PaymentHistoryStack, tempHistoryObj);
            }
         }
         
         // �ڷΰ��� ��ư �̺�Ʈ ó��
         if (event.getSource() == backButton) {
            resetInquiryRecord();
         }
      }
   }

   // ���ÿ� Ǫ���� , getTotalCash : �ֹ��� ���ұݾ�
   public static void HistoryStackPush(Cafeteria cafe, Date date) {

      paymentHistoryStack.push(new History(cafe.getName(), date, cafe.getTotalCash()));
      divideHistoryStack();
      updateTotalPayment();
   }

   // ��ü�������� ���� ������ �������� �и���Ų��
   public static  void divideHistoryStack() {

      Stack<History> tempCafe1Stack = new Stack<>();
      Stack<History> tempCafe2Stack = new Stack<>();

      // ��ü������ ���纻�� �����
      Stack<History> copyStack = new Stack<>();
      copyStack.addAll(paymentHistoryStack);

      while (!copyStack.empty()) {
         if (copyStack.peek().getCafeName().equals("������")) {
            tempCafe1Stack.push(copyStack.pop());
         } else {
            tempCafe2Stack.push(copyStack.pop());
         }
      }
      cafe1PaymentHistoryStack.clear();
      cafe2PaymentHistoryStack.clear();

      while (!tempCafe1Stack.empty()) {
         cafe1PaymentHistoryStack.push(tempCafe1Stack.pop());
      }

      while (!tempCafe2Stack.empty()) {
         cafe2PaymentHistoryStack.push(tempCafe2Stack.pop());
      }

   }

   // ���ϴ� �ֹ����� ã�Ƽ� �����Ѵ�
   public static void removeHistory(Date paymentDate) {

      Stack<History> tempStack = new Stack<History>(); // �� ���� ����
      Stack<History> copyStack = makeCopyStack(paymentHistoryStack); // ��ü������ ���纻 ���� ����

      // ��ü������ ���纻 ���ÿ��� ���ҽð��븦 ã�����ϴ� �ð���� ���ؼ�
      // ���ٸ� �ݺ��� �����. �ݺ������� ���ϴ� �ð��븦 ã�� ������
      // ã�����ϴ� �ð��밡 �ƴ� ���Ҵ� �����°� �ƴ϶� ���߿� ��ġ�� ���� ����ؾ���
      // ����� ���ÿ� �־� ���´�
      while (!(copyStack.peek().getPaymentDate().equals(paymentDate))) {
         tempStack.push(copyStack.pop());
      }
      
      // ã�Ҵٸ� �����Ѵ�.
      copyStack.pop();

      // ���ÿ� �־���� ������ ��ϵ��� �ٽ� ���纻���� �ִ´�
      while (!tempStack.empty()) {
         copyStack.push(tempStack.pop());
      }

      paymentHistoryStack.clear(); // ������ü������ �ʱ�ȭ�Ѵ�
      paymentHistoryStack.addAll(copyStack); // �������ÿ� ���纻 ���õ��� ��� ���ҵ��� �߰��Ѵ�
      divideHistoryStack(); // ��ü������ ���ҵ��� �� ���ÿ� �°� �и��Ѵ�
      updateTotalPayment(); // �� ���ұݾ׵��� �����Ѵ�

   }
   
   // �� �Ĵ翡���� �� ���ұݾ��� �����Ѵ�
   public static void updateTotalPayment() {
      
      //������ ���õ��� ���纻 ������ ����� 
      Stack<History> cafe1CopyStack = makeCopyStack(cafe1PaymentHistoryStack);
      Stack<History> cafe2CopyStack = makeCopyStack(cafe2PaymentHistoryStack);
      
      // �� ���ұݾ��� 0���� �ʱ�ȭ �Ѵ�
      cafe1TotalPayment = 0;
      cafe2TotalPayment = 0;
      while(!(cafe1CopyStack.empty())) {
         cafe1TotalPayment += cafe1CopyStack.pop().getPrice();
      }
      while(!(cafe2CopyStack.empty())) {
         cafe2TotalPayment += cafe2CopyStack.pop().getPrice();
      }
   }

   // ���� ���纻�� ����� �����ش�
   public static Stack<History> makeCopyStack(Stack<History> originalStack) {

      Stack<History> copyStack = new Stack<History>();
      copyStack.addAll(originalStack);
      return copyStack;
   }

   // �ؽ�Ʈ������ ���ڸ� �߰��Ѵ�
   public void textAreaAppend(String cafeName, int price, Date paymentDate) {

      resultTextArea.setFont(new Font("", Font.ITALIC, 40));
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd   HH:mm:ss"); // 2020.09.27 01:14 ��¥��������
      resultTextArea.append(cafeName + "      " + price + "��\n" + sdf.format(paymentDate) + "\n");

   }
   
   // ���������� ȭ�鿡 ����Ѵ�
   private void printHistory(Stack<History> copyStack, Stack<History> HistoryStack, History tempHistoryObj) {

      copyStack = makeCopyStack(HistoryStack); // �ش� ���纻 ������ ������ش�

      while (!copyStack.empty()) { // ������ ������� ���� ���� �ݺ�

         tempHistoryObj = copyStack.pop();
         textAreaAppend(tempHistoryObj.getCafeName(), tempHistoryObj.getPrice(), tempHistoryObj.getPaymentDate());
      }
   }
   
   // ��ȸ��ϵ��� �ʱ���·� �������´�
   private void resetInquiryRecord() {
      
      PaymentHistory.PaymentHistoryMainFrame.setVisible(false);
      comboBox.setSelectedIndex(0);
      resultTextArea.setFont(new Font("", 0, 12));
      resultTextArea.setText(" �Ĵ��� ������ �� ��ȸ�� �����ּ���.");
      totalPaymentLabel.setText("����������");
      numberOfPayLabel.setText("��  ��");
   }

}