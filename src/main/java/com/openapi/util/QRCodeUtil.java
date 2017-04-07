package com.openapi.util;

import com.google.zxing.EncodeHintType;
import com.openapi.config.ConfigHolder;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * 二维码生成
 *
 * @author liuzeyuan
 */
public class QRCodeUtil {

	/**
	 * 生成二维码图片（默认png）
	 *
	 * @param desPath
	 *            目标文件地址
	 * @param content
	 *            内容
	 * @throws IOException
	 *             IO异常
	 */
	public static void write(String desPath, String content, int size, int margin) throws IOException {
		write(desPath, content, size, ImageType.PNG, margin);
	}

	/**
	 * 生成二维码图片（默认png）
	 *
	 * @param desPath
	 *            目标文件地址
	 * @param content
	 *            内容
	 * @param size
	 *            大小px
	 * @param imageType
	 *            图片类型
	 * @param margin
	 *            边界
	 * @throws IOException
	 */
	public static void write(String desPath, String content, int size, ImageType imageType, int margin) throws IOException {
		FileUtils.moveFile(QRCode.from(content).withHint(EncodeHintType.MARGIN, margin).withSize(size, size).to(ImageType.PNG).file(), new File(desPath));
	}

	public static void main(String[] args) throws IOException {
		QRCodeUtil.write(ConfigHolder.getFileServerPath() + ConfigHolder.getAgentQrCodePath() + 123 + ".png", ConfigHolder.getAgentBaseUrl("123"), 132, 0);
	}
}