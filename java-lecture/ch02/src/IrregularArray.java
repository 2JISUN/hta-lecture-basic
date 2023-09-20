public class IrregularArray {
	public static void main(String[] args) {
		int intArray[][] = new int[4][];
		intArray[0] = new int[3];
		intArray[1] = new int[2];
		intArray[2] = new int[3];
		intArray[3] = new int[2];
		intArray[0][0] = 10;
		intArray[0][1] = 20;
		intArray[0][2] = 30;
		intArray[1][0] = 21;
		intArray[1][1] = 22;
		intArray[2][0] = 31;
		intArray[2][1] = 32;
		intArray[2][2] = 33;
		intArray[3][0] = 41;
		intArray[3][1] = 42;

		for(int i= 0; i<4;i++){
			for(int j = 0; j<intArray[i].length;j++){
				System.out.println(intArray[i][j]);

			}
		}

		int intArray02[][] = {{1,2,3},{4,5},{6,7,8}};
			for(int i= 0; i<intArray02.length;i++){
			for(int j = 0; j<intArray[i].length;j++){
				System.out.println(intArray[i][j]);

			}
		}

		


	}
}
