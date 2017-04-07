package com.openapi.util;

import javax.ws.rs.core.MultivaluedMap;
import java.util.HashMap;
import java.util.Map;

/**
 * resteasy 参数注入
 *
 * @author Administrator
 */
public class MultivaluedMapUtil {
	public static <K, V> Map<K, V> getSingleValueMap(MultivaluedMap<K, V> form) {
		Map<K, V> values = new HashMap<K, V>();
		for (K key : form.keySet()) {
			V value = form.getFirst(key);
			values.put(key, value);
		}
		return values;
	}
}
