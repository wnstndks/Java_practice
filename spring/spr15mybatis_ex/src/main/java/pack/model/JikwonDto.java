package pack.model;

import org.springframework.stereotype.Component;

@Component
public class JikwonDto {
	private String jikwon_no,jikwon_name,buser_num,jikwon_ibsail,jikwon_pay,buser_name,count;

	public String getJikwon_no() {
		return jikwon_no;
	}

	public void setJikwon_no(String jikwon_no) {
		this.jikwon_no = jikwon_no;
	}

	public String getJikwon_name() {
		return jikwon_name;
	}

	public void setJikwon_name(String jikwon_name) {
		this.jikwon_name = jikwon_name;
	}

	public String getBuser_num() {
		return buser_num;
	}

	public void setBuser_num(String buser_num) {
		this.buser_num = buser_num;
	}

	public String getJikwon_ibsail() {
		return jikwon_ibsail;
	}

	public void setJikwon_ibsail(String jikwon_ibsail) {
		this.jikwon_ibsail = jikwon_ibsail;
	}

	public String getJikwon_pay() {
		return jikwon_pay;
	}

	public void setJikwon_pay(String jikwon_pay) {
		this.jikwon_pay = jikwon_pay;
	}

	public String getBuser_name() {
		return buser_name;
	}

	public void setBuser_name(String buser_name) {
		this.buser_name = buser_name;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	
	
}
