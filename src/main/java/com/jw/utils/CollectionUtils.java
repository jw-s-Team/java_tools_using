/**
 * 
 */
package com.jw.utils;

import org.apache.commons.beanutils.BeanPropertyValueEqualsPredicate;
import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.collections.Predicate;
import com.jw.utils.StringUtils;

import java.util.*;

/**
 * @author Chris
 */
public class CollectionUtils extends org.apache.commons.collections.CollectionUtils {

	/**
	 * 查找给定集合中匹配属性对应的值等于给定值的所有元素。
	 * 
	 * @param collection 要查找的集合，不能为空
	 * @param name 集合中元素的属性名
	 * @param key 集合中元素的属性值
	 * @return 所有匹配属性名对应的值等于给定值的元素
	 * @throws NullPointerException 要查找的集合为空
	 */
	public static <T> List<T> findAll(Collection<T> collection, String name, Object key) {
		List<T> answer = new ArrayList<T>(collection.size());
		select(collection, new BeanPropertyValueEqualsPredicate(name, key, true), answer);
		return answer;
	}

	public static <T> Set<T> findSet(Collection<T> collection, String name, Object key) {
		Set<T> answer = new HashSet<T>(collection.size());
		select(collection, new BeanPropertyValueEqualsPredicate(name, key, true), answer);
		return answer;
	}

	public static <T> Set<T> findSortedSet(Collection<T> collection, String name, Object key) {
		Set<T> answer = new LinkedHashSet<T>(collection.size());
		select(collection, new BeanPropertyValueEqualsPredicate(name, key, true), answer);
		return answer;
	}

	/**
	 * @see #findOne(Collection, String, Object)
	 */
	public static <T, S> List<T> findList(Collection<T> collection, String name, List<S> values) {
		List<T> answer = new ArrayList<T>();
		for (S value : values) {
			T findOne = findOne(collection, name, value);
			answer.add(findOne);
		}
		return answer;
	}

	/**
	 * 返回给定集合中匹配属性对应的值等于给定值的第一个元素。
	 * <p>
	 * 如果给定集合为空，将返回{@code null}
	 * 
	 * @param collection 要查找的集合，可以为空
	 * @param name 给定的属性名称，如果给定的集合不为空，则此参数亦不能为空
	 * @return 第一个匹配属性名对应的值等于给定值的元素
	 */
	public static <T> T findOne(Collection<T> collection, String name, Object value) {
		if (collection != null && name != null) {
			Predicate predicate = new BeanPropertyValueEqualsPredicate(name, value, true);
			for (Iterator<T> iter = collection.iterator(); iter.hasNext();) {
				T item = iter.next();
				if (predicate.evaluate(item)) {
					return item;
				}
			}
		}
		return null;
	}

	public static boolean exists(Collection<?> collection, String name, Object value) {
		if (collection != null && name != null) {
			Predicate predicate = new BeanPropertyValueEqualsPredicate(name, value, true);
			return exists(collection, predicate);
		}
		return false;
	}

	/**
	 * @see #collect(Collection, String)
	 */
	public static <T, S> Collection<S> collect(Collection<T> collection, String name) {
		return collectList(collection, name);
	}

	/**
	 * 返回一个包含给定属性所对应值的元素。
	 * <p>
	 * 如果属性名为空，将返回一个空列表。
	 * 
	 * @param collection 给定的集合， 不能为空
	 * @param name 集合元素包含的属性名
	 * @return 转换后的结果(新列表)
	 * @throws NullPointerException 如果给定的集合为空
	 */
	public static <T, S> List<S> collectList(Collection<T> collection, String name) {
		return collectList(collection, name, true);
	}

	/**
	 * 返回一个包含给定属性所对应值的元素。
	 * <p>
	 * 如果属性名为空，将返回一个空列表。
	 * 
	 * @param collection 给定的集合， 不能为空
	 * @param name 集合元素包含的属性名
	 * @param ignoreContains 是否忽略存在的元素
	 * @return 转换后的结果(新列表)
	 * @throws NullPointerException 如果给定的集合为空
	 */
	public static <T, S> List<S> collectList(Collection<T> collection, String name, boolean ignoreContains) {
		if (collection == null) {
			return null;
		}
		Collection<S> answer = null;
		if (ignoreContains) {
			answer = new LinkedHashSet<>(collection.size());
		} else {
			answer = new ArrayList<>(collection.size());
		}
		collect(collection, new BeanToPropertyValueTransformer(name, true), answer);
		for (Iterator<S> iterator = answer.iterator(); iterator.hasNext();) {
			if (iterator.next() == null) {
				iterator.remove();
			}
		}
		return new ArrayList<>(answer);
	}

	/**
	 * 返回一个包含给定属性所对应值的元素。
	 * <p>
	 * 如果属性名为空，将返回一个空列表。
	 * 
	 * @param collection 给定的集合， 不能为空
	 * @param name 集合元素包含的属性名
	 * @return 转换后的结果(新列表)
	 * @throws NullPointerException 如果给定的集合为空
	 */
	public static <R, T, S> List<S> collectList(Collection<T> collection, String collectProp, String byProp,
			List<R> byPropVals) {
		return collectList(findList(collection, byProp, byPropVals), collectProp);
	}

	/**
	 * 给定的集合列表中，至少一个为空
	 * 
	 * @param collections 给定的集合列表
	 * @return 至少一个为空返回true，否则false
	 */
	public static boolean isAnyEmpty(Collection<?>... collections) {
		for (Collection<?> collection : collections) {
			if (isEmpty(collection)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 向给定的集合中添加元素，忽略存在的元素
	 * 
	 * @param collection 给定的集合
	 * @param object 要添加的元素
	 * @return 添加成功返回true，否则false
	 */
	public static <T> boolean addIgnoreContains(Collection<T> collection, T object) {
		return (collection.contains(object) ? false : collection.add(object));
	}

	/**
	 * 返回一个新的包含<tt><i>a</i> - <i>b</i></tt>的{@link List}。
	 * 
	 * @param a 被减的集合，不能为空
	 * @param b 要减去的集合，不能为空
	 */
	public static <T> List<T> subtractList(Collection<T> a, Collection<T> b) {
		List<T> list = new ArrayList<T>(a);
		for (Iterator<T> it = b.iterator(); it.hasNext();) {
			list.remove(it.next());
		}
		return list;
	}

	public static <T> void addAllIgnoreNull(Collection<T> collection, Collection<T> collection2) {
		if (collection2 == null) {
			return;
		}
		collection.addAll(collection2);
	}

	public static <T> List<String> toStringList(Collection<T> collection) {
		if (collection == null) {
			return null;
		}
		List<String> result = new ArrayList<>();
		for (Iterator<T> iterator = collection.iterator(); iterator.hasNext();) {
			result.add(iterator.next().toString());
		}
		return result;
	}

	public static List<Long> toLongList(String[] strs) {
		if (strs == null) {
			return null;
		}
		List<Long> result = new ArrayList<>();
		for (String str : strs) {
			if (StringUtils.isNotBlank(str)) {
				result.add(Long.valueOf(str));
			}
		}
		return result;
	}

	/*
	 * @Author 汪立
	 * @Description //移除list中负数元素(做删除判断用)
	 * @Date 15:29 2018/12/20
	 * @Param [list]
	 * @return void
	 **/
	public static void removeCollectionNegativeElement(Collection<Long> collection) {
		for (Iterator<Long> iter = collection.iterator(); iter.hasNext();) {
			Long item = iter.next();
			if (item < 0) {
				iter.remove();
			}
		}
	}
}
