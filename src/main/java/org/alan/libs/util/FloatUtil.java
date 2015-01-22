package org.alan.libs.util;


/**
 * 浮点数相关操作，精度至小数点后第8位
 * Alan
 * 2015-1-20 下午9:46:04
 */
public class FloatUtil {
	private static final double P_MIN = 1e-8;
	private static final double N_MIN = -1e-8;
	
	/**
	 * 浮点数比较
	 * Alan
	 * @param f1
	 * @param f2
	 * @return 是否相等
	 * 2015-1-20 下午9:46:23
	 */
	public static boolean equal(double f1, double f2) {
		double ds = f1 - f2;
		return ds >= N_MIN && ds <= P_MIN;
	}
	
	/**
	 * 判断 f1 是否大于 f2，即 f1>f2
	 * Alan
	 * @param f1
	 * @param f2
	 * @return
	 * 2015-1-20 下午9:46:49
	 */
	public static boolean greater(double f1, double f2) {
		return (f1-P_MIN) > f2;
	}
	
	/**
	 * 判断f1是否小于f2，即f1<f2
	 * Alan
	 * @param f1
	 * @param f2
	 * @return
	 * 2015-1-20 下午9:47:15
	 */
	public static boolean lesser(double f1, double f2) {
		return (f1+P_MIN) < f2;
	}
	
	/**
	 * 判断f1是否大于等于f2，即f1>=f2
	 * Alan
	 * @param f1
	 * @param f2
	 * @return
	 * 2015-1-20 下午9:47:35
	 */
	public static boolean greaterOrEqual(double f1, double f2) {
		double ds = f1 - f2;
		return ds > N_MIN;
	}
	
	/**
	 * 判断f1是否小于等于f2，即f1<=f2;
	 * Alan
	 * @param f1
	 * @param f2
	 * @return
	 * 2015-1-20 下午9:47:42
	 */
	public static boolean lesserOrEqual(double f1, double f2) {
		double ds = f1 - f2;
		return ds < P_MIN;
	}
	
	/**
	 * 四舍五入
	 * Alan
	 * @param source 要处理的小数
	 * @param digits 小数点保留位数
	 * @return
	 * 2015-1-20 下午9:48:10
	 */
	public static double round(double source, int digits) {
	    int temp = (int) Math.pow(10, digits);
	    return ((double) Math.round(source * temp)) / temp;
	}
}
