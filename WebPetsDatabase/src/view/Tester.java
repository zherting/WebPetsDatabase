package view;

import java.util.List;

import controller.BillinfoHelper;
import controller.OwnerinfoHelper;
import model.TableOwnerinfo;
import model.billInfo;

public class Tester {
	public static void main(String[] args) {
		TableOwnerinfo taylor = new TableOwnerinfo("Bird", "Taylor", "Cameron");
		OwnerinfoHelper oih = new OwnerinfoHelper();

		oih.insertItem(taylor);

		BillinfoHelper bih = new BillinfoHelper();
		billInfo taylorBill = new billInfo(154, taylor);
		bih.insertBill(taylorBill);

		List<billInfo> allBills = bih.getBills();
		for (billInfo a : allBills) {
			System.out.println(a.toString());
		}
	}
}
