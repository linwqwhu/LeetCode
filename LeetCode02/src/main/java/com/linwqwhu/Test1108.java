package com.linwqwhu;

import org.junit.Test;

/**
 * 1108.IP地址无效化
 */
public class Test1108 {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
//        return address.replaceAll("\\.", "[.]");
    }

    @Test
    public void testDefangIPaddr() {
        String s = "1.1.1.1";
        String s1 = defangIPaddr(s);
        System.out.println(s1);
    }
}
