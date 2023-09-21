package com.linwqwhu;

import java.util.HashMap;
import java.util.Map;

/**
 * 1507.转变日期格式
 */
public class Test1507 {
    public String reformatDate(String date) {
        String[] s = date.split(" ");
        HashMap<String, String> map = new HashMap<String, String>() {
            {
                put("Jan", "01");
                put("Feb", "02");
                put("Mar", "03");
                put("Apr", "04");
                put("May", "05");
                put("Jun", "06");
                put("Jul", "07");
                put("Aug", "08");
                put("Sep", "09");
                put("Oct", "10");
                put("Nov", "11");
                put("Dec", "12");
            }
        };
        StringBuffer sb = new StringBuffer();
        sb.append(s[2] + "-");
        sb.append(map.get(s[1]) + "-");
        if (s[0].length() == 3)
            sb.append("0" + s[0].charAt(0));
        else
            sb.append(s[0].charAt(0) + "" + s[0].charAt(1));
        return sb.toString();

    }
}


