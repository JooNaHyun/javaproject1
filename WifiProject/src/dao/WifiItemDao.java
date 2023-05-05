package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import domain.WifiItem;

public class WifiItemDao {
	public WifiItem create(WifiItem wifiItem) {

		return null;
	}

	public WifiItem selectone(int id) {

		return null;
	}

	public static List<WifiItem> selectAll() {
		List<WifiItem> wifiItems = new ArrayList<>();

		File k31_f = new File("C:\\Users\\nahyun\\���������������.txt");// �ش� ��ο� ���ο� ���� �����
		BufferedReader k31_br = null;
		try {
			k31_br = new BufferedReader(new FileReader(k31_f));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// BufferedReader�� FileReader�� ���� ���� ��ü ����

		String k31_readtxt;// ����� ���ڿ��� ���� ���� ����

		try {
			if ((k31_readtxt = k31_br.readLine()) == null) {// �о�� ������ ������ ���� ������
				System.out.printf("�� ���� �Դϴ�\n");// ����ϱ�
				return wifiItems;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while ((k31_readtxt = k31_br.readLine()) != null) {// �о�� ������ ������ ���� ������
				String[] k31_field = k31_readtxt.split("\t");
			
				WifiItem wifiItem = new WifiItem();
				wifiItem.setId(Integer.parseInt(k31_field[0]));
				wifiItem.setInstallationLocationName(k31_field[1]);
				wifiItem.setInstallationLocationDetails(k31_field[2]);
				wifiItem.setInstallationCityName(k31_field[3]);
				wifiItem.setInstallationDistrictName(k31_field[4]);
				wifiItem.setInstallationFaciliyType(k31_field[5]);
				wifiItem.setServiceProviderName(k31_field[6]);
				wifiItem.setWifiSsid(k31_field[7]);
				wifiItem.setDateOfInstallation(k31_field[8]);
				wifiItem.setRoadNameAddress(k31_field[9]);
				wifiItem.setLotNumberAddress(k31_field[10]);
				wifiItem.setManagementAgencyName(k31_field[11]);
				wifiItem.setManagementAgencyPhoneNumber(k31_field[12]);
				wifiItem.setLatitude(Double.parseDouble(k31_field[13]));
				wifiItem.setLongitude(Double.parseDouble(k31_field[14]));
				wifiItem.setCreated(k31_field[15]);
				
				wifiItems.add(wifiItem);
				
//			k31_LineCnt++;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return wifiItems;
	}

	public WifiItem update(WifiItem wifiitem) {

		return null;
	}

	public WifiItem delete(int id) {

		return null;
	}
}
