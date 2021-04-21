package com.github.firsthomework;

public class ToTextConvertion {
    public String convert(long a) {
        if (a < 0 || a > 999) throw new IllegalArgumentException("Число от 0 до 999");
        StringBuilder result = new StringBuilder();
        result.append(hundreds(a));
        result.append(decades(a));
        result.append(numbers(a));
        return result.toString();
    }

    public String convertExtended(long a) {
        if(a<0||a>999999999999L) {throw new IllegalArgumentException("Число не в диапазоне");}
        if(a==0) return "Ноль";
        long a1 = a / 1000000000;
        long a2 = a % 1000000000 / 1000000;
        long a3 = a % 1000000 / 1000;
        long a4 = a % 1000;
        StringBuilder result = new StringBuilder();
        result.append(convert(a1));
        result.append(addMilliards(convert(a1)));
        result.append(convert(a2));
        result.append(addMillions(convert(a2)));
        result.append(convert(a3).replaceAll("один", "одна").replaceAll("два", "две"));
        result.append(addThousands(convert(a3)));
        result.append(convert(a4));
        String res = Character.toUpperCase(result.charAt(0)) + result.substring(1);
        return res.trim();
    }

    public String addThousands(String a) {
        String k = a.split(" ")[a.split(" ").length - 1].toLowerCase();
        switch (k) {
            case "":
                break;
            case "один":
                k = " тысяча ";
                break;
            case "два":
            case "три":
            case "четыре":
                k = " тысячи ";
                break;
            default:
                k = " тысяч ";
                break;
        }
        return k;
    }

    public String addMilliards(String a) {
        String k = a.split(" ")[a.split(" ").length - 1].toLowerCase();
        switch (k) {
            case "":
                break;
            case "один":
                k = " миллиард ";
                break;
            case "два":
            case "три":
            case "четыре":
                k = " миллиарда ";
                break;
            default:
                k = " миллиардов ";
                break;
        }
        return k;
    }

    public String addMillions(String a) {
        String k = a.split(" ")[a.split(" ").length - 1].toLowerCase();
        switch (k) {
            case "":
                break;
            case "один":
                k = " миллион ";
                break;
            case "два":
            case "три":
            case "четыре":
                k = " миллиона ";
                break;
            default:
                k = " миллионов ";
                break;
        }
        return k;
    }

    public String decades(long a) {
        int k = (int) (a / 10) % 10;
        String result = new String();
        switch (k) {
            case 2:
                result = "двадцать ";
                break;
            case 3:
                result = "тридцать ";
                break;
            case 4:
                result = "сорок ";
                break;
            case 5:
                result = "пятьдесят ";
                break;
            case 6:
                result = "шестьдесят ";
                break;
            case 7:
                result = "семьдесят ";
                break;
            case 8:
                result = "восемьдесят ";
                break;
            case 9:
                result = "девяносто ";
                break;
        }
        return result;
    }

    public String numbers(long a) {
        int k = (int) a % 100;
        if (k >= 20) k = k % 10;
        String result = new String();
        switch (k) {
            case 1:
                result = "один";
                break;
            case 2:
                result = "два";
                break;
            case 3:
                result = "три";
                break;
            case 4:
                result = "четыре";
                break;
            case 5:
                result = "пять";
                break;
            case 6:
                result = "шесть";
                break;
            case 7:
                result = "семь";
                break;
            case 8:
                result = "восемь";
                break;
            case 9:
                result = "девять";
                break;
            case 10:
                result = "десять";
                break;
            case 11:
                result = "одинадцать";
                break;
            case 12:
                result = "двенадцать";
                break;
            case 13:
                result = "тринадцать";
                break;
            case 14:
                result = "четырнадцать";
                break;
            case 15:
                result = "пятнадцать";
                break;
            case 16:
                result = "шестнадцать";
                break;
            case 17:
                result = "семнадцать";
                break;
            case 18:
                result = "восемнадцать";
                break;
            case 19:
                result = "девятнадцать";
                break;
        }
        return result;
    }

    public String hundreds(long a) {
        int k = (int) a / 100;
        String result = new String();
        switch (k) {
            case 1:
                result = "сто ";
                break;
            case 2:
                result = "двести ";
                break;
            case 3:
                result = "триста ";
                break;
            case 4:
                result = "четыреста ";
                break;
            case 5:
                result = "пятьсот ";
                break;
            case 6:
                result = "шестьсот ";
                break;
            case 7:
                result = "семьсот ";
                break;
            case 8:
                result = "восемьсот ";
                break;
            case 9:
                result = "девятьсот ";
                break;
        }
        return result;
    }
}
