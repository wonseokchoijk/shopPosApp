package service;

import common.Common;

public class Properties {

	public static String DbConnect = "";

	public static void init() {
		DbConnect = Common.getProperty("db_connect");
	}
}
