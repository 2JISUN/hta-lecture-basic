public class MultiArray {
	public static void main(String[] args) {

		double score[][]={{2.555,3.163},{3.5,3.7},{3.5,4.1},{4.25,4.1}};

		for (int i=0;i<4;i++){
			for(int j=0;j<2;j++){
				System.out.printf("score[%d][%d] : [%.2f][%.2f] %n", i,j,score[i][j],score[i][j]);
			}
		}


		
	}
}
