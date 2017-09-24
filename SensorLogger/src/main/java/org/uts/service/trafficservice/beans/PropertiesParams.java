package org.uts.service.trafficservice.beans;

public class PropertiesParams {

	private String dbPath;
	private String userName;
	private String password;
	
	public String getdbPath() {
        return dbPath;
    }

    public void setdbPath(String dbPath) {
        this.dbPath = dbPath;
    }
    
    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }
    
    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }
}
