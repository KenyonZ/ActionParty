/**
 * @文件名：XmlUtil.java 
 * @作者:author
 * @创建时间： 2017年3月3日 上午9:06:59
 * @版本:V1.0
 * 版权：版权所有 bsoft 保留所有权力。
 */
package cn.edu.tju.rico.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * @author lyh
 * @类功能说明:字典解析类
 */
public class XmlUtil {

	/**
	 * 
	 * @方法说明：读取字典
	 * @param filePath
	 * @return
	 */
	public static List readTxtFile(String filePath) {
		try {
			String encoding = "UTF-8";
			File file = new File(filePath);
			List list = new ArrayList<>();
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				String allText = "";
				int i = 0;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					if (i != 0) {
						allText = allText + lineTxt;
					}
					i++;
				}
				list = XmlUtil.Xml2Map(allText);
				read.close();
				return list;
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return null;

	}
	
	/**
	 * 
	 * @方法说明：节点解析
	 * @param xml
	 * @return
	 */
	public static List Xml2Map(String xml) {
		Document doc;
		try {
			doc = DocumentHelper.parseText(xml);
		} catch (DocumentException e1) {
			e1.printStackTrace();
			return null;
		}
		List list = new ArrayList<>();
		if (doc == null)
			return list;
		Element root = doc.getRootElement();
		list = Dom2Map(root);
		return list;
	}

	/**
	 * @方法说明：子节点解析（递归）
	 * @param e
	 * @return map
	 */
	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> Dom2Map(Element root) {
		List list = new ArrayList<>();
		for (Iterator<Element> iterator = root.elementIterator(); iterator
				.hasNext();) {
			Element e = (Element) iterator.next();
			Attribute keyAttr = e.attribute("key");// 获取<line>元素的属性
			String key = keyAttr.getValue();// 获取<line>元素的属性值
			Attribute textAttr = e.attribute("text");// 获取<line>元素的属性
			String text = textAttr.getValue();// 获取<line>元素的属性值
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("value", key);
			map.put("label", text);
			if (e.elements().size() > 0) {
				map.put("children", Dom2Map(e)); // 通过size判断有没有子节点，有就拆解子节点
				list.add(map);
			} else {
				list.add(map);
			}
		}
		return list;
	}
}