package com.openapi.util;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 获取文本相似度
 *
 * @author liuzeyuan
 */
public class CosineSimilarAlgorithm {

	/**
	 * 获取文本相似度
	 *
	 * @param doc_src
	 * @param doc_other
	 * @return
	 */
	public static double getSimilarity(String doc_src, String doc_other) {
		if (doc_src != null && doc_src.trim().length() > 0 && doc_other != null && doc_other.trim().length() > 0) {
			doc_src = doc_src.replace(" ", "");
			doc_other = doc_other.replace(" ", "");
			if (doc_src.equals(doc_other)) {
				return 1;
			}
			HashMap<Integer, int[]> algorithmMap = new HashMap<Integer, int[]>();
			// 将两个字符串中的中文字符以及出现的总数封装到，AlgorithmMap中
			for (int i = 0; i < doc_src.length(); i++) {
				int charIndex = doc_src.charAt(i);
				if (isCharOk(charIndex)) {
					int[] fq = algorithmMap.get(charIndex);
					if (fq != null && fq.length == 2) {
						fq[0]++;
					} else {
						fq = new int[2];
						fq[0] = 1;
						fq[1] = 0;
						algorithmMap.put(charIndex, fq);
					}
				}
			}
			for (int i = 0; i < doc_other.length(); i++) {
				int charIndex = doc_other.charAt(i);
				if (isCharOk(charIndex)) {
					int[] fq = algorithmMap.get(charIndex);
					if (fq != null && fq.length == 2) {
						fq[1]++;
					} else {
						fq = new int[2];
						fq[0] = 0;
						fq[1] = 1;
						algorithmMap.put(charIndex, fq);
					}
				}
			}
			Iterator<Integer> iterator = algorithmMap.keySet().iterator();
			double sq_src = 0;
			double sq_other = 0;
			double denominator = 0;
			while (iterator.hasNext()) {
				int[] c = algorithmMap.get(iterator.next());
				denominator += c[0] * c[1];
				sq_src += c[0] * c[0];
				sq_other += c[1] * c[1];
			}
			double base = Math.sqrt(sq_src * sq_other);
			return base == 0 ? base : denominator / base;
		} else {
			throw new NullPointerException("the Document is null or have not cahrs!!");
		}
	}

	/**
	 * 判断是否汉字和ascii码
	 *
	 * @param ch
	 * @return
	 */
	private static boolean isCharOk(int ch) {
		return (ch >= 0x4E00 && ch <= 0x9FA5) || (ch >= 48 && ch <= 122);
	}

	public static void main(String[] args) {
		String st1 = "";
		String st2 = "";
		System.out.println(getSimilarity(st1, st2));
	}
}