package teamProject;

import java.util.Date;

//���� ���� ��ü
public class History {

	private String cafeName; // �Ĵ��̸�
	private Date paymentDate; // ������¥
	private int price; // �޴�����

	public History(String cafeName, Date paymentDate, int price) {

		this.cafeName = cafeName;
		this.paymentDate = paymentDate;
		this.price = price;
		
		/*
		if (this.cafeName.equals("������")) {
			this.price = 4500;
		} else if (this.cafeName.equals("�л�ȸ��") && price == 3000) {
			this.price = 3000;
		} else if (this.cafeName.equals("�л�ȸ��") && price == 3500) {
			this.price = 3500;
		} else if (this.cafeName.equals("�л�ȸ��") && price == 4000) {
			this.price = 4000;
		}
		*/
	}

	// ������ �޼ҵ�
	public String getCafeName() {
		return cafeName;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public int getPrice() {
		return price;
	}
	
	// ������ �޼ҵ�
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