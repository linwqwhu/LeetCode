package cn;

/**
 * 加一
 */
public class Test66 {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int sum = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            sum = digits[i] + carry;
            carry = sum / 10;
            digits[i] = sum % 10;
        }
        if (carry == 0) {
            return digits;
        } else {
            int[] newInt = new int[digits.length + 1];
            newInt[0] = carry;
            for (int i = 1; i < newInt.length; i++) {
                newInt[i] = digits[i - 1];
            }
            return newInt;
        }
    }
}
