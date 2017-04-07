package com.openapi.util;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

/**
 * 字符串公共类
 *
 * @author liuzeyuan
 */
public class StringUtil extends StringUtils {
	protected static final Logger	logger			= LogManager.getLogger(StringUtil.class);
	// 定义script的正则表达式
	private static final String		regEx_script	= "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
	// 定义style的正则表达式
	private static final String		regEx_style		= "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
	// 定义HTML标签的正则表达式
	private static final String		regEx_html		= "<[^>]+>";
	// 定义空格回车换行符: \s等价于[ \f\n\r\t\v]
	private static final String		regEx_space		= "[\\f\\n\\r\\t\\v\\u00A0]+";

	/**
	 * 去除标签
	 *
	 * @param content
	 *            含html标签的内容
	 * @return 不含html标签的内容
	 */
	public static String replaceHTMLTag(String content) {
		if (content == null) {
			return "";
		}
		content = StringEscapeUtils.unescapeHtml(content);
		// 过滤script标签
		content = replacePattern(content, regEx_script, "");
		// 过滤style标签
		content = replacePattern(content, regEx_style, "");
		// 过滤html标签
		content = replacePattern(content, regEx_html, "");
		// 过滤空白
		content = replacePattern(content, regEx_space, "");

		return content;// 返回文本字符串
	}

	/**
	 * Replaces each substring of the source String that matches the given regular expression with the given replacement using the {@link Pattern#DOTALL} option. DOTALL is also know as single-line mode in Perl. This call is also equivalent to:
	 * <ul>
	 * <li>{@code source.replaceAll(&quot;(?s)&quot; + regex, replacement)}</li>
	 * <li>
	 * {@code Pattern.compile(regex, Pattern.DOTALL).matcher(source).replaceAll(replacement)}</li>
	 * </ul>
	 *
	 * @param source
	 *            the source string
	 * @param regex
	 *            the regular expression to which this string is to be matched
	 * @param replacement
	 *            the string to be substituted for each match
	 * @return The resulting {@code String}
	 * @see String#replaceAll(String, String)
	 * @see Pattern#DOTALL
	 * @since 3.2
	 */
	public static String replacePattern(final String source, final String regex, final String replacement) {
		return Pattern.compile(regex, Pattern.DOTALL).matcher(source).replaceAll(replacement);
	}

	public static void main(String[] args) {

		String ss = "<P><STRONG>&nbsp;<FONT color=#000000><FONT style=\"BACKGROUND-COLOR: #ff99cc\"><SPAN style=\"FONT-SIZE: 26px\">房源特色：</SPAN></FONT><BR></FONT><FONT color=#800080><SPAN style=\"FONT-SIZE: 26px\">&nbsp;&nbsp;☞金城阜业…竭诚为您服务！</SPAN></FONT></STRONG></P>"
				+ "<P><FONT color=#800080><STRONG><SPAN style=\"FONT-SIZE: 26px\">&nbsp; ☞金城阜业…郑重承诺以上所说房源真实有效， 看房请提前预约！</SPAN></STRONG></FONT></P>"
				+ "<P><STRONG><FONT color=#800080><SPAN style=\"FONT-SIZE: 26px\">&nbsp;&nbsp;☞金城阜业▶专业心，爱家情◀…金城阜业房地产经纪有限公司，您身边的房产公司！</SPAN></FONT><BR><SPAN style=\"FONT-SIZE: 26px\">&nbsp;</SPAN><BR><FONT style=\"BACKGROUND-COLOR: #ff99cc\" color=#333399><SPAN style=\"FONT-SIZE: 26px\">房源♡优势（分析）：</SPAN></FONT><BR><SPAN style=\"BACKGROUND-COLOR: #ff0000; FONT-SIZE: 26px\">☞卖点1：房东诚♡意出售，稀缺，仅售110万元，单价仅1.7万元。</SPAN><BR><SPAN style=\"BACKGROUND-COLOR: #ff0000; FONT-SIZE: 26px\">☞卖点2：户型好，户型：南北通透，全明格局。2室1厅1厨1卫1阳台，小区配套设施齐全，非常的方便。</SPAN><BR><SPAN style=\"BACKGROUND-COLOR: #ff0000; FONT-SIZE: 26px\">☞卖点3：面积：64.2平方米， 层次非常的好，110万元，便宜.房主接受贷款。</SPAN><BR><BR><FONT style=\"BACKGROUND-COLOR: #ff99cc\" color=#333399><SPAN style=\"FONT-SIZE: 26px\">&nbsp;小区描述▶交通，配套◀</SPAN></FONT></STRONG></P>"
				+ "<P><FONT color=#008000><STRONG><SPAN style=\"FONT-SIZE: 26px\">☞：周边公交：公交：<SPAN style=\"BACKGROUND-COLOR: #ff0000\">370路、960路、992路，T4快线在小区门口，出行非常方便<BR></SPAN></SPAN></STRONG></FONT><FONT color=#008000><STRONG><SPAN style=\"FONT-SIZE: 26px\">☞：周边配套齐全，周围商店：华洋新盛百货商场、吴亚商场餐饮：百花速8酒店周边银行：中国建设银行周边医院：京煤集团总医院、得坤瑶医医院、龙泉医院</SPAN></STRONG></FONT></P>" + "<P><FONT color=#008000><STRONG><SPAN style=\"FONT-SIZE: 26px\">&nbsp;&nbsp; 本人郑重承诺：所提供房源信息和图片真实、有效！！诚心做事，诚实做人！有需要的朋友请打我的电话。</SPAN><BR><SPAN style=\"FONT-SIZE: 26px\">&nbsp;&nbsp; &nbsp;更多房源请点击我的头像</SPAN><BR></STRONG></FONT></P>";
		// System.out.println(replaceHTMLTag("<html>123</html>"));
		System.out.println(replaceHTMLTag(ss));
		// System.out.println(StringUtil.replaceHTMLTag("abc<img src=\"url\" />efg&nbsp;&nbsp;&nbsp;&#160;&#160;&#160;"));
	}
}
