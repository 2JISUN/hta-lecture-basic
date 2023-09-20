import java.io.File;

public class FileDirExist {
	
	 public static void main(String[] args) {
        String dirPath = "C:\\temp\\"; 
        File dir = new File(dirPath); 
		
		// 파일이나 폴더가 존재한다면
        if (dir.exists() && dir.isDirectory()) {
			System.out.println(dirPath + " 에 존재하는 파일과 폴더 목록은 아래와 같습니다.");
            File[] filesAndDirectories = dir.listFiles();
			// 파일이나 폴더가 존재한다면 > 반복한다
			for (File fileOrDir : filesAndDirectories) {
				if (fileOrDir.isFile()) {
                	System.out.println("File: " + fileOrDir.getName());
                } else if (fileOrDir.isDirectory()) {
                    System.out.println("Dir: " + fileOrDir.getName());
                }
			} 
			// 파일이나 폴더가 존재하지 않는다면
        } else {
            System.out.println(dirPath + " 에서 파일과 폴더는 존재하지 않습니다.");
        }
    }
}
