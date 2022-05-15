package point;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		UserController uc = new UserController();
		
		
		System.out.println("====포인트 테스트 중입니다. 1번은 가입, 2번은 로그인입니다. ====");
		
		int num = sc.nextInt();
		
		if(num==1) {
			System.out.println("회원가입 화면으로 이동합니다.");
			Thread.currentThread().sleep(1000);
			uc.joinUser();
		}
		
		if(num==2) {
			System.out.println("로그인 화면으로 이동합니다.");
			Thread.currentThread().sleep(1000);
			uc.login();
		}

	}

}
