package teamProject;


public class Cafeteria {

   int menu1remains, menu2remains, menu3remains; // 메뉴1,2,3 의 재고량
   int menu1orders, menu2orders, menu3orders; // 메뉴1,2,3의 주문 수량
   int menu1price, menu2price, menu3price; // 메뉴 1,2,3의 가격
   int totalCash;   // 식당의 수익?
   
   int totalPayment; // 식당 당 총 수익
   String cafeteriaName;
   String m1_1, m1_2, m1_3, m1_4, m2_1, m2_2, m2_3, m2_4, m3_1, m3_2, m3_3, m3_4;
    
   public void setMenuName1(String m1_1, String m1_2, String m1_3, String m1_4,
         String m2_1, String m2_2, String m2_3, String m2_4,
         String m3_1, String m3_2, String m3_3, String m3_4) {   //식당 1 메뉴 이름 기입
      this.m1_1 = m1_1;
      this.m1_2 = m1_2;
      this.m1_3 = m1_3;
      this.m1_4 = m1_4;
      this.m2_1 = m2_1;
      this.m2_2 = m2_2;
      this.m2_3 = m2_3;
      this.m2_4 = m2_4;
      this.m3_1 = m3_1;
      this.m3_2 = m3_2;
      this.m3_3 = m3_3;
      this.m3_4 = m3_4;
   }
   
   public void setMenuName2(String m1_1, String m2_1, String m3_1) {   //식당 2 메뉴 이름 기입
      this.m1_1 = m1_1;
      this.m2_1 = m2_1;
      this.m3_1 = m3_1;
   }
   
   public void setCafeteria(int m1r, int m2r, int m3r, int m1o, int m2o, int m3o,
         int price1, int price2, int price3, String name) {   //식당 재고량, 주문량, 가격 기입
      this.menu1remains = m1r;
      this.menu2remains = m2r;
      this.menu3remains = m3r;
      this.menu1orders = m1o;
      this.menu2orders = m2o;
      this.menu3orders = m3o;
      this.cafeteriaName = name;
      this.menu1price = price1;
      this.menu2price = price2;
      this.menu3price = price3;
      this.totalCash = 0;
   }
   
   public int clickPlusRemains(int orders, int menuNum) {   //plus 시 재고량 감소
      int result = 0;
      
      if (menuNum == 1) {
         this.menu1remains -= orders;
         result = this.menu1remains;
      }
      if(menuNum == 2) {
         this.menu2remains -= orders;
         result = this.menu2remains;
      }
      if(menuNum == 3) {
         this.menu3remains -= orders;
         result = this.menu3remains;
      }
      return result;
   }
   
   public int clickMinusRemains(int orders, int menuNum) {   //minus 시 재고량 증가
      int result = 0;
      
      if (menuNum == 1) {
         this.menu1remains += orders;
         result = this.menu1remains;
      }
      if(menuNum == 2) {
         this.menu2remains += orders;
         result = this.menu2remains;
      }
      if(menuNum == 3) {
         this.menu3remains += orders;
         result = this.menu3remains;
      }
      return result;
   }
   
   public int clickPlusOrders(int orders, int menuNum) {   //plus 시 주문량 증가
      int result = 0;
      
      if (menuNum == 1) {
         this.menu1orders += orders;
         result = this.menu1orders;
      }
      if(menuNum == 2) {
         this.menu2orders += orders;
         result = this.menu2orders;
      }
      if(menuNum == 3) {
         this.menu3orders += orders;
         result = this.menu3orders;
      }
      return result;
   }
   
   public int clickMinusOrders(int orders, int menuNum) {   //minus 시 주문량 감소
      int result = 0;
      
      if (menuNum == 1) {
         this.menu1orders -= orders;
         result = this.menu1orders;
      }
      if(menuNum == 2) {
         this.menu2orders -= orders;
         result = this.menu2orders;
      }
      if(menuNum == 3) {
         this.menu3orders -= orders;
         result = this.menu3orders;
      }
      return result;
   }
   
   public String getName() {   //식당 이름 호출
      return this.cafeteriaName;
   }
   
   public void totalZero() {   //총 금액 초기화
      this.totalCash = 0;
   }
   
   public void countTotalCash(int cash) {   
      this.totalCash += cash;
   }
   
   public void countTotalPayment(int cash) {   //총 수익 계산
      this.totalPayment+= cash;
   }
   
   public int getTotalCash() {      // 총 금액 호출
      return this.totalCash;
   }

   
   public int getMenuPrice(int menuNum) {   //메뉴별 가격 호출
      int result = 0;
      
      if(menuNum == 1) {
         result = this.menu1price;
      }
      if(menuNum == 2) {
         result = this.menu2price;
      }
      if(menuNum == 3) {
         result = this.menu3price;
      }
      return result;
   }
   
   public int getTotalPayment() {
      return this.totalPayment;
   }
}