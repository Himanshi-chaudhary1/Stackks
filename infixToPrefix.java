package Stackks;
import java.util.Stack;

public class infixToPrefix {
    public static void main(String[] args) {
    String infix ="9-(5+3)*4/6";
    System.out.println(infix);
        Stack<String> val = new Stack<>();
        Stack<Character> oper = new Stack<>();
        for(int i= 0;i<infix.length();i++){
            char ch = infix.charAt(i);
            int ascii = (int)ch;
            //'0' = 48 and '9'= 57
            if(ascii>=48 && ascii<=57){
               String s = " "+ch;
               val.push(s);
            }
            else if(oper.size()==0 || ch =='('|| oper.peek()=='('){
                oper.push(ch);
            }
            else if(ch==')'){
                while (oper.peek()!='(') {
                    //work
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = oper.pop();
                    String t = o +v1+v2;
                    val.push(t);
                }
                oper.pop();//'('hta diya
            }
            else{
                if(ch =='+' || ch=='-'){
                 //work
                 String v2 = val.pop();
                 String v1 = val.pop();
                 char o = oper.pop();
                 String t = o +v1+v2;
                 val.push(t);
                 //push
                oper.push(ch);
                }
                if(ch=='*'||ch=='/'){
                    if(oper.peek()=='*'||oper.peek()=='/'){
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char o = oper.pop();
                        String t = o +v1+v2;
                        val.push(t);
                 //push
                 oper.push(ch); 
                    }
                    else oper.push(ch);
                }
            }
        }
        //val stack size sjould be 1
        while (val.size()>1) {
            String v2 = val.pop();
            String v1 = val.pop();
            char o = oper.pop();
            String t = o +v1+v2;
            val.push(t);
        }
        String prefix = val.pop();
        System.out.println(prefix);
    }
}
