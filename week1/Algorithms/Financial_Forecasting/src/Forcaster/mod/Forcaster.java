package Forcaster.mod;
import java.util.Scanner;
public class Forcaster {
	
	// recursively finds predicted amount
	public static double predictor(int i , int growth_rates[] , int initial) {
		if( i == -1) {
			return initial;
		}
		double amt = predictor(i-1 , growth_rates , initial )*(1+(growth_rates[i]*0.01));
		return amt;
	}
	
	public static void main(String args[]) {
		int initial_value = 100;
		int[] growth_rates = new int[] {7, 6, 4, 7, 8, 6, 10, 12, 13};
		Scanner sc = new Scanner(System.in);
		System.out.println("enter year number");
		int yearno = sc.nextInt();
		
		
		if( yearno <0 || yearno >= growth_rates.length) {
			System.out.println("Cannot predict.");
			sc.close();
			System.exit(1);
		}
		
		sc.close();
		double val = predictor(yearno , growth_rates , initial_value);
		System.out.println("Amount at the end of "+yearno+"th year: "+val);
	}
}
