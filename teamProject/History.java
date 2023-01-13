package teamProject;

import java.util.Date;

//결제 내역 객체
public class History {

	private String cafeName; // 식당이름
	private Date paymentDate; // 결제날짜
	private int price; // 메뉴가격

	public History(String cafeName, Date paymentDate, int price) {

		this.cafeName = cafeName;
		this.paymentDate = paymentDate;
		this.price = price;
		
		/*
		if (this.cafeName.equals("명진당")) {
			this.price = 4500;
		} else if (this.cafeName.equals("학생회관") && price == 3000) {
			this.price = 3000;
		} else if (this.cafeName.equals("학생회관") && price == 3500) {
			this.price = 3500;
		} else if (this.cafeName.equals("학생회관") && price == 4000) {
			this.price = 4000;
		}
		*/
	}

	// 접근자 메소드
	public String getCafeName() {
		return cafeName;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public int getPrice() {
		return price;
	}
	
	// 수정자 메소드
	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}