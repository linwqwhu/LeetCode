package com.linwqwhu;

/**
 * 2525.根据规则将箱子分类
 */
public class Test2525 {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean isBulky = length >= 1e4 || width >= 1e4 || height >= 1e4 || 1L * height * width * height >= 1e9;
        boolean isHeavy = mass >= 100;
        if (isBulky && isHeavy)
            return "Both";
        if (!isBulky && isHeavy)
            return "Heavy";
        if (isBulky)
            return "Bulky";
        return "Neither";
    }

    public String categorizeBox2(int length, int width, int height, int mass) {
        long maxd = Math.max(length, Math.max(width, height)), vol = 1L * length * width * height;
        boolean isBulky = maxd >= 10000 || vol >= 1000000000, isHeavy = mass >= 100;
        if (isBulky && isHeavy) {
            return "Both";
        } else if (isBulky) {
            return "Bulky";
        } else if (isHeavy) {
            return "Heavy";
        } else {
            return "Neither";
        }
    }
}


