package calculator;

import java.util.*;

public class App {
    public static void main(String[] args) {
        System.out.println( "Calculator Project");
        //계산 결과가 저장될 창고
        ArrayList<String> list = new ArrayList<>();
        Integer num1 = null, num2 = null;
        String operator = null;
        StringBuilder sb = new StringBuilder();

        while(true){
            String first = stringCheck();
            try{
                if(operator == null){
                    num1 = Integer.parseInt(first);
                    sb.setLength(0);
                    sb.append(first);
                }else{
                    num2 = Integer.parseInt(first);
                    num1 = calc(num1, num2);
                    operator = null;
                    sb.append(first).append("=").append(String.valueOf(num1));
                    System.out.println(sb);
                    sb.setLength(0);
                    sb.append(num1);
                }
            }catch(NumberFormatException e){
                if(num1 == null){
                    num1 = 0;
                    operator = first;
                    sb.append("0").append(operator);
                }else{
                    operator = first;
                    sb.append(operator);
                }
            }
        }
    }

    //사용자로부터의 입력 exit 일 경우 종료
    public static String stringCheck(){
        Scanner scan = new Scanner(System.in);
        String returnString = scan.nextLine();
        if(returnString.equals("exit")){
            System.exit(0);
        }
        return returnString;
    }

    public static int calc(int num1, int num2){
        System.out.println(num1+num2);
        return num1+num2;
    }
}
