/**
 * 
 */
package promdashboard.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import promdashboard.forms.LoginForm;

/**
 * @author Ibrahim-Abdullah
 *
 */

@Controller
public class LoginController {
	
	
//	@RequestMapping(value={"/","/login"}, method=RequestMethod.GET)
//	public String showLoginPage(Model model){
//		//model.addAttribute("loginForm", new LoginForm());
//		return "login";
//	}
//	
//	/**
//	 * Process user login 
//	 * @param loginForm an object of the login form
//	 * @param bindingResult 
//	 * @return Page to show
//	 */
//	@RequestMapping(value="/login",method=RequestMethod.POST)
//	public String login(/**@Valid LoginForm loginForm,**/ BindingResult bindingResult,Model model){
//		
//		if(bindingResult.hasErrors()){
//			//Show notification of invalid login
//			return "redirect:/login";
//		}
//                return null;
//	}
}
