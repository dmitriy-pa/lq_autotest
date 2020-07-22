package lq_autotest.common;

public enum User {

	TestUser("tteesstt1122", "@mail.ru", "ABCQWE765");
	
	public final String name;
	public final String domain;
	public final String password;
	private User(String name, String domain, String password) {
		this.name = name;
		this.password = password;
		this.domain = domain;
	}
}
