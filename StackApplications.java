import java.util.*;
class Applications
{
	public static boolean ValidParanthesis(String paranthesis)
	{
	
		 Stack<Character> st = new Stack<Character>();
	        int i;char val;
	        for(i=0; i<paranthesis.length(); i++)
	        {
	            val=paranthesis.charAt(i);
	            
	            if(val == '('|| val=='[' ||val=='{')
	                st.add(val);
	            
	            else 
	            {
	                if(st.isEmpty())
	                    return false;
	                
	                else if(val == ')' ){
	                   if(st.peek()=='(')
	                      st.pop();
	                   else
	                       return false;
	             
	                      }
	           else if(val == '}' ){
	                if(st.peek()=='{')
	                    st.pop();
	               else
	                       return false;
	             
	            }
	            else if(val == ']' ){
	                if(st.peek()=='[')
	                    st.pop(); 
	                else
	                       return false;
	             
	                 }
	            }
	            
	                 }
	        if(st.isEmpty())
	            return true;
	        else
	            return false;
	}
	public static int Prec(char ch)
	{
		switch (ch) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
	}
	public static void InfixtoPostfix(String expr)
	{
		    int i;
			String result = new String("");
            Stack<Character> st = new Stack<Character>();

				for ( i = 0; i < expr.length(); ++i) {
					char ch = expr.charAt(i);
					if (Character.isLetterOrDigit(ch))
						result += ch;
					else if (ch == '(')
						st.push(ch);
					else if (ch == ')') {
						while (!st.isEmpty() && st.peek() != '(') {
							result += st.peek();
							st.pop();
						}
                      if(!st.isEmpty())
						st.pop();
					}
					else					{
						while (!st.isEmpty() && Prec(ch) <= Prec(st.peek())) {

							result += st.peek();
							st.pop();
						}
						st.push(ch);
					}
				}
				while (!st.isEmpty()) {
					if (st.peek() == '(') {
						System.out.println("Invalid Expression");return;}
					result += st.peek();
                    if(!st.isEmpty())
					st.pop();
				}
			
				System.out.println(result);
			}

	public static int Postfixevaluation(String expr)
	{  
        int res=0; int i;
        Stack<Integer> st = new Stack();
        for(i=0; i<expr.length(); i++)
        {
            char ch= expr.charAt(i);
            if(Character.isDigit(ch)){
               st.push(ch-'0');
            }
            else 
            {
                int v1=st.pop();
                int v2=st.pop();
                switch(ch)
                {
                    case '+':
                        st.push(v1+v2);
                        break;
                    case '-':
                        st.push(v2-v1);
                        break;
                    case '*':
                        st.push(v1*v2);
                        break;
                    case '/':
                        st.push(v2/v1);
                        break;
                }
            }
        }
        res=st.pop();
        return res;
    }
}
public class StackApplications {
	
	public static void main(String args[])
	{
		Applications obj = new Applications();
		Scanner sc = new Scanner(System.in);
		String paranthesis="";
		String itop="";
		String pe="";
		System.out.println("Enter the paranthsesis string");
		paranthesis = sc.nextLine();
		System.out.println("Enter the infixtopostfix conversion string");
		itop = sc.nextLine();
		System.out.println("Enter the postfix evaluation string");
		pe = sc.nextLine();
		boolean isvalidd= obj.ValidParanthesis(paranthesis);
		int result =obj.Postfixevaluation(pe);
		obj.InfixtoPostfix(itop);
	}

}
