package org.alan.libs.util;

import org.junit.Test;

public class HexConvertionUtilTest {
    @Test
    public void test() {
        String str = HexConversionUtil.decimal2SixtyFour(10);
        System.out.println(str);
        long num = HexConversionUtil.sixtyFour2Decimal(str);
        System.out.println(num);
        
        str = HexConversionUtil.decimal2ThirtyTwo(100);
        System.out.println(str);
        num = HexConversionUtil.thirtyTwo2Decimal(str);
        System.out.println(num);
        
        String rot16 = "hyukjnkpoghij23";
        rot16 = HexConversionUtil.rot16(rot16);
        System.out.println(rot16);
        rot16 = HexConversionUtil.rot16(rot16);
        System.out.println(rot16);
        
        str = HexConversionUtil.decimal2Sixteen(12453);
        System.out.println(str);
        num = HexConversionUtil.sixteen2Decimal(str);
        System.out.println(num);
        
        byte[] bytes = {-122, -46, 0, 12, 1, 2, 98, 50, -1, -0, -77, 78, 22, 33, 55, 99, 101, 43, 23, 34, 111, 121, 127, -128, 33, 99, 56, 34, 56, -128, -100};
        str = HexConversionUtil.byte2Sixteen(bytes);
        System.out.println(str);
        bytes = HexConversionUtil.sixteen2Byte(str);
        for (byte b : bytes)
            System.out.print(b + ",");
        System.out.println();
        
        str = HexConversionUtil.byte2ThirtyTwo(bytes);
        System.out.println(str);
        bytes = HexConversionUtil.thirtyTwo2Byte(str);
        for (byte b : bytes)
            System.out.print(b + ",");
        System.out.println();
        
        str = HexConversionUtil.byte2SixtyFour(bytes);
        System.out.println(str);
        bytes = HexConversionUtil.sixtyFour2Byte(str);
        for (byte b : bytes)
            System.out.print(b + ",");
        System.out.println();
    }
}
