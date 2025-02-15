package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dto.Todo;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListView {

	private TodoListService service = null;
	private BufferedReader br = null; // Scanner 대신 사용
	// 기본 생성자
	public TodoListView() {
		
		try {
			service = new TodoListServiceImpl();			
			br = new BufferedReader(new InputStreamReader(System.in));
			
		} catch (Exception e) {
			System.out.println("*** 프로그램 실행 중 오류 발생 ***");
			e.printStackTrace();
			System.exit(0); // 프로그램 종료
		}
	}
	
	
	// ------------------------------------------------------------------------------------------------------
	
	
	/**
	 * Todo List 화면 시작 
	 */
	public void startView() {

		int selectNumber = 0;
		
		do {
			try {
				selectNumber = selectMenu();
				
				switch (selectNumber) {
				case 1: todoListFullView(); break; 
				case 2: todoDetailView(); 	break; 
				case 3: todoAdd(); 					break; 
				case 4: todoComplete(); 		break; 
				case 5: todoUpdate(); 			break; 
				case 6: todoDelete(); 			break; 
				
				case 0: 
					System.out.println("@@@ 프로그램 종료 @@@"); 
					br.close();
				break; 
				
				default: System.out.println("### 메뉴에 작성된 번호만 입력해 주세요 ###");
				}
				
				System.out.println("=====================================================================");
				

			} catch (NumberFormatException e) {
				System.out.println("### 숫자만 입력해 주세요 ###");
			} catch (IOException e) {
				System.err.println("### 입/출력 관련 예외 발생 ###");
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			
		} while (selectNumber != 0);
		
		
		
		try {
			if (br != null) 	br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	// ------------------------------------------------------------------------------------------------------
	
	
	/** 메뉴 출력 및 선택
	 * @return 선택한 메뉴 번호 반환
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private int selectMenu() throws NumberFormatException, IOException {

		System.out.println("\n====== Todo List =====\n");
		
		System.out.println("1. Todo List Full View");
		System.out.println("2. Todo Detail View");
		System.out.println("3. Todo Add");
		System.out.println("4. Todo Complete");
		System.out.println("5. Todo Update");
		System.out.println("6. Todo Delete");
		System.out.println("0. EXIT");
		
		
		System.out.print("select menu number >>> ");
		int input = Integer.parseInt(br.readLine());
		System.out.println();
		
		return input;
	}

	
	// ------------------------------------------------------------------------------------------------------
	
	
	/** 할 일 목록 모두 보기
	 */
	private void todoListFullView() {
		
		System.out.println("\n===============[1. Todo List Full View]===============\n");
		
		Map<String, Object> map = service.todoListFullView();
		List<Todo> todoList = (ArrayList<Todo>)map.get("todoList");
		System.out.printf(" 완료된 Todo 개수 / 전체 Todo 수 : %d / %d\n", map.get("completeCount"), todoList.size());
		System.out.println("-------------------------------------------------------------");
		System.out.println("인덱스\t\t등록일\t\t완료여부\t할 일 제목");
		System.out.println("-------------------------------------------------------------");
		for(int i =0; i<todoList.size(); i++) {
			System.out.printf("[ %d ]\t%s\t(%s)\t%s\n",
					i,
					service.dateFormat(todoList.get(i).getRegDate()),
					todoList.get(i).isComplete() ? "O" : "X",
					todoList.get(i).getTitle()
					);
		}
	}
	
	
	// ------------------------------------------------------------------------------------------------------
	
	
	/** 할 일 상세 조회 
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	private void todoDetailView() throws NumberFormatException, IOException {
		
		System.out.println("\n===============[2. Todo Detail View]===============\n");
		System.out.print("인덱스 번호 입력 : ");
		int number = Integer.parseInt(br.readLine());
		if (service.todoDetailView(number) == null) {
			System.out.println("### 입력한 인덱스 번호에 할 일(Todo)가 존재하지 않습니다 ###");
		} else {
			System.out.println(service.todoDetailView(number));
		}
	}
	
	
	// ------------------------------------------------------------------------------------------------------
	
	
	/** 할 일 추가
	 * @throws IOException 
	 * 
	 */
	private void todoAdd() throws IOException {
		
		System.out.println("\n===============[3. Todo Add]===============\n");
		System.out.print("할 일 제목 입력 : ");
		String title = br.readLine();
		System.out.println("세부 내용 작성 (입력 종료 시 !wq 작성 후 엔터)");
		System.out.println("-------------------------------------------------------------");

		StringBuilder detail = new StringBuilder("");
		while(true) {
			detail.append(br.readLine() + "\n");
			if (br.readLine().contains("!wq")) {
				break;
			}
		}
		System.out.printf("[%d] 인덱스에 추가 되었습니다. ", service.todoAdd(title, detail.toString()));
	}
	
	
	// ------------------------------------------------------------------------------------------------------
	
	
	/** 할 일 완료 여부 변경 (O <-> X) 
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	private void todoComplete() throws NumberFormatException, IOException {
		System.out.println("\n===============[4. Todo Complete]===============\n");
		System.out.print("O <-> X 변경할 인덱스 번호 입력 : ");
		int num = Integer.parseInt(br.readLine());
		if(service.todoComplete(num)) {
			System.out.println("[변경 되었습니다]");
		} else {
			System.out.println("### 입력한 인덱스에 Todo가 존재하지 않습니다 ###");
		}
	}
	
	
	
	// ------------------------------------------------------------------------------------------------------

	
	/** 할 일 수정
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	private void todoUpdate() throws NumberFormatException, IOException {
		System.out.println("\n===============[5. Todo Update]===============\n");
		System.out.print("수정할 To do인덱스 번호 입력 :");
		int num = Integer.parseInt(br.readLine());
		if (service.todoDetailView(num) != null ) {
			System.out.println(service.todoDetailView(num).toString()); 
			System.out.print("수정할 제목 : ");
			String title = br.readLine();
			System.out.println("수정할 세부 내용 작성 (입력 종료 시 !wq 작성 후 엔터)");
			System.out.println("-------------------------------------------------------------");
			StringBuilder detail = new StringBuilder("");
			while(true) {
				detail.append(br.readLine() + '\n');
				if (br.readLine().contains("!wq")) {
					break;
				}
			}
			service.todoUpdate(num, title, detail.toString());
		} else {
			System.out.println("### 입력한 인덱스 번호에 할 일(Todo)가 존재하지 않습니다 ###");
		}
	}
	
	
	
	// ------------------------------------------------------------------------------------------------------	
	
	private void todoDelete() throws NumberFormatException, IOException {
		System.out.println("\n===============[6. Todo Delete]===============\n");
		System.out.print("삭제할 인덱스 번호 입력 : ");
		int num = Integer.parseInt(br.readLine());
		if (service.todoDelete(num) == null) {
			System.out.println("### 입력한 인덱스에 Todo가 존재하지 않습니다 ###");
		} else {
			System.out.println("[삭제 되었습니다]");
		}
		
	}
	
	
	
	
}