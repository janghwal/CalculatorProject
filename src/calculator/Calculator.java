package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    //모든 계산 결과를 저장할 리스트
    private ArrayList<String> resultList = new ArrayList<>();
    //연산에 사용 할 두개의 숫자
    private Integer num1 = null, num2 = null;
    //연산에 사용되는 연산자
    private String operator = null;
    //리스트에 넣기 전 저장되는 버퍼
    private StringBuilder sb = new StringBuilder();

    //시작 매서드
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

    //하나의 값을 가져오는 함수
    public void getResult(int num){
        try{
            System.out.println(num+"번째 기록: "+resultList.get(num-1));
        }catch(IndexOutOfBoundsException e){
            System.out.println("해당 값이 없습니다.");
        }
    }

    //모든 결과 값을 가져오는 함수
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

    //저장된 값을 모두 지운다.
    public void deleteAllResults(){
        resultList.clear();
    }

    //가장 오래된 값을 하나 지운다.
    public void deleteOldResults(){
        resultList.subList(0, 1).clear();
    }

}


