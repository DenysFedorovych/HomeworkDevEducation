package com.github.firsthomework;

public class Cycles {
    public static int sumOfEvenNumber(){
            int sum=0;
            for(int i=2;i<100;i+=2){
                sum+=i;
            }
            return sum;
    }

    public static boolean isPrime(int a){
        a = Math.abs(a);
        for(int i=2;i<=Math.sqrt(a);i++){
            if(a%i==0) return false;
        }
        return true;
    }

    public static int squareRootSimple(int a){
        if(a<0) throw new IllegalArgumentException("Only positive numbers");
        for(int i=0;i<=a;i++){
            if(i*i>a) return i-1;
            else{
                if(i*i==a) return i;
            }
        }
        return 0;
    }

    public static int squareRootBinary(int a){
        if(a<0) throw new IllegalArgumentException("Only positive numbers");
        int min=0;
        int max=a+1;
        int mid=0;
        while(max-min>1){
            mid = (min+max)/2;
            if(mid*mid>a) max = mid;
            else min = mid;
        }
        return min;
    }

    public static int factorial(int a){
        if(a<0) throw new IllegalArgumentException("Only positive numbers");
        int result=1;
        for(int i=2;i<=a;i++) result*=i;
        return result;
    }

    public static int sumOfNumbers(int a){
        a = Math.abs(a);
        int sum=0;
        while(a!=0){
            sum+=a%10;
            a/=10;
        }
        return sum;
    }

    public static int reverseNumber(Integer a){
        StringBuilder number = new StringBuilder(a.toString());
        number.reverse();
        return Integer.parseInt(number.toString());
        // Пример с числом, заканчивающимся на 0, все еще будет решен абсолютно зеркально, хотя обрезать
        // эти нули вначале несложно, но нужно ли - этого я, так-то, не знаю ¯\_(ツ)_/¯
    }

}
