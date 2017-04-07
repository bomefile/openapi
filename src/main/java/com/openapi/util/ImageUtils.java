package com.openapi.util;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class ImageUtils {
	/**
	 * 图片缩放
	 *
	 * @param srcPath
	 *            原图路径
	 * @param desPath
	 *            新图路径
	 * @param width
	 *            新图宽度
	 * @param height
	 *            新图高度
	 * @throws IOException
	 */
	public static void resize(String srcPath, String desPath, Integer width, Integer height) throws IOException {
		BufferedImage srcImage = ImageIO.read(new FileInputStream(srcPath));
		if (width == null) {
			width = srcImage.getWidth();
		}
		if (height == null) {
			height = srcImage.getHeight();
		}
		BufferedImage desImage = Scalr.resize(srcImage, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_TO_WIDTH, width, height, Scalr.OP_BRIGHTER);
		File desFile = new File(desPath);
		if (!desFile.getParentFile().exists()) {
			desFile.getParentFile().mkdirs();
		}
		// 扩展名
		String extName = "jpg";
		int dot = desPath.lastIndexOf(".");
		if (dot != -1) {
			extName = desPath.substring(desPath.lastIndexOf(".") + 1);
		}
		ImageIO.write(desImage, extName, desFile);
	}

	public static void main(String[] args) throws IOException {
		// pressText("C://pic//jpg", "旺仔之印", "宋体", Font.BOLD | Font.ITALIC, 20,
		// Color.BLACK, 0, 0, 8f, null);
		resize("c://349029.jpg", "c://12312322.jpg", 600, 450);
	}
}