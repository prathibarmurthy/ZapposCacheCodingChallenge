package interv.zappos.challenge.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Prathiba Ramachandramurthy
 * Class Name: ConcurrentAccessCache.java
 * Aim: Simple Cache library-Least Recently Used cache which
 * inserts, removes users from queue based on their last login date
 */
public class ConcurrentAccessCache<Key, Value> {

	private final int maxSize;
	private ConcurrentHashMap<Key, Value> map;
	private ConcurrentLinkedQueue<Key> queue;

	public ConcurrentAccessCache(final int maxSize) {
		this.maxSize = maxSize;
		map = new ConcurrentHashMap<Key, Value>(maxSize);
		queue = new ConcurrentLinkedQueue<Key>();
	}

	/**
	 * @param key
	 * @param value
	 */
	public void put(final Key key, final Value value) {
		if (map.containsKey(key)) {
			queue.remove(key); // remove the key from the Concurrent queue
		}

		while (queue.size() >= maxSize) {
			Key lastKey = queue.poll();
			if (null != lastKey) {
				map.remove(lastKey);
			}
		}
		queue.add(key);
		map.put(key, value);
	}

	/**
	 * @param key
	 * @return the value associated to the given key or null
	 */
	public Value get(final Key key) {
		return map.get(key);
	}

	public Boolean hasKey(final Key key) {
		if (map.containsKey(key))
			return true;
		return false;

	}

	public void removeOldestByTime(final Key oldestKey) {
		map.remove(oldestKey);
		queue.remove(oldestKey);
	}
}