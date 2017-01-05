import java.io.*;

public class Math {
	public double weeklyIncome(double hourly) {
		return hourly * 40;
	}
	
	public double monthlyIncome(double hourly) {
		double yearly = hourly * 40 * 52;
		return yearly / 12;
	}
	
	public double yearlyTaxedIncome(double hourly) {
		return hourly * 40 *52;
	}
	
	
}
