package calculator;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scan = new Scanner(System.in);

        mainRoop:
        while(true){
            System.out.println("========================================================================");
            System.out.println("1. 계산기 사용           2. 계산 기록 확인하기           3. 종료하기");
            System.out.println("========================================================================");
            int selectedAction = scan.nextInt();
            System.out.println("========================================================================");
            switch(selectedAction){
                case 1:
                    calculator.start();
                    break;
                case 2:
                    System.out.println("1. 기록 확인             2. 모든 기록 확인하기          3.기록 삭제");
                    int selectedRecord = scan.nextInt();
                    if(selectedRecord == 1){
                        System.out.print("기록 번호를 선택하세요 (예: 1, 2, 3):");
                        calculator.getResult(scan.nextInt());
                    }else if(selectedRecord == 2){
                        calculator.getResultAll();
                    }else if(selectedRecord == 3){
                        calculator.deleteOldResults();
                    }
                    break;
                case 3:
                    System.out.println("프로그램이 종료 됩니다.");
                    break mainRoop;
                default:
                    System.out.println("기능 번호를 선택하세요 (예: 1, 2, 3)");
                    break;
            }
        }
    }
}
