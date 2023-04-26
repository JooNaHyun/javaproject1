package dailyjava01;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class daily01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {//예외가 발생하지 않았을 때   
			
			File k31_f = new File("c:\\Users\\nahyun\\test.txt");//test.txt라는 파일을 c:\\Users\\nahyun 경로에 만든다.
			FileWriter k31_fw = new FileWriter(k31_f);//FileWriter를 사용하여 파일을 생성하고 쓰기 작업을 수행
			
			k31_fw.write("안녕 파일\n");//쓰기 작업으로 "안녕 파일"과 
			k31_fw.write("hello 헬로\n");//"hello 헬로" 문자열을 파일에 쓴다.
			
			k31_fw.close();//FileWriter 객체를 close() 메소드를 사용하여 닫는다.
			
			FileReader k31_fr = new FileReader(k31_f);
			//FileReader 객체를 생성하고 파일 객체를 전달하여 파일을 읽기(read) 모드로 연다.
			
			int k31_n =-1;//변수 선언
			char [] k31_ch;//배열 선언
			while(true) {
				k31_ch = new char[100];//배열 크기 100으로 선언
				k31_n = k31_fr.read(k31_ch);// n에 read() 메소드를 호출하여 반환값을 저장
				
				if(k31_n == -1)break;//n이 -1이면 break문을 실행하여 while문을 탈출한다.
				
				for(int i = 0; i < k31_n; i++) {
					System.out.printf("%c",k31_ch[i]);//n이 -1이 아니면 for문을 실행하여 ch 배열에 저장된 문자열을 출력
				}
			}
			k31_fr.close();//FileReader 객체를 close() 메소드로 닫는다.
			
			System.out.printf("\n FILE READ END");// 한 줄 띄고 한 칸 뛴 다음 "FILE READ END"를 출력
		}catch(Exception e) {
			System.out.printf("나 에러[%s]\n",e);//예외가 발생하면 "나 에러"를 출력
		}
	}

}
