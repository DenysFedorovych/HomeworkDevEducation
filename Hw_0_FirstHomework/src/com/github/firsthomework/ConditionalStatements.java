package com.github.firsthomework;

public class ConditionalStatements {
    public static int sumOrMulti(int a, int b){
        if(a%2==0){
            return a*b;
        }
        else{
            return a+b;
        }
    }

    public static int pointAnalytics(int x, int y){
        if(x==0&&y==0){
            System.out.println("Точка  находится в центре координат");
            return 0;
        }
        if(x==0){
            System.out.println("Точка  находится на оси абсцисс");
            return 0;
        }
        if(y==0){
            System.out.println("Точка  находится на оси ординат");
            return 0;
        }
        if(x>0){
            if(y>0){return 1;}
            else{return 4;}
        }
        else{
            if(y<0){return 3;}
            else{return 2;}
        }
    }

    public static int sumOfPositive(int a, int b, int c){
        int sum=0;
        if(a>0){sum+=a;}
        if(b>0){sum+=b;}
        if(c>0){sum+=c;}
        return sum;
    }

    public static int resultOfEquation(int a, int b, int c){
        return Math.max(a*b*c,a+b+c)+3;
    }

    public static char studentGrade(int a){
        if(a>100||a<0){throw new IllegalArgumentException("Оценка должна быть от 0 до 100");}
        if(a>=0&&a<=19) return 'F';
        if(a>19&&a<=39) return 'E';
        if(a>39&&a<=59) return 'D';
        if(a>59&&a<=74) return 'C';
        if(a>74&&a<=89) return 'B';
        if(a>89) return 'A';
        return 0;
    }

}
