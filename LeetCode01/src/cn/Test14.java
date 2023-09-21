package cn;

import org.junit.Test;

/**
 * 最长公共前缀
 */
public class Test14 {

    public String longestCommonPrefix(String[] strs) {
        String s = strs[0];
        for(int i=1;i<strs.length;i++){
            while (!strs[i].startsWith(s)){
                if(s.length()==0){
                    return "";
                }
                s=s.substring(0,s.length()-1);
            }
        }
        return s;
    }

    @Test
    public void t(){

        //String[] strs = {"flower","flow","flight"};
        String[] strs = {"dog","racecar","car"};

        System.out.println(longestCommonPrefix(strs));
    }

}
