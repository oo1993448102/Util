package com.rudder.core.utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * @author wliu
 */
public class ObjectConvertUtils {

	/**
	 * 将对象转化成Map，仅支持简单值对象处理。
	 * @param obj
	 * @return
	 */
	public static Map<?,?> objToMap(Object obj) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 获取f对象对应类中的所有属性域  
        Field[] fields = obj.getClass().getDeclaredFields();  
        for (int i = 0, len = fields.length; i < len; i++) {  
            String varName = fields[i].getName();  
            try {  
                // 获取原来的访问控制权限  
                boolean accessFlag = fields[i].isAccessible();  
                // 修改访问控制权限  
                fields[i].setAccessible(true);  
                // 获取在对象f中属性fields[i]对应的对象中的变量  
                Object o = fields[i].get(obj);  
                if (o != null)  
                    map.put(varName, o);  
                // 恢复访问控制权限  
                fields[i].setAccessible(accessFlag);  
            } catch (IllegalArgumentException ex) {  
                ex.printStackTrace();  
            } catch (IllegalAccessException ex) {  
                ex.printStackTrace();  
            }  
        }  
        return map; 
	}
	
	/**
	 * 将对象转化为URL参数形式
	 * @param obj
	 * @return
	 */
	public static String objToUrl(Object obj) { 
		StringBuffer stbf = new StringBuffer();
        // 获取f对象对应类中的所有属性域  
        Field[] fields = obj.getClass().getDeclaredFields(); 
        int j = 0;
        for (int i = 0, len = fields.length; i < len; i++) {  
            String varName = fields[i].getName();  
            try {  
                // 获取原来的访问控制权限  
                boolean accessFlag = fields[i].isAccessible();  
                // 修改访问控制权限  
                fields[i].setAccessible(true);  
                // 获取在对象f中属性fields[i]对应的对象中的变量  
                Object o = fields[i].get(obj);  
                if (o != null)  {
                	if (j==0) {
                		stbf.append("?");
                	} else {
                		stbf.append("&");
                	}
                	stbf.append(varName);
               		stbf.append("=");
               		String value = URLDecoder.decode(o.toString(), "UTF-8");
               		stbf.append(value);
               		j++;
                }
                // 恢复访问控制权限  
                fields[i].setAccessible(accessFlag);  
            } catch (IllegalArgumentException ex) {
				// TODO 抛出运行期异常
                ex.printStackTrace();  
            } catch (IllegalAccessException ex) {  
				// TODO 抛出运行期异常
                ex.printStackTrace();  
            } catch (UnsupportedEncodingException e) {
				// TODO 抛出运行期异常
				e.printStackTrace();
			}  
        } 
		return stbf.toString();
	}

	/**
	 * 将Map转换为URL参数
	 * @param params
	 * @return
	 */
	public static String mapToUrlParams(Map<?, ?> params) {
		StringBuffer stbf = new StringBuffer();
		if (params==null) return stbf.toString();
		if(params.size()>0) {
			int i = 0;
            for (Entry<?, ?> entry : params.entrySet()) {
            	if (i==0) {
        			stbf.append("?");
            	} else {
            		stbf.append('&');
            	}
            	stbf.append(entry.getKey());
            	stbf.append('=');
            	try {
            		//防止中文乱码
					String value = URLDecoder.decode((String)entry.getValue(), "UTF-8");
					stbf.append(value);
				} catch (UnsupportedEncodingException e) {
					// TODO 抛出RuntimeException
					e.printStackTrace();
				}
            }		
		}
		return stbf.toString();
	}
	
}
