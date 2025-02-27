package calculator;

import java.util.*;

public class App {
    public static void main(String[] args) {

        ArithmeticCalculator calculator = new ArithmeticCalculator(1);
//        Calculator calculator = new Calculator();
//        Scanner scan = new Scanner(System.in);
//
//        mainRoop:
//        while(true){//사용자 매뉴를 보여준다. 종료 전까지 반복
//            System.out.println("========================================================================");
//            System.out.println("1. 계산기 사용           2. 계산 기록 확인하기           3. 종료하기");
//            System.out.println("========================================================================");
//            int selectedAction = scan.nextInt();
//            System.out.println("========================================================================");
//            switch(selectedAction){
//                case 1:
//                    calculator.start();
//                    break;
//                case 2:
//                    System.out.println("1. 기록 확인             2. 모든 기록 확인하기          3.기록 삭제");
//                    int selectedRecord = scan.nextInt();
//                    if(selectedRecord == 1){
//                        System.out.print("기록 번호를 선택하세요 (예: 1, 2, 3):"); //이전 기록 중 하나를 선택해서 확인
//                        calculator.getResult(scan.nextInt());
//                    }else if(selectedRecord == 2){
//                        calculator.getResultAll();//이전 기록 전부를 확인
//                    }else if(selectedRecord == 3){
//                        calculator.deleteOldResults();//가장 오래된 기록 하나 삭제
//                    }
//                    break;
//                case 3:
//                    System.out.println("프로그램이 종료 됩니다.");
//                    break mainRoop;//프로그램 종료
//                default:
//                    System.out.println("기능 번호를 선택하세요 (예: 1, 2, 3)");
//                    break;//재 입력 받기
//            }
//        }
    }
}
