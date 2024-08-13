import java.util.Scanner;

public class Prime {
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();

        int n;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        primeCheck(n);
        long endTime = System.currentTimeMillis();
        System.out.println(startTime-endTime);

    }

    static void primeCheck(double a){
        int count =1;
        for(int i=2;i<=a-1;i++){
            if(a%i==0){
                count=0;
                break;
            }
            else {
                count++;
            }

        }
        if(count==0){
            System.out.println(a +" is not a prime number");
        }
        if(count>=1){
            System.out.println(a+" is a prime number");
        }
    }
}
