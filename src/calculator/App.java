package calculator;

import java.util.*;

public class App {
    public static void main(String[] args) {
        System.out.println( "Calculator Project");
        System.out.println( "exit : 종료");
        Scanner scan = new Scanner(System.in);
        //계산 결과가 저장될 창고
        ArrayList<String> resultList = new ArrayList<>();
        Integer num1 = null, num2 = null;
        String operator = null;
        StringBuilder sb = new StringBuilder();

        activeRoop:
        while(true){
            String input = scan.nextLine();
            if(input.equals("exit")){
                break;
            }
            try{
                if(operator == null){
                    num1 = Integer.parseInt(input);
                    sb.setLength(0);
                    sb.append(input);
                }else{
                    num2 = Integer.parseInt(input);
                    switch(operator){
                        case "+":
                            num1 = num1+num2;
                            break;
                        case "-":
                            num1 = num1-num2;
                            break;
                        case "*":
                            num1 = num1*num2;
                            break;
                        case "/":
                            try{
                                num1 = num1/num2;
                            }catch(ArithmeticException e){
                                System.out.println("0으로 나눌 수 없습니다");
                                break activeRoop;
                            }
                            break;
                    }
                    operator = null;
                    sb.append(input).append("=").append(String.valueOf(num1));
                    resultList.add(sb.toString());
                    System.out.println(resultList.get(resultList.size()-1)+"                   exit : 종료");
                    System.out.println("========================================================================");
                    sb.setLength(0);
                    sb.append(num1);
                }
            }catch(NumberFormatException e){
                if(!(input.equals("+")||input.equals("-")||input.equals("*")||input.equals("/"))) {
                    System.out.println("숫자 혹은 연산자를 입력해주세요");
                }else{
                    if(num1 == null){
                        num1 = 0;
                        operator = input;
                        sb.append("0").append(operator);
                    }else if(operator != null){
                        operator = input;
                        sb.deleteCharAt(sb.length() - 1);
                        sb.append(operator);
                    }
                    else{
                        operator = input;
                        sb.append(operator);
                    }
                }
            }
        }
//        컬렉션 사용 테스트
//        for (String result : resultList){
//            System.out.println(result);
//        }
    }
}
