//a simple java code to permute two variables in an optimized way
public class SimplePermut{
public static void main (String[] args){
//initial values:
int x = 0;
int y = 1;
//cheap and fast swapping:
x = x ^ y;
y = x ^ y;
x = x ^ y;
//yields: x = 1 and y = 0

//Thanks for your time!
}
}
