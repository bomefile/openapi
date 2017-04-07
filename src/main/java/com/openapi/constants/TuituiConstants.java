package com.openapi.constants;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 推推99常量参数
 *
 * @author liuzeyuan
 */
public class TuituiConstants {
	public final static Map<String, String>	CITIES			= new HashMap<String, String>();
	public final static Map<String, String>	HOUSE_TYPES		= new HashMap<String, String>();	// 房源类型
	public final static Map<String, String>	TOWARDS			= new HashMap<String, String>();	// 朝向
	public final static Map<String, String>	DECORATE		= new HashMap<String, String>();	// 装修
	public final static Map<String, String>	PAYMENT			= new HashMap<String, String>();	// 支付方式
	public final static Map<String, String>	Type4Property2	= new HashMap<String, String>();	// 支付方式
	//
	public final static Set<String>			black_words		= new HashSet<String>();

	static {
		//
		CITIES.put("1", "北京");
		CITIES.put("2", "广州");
		CITIES.put("3", "深圳");
		CITIES.put("4", "成都");
		CITIES.put("5", "上海");
		CITIES.put("6", "天津");
		CITIES.put("7", "重庆");
		CITIES.put("8", "长春");
		CITIES.put("9", "苏州");
		CITIES.put("10", "杭州");
		CITIES.put("11", "大连");
		CITIES.put("12", "郑州");
		CITIES.put("13", "武汉");
		CITIES.put("14", "东莞");
		CITIES.put("15", "珠海");
		CITIES.put("16", "沈阳");
		CITIES.put("17", "石家");
		CITIES.put("18", "西安");
		CITIES.put("19", "济南");
		CITIES.put("20", "昆明");
		CITIES.put("21", "福州");
		CITIES.put("22", "南宁");
		CITIES.put("23", "长沙");
		CITIES.put("24", "惠州");
		CITIES.put("25", "海口");
		CITIES.put("26", "佛山");
		CITIES.put("27", "无锡");
		CITIES.put("28", "贵阳");
		CITIES.put("29", "厦门");
		CITIES.put("30", "中山");
		//
		HOUSE_TYPES.put("1", "普通住宅");
		HOUSE_TYPES.put("2", "复式住宅");// --
		HOUSE_TYPES.put("3", "公寓");
		HOUSE_TYPES.put("4", "别墅");
		HOUSE_TYPES.put("8", "四合院");
		HOUSE_TYPES.put("9", "平房");// --
		HOUSE_TYPES.put("10", "小产权房");// --
		HOUSE_TYPES.put("11", "商铺");// --
		HOUSE_TYPES.put("12", " 写字楼");// --
		//
		TOWARDS.put("1", "南北通透");
		TOWARDS.put("2", "东西向");
		TOWARDS.put("3", "朝东");
		TOWARDS.put("4", "朝南");
		TOWARDS.put("5", "朝西");
		TOWARDS.put("6", "朝北");
		TOWARDS.put("7", "东南");
		TOWARDS.put("8", "东北");
		TOWARDS.put("9", "西南");
		TOWARDS.put("10", "西北");
		//
		DECORATE.put("1", "毛坯");
		DECORATE.put("2", "简装修");
		DECORATE.put("3", "中等装修");
		DECORATE.put("4", "精装修");
		DECORATE.put("5", "豪华装修");
		//
		PAYMENT.put("1", "押一付三");
		PAYMENT.put("2", "押一付一 ");
		PAYMENT.put("3", "押一付六");
		PAYMENT.put("4", "押二付三");
		PAYMENT.put("5", "押二付二");
		PAYMENT.put("6", "押二付一");
		PAYMENT.put("7", "押一付十二");
		PAYMENT.put("8", "半年付不押");
		PAYMENT.put("9", "年付不押");
		//
		// Type4Property2 出租性质
		Type4Property2.put("1", "整租");
		Type4Property2.put("2", "主卧");
		Type4Property2.put("3", "次卧");
		Type4Property2.put("4", "隔断");
		Type4Property2.put("5", "床位");
		//
	}

	/**
	 * 城市
	 *
	 * @param cityNo
	 * @return
	 */
	public static String getCity(String cityNo) {
		return CITIES.get(cityNo);
	}

	/**
	 * 房屋类型
	 *
	 * @param typeno
	 * @return
	 */
	public static String getHouseType(String typeno) {
		if (HOUSE_TYPES.get(typeno) == null) {
			return "普通住宅";
		}
		return HOUSE_TYPES.get(typeno);
	}

	/**
	 * 朝向
	 *
	 * @param towardno
	 * @return
	 */
	public static String getToward(String towardno) {
		return TOWARDS.get(towardno);
	}

	/**
	 * 装修
	 *
	 * @param decorateno
	 * @return
	 */
	public static String getDecorate(String decorateno) {
		if (DECORATE.get(decorateno) == null) {
			return "其他";
		}
		return DECORATE.get(decorateno);
	}

	/**
	 * 付款方式
	 *
	 * @param decorateno
	 * @return
	 */
	public static String getPayment(String payment) {
		if (PAYMENT.get(payment) == null) {
			return "其他";
		}
		return PAYMENT.get(payment);
	}

	/**
	 * 出租性质 和推推对应上的只有整租,非整租按合租
	 *
	 * @param decorateno
	 * @return
	 */
	public static String getRentType(String rentType) {
		if (Type4Property2.get(rentType) == null || !"整租".equals(Type4Property2.get(rentType))) {
			return "合租";
		}
		return Type4Property2.get(rentType);
	}
}
