package point;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		UserController uc = new UserController();
		
		
		System.out.println("====����Ʈ �׽�Ʈ ���Դϴ�. 1���� ����, 2���� �α����Դϴ�. ====");
		
		int num = sc.nextInt();
		
		if(num==1) {
			System.out.println("ȸ������ ȭ������ �̵��մϴ�.");
			Thread.currentThread().sleep(1000);
			uc.joinUser();
		}
		
		if(num==2) {
			System.out.println("�α��� ȭ������ �̵��մϴ�.");
			Thread.currentThread().sleep(1000);
			uc.login();
		}

	}

}
