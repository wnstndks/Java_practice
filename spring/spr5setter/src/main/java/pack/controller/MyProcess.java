package pack.controller;

import pack.model.Calcinter;
import pack.model.Gugudan;

public class MyProcess {
	private String name;
	private int su;
//	private Gugudan gugudan;
	private Calcinter calcInter;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setSu(int su) {
		this.su = su;
	}
	public void setCalcInter(Calcinter calcInter) {
		this.calcInter = calcInter;
	}

	//public String displayData() 
	@Override
	public String toString() {
		int[] results=calcInter.numberCalc(su);
		String ss="";
		
		for (int i = 0; i < results.length; i++) {
			ss +=su+"*"+(i+1)+"="+results[i]+"\n";
			
		}
		
		return "작성자:"+ name + "\n" + su+"단 결과 : \n"+ss;
	}
}
