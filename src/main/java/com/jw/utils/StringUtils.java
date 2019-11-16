package com.jw.utils;


import com.google.common.base.CaseFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 扩展{@link org.apache.commons.lang3.StringUtils}工具类
 * 
 * @author Chris
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

	private static final String PARAMS_IS_NULL = "后台传参为空值！";

	/**
	 * 将字符{@code literal}按分隔符{@code separatorChar}分隔后转成驼峰命名的字符串
	 * 
	 * @param literal 给定字符串
	 * @param separatorChar 分隔符
	 */
	public static String toCamelCase(String literal, String separatorChar) {
		String[] words = literal.split(separatorChar);
		StringBuffer camelCaseWord = new StringBuffer(50);
		for (int i = 0, len = words.length; i < len; i++) {
			String word = words[i];
			if (i > 0) {
				camelCaseWord.append(word.substring(0, 1).toUpperCase());
				camelCaseWord.append(word.substring(1).toLowerCase());
			} else {
				camelCaseWord.append(word.toLowerCase());
			}
		}
		return camelCaseWord.toString();
	}

	/**
	 * 集合中如果包含多个元素，取默认值，否则取集合中的值
	 * 
	 * @param collection 集合
	 * @param defaultString 默认值
	 */
	public static String defaultIfMulti(Collection<String> collection, String defaultString) {
		if (CollectionUtils.isEmpty(collection)) {
			return null;
		}
		if (collection.size() == 1) {
			return collection.iterator().next();
		}
		return defaultString;
	}

	/**
	 * 驼峰转换工具类- eg:test_data转为testData
	 * 
	 * @param literal
	 * @return
	 */
	public static String lowerCamel(String literal) {
		if (literal == null) {
			throw new RuntimeException(PARAMS_IS_NULL);
		}
		return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, literal);
	}

	/**
	 * 驼峰转换工具类- eg:test_data转为TestData
	 * 
	 * @param literal
	 * @return
	 */
	public static String upperCamel(String literal) {
		if (literal == null) {
			throw new RuntimeException(PARAMS_IS_NULL);
		}
		return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, literal);
	}

	/**
	 * 驼峰转换工具类- eg:testData或TestData转为test_data
	 * 
	 * @param literal
	 * @return
	 */
	public static String underscore(String literal) {
		if (literal == null) {
			throw new RuntimeException(PARAMS_IS_NULL);
		}
		return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, literal);
	}





	public static List<Long> getIdList(String idStr,String regex){
		if (isEmpty(idStr)) {
			return null;
		}
		String[] idsTmp = idStr.split(regex);
		List<Long> ids = new ArrayList<>();
		for (int i = 0; i < idsTmp.length; i++) {
			Long id = handleLong(idsTmp[i]);
			if (id != null) {
				ids.add(new Long(idsTmp[i]));
			}
		}
		return ids;
	}

	private static Long handleLong(String id) {
		if (StringUtils.isEmpty(id)) {
			return null;
		}
		if ("NaN".equals(id)) {
			return null;
		}

		Long value = new Long(id);
		if (value.compareTo(0L) > 0) {
			return value;
		}
		return null;
	}

	public static String toString(Object object) {
		if (object == null) {
			return "";
		}
		return object.toString();
	}

	/**
	 * @Description //TODO 转换类型
	 * @Date 14:50 2019/5/15
	 * @Param [orderName]
	 * @Author 郑族彬
	 * @return
	 */
	public static String StringCellValue(String name){
		if(StringUtils.isNotEmpty(name)){
			Boolean strResult = name.matches("^[-\\+]?([0-9]+\\.?)?[0-9]+$");
			if(strResult==true){
				int i;
				for( i=name.length()-1;i>=0;i-- ) //从串尾向前检查，遇到非0数据结束循环
				{
					if( name.charAt(i)=='.' ) { //遇到小数点结束，说明是个整数
						break;
					}
					if ( name.charAt(i) != '0' ) //遇到小数中有非0值，结束
					{
						i++;
						break;
					}
				}
				return name.substring(0,i);
			}else{
				return name;
			}
		}
		return null;
	}
}
