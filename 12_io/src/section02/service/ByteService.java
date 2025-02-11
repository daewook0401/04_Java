package section02.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ByteService {
	
	/* [Byte 기반 스트림]
	 * 
	 * - 1byte 단위로 데이터를 입/출력하는 스트림
	 * 
	 * - 최상위 클래스 : InputStream, OutputStream
	 * 
	 * - 입/출력 가능 데이터
	 * 	 문자열, 파일(이미지, 영상, 오디오, pdf 등 모든 파일)
	 * 
	 *  * 단, 2byte 범위 문자열이 깨질 수 있고
	 *  	좁은 통로(1byte)를 이용하다 보니 속도가 상대적으로 느림
	 *  
	 *  ***************************
	 *  Stream 객체는 Java 프로그램이 종료 되어도
	 *  외부 장치/파일/프로그램과의 연결이 유지되기 때문에
	 *  자동으로 사라지지 않는다
	 *  -> 프로그램 종료 전
	 *  	 Stream 객체의 메모리를 반환하는 close() 구문 필수
	 *  ***************************
	 */
	
	/**
	 * 지정된 경로에
	 * 파일 생성 + 내용 출력(파일 기반 바이트 스트림 이용)
	 */
	public void fileByteOutput() {
		
		// fos 참조 변수를 try, finally에서 모두 사용할 수 있게 선언
		FileOutputStream fos = null;
		try {
			// 폴더 경로, 파일명 지정
			String folderPath = "io_test/byte"; // 프로젝트폴더/io_test/byte 
			String fileName = "바이트기반테스트.txt";
			
			// 폴더가 없으면 생성
			File folder = new File(folderPath);
			
			if(!folder.exists()) {
				System.out.println("123");
				folder.mkdirs(); //폴더 생성
			}
			
			
			// 출력할 파일과 연결된 출력용 스트림 객체를 생성
			// -> 이 때, 해당 파일이 없으면 자동으로 생성됨.
			fos = new FileOutputStream(folderPath + "/" + fileName, false);
			
			/* StringBuilder : String의 불변성 문제를 해결하기 위한 객체 */
			StringBuilder builder = new StringBuilder();
			
			builder.append("Hello World!!\n");
			builder.append("1234567890\n");
			builder.append("!@#$%^&**(\n");
			builder.append("가나다라마바사\n");
			
			// StringBuilder에 저장된 내용을 String으로 변경
			String content = builder.toString();
			
			
			/* 연결된 외부 txt파일로 content 내용을 출력  */
			
			// 방법 1) 1byte씩끊어서 출력
			
//			for(int i=0; i<content.length(); i++) {
//				char ch = content.charAt(i); /// i번째 문자 1개 반환
//				
//				// 바이트 기반 스트림 -> 1바이트 범위만 출력 가능
//				// -> 0~255(바이트 범위) 사이 글자는 정상 출력
//				// 		이후 글자(한글 등)은 모두 깨져서 출력
//				fos.write(ch);
//			}
			
			// 방법 2) String을 byte로 먼저 변환한 후 
			// 				 손실되는 데이터 없이 출력하기
			byte[] bytes = content.getBytes(); // String -> byte[] 형태로 얻어오기
			
			fos.write(bytes); // 손실되는 데이터 없이 모든 문자열(byte) 출력
			
			
			System.out.println("출력 완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) {
					fos.close(); // IOException 발생 가능성 있음
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 *보조 Stream 중 BufferedOutputStream을 이용해서출력 속도 향상시키기
	 */
	public void bufferedFileByteOutput() {
		
		/* 버퍼(buffer)란?
		 * - 데이터를 모아져있는 메모리 상에 임시 공간
		 * == 장바구니 
		 * -> 한 번에 많은 양의 데이터를 이동 시켜서
		 * 		시간 효율을 좋아지게 만듦
		 */
		
		/* 스트림 객체 참조 변수 선언 */
		FileOutputStream fos 			= null; // 기반 스트림(단독 사용 O)
		BufferedOutputStream bos 	= null; // 보조 스트림(단독 사용 X)
		
		try {
			/* 기반 스트림 생성 */
			fos = new FileOutputStream("io_test/byte/버퍼_바이트.txt");
			// -> 파일이 없으면 생성됨
			
			/* 보조 스트림 생성 */
			// 보조 스트림 생성 시 기반 스트림과 연결
			// """ -> <pre>태그와 비슷한 역할
			bos = new BufferedOutputStream(fos);
			
			String content = 
"""
I know who I am

[나는 나를 알고 있어]

The moonlit lake told me

[호수의 달빛이 내게 말했지]

"This is who you are"

[이것이 너라고]

​

My fangs are so long

[긴 송곳니와]

My nails are sharper than ice

[얼음처럼 날카로운 발톱]

That is me

[그것이 나야]

​

I wonder what that will prove?

[그게 무엇을 증명해주지?]

​

That is bullshit! Blazing!

[개소리 집어치워! 타오른다!]

Still my heart is blazing!

[내 심장은 뜨겁게 타오르고 있어!]

​

If the "words" kill me

["말"이 나를 죽일 수 있다면]

I don't need a new world order

[신세계의 질서가 무슨 소용이야?]

​

You… Soon you will know

[너도 곧 알게 되겠지]

We already know the smell of the game

[우린 이미 사냥감의 냄새를 알고 있어]

​

* * * * *

​

Do you know who you are?

[너는 네가 누군지 알아?]

When you speak your words

[네가 하는 말들은]

Don't sound like your own

[너 자신의 말이 아냐]

​

You're trapped in a dark cell created by this world

[이 세상이 만든 어두운 감옥에 갇힌]

"That is who you are"

[그게 바로 너야]

​

Norms, standards, rules, and guidelines 

[일반 상식 기준 그리고 규범] 

must be kept so time to wake up!

[이제는 깨어날 시간이야!]

Gravity keeps us on the ground

[중력 때문에 땅바닥을 벗어날 수 없다고?]

​

That is bullshit! Blazing!

[개소리 집어치워! 타오른다!]

Still my heart is blazing!

[내 심장은 뜨겁게 타오르고 있어!]

​

If I lose my wings

[날개를 잃게 된다면]

I don't need a new world order

[신세계의 질서가 무슨 소용이야?]

​

You… can't feel a thing…

[아무것도 느껴지지 않아?]

(But) We already know the smell of game.

[하지만 우린 이미 사냥감의 냄새를 알고 있어]

​

(Remember you are) Blazing!

[타오르고 있는 너를 기억해!]

Still your heart is blazing!

[네 심장은 뜨겁게 타오르고 있어!]

​

If the "words" made you

[너를 만든 것이 "말"이라면]

I don't need a new world order

[신세계의 질서가 무슨 소용이야?]

You… Soon you will know

[너도 곧 알게 되겠지]

We already know the smell of the game

[우린 이미 사냥감의 냄새를 알고 있어]

​

* * * * *

​

What am I? What am I?

[나는 무엇인가? 나는 무엇인가?]

What am I? What am I?

[나는 무엇인가? 나는 무엇인가?]

​

Mankind knew that they cannot change society.

[인류는 스스로의 사회를 바꿀 수 없음을 깨달았다]

So instead of reflecting on themselves, 

[그래서 그들은 자신들을 비추어보는 대신]

they blamed the Beasts.

[짐승들을 탓하기로 했다]

But they found beauty in the lives of Beasts,

[그러나 그들은 짐승들의 삶에서 아름다움을 발견했고]

And couldn't lie to themselves about it.

[자신을 속이며 그것을 무시할 순 없었다]

​

I'm just a small part of the world…

[나는 이 세계의 작은 일부일 뿐…]

​

But no one could break me!!!!!

[하지만 아무도 날 파괴할 수 없어!!!!!]

​

* * * * *

​

Can't you see I'm Blazing?

[내가 불타는 것이 보이지 않아?]

Still my heart is blazing!

[내 심장은 아직도 타오르고 있어!]

​

If the "words" kill me

["말"이 나를 죽일 수 있다면]

I don't need a new world order

[신세계의 질서가 무슨 소용이야?]

You… My tribe is my world

[나의 사람들이 곧 나의 세계]

Your "words" will never make me disappear!

[너의 "말"은 나를 사라지게 할 수 없어!]

​

(That is bullshit!) Blazing!

[개소리 집어치워! 타오른다]

Still my heart is blazing!

[내 심장은 아직도 타오르고 있어!]

​

If the words kill me

["말"이 나를 죽일 수 있다면]

I don't need a new world order

[신세계의 질서가 무슨 소용이야?]

You… Soon you will know

[너도 곧 알게 되겠지]

We already know the smell of the

[우린 이미 사냥감의 냄새를]

Know the smell of the

[사냥감의 냄새를]

Know the smell of the

[사냥감의 냄새를]

Know the smell of the game

[사냥감의 냄새를 알고 있어]

""";
			// 보조 스트림을 이용해서 출력
			// -> 내용 출력 시 버퍼를 이용해서 한 번에 출력
			// ->
			bos.write(content.getBytes());
			System.out.println("출력 성공");
			
		} catch(Exception e) { // 다형성 이용해서 모든 예외 처리
			e.printStackTrace();
		} finally {
			try {
				if(bos != null) bos.close();
				// 보조 스트림만 close 하면
				// 연결된 기반 스트림도 같이 close 된다.
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 바이트 기반 파일 입력 (파일 읽어오기)
	 */
	public void fileByteInput() {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("io_test/byte/노래가사.txt");
			
			int value = 0; // 읽어온 1byte를 저장할 임시 변수
			
			// 읽어온 내용 누적용 객체
			StringBuilder sb = new StringBuilder();
			
			while(true) { // 무한 반복
				// int fis.read()
				// - 파일로 부터 1바이트 읽어서 반환
				// - 호출 시 마다 다음 내용을 읽어옴
				// - 읽어올 내용이 없다면 -1 반환
				value = fis.read(); 
				
				if(value == -1) break;
				
				sb.append((char)value);
			}
			System.out.println(sb.toString());
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 바이트 기반 파일 입력 2(한글 안깨지게 가져오기)
	 */
	public void fileByteInput2() {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("io_test/byte/메모라이즈.txt");
			
			// byte[] readAllBytes()
			// - 연결된 파일의 내용을 모두 byte로 변환하여 읽어오기
			// - byte[] 형태로 반환됨
			byte[] bytes = fis.readAllBytes();
			
			String content = new String(bytes); // byte[]을 String에 그대로 저장
			System.out.println(content);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 보조 스트림(BufferedInputStream)을 이용해서
	 * 효율적으로 파일 읽어오기
	 */
	public void bufferedFileByteInput() {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		try {
			fis = new FileInputStream("io_test/byte/메모라이즈.txt");
			
			bis = new BufferedInputStream(fis);
			
			// 보조 스트림을 이용해서
			// 파일 내용 -> 바이트로 변환
			// -> 버퍼를 이용해 한 번에 읽어옴 -> byte[]로 반환
			byte[] bytes = bis.readAllBytes();
			
			String content = new String(bytes); // byte[]을 String에 그대로 저장
			System.out.println(content);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(bis != null) bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//---------
	
	/**[파일 복사]
	 * <pre>
	 * - 복사할 파일의 경로를 입력 받아
	 * 	 같은 경로에 복사된 파일을 생성
	 * 
	 * - 입력 받은 경로에 파일이 존재하지 않으면
	 * 	 -> "파일이 존재하지 않습니다" 출력
	 * 
	 * - 존재하면
	 * 	 -> 같은 경로에 "파일명_copy.확장자" 이름으로 출력
	 * 
	 * [실행 화면]
	 * 파일 경로 입력 : io_test/byte/노래가사.txt
	 * 복사 완료 : io_test/byte/노래가사_copy.txt
	 * </pre>
	 */
	public void fileCopy() {
		
		// 스캐너, 파일 입출력 스트림, 보조스트림 참조 변수 선언
		Scanner sc = null;
		
		// 입, 출력 기반 스트림
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		// 입, 출력 보조 스트림
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			sc = new Scanner(System.in);
			
			// 1) 파일 경로 입력 받기
			System.out.print("파일 경로 입력 : " );
			String path = sc.nextLine();
			
			// 2) 입력받은 경로의 파일과 FileinputStream 연결하기
			fis = new FileInputStream(path);
			// -> path에 파일이 없다면
			//		FileNotFoundException 발생 -> catch에서 처리
			
			// 3) 보조 입력용 스트림 생성
			bis = new BufferedInputStream(fis);
			
			// 4) 연결된 파일을 byte[]로 읽어오기
			byte[] bytes = bis.readAllBytes(); // == 읽어온 파일
			
			// 5) 입력 받은 경로 파일명에 _copy 붙이기
			
			StringBuilder sb = new StringBuilder();
			sb.append(path);
			
			int insertPoint = sb.lastIndexOf(".");
			sb.insert(insertPoint, "_copy");
			
			// 복사본의 경로
			String copyPath = sb.toString();
			
			
			// 6) 출력용 기반 스트림 객체 생성
			fos = new FileOutputStream(copyPath);
			
			// 7) 출력용 보조 스트림 객체 생성
			bos = new BufferedOutputStream(fos);
			
			// 8) 보조 스트림을 이용해서 출력하기
			bos.write(bytes); // 읽어온 파일(bytes) 출력하기
			
			System.out.println("복사 완료 : " + copyPath);
		} catch(FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			// 스트림 객체 메모리 반환
			try {
				if(bis != null) bis.close();
				if(bos != null) bos.close();
				if(sc != null) sc.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
