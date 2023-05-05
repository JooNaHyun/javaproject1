package kr.ac.kopo.ctc.kopo31;

import java.io.IOException;
import java.util.List;

import dao.WifiItemDao;
import domain.WifiItem;
import service.WifiItemService;

public class WifiMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("wifi project");

		WifiItemService wifiitemservice = new WifiItemService();
		WifiItemDao wifiitemdao = new WifiItemDao();
		List<WifiItem> wifiitems = wifiitemdao.selectAll();
		WifiItem me = new WifiItem();
		double k31_lat = 37.3860521;
		double k31_lng = 127.1214038;
		me.setLatitude(k31_lat);
		me.setLongitude(k31_lng);
		 
		
		int k31_LineCnt = 0;
		double maxdist = 0;
		double mindist = 0;
		WifiItem maxDist = null;
		WifiItem minDist = null;
		
		
			
		
		
		for (WifiItem target : wifiitems) {
			double d = wifiitemservice.getdistance(me, target);
			System.out.printf(" ��ġ��Ҹ�: %s\n",target.getInstallationLocationName());
			System.out.printf("**[%d��° �׸�]***********\n", k31_LineCnt);// ����ϱ�
			
			if (target.getRoadNameAddress() != null) {
				System.out.printf(" �����������ּ� : %s\n", target.getLotNumberAddress());
			} else if (target.getLotNumberAddress() != null) {
				System.out.printf(" ���������θ��ּ� : %s\n", target.getRoadNameAddress());
			}
			System.out.printf(" ���� : %s\n",target.getLatitude());
			System.out.printf(" �浵 : %s\n",target.getLongitude());
			double dist = wifiitemservice.getdistance(me, target);
			System.out.printf(" ���������� �Ÿ� : %f\n", dist);
			System.out.println("*************************");
			
			if (k31_LineCnt == 0) {
				maxdist = dist;
				mindist = dist;
			} else {
				if (maxdist < dist) {
					maxdist = dist;
					maxDist = target;
				}
				if (mindist > dist) {
					mindist = dist;
					minDist = target;
				}
			}
			k31_LineCnt++;
			
			
		}
		if (minDist != null) {
			System.out.printf("\n**[�ִ� �Ÿ�]***************\n");
			System.out.printf(" ��ġ��Ҹ�  : %s\n", minDist.getInstallationLocationName());
			System.out.printf(" ���������θ��ּ� : %s\n" ,minDist.getRoadNameAddress());
			System.out.printf(" ���� : %s\n",  minDist.getLatitude());
			System.out.printf(" �浵 : %s\n", minDist.getLongitude());
			System.out.printf(" ���������� �Ÿ� : %f\n", mindist);
		} else {
			System.out.printf("\n��� ������ �����ϴ�.\n");
		}

		// ���� �� ��� ���� ���
		if (maxDist != null) {
			System.out.printf("\n**[�ִ� �Ÿ�]***************\n");
			System.out.printf(" ��ġ��Ҹ� : %s\n", maxDist.getInstallationLocationName());
			System.out.printf(" ���������θ��ּ� : %s\n", maxDist.getRoadNameAddress());
			System.out.printf(" ���� : %s\n", maxDist.getLatitude());
			System.out.printf(" �浵 : %s\n", maxDist.getLongitude());
			System.out.printf(" ���������� �Ÿ� : %f\n", maxdist);
		} else {
			System.out.printf("\n��� ������ �����ϴ�.\n");
		}

		
		
		

	}

}
