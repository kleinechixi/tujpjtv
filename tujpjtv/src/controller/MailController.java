package controller;

import model.UserModel;

public class MailController  {

	public MailController doSend(String email) {
		String mail_subject = "Welcome,";
		String mail_body = "Your signup is successful. URL is http://127.0.0.1:8082/tujpjtv/ for your service. Thanks.";
		System.out.println("Mailto:" + email);
		System.out.println("Subject:" + mail_subject);
		System.out.println("Message:" + mail_body);		
		//I wanna mail.
		return null;
		
	}

}
