package model;

public class ServiceProvider {
	private static SysteemService systeemService = new SysteemService();

	public static SysteemService getService() {
		return systeemService;
	}
}
