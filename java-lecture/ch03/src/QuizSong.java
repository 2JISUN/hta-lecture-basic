public class QuizSong {
	// 필드생성
	private String title ;
	private String artist ;
	private String contury ;
	private int year;

	// 생성자(메인>생략가능)
	public QuizSong(){
	}

	// 생성자02(생성자 메인 생략 불가능)
	public QuizSong(String title, String artist, int year, String contury){
		this.title = title;
		this.artist =artist;
		this.year = year;
		this.contury = contury;
	}


	// 메서드(일반, 리턴타입 없음)
	public void show(){
		System.out.printf("%d년도에 출시된 %s 국적의 %s이 부른 %s",this.year,this.contury,this.artist,this.title);
	}


	// 메서드(메인)
	public static void main(String[] args) {
	QuizSong song = new QuizSong("ISTJ", "NCT DREAM", 2023, "한국");
	song.show();
	}




}
