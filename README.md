# CalculatorProject
## App
  * Main


## ArithmeticCalculator
* calculationResults

  * 계산 결과를 저장하는 ArrayList


* start()
  
  * showMainMenu()를 호출
  * 계산기 사용, 계산 기록 확인, 종료하기, 모든 기록 확인, 기록 삭제, 필터링으로 분기
 
* showMainMenu()

  * 메인 매뉴를 보여주고 숫자를 입력받아 start()에 전달한다.
  *     1. 계산기 사용           2. 계산 기록 확인하기           3. 종료하기
 
* showRecordMenu()

  * 계산 기록 확인하기 매뉴를 보여주고 숫자를 입력받아 start()에 전달한다.
  *      1. 기록 확인하기          2. 기록 삭제하기            3. 기록 필터링
 
* calculate()

  * 사용자로부터 숫자를 입력받아 계산하고, 계산 결과를 리스트에 저장한다.
  * 사용자의 입력에 따라 처음 2가지로 분기한다. try catch 사용
    1. 숫자일경우
 
     
        *   첫번째 숫자가 비어 있을 경우 첫번째 숫자로 사용
        *   첫번째 숫자가 있을 경우 연산자 유무 확인 연산자가 있을 경우 두번째 숫자로 사용하고 없을 경우 첫번째 숫자 교체
        *   두번째 숫자가 입력 될 경우 연산자에 맞는 함수(add, subtract, multiply, divide) 호출 하여 계산 및 calculationResults에 저장
    2. 숫자가 아닐 경우
   

        * 연산자인지 확인 연산자가 아닐 경우 "숫자 혹은 연산자를 입력해주세요" 문구 출력 후 재입력 대기
        * 연산자일 경우 첫번째 숫자 유무 확인 첫번째 숫자 없을 경우 첫번째 숫자에 0 저장 후 연산자에 입력받은 연산자 저장
        * 첫번째 숫자 있을 경우 연산자 유무 확인 연산자 있을 경우 연산자 교체
        * 연산자 없을 경우 연산자에 저장
      


* add, subtract, multiply, divide
  * 입력 받아서 계산한 후 Integer 혹은 Double 타입으로 반환
  * divide에서 0으로 나눌 경우 예외처리 하였다.
 
* recordResult()
  * 입력 받은 수식과 답을 calculationResults에 저장한다.
 
* printAllResult()
  * 모든 기록을 보여준다. 향상된 for문 사용
 
* printResult()
  * 계산 직후 값을 보여준다. 마지막 값 출력
 
* deleteAllResult()
  * 모든 계산 기록 삭제
 
* filterResult()
  * 사용자로부터 값을 입력받아 그 값보다 계산 결과가 큰 값들을 보여준다.
  * stream 사용
  
  


## CalculationResult
  * 자료형을 구조체와 같이 사용하기 위해 넣은 클래스
  * 제네릭 사용하여 integer일 경우와 double일 경우 모두 저장할 수 있도록 하였다.
  * String 타입과 제네릭 타입 변수를 가진다.






# troubleshooting
1. 제네릭을 사용하여 받는 입력에 따라 변하는 타입을 만들고 싶었지만 불가능했다.
   * String 타입으로 받은 후 Integer형 혹은 Double 형으로 변환하여 사용하였다.




