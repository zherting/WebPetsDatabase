package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "billinfo")
public class billInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BILL_ID")
	private int billId;
	@Column(name = "BILL")
	private int bill;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "ID")
	private TableOwnerinfo id;

	public billInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public billInfo(int billId, int bill, TableOwnerinfo id) {
		super();
		this.billId = billId;
		this.bill = bill;
		this.id = id;
	}

	public billInfo(int bill, TableOwnerinfo id) {
		super();
		this.bill = bill;
		this.id = id;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getBill() {
		return bill;
	}

	public void setBill(int bill) {
		this.bill = bill;
	}

	public TableOwnerinfo getId() {
		return id;
	}

	public void setId(TableOwnerinfo id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "billInfo [billId=" + billId + ", bill=" + bill + ", id=" + id + "]";
	}

}
