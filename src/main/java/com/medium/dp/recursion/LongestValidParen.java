package com.medium.dp.recursion;

import java.util.Stack;

public class LongestValidParen {
    public int longestValidParentheses(String k) {
        // String k = "(((())";
        Stack st = new Stack();
        st.push(-1);
        int ret=0;
        int sum=0;
        for(int i=0;i<k.length();i++){
            if(k.charAt(i) == '('){
                st.push(i);  //0,
            }else{
                if(!st.isEmpty()){
                    st.pop(); //3, i=4,st.peek=0

                }



                if(st.isEmpty()){
                    System.out.println(i);
                    st.push(i); //0
                }else{
                    int len = i-(int)st.peek(); //4-0=4
                    if(len>ret){
                        ret=len; //2
                    }
                }
            }
        }




        return ret;
    }

}
