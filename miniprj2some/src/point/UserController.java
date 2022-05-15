package point;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserController {
	
	//���� ������ DB����� ��ü, ���� �� ��������
	
	private String path = "C:\\dev\\user.txt";
	private File f = new File(path); 
	public Scanner sc = new Scanner(System.in);
	private int cnt = 0;
	
	public String[] inputUser() {
		
		System.out.print("���� : ");
		String id = sc.nextLine().trim();
		System.out.print("��ȭ��ȣ : ");
		String pwd = sc.nextLine().trim(); 
		
		return new String[] {id,pwd};
	}
	
	
	public void joinUser() {
		
		
		// ȸ������ �޼ҵ�. ���� ȭ�鿡�� ȸ�������� �Է��ϰų�,
		// �α��� 3ȸ �̻� ������ ��� �����Ѵ�.
		// ���� ������ DB��, ��� ��Ʈ���� �Է¹޴� �̸��� ��ȭ��ȣ �κ���
        // ���� 2~4���� ���ڿ��� 8������ ���ڸ� ���� �� �ֵ���, �ߺ����� ���� �� ��� �ϴ°� ��ǥ
		
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("�����忡 �Ͻ����� ���ܰ� �߻��Ͽ����ϴ�.");
		}
		
		System.out.println("========================");
		System.out.println("=====ȸ������====");
		System.out.println("������ ȸ�������� �����ϵ��� �ϰڽ��ϴ�.");
		System.out.println("������ ���԰� �޴��� ��ȣ 8�ڸ��� �Է����ֽñ� �ٶ��ϴ�.");
		
		String[] strArr = inputUser();
		
		String id = strArr[0];
		String pwd = strArr[1];
		
		if(id.contains("/")||pwd.contains("/")) {
			System.out.println("�߸��� �����Դϴ�.");
		}
		
		String path = "C:\\dev\\user.txt";
		File f = new File(path);
		
		BufferedWriter bw = null;
		try {
			bw =  new BufferedWriter(new FileWriter(f,true)); 
			bw.write(id);
			bw.write("/");
			bw.write(pwd);
			bw.write("\n");
			bw.flush();
		} catch (IOException e) {
			System.out.println("���� �߻�!!!");
		} finally {
			try {bw.close();} catch (IOException e) {
				System.out.println("Ŭ���� ���� �߻�!!");
			}
		}
		
		System.out.println("================");
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("ȸ������ �̿� �� ���ܰ� �߻��Ͽ����ϴ�.");
			joinUser();
		}
		System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
		System.out.println("3�� �� �α��� ȭ������ �Ѿ�ϴ�.");
		try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("�α��� ȭ������ �̵� �� ���ܰ� �߻��Ͽ����ϴ�.");
			login();
		}
		login();
	}
	
	public void login() {
		
		//�α��� �޼ҵ�, ���� ȭ�鿡�� �Ѿ�´�.
		// ���� ������ DB��, ��� ��Ʈ���� �Է¹޴� �̸��� ��ȭ��ȣ �κ���
        // ���� 2~4���� ���ڿ��� 8������ ���ڸ� ���� �� �ֵ���, �ߺ����� ���� �� ��� �ϴ°� ��ǥ
		
		
		// ���� �α��� ���� ����� 2ȸ �̻� ��µǴ� ������ �߰ߵ�, �ּ� �κп� �̵��� �޼ҵ� �ۼ� ��
		// �ش� ���� ������
		
		
		System.out.println("========================");
		System.out.println("=========�α���=========");
		System.out.println("�α��� �� ID, PWD �Է��ϼ���");
		String[] strArr = inputUser();
		
		String id = strArr[0];
		String pwd = strArr[1];
		
		try (BufferedReader br = new BufferedReader(new FileReader(f))){
			
			
			boolean isLoginSuccess = false;
			
			while (true) {
			String data = br.readLine(); 
			
			if(data == null) {
				break;
			}
			
			int index = data.indexOf('/'); 
			String dataId = data.substring(0, index);
			String dataPwd = data.substring(index+1);

			
			if(id.equals(dataId) && pwd.equals(dataPwd)) {
				System.out.println(dataId + " �� �α��� �����߽��ϴ�.");
				isLoginSuccess = true;
				
				
				
				// �̵��� �޼ҵ� ����
			}
			
			}
			if(!isLoginSuccess) {
					System.out.println("�α��� �����Ͽ����ϴ�. ");
					System.out.println("�ٽ� �Է����ֽñ� �ٶ��ϴ�.");
					cnt++;
					if (cnt == 3) {
						
					System.out.println("�α��ο� 3ȸ �����Ͽ����ϴ�.");
					System.out.println("3�� �� ȸ������ �������� �̵��մϴ�.");
					Thread.currentThread().sleep(3000);
					joinUser();
				}
					else if (cnt <3) {
						login();
					}
					
					else {
						System.out.println("asd");
					}
			
			}
			
			}
			catch (FileNotFoundException e) {
			System.out.println("���� �߻�!!");
			} catch (IOException e1) {
			System.out.println("����� ���� �߻�!!");
			} catch (InterruptedException e) {
				System.out.println("���� �߻�!!!");
			}
		
		}
	
	}

