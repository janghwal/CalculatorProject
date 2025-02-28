package calculator;

import java.util.*;
import java.util.stream.Collectors;

import static calculator.OperatorType.ADD;

public class ArithmeticCalculator {
    //계산 결과 저장
    private ArrayList<CalculationResult> calculationResults = new ArrayList<>();

    public void start(){
        int selectedMainAction;
        while(true){
            selectedMainAction = this.showMainMenu();
            if(selectedMainAction == 1){ //계산기 사용
                this.calculate();
            } else if ( selectedMainAction == 2) { // 계산 기록 확인하기 + 필터링
                int selectedRecordAction= showRecordMenu();
                if(selectedRecordAction == 1) { //계산기 사용
                    this.printAllResult();
                }else if(selectedRecordAction == 2){
                    deleteAllResult();
                }else{
                    filterResult();
                }
            } else { // 프로그램 종료
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }

    public int showMainMenu(){
        Scanner scan = new Scanner(System.in);
        int selectedAction;
        System.out.println("========================================================================");
        System.out.println("1. 계산기 사용           2. 계산 기록 확인하기           3. 종료하기");
        System.out.println("========================================================================");
        try{
            selectedAction = scan.nextInt();
            return selectedAction;
        }catch(Exception e){
            System.out.println("숫자를 입력해 주세요. 예:(1, 2, 3)");
            this.showMainMenu();
        }
        return 0;
    }

    public void calculate(){
        Scanner scan = new Scanner(System.in);
        System.out.println("========================================================================");
        StringBuilder stringBuf = new StringBuilder();
        Number num1 = null, num2;
        OperatorType operator = null;

        activeRoop:
        while(true){
            String input = scan.nextLine();
            if(input.equals("exit")) {
                break;
            }
            try{
                if(operator == null){
                    num1 = Double.parseDouble(input);
                    stringBuf.setLength(0);
                    stringBuf.append(input).append(" ");;
                }else{
                    num2 = Double.parseDouble(input);
                    switch(operator){
                        case ADD:
                            num1 = this.add(num1, num2);
                            break;
                        case SUBTRACT:
                            num1 = this.subtract(num1, num2);
                            break;
                        case MULTIPLY:
                            num1 = this.multiply(num1, num2);
                            break;
                        case DIVIDE:
                            try{
                                num1 = this.divide(num1, num2);
                            }catch(ArithmeticException e){
                                System.out.println("0으로 나눌 수 없습니다");
                                break activeRoop;
                            }
                            break;
                    }
                    operator = null;
                    stringBuf.append(input).append(" ");
                    this.recordResult(stringBuf.toString(), num1);
                    this.printResult();
                    System.out.println("========================================================================");
                    stringBuf.setLength(0);
                    stringBuf.append(num1).append(" ");;
                }
            }catch(NumberFormatException e){
                if (!(input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/"))) {
                    System.out.println("숫자 혹은 연산자를 입력해주세요");
                } else {
                    // OperatorType 열거형 값을 input에 맞게 설정
                    OperatorType operatorType = switch (input) {
                        case "+" -> OperatorType.ADD;
                        case "-" -> OperatorType.SUBTRACT;
                        case "*" -> OperatorType.MULTIPLY;
                        case "/" -> OperatorType.DIVIDE;
                        default -> null;
                    };

                    // operatorType을 사용하여 연산자 처리
                    if (num1 == null) {
                        num1 = 0;
                        operator = operatorType;  // operator에 OperatorType 값 할당
                        stringBuf.append("0").append(" ").append(operator.getSymbol());  // OperatorType의 기호 사용
                    } else if (operator != null) {
                        operator = operatorType;  // operator에 새 OperatorType 값 할당
                        stringBuf.delete(stringBuf.length() - 2, stringBuf.length());  // 마지막 연산자 제거
                        stringBuf.append(operator.getSymbol()).append(" ");  // 새 연산자 기호 추가
                    } else {
                        operator = operatorType;  // operator에 OperatorType 값 할당
                        stringBuf.append(operator.getSymbol()).append(" ");  // 연산자 기호 추가
                    }
                }
            }
        }
    }

    public <T extends Number> T add(T a, T b) {
        return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
    }

    // 뺄셈
    public <T extends Number> T subtract(T a, T b) {
        return (T) Double.valueOf(a.doubleValue() - b.doubleValue());
    }

    // 곱셈
    public <T extends Number> T multiply(T a, T b) {
        return (T) Double.valueOf(a.doubleValue() * b.doubleValue());
    }

    // 나눗셈
    public <T extends Number> T  divide(T a, T b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return (T) Double.valueOf(a.doubleValue() / b.doubleValue());
    }

    public void recordResult (String expression, Object result) {
        CalculationResult calcResultTemp = new CalculationResult(expression, result);
        calculationResults.add(calcResultTemp);
    }

    public int showRecordMenu(){
        Scanner scan = new Scanner(System.in);
        int selectedAction;
        System.out.println("========================================================================");
        System.out.println("1. 기록 확인하기          2. 기록 삭제하기            3. 기록 필터링");
        System.out.println("========================================================================");
        try{
            selectedAction = scan.nextInt();
            return selectedAction;
        }catch(Exception e){
            System.out.println("숫자를 입력해 주세요. 예:(1, 2, 3)");
            this.showMainMenu();
        }
        return 0;
    }

    public void printAllResult() {
        if (calculationResults.isEmpty()) {
            System.out.println("데이터가 없습니다.");
        }
        int i = 1;
        for(CalculationResult result : calculationResults){
            System.out.println(i+". "+result.expression+"= "+result.result);
            i++;
        }
    }

    public void printResult() {
        System.out.println(calculationResults.get(calculationResults.size()-1).expression + "= " + calculationResults.get(calculationResults.size()-1).result+"                   exit : 종료");
    }

    public void deleteAllResult() {
        calculationResults.clear();
    }

    public void filterResult() {
        Scanner scan = new Scanner(System.in);
        System.out.print("기준이 될 값을 입력하세요: ");

        double thresholdValue = scan.nextDouble();
        List<CalculationResult> ret = calculationResults.stream().filter(result -> {
            // 결과 값이 숫자일 경우만 처리
            if (result.result instanceof Number) {
                return ((Number) result.result).doubleValue() > thresholdValue;
            }
            return false;
        }).collect(Collectors.toList());

        if (ret.isEmpty()) {
            System.out.println("입력하신 값보다 큰 결과가 없습니다.");
        } else {
            System.out.println("입력하신 값보다 큰 계산 결과들:");
            for (CalculationResult result : ret) {
                System.out.println(result.expression + " = " + result.result);
            }
        }

    }
}
