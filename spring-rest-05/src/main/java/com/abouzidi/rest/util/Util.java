package com.abouzidi.rest.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Util {

	public static <E> Collection<E> toList(Iterable<E> iterable) {
		if (iterable instanceof List) {
			return (List<E>) iterable;
		}
		ArrayList<E> list = new ArrayList<E>();
		if (iterable != null) {
			for (E e : iterable) {
				list.add(e);
			}
		}
		return list;
	}

}
