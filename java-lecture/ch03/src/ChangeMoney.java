class MoneyConverter{
	//변수
	private static double rate; //접근불가능 > getter+setter
	public static double getRate() {
		return rate;
	}
	public static void setRate(double _rate) {
		rate = _rate;
	}


	// 메소드
	static double todollar(double won){
		return won/rate;
	}
	static double toWon(double dollar){
		return dollar * rate;
	}

}


public class ChangeMoney {
	public static void main(String[] args) {
		MoneyConverter.setRate(1380);

		double won = MoneyConverter.todollar(100000);
		System.out.printf("십만원은 달러로 환전하면 = %f%n",won);
		
		double dollar = MoneyConverter.toWon(1000);
		System.out.printf("천달러는 원으로 환전하면 = %f",dollar);
	}
}
