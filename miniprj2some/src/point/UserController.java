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
	
	//추후 파일을 DB연결로 대체, 변수 등 수정예정
	
	private String path = "C:\\dev\\user.txt";
	private File f = new File(path); 
	public Scanner sc = new Scanner(System.in);
	private int cnt = 0;
	
	public String[] inputUser() {
		
		System.out.print("성함 : ");
		String id = sc.nextLine().trim();
		System.out.print("전화번호 : ");
		String pwd = sc.nextLine().trim(); 
		
		return new String[] {id,pwd};
	}
	
	
	public void joinUser() {
		
		
		// 회원가입 메소드. 결제 화면에서 회원가입을 입력하거나,
		// 로그인 3회 이상 실패한 경우 연결한다.
		// 추후 파일을 DB로, 모든 스트링을 입력받는 이름과 전화번호 부분을
        // 각각 2~4글자 문자열과 8글자의 숫자만 받을 수 있도록, 중복없이 기입 및 사용 하는게 목표
		
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("쓰레드에 일시적인 예외가 발생하였습니다.");
		}
		
		System.out.println("========================");
		System.out.println("=====회원가입====");
		System.out.println("고객님의 회원가입을 진행하도록 하겠습니다.");
		System.out.println("고객님의 성함과 휴대폰 번호 8자리를 입력해주시길 바랍니다.");
		
		String[] strArr = inputUser();
		
		String id = strArr[0];
		String pwd = strArr[1];
		
		if(id.contains("/")||pwd.contains("/")) {
			System.out.println("잘못된 접근입니다.");
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
			System.out.println("예외 발생!!!");
		} finally {
			try {bw.close();} catch (IOException e) {
				System.out.println("클로즈 에러 발생!!");
			}
		}
		
		System.out.println("================");
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("회원가입 이용 중 예외가 발생하였습니다.");
			joinUser();
		}
		System.out.println("회원가입이 완료되었습니다.");
		System.out.println("3초 뒤 로그인 화면으로 넘어갑니다.");
		try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("로그인 화면으로 이동 중 예외가 발생하였습니다.");
			login();
		}
		login();
	}
	
	public void login() {
		
		//로그인 메소드, 결제 화면에서 넘어온다.
		// 추후 파일을 DB로, 모든 스트링을 입력받는 이름과 전화번호 부분을
        // 각각 2~4글자 문자열과 8글자의 숫자만 받을 수 있도록, 중복없이 기입 및 사용 하는게 목표
		
		
		// 현재 로그인 성공 출력이 2회 이상 출력되는 현상이 발견됨, 주석 부분에 이동할 메소드 작성 시
		// 해당 증상 없어짐
		
		
		System.out.println("========================");
		System.out.println("=========로그인=========");
		System.out.println("로그인 할 ID, PWD 입력하세요");
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
				System.out.println(dataId + " 님 로그인 성공했습니다.");
				isLoginSuccess = true;
				
				
				
				// 이동할 메소드 적기
			}
			
			}
			if(!isLoginSuccess) {
					System.out.println("로그인 실패하였습니다. ");
					System.out.println("다시 입력해주시길 바랍니다.");
					cnt++;
					if (cnt == 3) {
						
					System.out.println("로그인에 3회 실패하였습니다.");
					System.out.println("3초 뒤 회원가입 페이지로 이동합니다.");
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
			System.out.println("예외 발생!!");
			} catch (IOException e1) {
			System.out.println("입출력 예외 발생!!");
			} catch (InterruptedException e) {
				System.out.println("예외 발생!!!");
			}
		
		}
	
	}

