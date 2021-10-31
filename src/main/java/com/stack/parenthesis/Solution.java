package com.stack.parenthesis;

public class Solution {
    public boolean isValid(String s) {
        if(s.isEmpty()){
            return true;
        }
        if(s.charAt(0)== ')' || s.charAt(0) == '}' || s.charAt(0) == ']'){
            return false;
        }
        CustomStack stack = new CustomStack(s.length());
        // stack[0]=s.charAt(0);
        stack.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            try{
                if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){

                    stack.push(s.charAt(i));

                }
                if(s.charAt(i)==')'){

                    char cc =stack.pop();

                    if('(' != cc){
                        return false;
                    }
                }
                if(s.charAt(i)=='}'){

                    char cc =stack.pop();
                    System.out.println(cc);
                    if('{' != cc){
                        return false;
                    }
                }
                if(s.charAt(i)==']'){

                    char cc =stack.pop();
                    if('[' != cc){
                        return false;
                    }
                }
            }catch(Throwable th){
                return false;
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }


}
class CustomStack{
    char[] chars;
    int top=-1;
    public CustomStack(int length){
        chars= new char[length];
    }

    public void push(char c){
        if(top == chars.length-1){
            System.out.println("Stack is full");
            System.exit(1);
        }
        chars[++top]=c;


    }
    public char pop(){
        if(top ==-1){
            System.out.println("Stack is empty");
        }

        char element= chars[top];
        --top;
        return element;
    }
    public boolean isEmpty(){
        return top==-1;
    }
}
