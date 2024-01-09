package pack.guest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import pack.bank.HanaBank;
import pack.bank.SinhanBank;
import pack.bank.Bank;

@Service
@Scope("prototype")
@ComponentScan("pack.bank")
public class Gogek {
	private Bank bank;
	
	@Autowired
	private SinhanBank sinhanBank;
	
	@Resource(name="hana")
	private HanaBank hanaBank;
	
	public void selectBank(String sel) {
		if(sel.equals("sinhan")) {
			bank=sinhanBank;
		}else if(sel.equals("hana")) {
			bank=hanaBank;
		}
	}
	public void playInputMoney(int money) {
		bank.inputMoney(money);
	}
	public void playOutputMoney(int money) {
		bank.outputMoney(money);
	}
	
	private String msg;
	
	@PostConstruct //생성자 이후 자동발생
	public void init() {
		msg="계좌 잔고 : ";
	}
	
	@PreDestroy
	public void end() {
		if(sinhanBank!=null)sinhanBank=null;
		if(hanaBank!=null)hanaBank=null;
	}
	
	public void showMoney() {
		//System.out.println("고객님의 계좌 잔고는 "+bank.getMoney());
		System.out.println(msg+bank.getMoney());
	}
}













