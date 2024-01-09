package pack.model;

import java.util.Iterator;

public class Gugudan implements Calcinter{
	
	@Override
	public int[] numberCalc(int su) {
		int[] cal= new int[9];
		
		for (int i = 0; i < 9; i++) {
			cal[i]=su*(i+1);
		}
		
		
		return cal;
	}	
}
