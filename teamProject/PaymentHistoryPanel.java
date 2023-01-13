package teamProject;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Stack;

// 결제내역을 조회하기 위한 패널
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

   private static int cafe1TotalPayment; // 명진당에서 총 지불한 금액
   private static int cafe2TotalPayment; // 학생회관에서 총 지불한 금액

   private static Stack<History> paymentHistoryStack; // 모든 식당에 대한 스택
   private static Stack<History> cafe1PaymentHistoryStack; // 명진당에 대한 스택
   private static Stack<History> cafe2PaymentHistoryStack; // 학생회관에 대한 스택

   // 패널을 만든다
   public PaymentHistoryPanel() {

      this.setSize(776, 600);

      backButton = new JButton("뒤로");
      totalPaymentLabel = new JLabel("　　　　원");
      numberOfPayLabel = new JLabel("총  건");
      divisionLabel1 = new JLabel("────────────────────────────────────────────────────────────");
      divisionLabel2 = new JLabel("────────────────────────────────────────────────────────────");

      cafeList = new String[] { "전체", "명진당", "학생회관" };
      comboBox = new JComboBox(cafeList);
      comboBox.setSelectedIndex(0);

      inquireButton = new JButton("조회");
      resultTextArea = new JTextArea(" 식당을 선택한 후 조회를 눌러주세요.");
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

      // 각 요소들 위치 배정
      // (x위치,y위치,가로크기,세로크기)
      backButton.setBounds(10, 10, 79, 39);
      backButton.setFont(new Font("굴림", Font.BOLD, 20));

      comboBox.setBounds(300, 70, 77, 40);
      inquireButton.setBounds(390, 70, 60, 40);

      totalPaymentLabel.setBounds(300, 120, 250, 70);
      totalPaymentLabel.setFont(new Font("", Font.BOLD, 40)); // 글씨체 속성 설정

      divisionLabel1.setBounds(0, 160, 800, 80);

      numberOfPayLabel.setBounds(10, 190, 100, 50);
      numberOfPayLabel.setFont(new Font("", Font.BOLD, 15));

      divisionLabel2.setBounds(0, 200, 800, 80);

      resultTextArea.setLineWrap(true); // 행 넘기기 기능 켜기
      resultTextArea.setEditable(false); // 텍스트편집 불가능 : false

      scrollPane.setBounds(10, 255, 740, 270);

      MyActionListener listener = new MyActionListener();

      backButton.addActionListener(listener);
      comboBox.addActionListener(listener);
      inquireButton.addActionListener(listener);

      // 결제내역스택
      paymentHistoryStack = new Stack<History>(); // 전체에 결제내역에 대한 스택
      cafe1PaymentHistoryStack = new Stack<History>(); // 명진당에 대한 스택
      cafe2PaymentHistoryStack = new Stack<History>(); // 학생회관에 대한 스택

   }

   // 내부 클래스
   private class MyActionListener implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent event) {

         // 조회버튼 이벤트 처리
         if (event.getSource() == inquireButton) {

            resultTextArea.setText(""); // 결과화면 초기화
            Stack<History> copyStack = null;
            History tempHistoryObj = null;

            // 콤보박스 아이템에 따른 필드 값들 변수 갱신
            if (comboBox.getSelectedIndex() == 0) { // 0 : 전체

               totalPaymentLabel.setText((cafe1TotalPayment + cafe2TotalPayment) + "원");
               numberOfPayLabel.setText("총" + paymentHistoryStack.size() + "건");

               printHistory(copyStack, paymentHistoryStack, tempHistoryObj);

            } else if (comboBox.getSelectedIndex() == 1) { // 1 : 명진당

               totalPaymentLabel.setText(cafe1TotalPayment + "원");
               numberOfPayLabel.setText("총" + cafe1PaymentHistoryStack.size() + "건");

               printHistory(copyStack, cafe1PaymentHistoryStack, tempHistoryObj);

            } else if (comboBox.getSelectedIndex() == 2) { // 2 : 학생회관

               totalPaymentLabel.setText(cafe2TotalPayment + "원");
               numberOfPayLabel.setText("총" + cafe2PaymentHistoryStack.size() + "건");

               printHistory(copyStack, cafe2PaymentHistoryStack, tempHistoryObj);
            }
         }
         
         // 뒤로가기 버튼 이벤트 처리
         if (event.getSource() == backButton) {
            resetInquiryRecord();
         }
      }
   }

   // 스택에 푸시함 , getTotalCash : 주문당 지불금액
   public static void HistoryStackPush(Cafeteria cafe, Date date) {

      paymentHistoryStack.push(new History(cafe.getName(), date, cafe.getTotalCash()));
      divideHistoryStack();
      updateTotalPayment();
   }

   // 전체스택으로 부터 각각의 스택으로 분리시킨다
   public static  void divideHistoryStack() {

      Stack<History> tempCafe1Stack = new Stack<>();
      Stack<History> tempCafe2Stack = new Stack<>();

      // 전체스택의 복사본을 만든다
      Stack<History> copyStack = new Stack<>();
      copyStack.addAll(paymentHistoryStack);

      while (!copyStack.empty()) {
         if (copyStack.peek().getCafeName().equals("명진당")) {
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

   // 원하는 주문건을 찾아서 삭제한다
   public static void removeHistory(Date paymentDate) {

      Stack<History> tempStack = new Stack<History>(); // 빈 스택 생성
      Stack<History> copyStack = makeCopyStack(paymentHistoryStack); // 전체스택의 복사본 스택 생성

      // 전체스택의 복사본 스택에서 지불시간대를 찾고자하는 시간대와 비교해서
      // 같다면 반복은 멈춘다. 반복내용은 원하는 시간대를 찾는 과정임
      // 찾고자하는 시간대가 아닌 원소는 날리는게 아니라 나중에 합치기 위해 백업해야함
      // 백업은 빈스택에 넣어 놓는다
      while (!(copyStack.peek().getPaymentDate().equals(paymentDate))) {
         tempStack.push(copyStack.pop());
      }
      
      // 찾았다면 삭제한다.
      copyStack.pop();

      // 빈스택에 넣어놨던 이전의 기록들을 다시 복사본으로 넣는다
      while (!tempStack.empty()) {
         copyStack.push(tempStack.pop());
      }

      paymentHistoryStack.clear(); // 원본전체스택을 초기화한다
      paymentHistoryStack.addAll(copyStack); // 원본스택에 복사본 스택들의 모든 원소들을 추가한다
      divideHistoryStack(); // 전체스택의 원소들을 각 스택에 맞게 분리한다
      updateTotalPayment(); // 총 지불금액들을 갱신한다

   }
   
   // 각 식당에서의 총 지불금액을 갱신한다
   public static void updateTotalPayment() {
      
      //각각의 스택들의 복사본 스택을 만든다 
      Stack<History> cafe1CopyStack = makeCopyStack(cafe1PaymentHistoryStack);
      Stack<History> cafe2CopyStack = makeCopyStack(cafe2PaymentHistoryStack);
      
      // 총 지불금액을 0으로 초기화 한다
      cafe1TotalPayment = 0;
      cafe2TotalPayment = 0;
      while(!(cafe1CopyStack.empty())) {
         cafe1TotalPayment += cafe1CopyStack.pop().getPrice();
      }
      while(!(cafe2CopyStack.empty())) {
         cafe2TotalPayment += cafe2CopyStack.pop().getPrice();
      }
   }

   // 스택 복사본을 만들어 돌려준다
   public static Stack<History> makeCopyStack(Stack<History> originalStack) {

      Stack<History> copyStack = new Stack<History>();
      copyStack.addAll(originalStack);
      return copyStack;
   }

   // 텍스트구역에 글자를 추가한다
   public void textAreaAppend(String cafeName, int price, Date paymentDate) {

      resultTextArea.setFont(new Font("", Font.ITALIC, 40));
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd   HH:mm:ss"); // 2020.09.27 01:14 날짜포멧형식
      resultTextArea.append(cafeName + "      " + price + "원\n" + sdf.format(paymentDate) + "\n");

   }
   
   // 결제내역을 화면에 출력한다
   private void printHistory(Stack<History> copyStack, Stack<History> HistoryStack, History tempHistoryObj) {

      copyStack = makeCopyStack(HistoryStack); // 해당 복사본 스택을 만들어준다

      while (!copyStack.empty()) { // 스택이 비어있지 않을 동안 반복

         tempHistoryObj = copyStack.pop();
         textAreaAppend(tempHistoryObj.getCafeName(), tempHistoryObj.getPrice(), tempHistoryObj.getPaymentDate());
      }
   }
   
   // 조회기록들을 초기상태로 돌려놓는다
   private void resetInquiryRecord() {
      
      PaymentHistory.PaymentHistoryMainFrame.setVisible(false);
      comboBox.setSelectedIndex(0);
      resultTextArea.setFont(new Font("", 0, 12));
      resultTextArea.setText(" 식당을 선택한 후 조회를 눌러주세요.");
      totalPaymentLabel.setText("　　　　원");
      numberOfPayLabel.setText("총  건");
   }

}