package sri.sai.bhavani.printers.website.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

	public boolean isValidUser(String userid, String password) {
		return userid.equalsIgnoreCase("bhavani") && password.equalsIgnoreCase("pooja");
		
	}
}
