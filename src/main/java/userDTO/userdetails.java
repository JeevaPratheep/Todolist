package userDTO;

public class userdetails {
	private int UserID;
	private String UserName;
	private String UserEmail;
	private long UserContact;
	private byte[] UserImage;
	private String UserPassword;
	
	
	public userdetails(int userID, String userName, String userEmail, long userContact, byte[] userImage,
			String userPassword) {
		UserID = userID;
		UserName = userName;
		UserEmail = userEmail;
		UserContact = userContact;
		UserImage = userImage;
		UserPassword = userPassword;
	}
	public userdetails() {
		
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public long getUserContact() {
		return UserContact;
	}
	public void setUserContact(long userContact) {
		UserContact = userContact;
	}
	public byte[] getUserImage() {
		return UserImage;
	}
	public void setUserImage(byte[] userImage) {
		UserImage = userImage;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	

}
