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
			System.out.printf(" 설치장소명: %s\n",target.getInstallationLocationName());
			System.out.printf("**[%d번째 항목]***********\n", k31_LineCnt);// 출력하기
			
			if (target.getRoadNameAddress() != null) {
				System.out.printf(" 소재지지번주소 : %s\n", target.getLotNumberAddress());
			} else if (target.getLotNumberAddress() != null) {
				System.out.printf(" 소재지도로명주소 : %s\n", target.getRoadNameAddress());
			}
			System.out.printf(" 위도 : %s\n",target.getLatitude());
			System.out.printf(" 경도 : %s\n",target.getLongitude());
			double dist = wifiitemservice.getdistance(me, target);
			System.out.printf(" 현재지점과 거리 : %f\n", dist);
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
			System.out.printf("\n**[최단 거리]***************\n");
			System.out.printf(" 설치장소명  : %s\n", minDist.getInstallationLocationName());
			System.out.printf(" 소재지도로명주소 : %s\n" ,minDist.getRoadNameAddress());
			System.out.printf(" 위도 : %s\n",  minDist.getLatitude());
			System.out.printf(" 경도 : %s\n", minDist.getLongitude());
			System.out.printf(" 현재지점과 거리 : %f\n", mindist);
		} else {
			System.out.printf("\n장소 정보가 없습니다.\n");
		}

		// 가장 먼 장소 정보 출력
		if (maxDist != null) {
			System.out.printf("\n**[최대 거리]***************\n");
			System.out.printf(" 설치장소명 : %s\n", maxDist.getInstallationLocationName());
			System.out.printf(" 소재지도로명주소 : %s\n", maxDist.getRoadNameAddress());
			System.out.printf(" 위도 : %s\n", maxDist.getLatitude());
			System.out.printf(" 경도 : %s\n", maxDist.getLongitude());
			System.out.printf(" 현재지점과 거리 : %f\n", maxdist);
		} else {
			System.out.printf("\n장소 정보가 없습니다.\n");
		}

		
		
		

	}

}
