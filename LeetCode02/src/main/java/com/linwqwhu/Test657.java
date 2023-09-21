package com.linwqwhu;

/**
 * 657.机器人能够回到原点
 */
public class Test657 {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0)
            return true;
        if (moves.length() % 2 == 1)
            return false;
        int x = 0, y = 0;
        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
            }
        }
        return x == 0 && y == 0;
    }

    public boolean judgeCircle2(String moves) {
        if (moves == null || moves.length() == 0)
            return true;
        if (moves.length() % 2 == 1)
            return false;
//        int[] count = new int[26];
        int[] count = new int['U' - 'A' + 1];
        for (char move : moves.toCharArray()) {
            count[move - 'A']++;
        }
        return count['L' - 'A'] == count['R' - 'A'] && count['U' - 'A'] == count['D' - 'A'];
    }
}
