package com.openapi.config;

import java.util.ResourceBundle;

/**
 * config.properties 获取值,绑定
 *
 * @author liuzeyuan
 */
public class ConfigHolder {
	private static ResourceBundle	bundle	= ResourceBundle.getBundle("config");

	/**
	 * 二手房房源访问地址模板
	 *
	 * @param house_id
	 * @return
	 */
	public static String getHouseBaseUrl(String house_id) {
		return String.format(bundle.getString("houseRegexUrl"), house_id);
	}

	/**
	 * 租房房源访问地址模板
	 *
	 * @param house_id
	 * @return
	 */
	public static String getRentHouseBaseUrl(String house_id) {
		return String.format(bundle.getString("rentHouseRegexUrl"), house_id);
	}

	/**
	 * 经纪人url访问地址模板
	 *
	 * @param agent_id
	 * @return
	 */
	public static String getAgentBaseUrl(String agent_id) {
		return String.format(bundle.getString("agentRegexUrl"), agent_id);
	}

	/**
	 * 经纪人二维码 图片目录
	 *
	 * @return
	 */
	public static String getAgentQrCodePath() {
		return bundle.getString("agentQrCodePath");
	}

	/**
	 * 二手房源图片目录（相对于文件服务器根目录）
	 *
	 * @return
	 */
	public static String getHousePicPath() {
		return bundle.getString("housePicPath");
	}

	/**
	 * 租房源图片目录（相对于文件服务器根目录）
	 *
	 * @return
	 */
	public static String getRentPicPath() {
		return bundle.getString("rentPicPath");
	}

	/**
	 * 经纪人图片目录（相对于文件服务器根目录）
	 *
	 * @return
	 */
	public static String getAgentPicPath() {
		return bundle.getString("agentPicPath");
	}

	/**
	 * 经纪人Auth图片目录（相对于文件服务器根目录）
	 *
	 * @return
	 */
	public static String getAgentAuthPicPath() {
		return bundle.getString("agentAuthPicPath");
	}

	/**
	 * 获取文件服务器根目录
	 *
	 * @return
	 */
	public static String getFileServerPath() {
		return bundle.getString("fileServerPath");
	}

	/**
	 * 项目启动,定时扫描线程启动
	 *
	 * @return
	 */
	public static boolean getThreadStartUp() {
		return Boolean.parseBoolean(bundle.getString("threadStartUp"));
	}

	/**
	 * 二手房最低价格
	 *
	 * @return
	 */
	public static long getErShouFangLowPrice() {
		return Long.parseLong(bundle.getString("ErShouFangLowPrice"));
	}

	/**
	 * 租房最低价格
	 *
	 * @return
	 */
	public static long getZuFangLowPrice() {
		return Long.parseLong(bundle.getString("ZuFangLowPrice"));
	}

	/**
	 * 下载图片的更新频率
	 *
	 * @return
	 */
	public static long getThreadDownloadFrequence() {
		return Long.parseLong(bundle.getString("threadDownloadFrequence"));
	}

	public static boolean getQuartzJobEnable() {
		return Boolean.parseBoolean(bundle.getString("quartzJobEnable"));
	}

	/**
	 * 每个经纪人下拥有房源的数量
	 *
	 * @return
	 */
	public static int getAgentHasHouseMaxCount() {
		return Integer.parseInt(bundle.getString("agentHasHouseMaxCount"));
	}

	/**
	 * 获取apns 监听端口
	 *
	 * @return
	 */
	public static int getApnsServerPort() {
		return Integer.parseInt(bundle.getString("apnsServerPort"));
	}

	/**
	 * 百度推送是否是生产环境
	 *
	 * @return
	 */
	public static boolean getBaiduPushProduct() {
		return Boolean.parseBoolean(bundle.getString("baiduPushProduct"));
	}
}