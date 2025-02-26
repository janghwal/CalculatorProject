package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    private ArrayList<String> resultList = new ArrayList<>();
    private Integer num1 = null, num2 = null;
    private String operator = null;
    private StringBuilder sb = new StringBuilder();

    public void start(){
        Scanner scan = new Scanner(System.in);

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
    }

    public void getResult(int num){
        try{
            System.out.println(num-1+"번째 기록: "+resultList.get(num));
        }catch(IndexOutOfBoundsException e){
            System.out.println("해당 값이 없습니다.");
        }
    }

    public void getResultAll(){
        if (!resultList.isEmpty()) {
            int i = 1;
            for(String result : resultList){
                System.out.println(i+"번째 기록: "+result);
                i++;
            }
        }else{
            System.out.println("저장된 값이 없습니다..");
        }
    }

    public void deleteAllResults(){
        resultList.clear();
    }

    public void deleteOldResults(){
        resultList.subList(0, 1).clear();
    }

}


