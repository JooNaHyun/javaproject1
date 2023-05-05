package service;




import domain.WifiItem;

public class WifiItemService {
	public double getdistance(WifiItem wifiitem1, WifiItem wifiitem2) { //me= wifiitem1, target = 
		
		
		
		double dist = Math.sqrt(Math.pow(wifiitem1.getLatitude() - wifiitem2.getLatitude(), 2)
				+ Math.pow(wifiitem1.getLongitude() - wifiitem2.getLongitude(), 2));
		return dist;
	}

}
