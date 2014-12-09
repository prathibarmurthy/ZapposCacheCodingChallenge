package interv.zappos.challenge.main;

/**
 *  @author Prathiba Ramachandramurthy
 *  Class Name: LoginService.java
 *  Aim: Interface to implement certain methods depicting the actions of the cache
 *  based on when the user was previously logged in.
 */
public interface LoginService {

	/**
	 * @param userId
	 * @return True if the user has logged in within 24 hours False otherwise
	 */
	public boolean hasUserLoggedInWithin24(String userId);

	/**
	 * Sets the last login time for the user to now.
	 * 
	 * @param userId
	 */
	public void userJustLoggedIn(String userId);
}
