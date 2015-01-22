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
    }
}
