package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.JikwonDto;
import pack.model.JikwonInter;

@Service
public class BusinessImpl implements BusinessInter {

	@Autowired
	private JikwonInter jikwonInter;

	@Override
	public void dataShow() {
		ArrayList<JikwonDto> list = (ArrayList<JikwonDto>) jikwonInter.selectList();
		ArrayList<JikwonDto> list2 = (ArrayList<JikwonDto>) jikwonInter.selectList2();
		ArrayList<JikwonDto> list3 = (ArrayList<JikwonDto>) jikwonInter.selectList3();

		for (JikwonDto s : list) {

			System.out.println(
					s.getJikwon_no() + " " + s.getJikwon_name() + " " + s.getBuser_name() + " " + s.getJikwon_ibsail());
		}
		System.out.println(" ");
		
		for (JikwonDto s : list2) {

			System.out.println(
					 s.getBuser_name()+" "+ s.getCount());
		}
		System.out.println(" ");

		for (JikwonDto s : list3) {

			System.out.println(
					 s.getBuser_name() +" " + s.getJikwon_name()+" "+s.getJikwon_pay());
		}

	}

}
