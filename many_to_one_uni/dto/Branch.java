package many_to_one_uni.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Branch {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int bId;
private String bname;
private String ifsc;
private String address;
private String manager;
private long phone;
@ManyToOne
private Bank bank;
public int getbId() {
	return bId;
}
public void setbId(int bId) {
	this.bId = bId;
}
public String getBname() {
	return bname;
}
public void setBname(String bname) {
	this.bname = bname;
}
public String getIfsc() {
	return ifsc;
}
public void setIfsc(String ifsc) {
	this.ifsc = ifsc;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getManager() {
	return manager;
}
public void setManager(String manager) {
	this.manager = manager;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public Bank getBank() {
	return bank;
}
public void setBank(Bank bank) {
	this.bank = bank;
}
@Override
public String toString() {
	return "Branch [bId=" + bId + ", bname=" + bname + ", ifsc=" + ifsc + ", address=" + address + ", manager="
			+ manager + ", phone=" + phone + ", bank=" + bank + "]";
}

}
