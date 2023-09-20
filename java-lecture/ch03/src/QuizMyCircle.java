public class QuizMyCircle {
	// 필드
	private double x;
	private double y;
	private int radius;


	// 생성자
	public QuizMyCircle(double x, double y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	// 메서드 : 면적공식(일반, 리턴타입O)
	public double getArea() {
		return radius*radius*Math.PI;
	}
	

	// 메서드 : print (일반, 리턴타입X)
	public void show(){
		System.out.printf("x좌표 : %f, y좌표 : %f, 반지름r : %d, 면적 : %f",this.x,this.y,this.radius,this.getArea());
	}


	// 메서드 : 메모리에 올리기 (메인)
	public static void main(String[] args) {
		QuizMyCircle myCircles[] = new QuizMyCircle[3];
		for (int i = 0; i<3;i++)
			double x = Math.random() * (300-100+1) + 100;		
			double y = Math.random() * (300-100+1) + 100;		
			int radius =  (int) (Math.random()*(50-10+1))+10;
		}
		int big = 0;

		for (int i =1; i<myCircles.length; i++){
			if(myCircles[i].getArea() > myCircles[big].getArea()) {
				big = i;
			}
		}
		myCircles[0].show();
		myCircles[1].show();
		myCircles[2].show();
		myCircles[big].show();





	}






	


	








}
