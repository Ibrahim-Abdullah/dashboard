/**
 * 
 */
package promdashboard.service;

/**
 * @author Ibrahim-Abdullah
 *
 */
public interface UserManagementService {
	
	boolean authenticate(String userEmail,String password);
}
