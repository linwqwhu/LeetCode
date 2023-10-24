package com.ieee;

import java.util.Scanner;

public class ReplaceA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        StringBuffer sb = new StringBuffer();
        sb.append(str.charAt(0));

        int len = str.length();
        for (int i = 1; i < len; ) {
            char c = str.charAt(i);
            if (c == 'A' && str.charAt(i - 1) == 'A')
                continue;
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}


//#include<iostream>
//#include<string>
//
//using namespace std;
//
//int main(){
//        string str;
//        cin>>str;
//
//        string result;
//        result+=str[0];
//
//        int len=str.length();
//        for(int i=1;i<len; ++i){
//        char c=str[i];
//        if(c=='A'&&str[i-1]=='A')
//        continue;
//        result+=c;
//        }
//
//        cout<<result<<endl;
//        return 0;
//}
