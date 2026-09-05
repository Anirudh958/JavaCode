import java.util.*;
public class pow_recursion{

public static double pow_recursion(double base,int exponent){
    if(exponent==0){
        return 1;
    }
    double halfPow=pow_recursion(base,exponent/2);

    if(exponent%2==0){
        return halfPow*halfPow;
    }
    else{
        if(exponent>0){
            return base*halfPow*halfPow;
        }
        else{
            return (halfPow*halfPow)/base;
        }
    }
}
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the base number");
        double base=scanner.nextDouble();
        System.out.println("Enter the exponent number");
        int exponent=scanner.nextInt();
        double result=pow_recursion(base,exponent);
        System.out.println("The result is: "+result);
    }
}