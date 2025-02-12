package section04.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharService {
	/* [문자 기반 스트림]
	 * 
	 * - 2byte 문자(char) 단위로 입/출력하는 스트림
	 * 
	 * - 문자만 작성된 파일(txt, bin 등),
	 * 	 채팅, JSON, 웹 요청(주소)/응답(HTML)
	 * 
	 * - 문자 기반 스트림 최상위 인터페이스 : Reader(입력), Writer(출력)
	 */
	
	/** 문자 기반 스트림을 이용한 파일 출력 */
	public void fileOutput1() {
		
		FileWriter fw = null;
		
		try {
			
			String content = 
"""
I know who I am
[나는 나를 알고 있어]

The moonlit lake told me
[호수의 달빛이 내게 말했지]

"This is who you are"
[이것이 너라고]

My fangs are so long
[긴 송곳니와]

My nails are sharper than ice
[얼음처럼 날카로운 발톱]

That is me
[그것이 나야]

I wonder what that will prove?
[그게 무엇을 증명해주지?]

That is bullshit! Blazing!
[개소리 집어치워! 타오른다!]

Still my heart is blazing!
[내 심장은 뜨겁게 타오르고 있어!]

If the "words" kill me
["말"이 나를 죽일 수 있다면]

I don't need a new world order
[신세계의 질서가 무슨 소용이야?]

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

You're trapped in a dark cell created by this world
[이 세상이 만든 어두운 감옥에 갇힌]

"That is who you are"
[그게 바로 너야]

Norms, standards, rules, and guidelines 
[일반 상식 기준 그리고 규범] 

must be kept so time to wake up!
[이제는 깨어날 시간이야!]

Gravity keeps us on the ground
[중력 때문에 땅바닥을 벗어날 수 없다고?]

That is bullshit! Blazing!
[개소리 집어치워! 타오른다!]

Still my heart is blazing!
[내 심장은 뜨겁게 타오르고 있어!]

If I lose my wings
[날개를 잃게 된다면]

I don't need a new world order
[신세계의 질서가 무슨 소용이야?]

You… can't feel a thing…
[아무것도 느껴지지 않아?]

(But) We already know the smell of game.
[하지만 우린 이미 사냥감의 냄새를 알고 있어]

(Remember you are) Blazing!
[타오르고 있는 너를 기억해!]

Still your heart is blazing!
[네 심장은 뜨겁게 타오르고 있어!]

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

I'm just a small part of the world…
[나는 이 세계의 작은 일부일 뿐…]

But no one could break me!!!!!
[하지만 아무도 날 파괴할 수 없어!!!!!]

​

* * * * *

​

Can't you see I'm Blazing?
[내가 불타는 것이 보이지 않아?]

Still my heart is blazing!
[내 심장은 아직도 타오르고 있어!]

If the "words" kill me
["말"이 나를 죽일 수 있다면]

I don't need a new world order
[신세계의 질서가 무슨 소용이야?]

You… My tribe is my world
[나의 사람들이 곧 나의 세계]

Your "words" will never make me disappear!
[너의 "말"은 나를 사라지게 할 수 없어!]

(That is bullshit!) Blazing!
[개소리 집어치워! 타오른다]

Still my heart is blazing!
[내 심장은 아직도 타오르고 있어!]

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
			String path = "io_test/char";
			File folder = new File(path);
			if(!folder.exists()) folder.mkdirs();
			
			// 문자 기반 파일 출력 스트림 객체 생성
			fw = new FileWriter(folder + "/" + "smell_of_the_game.txt");
			
			// 문자 기반 스트림을 이용해서 출력하기
			fw.write(content);
			
			// 스트림에 남은 데이터를 밀어냄
			fw.flush();
			
			System.out.println("출력완료");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw != null) fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
public void fileOutput2() {
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			
			String content = 
"""
I know who I am
[나는 나를 알고 있어]

The moonlit lake told me
[호수의 달빛이 내게 말했지]

"This is who you are"
[이것이 너라고]

My fangs are so long
[긴 송곳니와]

My nails are sharper than ice
[얼음처럼 날카로운 발톱]

That is me
[그것이 나야]

I wonder what that will prove?
[그게 무엇을 증명해주지?]

That is bullshit! Blazing!
[개소리 집어치워! 타오른다!]

Still my heart is blazing!
[내 심장은 뜨겁게 타오르고 있어!]

If the "words" kill me
["말"이 나를 죽일 수 있다면]

I don't need a new world order
[신세계의 질서가 무슨 소용이야?]

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

You're trapped in a dark cell created by this world
[이 세상이 만든 어두운 감옥에 갇힌]

"That is who you are"
[그게 바로 너야]

Norms, standards, rules, and guidelines 
[일반 상식 기준 그리고 규범] 

must be kept so time to wake up!
[이제는 깨어날 시간이야!]

Gravity keeps us on the ground
[중력 때문에 땅바닥을 벗어날 수 없다고?]

That is bullshit! Blazing!
[개소리 집어치워! 타오른다!]

Still my heart is blazing!
[내 심장은 뜨겁게 타오르고 있어!]

If I lose my wings
[날개를 잃게 된다면]

I don't need a new world order
[신세계의 질서가 무슨 소용이야?]

You… can't feel a thing…
[아무것도 느껴지지 않아?]

(But) We already know the smell of game.
[하지만 우린 이미 사냥감의 냄새를 알고 있어]

(Remember you are) Blazing!
[타오르고 있는 너를 기억해!]

Still your heart is blazing!
[네 심장은 뜨겁게 타오르고 있어!]

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

I'm just a small part of the world…
[나는 이 세계의 작은 일부일 뿐…]

But no one could break me!!!!!
[하지만 아무도 날 파괴할 수 없어!!!!!]

​

* * * * *

​

Can't you see I'm Blazing?
[내가 불타는 것이 보이지 않아?]

Still my heart is blazing!
[내 심장은 아직도 타오르고 있어!]

If the "words" kill me
["말"이 나를 죽일 수 있다면]

I don't need a new world order
[신세계의 질서가 무슨 소용이야?]

You… My tribe is my world
[나의 사람들이 곧 나의 세계]

Your "words" will never make me disappear!
[너의 "말"은 나를 사라지게 할 수 없어!]

(That is bullshit!) Blazing!
[개소리 집어치워! 타오른다]

Still my heart is blazing!
[내 심장은 아직도 타오르고 있어!]

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
			String path = "io_test/char";
			File folder = new File(path);
			if(!folder.exists()) folder.mkdirs();
			
			// 문자 기반 파일 출력 스트림 객체 생성
			fw = new FileWriter(folder + "/" + "smell_of_the_game_buffer.txt");
			bw = new BufferedWriter(fw);
			// 문자 기반 스트림을 이용해서 출력하기
			bw.write(content);
			
			// 스트림에 남은 데이터를 밀어냄
			bw.flush();
			
			System.out.println("출력완료");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

/**
 * 문자 기반 입력 스트림 + 보조 스트림 이용해서 파일 읽어오기
 */
	public void fileInput() {
		
		/* [try - with - resource]
		 * - 자바 7버전에서 추가된 기능
		 * - finally에서 작성하던 close 처리 구문을
		 * 	 자동으로 수행하도록 만드는 구문
		 */
		String path = "io_test/char/smell_of_the_game.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			// 보조 스트림을 이용해서 파일 내용 읽어오기
			StringBuilder sb = new StringBuilder();
			String temp = null; // 임시 변수
			
			while(true) {
				temp = br.readLine(); // 한 줄씩 읽어오기
				if(temp == null) break; // 읽어온 내용이 없으면 반복 종료
				
				sb.append(temp);
				sb.append("\n");
			}
			System.out.println("읽어오기 성공!");
			System.out.println("-----------------");
			System.out.println(sb.toString());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Scanner 대신 스트림을 이용한 문자열 입력 받기
	// -> Scanner가 편리하긴 하나 매우 느림
	
	// 키보드 입력 -> 바이트(2진수) 코드 입력 -> 문자 변화
	
	public void keyboardInput() {
		
		// System.in: 기본 장치(키보드)와 연결된 InputStream 반환
		
		// InputStreamReader : 바이트 스트림 -> 문자 스트림 변환 
		try(BufferedReader br = new BufferedReader( new InputStreamReader(System.in))) {
			
			System.out.print("문자열 입력1 : ");
			String input1 = br.readLine();
			System.out.print("문자열 입력2 : ");
			String input2 = br.readLine();
			
			
			System.out.println("입력 받은 문자열 : " + input1 + " / " + input2);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
