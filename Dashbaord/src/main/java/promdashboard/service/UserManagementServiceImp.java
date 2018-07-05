/**
 * 
 */
package promdashboard.service;

import org.springframework.stereotype.Component;

/**
 * @author Ibrahim-Abdullah
 *
 */

@Component
public class UserManagementServiceImp implements UserManagementService {

	public boolean authenticate(String userEmail, String password) {
		return (userEmail.equalsIgnoreCase("ibrahim.abdullah@ashesi.edu.gh")&&(password.equalsIgnoreCase("admin")));
	}

}
