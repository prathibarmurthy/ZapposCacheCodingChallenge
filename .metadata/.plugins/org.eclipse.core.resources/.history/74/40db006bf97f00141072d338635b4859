package interv.zappos.challenge.util;

import java.sql.SQLException;
import java.util.Date;

/**
 * @author Prathiba Ramachandramurthy
 * Class Name: ConcurrentLRUCache.java
 * Aim: Library to pretend read and write to the database.
 */
public class FakeDBAccess {
	public Date getLastLoginForUser(String userId) {
		if (Math.random() < .5)
			return new Date(System.currentTimeMillis());
		return new Date(System.currentTimeMillis() - 42 * 60 * 60 * 1000);
	}

	public void setLastLoginForUser(String userId, Date date) throws SQLException {
		// do nothing
	}
}
