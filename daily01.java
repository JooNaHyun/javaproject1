package dailyjava01;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class daily01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {//���ܰ� �߻����� �ʾ��� ��   
			
			File k31_f = new File("c:\\Users\\nahyun\\test.txt");//test.txt��� ������ c:\\Users\\nahyun ��ο� �����.
			FileWriter k31_fw = new FileWriter(k31_f);//FileWriter�� ����Ͽ� ������ �����ϰ� ���� �۾��� ����
			
			k31_fw.write("�ȳ� ����\n");//���� �۾����� "�ȳ� ����"�� 
			k31_fw.write("hello ���\n");//"hello ���" ���ڿ��� ���Ͽ� ����.
			
			k31_fw.close();//FileWriter ��ü�� close() �޼ҵ带 ����Ͽ� �ݴ´�.
			
			FileReader k31_fr = new FileReader(k31_f);
			//FileReader ��ü�� �����ϰ� ���� ��ü�� �����Ͽ� ������ �б�(read) ���� ����.
			
			int k31_n =-1;//���� ����
			char [] k31_ch;//�迭 ����
			while(true) {
				k31_ch = new char[100];//�迭 ũ�� 100���� ����
				k31_n = k31_fr.read(k31_ch);// n�� read() �޼ҵ带 ȣ���Ͽ� ��ȯ���� ����
				
				if(k31_n == -1)break;//n�� -1�̸� break���� �����Ͽ� while���� Ż���Ѵ�.
				
				for(int i = 0; i < k31_n; i++) {
					System.out.printf("%c",k31_ch[i]);//n�� -1�� �ƴϸ� for���� �����Ͽ� ch �迭�� ����� ���ڿ��� ���
				}
			}
			k31_fr.close();//FileReader ��ü�� close() �޼ҵ�� �ݴ´�.
			
			System.out.printf("\n FILE READ END");// �� �� ��� �� ĭ �� ���� "FILE READ END"�� ���
		}catch(Exception e) {
			System.out.printf("�� ����[%s]\n",e);//���ܰ� �߻��ϸ� "�� ����"�� ���
		}
	}

}
