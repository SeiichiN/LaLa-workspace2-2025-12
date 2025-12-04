package ex14_1;

public class Account {
	String accountNumber;
	int balance;
	
	public Account(String accountNumber, int balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "¥" + this.balance + 
				"（口座番号:" + this.accountNumber + "）";
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o instanceof Account t) {  // t = (Accout)o
			String a1 = this.accountNumber.trim();
			String a2 = t.accountNumber.trim();
			if (a1.equals(a2)) {
				return true;
			}
		}
		return false;
	}
}
