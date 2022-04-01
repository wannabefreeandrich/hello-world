import java.util.Scanner;

public class CalculatorEx {
	static boolean flag; // 반복문처리할 변수
	int sign; // 전역변수 연산자 기호 번호 1) 덧셈...
	int[] number; // 연산할 숫자 변수
	int numberCount; // 입력할 숫자 개수

	public static void main(String[] args) {
		// 순차적으로 계산프로그램을 지시하는 부분
		CalculatorEx cal = new CalculatorEx();
		// 반복문 언제 참? 1,2,3이면 참, 4이면 거짓
		System.out.println(cal.toString()+"참조변수");

		flag = true;
		while (flag) {
			int menuNumber = cal.MenuScreen();
//		System.out.println(menuNumber + "메모 번호 임시 출력하는 것");
			// menuNumber가 1이면 numberInput()호출 2이ㅣ면 operationInput()
			// 3이면 calcuResult() 4이면 exit()
			if (menuNumber == 1) {
				cal.numberInput();
			} else if (menuNumber == 2) {
				cal.operationInput();
			} else if (menuNumber == 3) {
				cal.calcuResult();
			} else if (menuNumber == 4) {
				cal.exit();
			} else {
				System.out.println("번호가 틀렸습니다.");
			} // end if
		} // end while
	} // end main

	// 첫번째 화면이 나오는 메소드
	public int MenuScreen() {
		System.out.println("======= 계산기 프로젝트 ========");
		System.out.println("개발자 : 본인성명 ");
		System.out.println("개발일 : 2022.04.01");
		System.out.println("프로그램명 : Cal.Ver.1.0");
		System.out.println("============================");
		System.out.println("1. 계산할 숫자의 개수");
		System.out.println("2. 연산의 종류");
		System.out.println("   1) 덧셈 2) 뺄셈 3) 곱셈 4) 나눗셈 ");
		System.out.println("3. 계산된 답");
		System.out.println("4. 프로그램 종료");
		System.out.println("----------------------------");
		System.out.println("번호를 고르시오");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		return choice;
	}

	// 1번을 누르면 나오는 화면 계산할 숫자를 입력하시오
	public void numberInput() {
		System.out.println("계산할 숫자의 개수를 입력하시오");
		Scanner scanner = new Scanner(System.in); // 키보드로 입력하는 클래스
		numberCount = scanner.nextInt(); // 예 3을 입력함
		int i = 0;
		number = new int[5]; // 배열

		while (i < numberCount) { // 0 < 3 참 1 < 3 참 2 < 3 참 3 < 3 거짓
			// 참이면 이것을 실행한다.
			System.out.println("숫자는? ");
			number[i] = scanner.nextInt(); // 10 20 30
			i = i + 1; // 1 i++
		}
		/*
		 * while(조건문){ / 참이면 수행하는 부분 } 거짓이면 반복하지 않고 반복문의 뒤로 감
		 */
	}

	// 2번을 누르면 나오는 화면 연산 종류를 고르는 화면
	public void operationInput() {
		System.out.println("--------- 연산의 종류를 고르세요 ----------");
		System.out.println("1) 덧셈 2) 뺄셈 3) 곱셈 4) 나눗셈 ");
		System.out.println("연산의 종류는 ---------->");
		Scanner scanner = new Scanner(System.in);
		sign = scanner.nextInt();
		/*
		 * 생각 sign 변수안의 자료는 지금 함수 속에서만 있어야 할까? =no 아니면 다른 함수에서도 사용해야 할까? = yes 해결 방법은?
		 * 1) 전역변수로 사용 2) 함수끼리 값을 주고 받는다 -- 전역변수가 있고 지역변수가 있으면 지역변수를 우선적으로 받고, 없는경우 전역변수를 받는다
		 */

	}

	// 3번을 누르면 나오는 화면 계산된 결과가 나오는 화면
	public void calcuResult() {
		// 10 20 30 1	number[0] + number[1] + number[2]
		// 10 20 2		number[0] - number[1]
		// 10 20 3		number[0] * number[1]
		// 10 20 4		number[0] / number[1] / number[1] 10/4 = 2.5? double
		System.out.println("--------계산된 결과-----------");
		// 반복문 안에 + - * / 판단       
		// 반복문의 개수는 numberCounter 변수안에 들어있는 숫자와 같다.
		int result = 0; // 연산된 값을 담을 변수
		double divResult = 0.0; // 나눗셈의 결과를 담을 변수
		
		for(int i=0; i < numberCount; i++) { // 0<3 i++ = i+1
			// 1<3 참 2<3 참 3<3 거짓
			// 참이면 수행
			if(sign == 1) {
				System.out.print(number[i] + " "); // 10 + 20 + 30
				if(i+1 != numberCount) { // 0+1 != 3 참 ,  1+1 != 3 참 ,  2+1 != 3 거짓
					System.out.print(" + ");
				}
				result = result + number[i]; // 0+10+20+30
				
			}else if(sign == 2) {
				
				if(i==0) {
					result = number[i]; // 10
				}else {
					result= result - number[i];
				}
				System.out.print(number[i] + " "); // 10 - 20 = -10
				if(i+1 != numberCount) {
					System.out.print(" - ");
				}
				result = result - number[i]; // 0-10-20 = -30
				
			}else if(sign == 3) { // ex) 10 * 20 * 30 = 6000
				if(i == 0) {
					result = number[i];
				}else {
					result = result * number[i];
				}
				System.out.print(number[i] + " ");
				if(i+1 != numberCount) {
					System.out.print(" * ");
				}
			}else if(sign == 4) { // ex) 10 / 20 / 30 = 0.254
				if(i == 0) {
					divResult = number[i];
				}else {
					divResult = divResult / number[i];
				}
				System.out.print(number[i] + " ");
				if(i+1 != numberCount) {
					System.out.print(" / ");
				}
			}
		}
		// for 반복문 형식
		/* for(초기값 ; 조건식 ; 증감식){
		 * 		조건식이 참이면 수행할 문장
		 * 	}
		 * 처리순서 초기값 수행 -> 조건식 조건이 참이면 수행문장 실행 --> 증감식
		 * 					-> 
		 */
		if(sign == 4) {
			System.out.printf("%s %.2f", " = " + divResult); // 소수점 2자리까지만
		}else {
		System.out.println( " = " + result);
	}
	}
	// 4번을 누르면 나오는 화면
	public void exit() {
		System.out.println("계산기 프로그램을 종료합니다");
		System.out.println("감사합니다");
		flag = false;
	}
}
