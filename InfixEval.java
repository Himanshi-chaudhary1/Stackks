package Stackks;
import java.util.Stack;

public class InfixEval {
    public static void main(String[] args) {
        String str ="9-(5+3)*4/6";
        Stack<Integer> val = new Stack<>();
        Stack<Character> oper = new Stack<>();
        for(int i= 0;i<str.length();i++){
            char ch = str.charAt(i);
            int ascii = (int)ch;
            //'0' = 48 and '9'= 57
            if(ascii>=48 && ascii<=57){
                val.push(ascii-48);
            }
            else if(oper.size()==0 || ch =='('|| oper.peek()=='('){
                oper.push(ch);
            }
            else if(ch==')'){
                while (oper.peek()!='(') {
                    //work
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if(oper.peek()=='-') val.push(v1-v2);
                    if(oper.peek()=='+') val.push(v1+v2);
                    if(oper.peek()=='*') val.push(v1*v2);
                    if(oper.peek()=='/') val.push(v1/v2);
                    oper.pop();
                }
                oper.pop();//'('hta diya
            }
            else{
                if(ch =='+' || ch=='-'){
                 //work
                 int v2 = val.pop();
                 int v1 = val.pop();
                 if(oper.peek()=='-') val.push(v1-v2);
                 if(oper.peek()=='+') val.push(v1+v2);
                 if(oper.peek()=='*') val.push(v1*v2);
                 if(oper.peek()=='/') val.push(v1/v2);
                 oper.pop();
                 //push
                 oper.push(ch);
                }
                if(ch=='*'||ch=='/'){
                    if(oper.peek()=='*'||oper.peek()=='/'){
                 int v2 = val.pop();
                 int v1 = val.pop();
                 if(oper.peek()=='*') val.push(v1*v2);
                 if(oper.peek()=='/') val.push(v1/v2);
                 oper.pop();
                 //push
                 oper.push(ch); 
                    }
                    else oper.push(ch);
                }
            }
        }
        //val stack size sjould be 1
        while (val.size()>1) {
            int v2 = val.pop();
            int v1 = val.pop();
            if(oper.peek()=='-') val.push(v1-v2);
            if(oper.peek()=='+') val.push(v1+v2);
            if(oper.peek()=='*') val.push(v1*v2);
            if(oper.peek()=='/') val.push(v1/v2);
            oper.pop();
        }
        System.out.println(val.peek());
    }
}
