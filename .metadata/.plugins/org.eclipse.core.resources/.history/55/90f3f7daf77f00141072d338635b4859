package interv.zappos.challenge.main;

import java.sql.SQLException;
import java.util.Date;
import interv.zappos.challenge.util.*;

/**
 * @author Prathiba Ramachandramurthy
 * Class Name: LoginDataHelpher.java
 * Aim: Class implementing LoginService interface to check whether the user has
 * logged in within the last 24 hours
 */

public class LoginDataHelper implements LoginService {
	ConcurrentAccessCache<String, Date> cache = new ConcurrentAccessCache<String, Date>(1000);
	FakeDBAccess databaseObject = new FakeDBAccess();
	
	// @Override
		public boolean hasUserLoggedInWithin24(String userId) {
			Date lastLoginDate = null;
			if (cache.hasKey(userId)) {
				lastLoginDate = cache.get(userId);
			} else {
				lastLoginDate = databaseObject.getLastLoginForUser(userId);
				//Update cache
				cache.put(userId, lastLoginDate);
			}
			Date presentDate = new Date();
			if(dateCheck24(lastLoginDate, presentDate))
				return true;
			else{
				cache.removeOldestByTime(userId);
				return false;
			}
		}
		
		// @Override
		public void userJustLoggedIn(String userId) {
			Date date = new Date();
			//Update cache
			cache.put(userId, date);
			try {
				databaseObject.setLastLoginForUser(userId, date);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/**
		 * Returns true if the time difference is less than 24 hours 
		 * else returns false
		 * 
		 * @param userId
		 */
		public boolean dateCheck24(Date startDate, Date endDate) {
			long hours = (endDate.getTime() - startDate.getTime()) / 1000 * 3600;
			if (hours < 24) return true;
			return false;
		}
}
