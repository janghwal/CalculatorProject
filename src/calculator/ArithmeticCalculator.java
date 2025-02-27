package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class ArithmeticCalculator {
    //계산 결과 저장
    private ArrayList<CalculationResult> calculationResults = new ArrayList<>();

    //생성자
    public ArithmeticCalculator(int mode){
        //일반(사칙연산) 계산기, 공학용 계산기 만들기
        if (mode == 1) {
            this.start();
        }
        else {

        }
    }

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

                }else{

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
            System.out.println(i+". "+result.expression+" = "+result.result);
            i++;
        }
    }
}
