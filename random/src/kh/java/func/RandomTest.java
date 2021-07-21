package kh.java.func;

import java.util.Random;
import java.util.Scanner;

public class RandomTest {
	public void test1() {
		Random random = new Random();
		System.out.println(
				random.nextInt(30)
				);		
	}

	public void test2() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		System.out.println("====���� ���� �� ����====");
		
		while(true) {
			
			System.out.println("���ڸ� �����ϼ���(1.����/2.����/3.��) : ");
			int user = sc.nextInt();
			int computer= r.nextInt(3)+1;
			
			String user2 = user==1 ? "����":(user==2? "����":"��");
			String computer2 = computer==1 ? "����":(computer==2? "����":"��");
			
			boolean draw = user==computer? true:false;
			boolean win = false;
			if(!draw) {
				if((user2.equals("����")&&computer2.equals("��"))
						||(user2.equals("����")&&computer2.equals("����"))
						||(user2.equals("��"))&&(computer2.equals("����"))) {
					win=true;
				} else {win=false;}
			}
			
			
			System.out.printf("user: %s, computer: %s%n",user2, computer2);
			System.out.println(draw? "���º�":(win? "User Win!":"Computer win!"));
			
		}
		
	}
	
	
	public void upDown() {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);

		boolean run = true;
		int min = 100;
		while(run) {
			System.out.println("===== Up & Down Game =====");		
			System.out.println("1.Game Start");		
			System.out.println("2.Game Score");
			System.out.println("3.End Game");
			
			int state = sc.nextInt();

			if(state==1) {
				boolean game = true;
				int num = 0;
				int answer = random.nextInt(100)+1;
				System.out.println("<< Game Start >>");
				while(game) {
					num++;
					System.out.printf("%d ȸ�� ��ȣ �Է� : ", num);
					int guess = sc.nextInt();
					if(guess==answer) {
						if(min>num) {min=num;}
						System.out.println("<< ���� >>");
						game=false;
					} else if(guess>answer) {
						System.out.println("<< DOWN >>");
					} else if(guess<answer) {
						System.out.println("<< UP >>");						
					}
				};
			} else if(state==2) {
				if(min==100) {
					System.out.println("���� ����� �����ϴ�.");					
				} else {System.out.printf("���� �ְ� ����� %dȸ �Դϴ�.", min); System.out.println();}
				
			} else if(state==3) {run=false;}
					
			
		}
	}
	
	
	public void $upDown() {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);

		boolean run = true;
		int min = 100;
		while(run) {
			System.out.println("===== Up & Down Game =====");		
			System.out.println("1.Game Start");		
			System.out.println("2.Game Score");
			System.out.println("3.End Game");
			System.out.print("����>> ");
			int sel = sc.nextInt();
			
			switch(sel){
			case 1:
				System.out.println("<<Game Start>>");
				int count = 1;
				int randomNum = random.nextInt(99)+1;
				while(true) {
					System.out.printf("%d ȸ�� ��ȣ �Է� : ", count);
					int inputNum = sc.nextInt();
					if(inputNum==randomNum) {
						System.out.println("<< ���� >>");
						min = min>count? count:min;
//						game=false;
						break;
					} else if(inputNum>randomNum) {
						System.out.println("<< DOWN >>");
					} else if(inputNum<randomNum) {
						System.out.println("<< UP >>");		
					}
					count++;
				}
				break;
			case 2:
				break;
			case 3:
				System.out.println("������ �����մϴ�.");
				run = false;
				break;
			}
			}
		
	}
	
	
	
	public void baskin() {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		
		int win = 0;
		int lose = 0;
		boolean run = true;
		int min = 100;
		while(run) {
			System.out.println("===== Baskin Robbins31 Game =====");
			System.out.println("1.Game Start");		
			System.out.println("2.Game Score");
			System.out.println("3.End Game");
			
			int state = sc.nextInt();
			if(state==3) {run=false;}
			if(state==1) {
				int start = 1;
				int limit = 31;
				int log = 1;
				boolean game = true;
				System.out.println("<< Game Start >>");
				
				boolean myturn = true;
				while(game) {
					int input = 0;
					if(myturn) {
						do { if(input>3) {System.out.println("�߸��� �Է� �Դϴ�.");}
							System.out.println("<< Your Turn >>");
							System.out.println("Input Number : ");
							input = sc.nextInt();
						} while(input>3);
							
							myturn=false;
					} else {
						System.out.println("<< Computer Turn >>");
						input = random.nextInt(3)+1;
						myturn=true;
					}
					
					for(int i=start;i<start+input;i++) {
						System.out.println(i+"!");
						log++;
						if(log==limit&&myturn) {
							System.out.println("�¸�!");
							win++;
							game=false;
							break;
						} else if(log==limit&&(!myturn)) {
							System.out.println("�й�Ф�"); 
							lose++;
							game=false;
							break;
							}
						};
					start+=input;
				}
				
			} else if (state==2) {
				System.out.println("<<����� ����>>");
				System.out.printf("WIN : %d %n", win);
				System.out.printf("LOSE : %d %n", lose);
			}
			
		
		}
	}
	
	
	public void $baskin() {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		
		int win = 0;
		int lose = 0;
		boolean run = true;
		while(run) {
			System.out.println("===== Baskin Robbins31 Game =====");
			System.out.println("1.Game Start");		
			System.out.println("2.Game Score");
			System.out.println("3.End Game");
			
			int state = sc.nextInt();
			switch(state) {
			case 1:
				
				int start = 1;
				int limit = 31;
				int log = 1;
				boolean game = true;
				boolean myturn = true;
				System.out.println("<< Game Start >>");
				
				while(game) {
					int input = 0;
					if(myturn) {
						do { if(input>3||input<=0) {System.out.println("�߸��� �Է� �Դϴ�.");}
						System.out.println("<< Your Turn >>");
						System.out.println("Input Number : ");
						input = sc.nextInt();
						} while(input>3);
						
					} else {
						System.out.println("<< Computer Turn >>");
						input = random.nextInt(3)+1;
					}
					
					for(int i=start;i<start+input;i++) {
						System.out.println(i+"!");
						log++;
						if(log==limit&&!myturn) {
							System.out.println("�¸�!");
							win++;
							game=false;
							break;
						} else if(log==limit&&(myturn)) {
							System.out.println("�й�Ф�"); 
							lose++;
							game=false;
							break;
						}
					};
					myturn=!myturn;
					start+=input;
				}
					break;
			case 2:
				System.out.println("<<����� ����>>");
				System.out.printf("WIN : %d %n", win);
				System.out.printf("LOSE : %d %n", lose);
				break;
			case 3:
				System.out.println("������ �����մϴ�.");
				run= false;
				break;
			
			}
			
		
		}
	}
	
	
	public void dice() {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		
		int win = 0;
		int lose = 0;
		int draw = 0;
		int money = 10000;
		boolean run = true;
		while(run) {
			System.out.println("===== Dice Game =====");
			System.out.println("1.Game Start");		
			System.out.println("2.Game Score");
			System.out.println("3.End Game");
			
			int state = sc.nextInt();
			state = money<=0? 3:state;
			if(state==3) {run=false;}
			if(state==1) {
				int total = 0;
				int comTotal =0;
				int input = 0;
				int comInput = 0;
				int inputMoney = 0;
				boolean game = true;
				while(game) {
					System.out.println("<< Game Start >>");
					for(int i=0;i<3;i++) {
						input = random.nextInt(6)+1;
						System.out.printf("%d��° �ֻ��� �� : %d %n", i+1, input );
						total+=input;
						}
	
					System.out.printf("�� �ֻ��� �� �� : %d %n", total);
					System.out.printf("���� �Ͻðڽ��ϱ�[y/n] : ");	
					boolean bet =sc.next().equals("y");
					if(bet) {
						do {
							System.out.printf(inputMoney>0? "�������� �����մϴ�. %n":"");
							System.out.printf("�󸶸� �����Ͻðڽ��ϱ�(���� �� ������ %d��) : ", money);							
							inputMoney= sc.nextInt();
						} while(inputMoney>money);
							
					} else {
						System.out.println("�޴��� ���ư��ϴ�.");
						game=false;
						break;
						
					}
					for(int j=0;j<3;j++) {
						comInput = random.nextInt(6)+1;
						System.out.printf("��ǻ�� %d��° �ֻ��� �� : %d %n", j+1, comInput);
						comTotal+=comInput;
					}
					System.out.printf("��ǻ�� �ֻ��� �� �� : %d %n", comTotal);
					
					System.out.println("<< ���  >>");
					if(comTotal>total) {
						System.out.println("�й�");
						System.out.printf("- %d��!! %n", inputMoney);
						money-=inputMoney;
						lose++;
					} else if (total>comTotal) {
						System.out.println("�¸�!!");
						System.out.printf("+ %d��!! %n", inputMoney);
						money+=inputMoney;
						win++;
					} else {
						System.out.println("���º�!");
						draw++;
					}
				game=false;
				
				}
								
			} else if(state==2) {
				System.out.printf("WIN : %d %n", win);
				System.out.printf("LOSE : %d %n", lose);
				System.out.printf("DRAW : %d %n", draw);
				System.out.printf("�� ������ : %d %n", money);
				
			}
			
		}
	}
	
	public void $dice() {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		
		int win = 0;
		int lose = 0;
		int draw = 0;
		int money = 10000;
		boolean run = true;
		while(run) {
			System.out.println("===== Dice Game =====");
			System.out.println("1.Game Start");		
			System.out.println("2.Game Score");
			System.out.println("3.End Game");
			
			int state = sc.nextInt();
			state = money<=0? 3:state;
			
			
			switch(state){
				case 1:
					int total = 0;
					int comTotal =0;
					int input = 0;
					int comInput = 0;
					int inputMoney = 0;
					boolean game = true;
					while(game) {
						System.out.println("<< Game Start >>");
						for(int i=0;i<3;i++) {
							input = random.nextInt(6)+1;
							System.out.printf("%d��° �ֻ��� �� : %d %n", i+1, input );
							total+=input;
							}
		
						System.out.printf("�� �ֻ��� �� �� : %d %n", total);
						System.out.printf("���� �Ͻðڽ��ϱ�[y/n] : ");	
						boolean bet =sc.next().equals("y");
						if(bet) {
							do {
								System.out.printf(inputMoney>0? "�������� �����մϴ�. %n":"");
								System.out.printf("�󸶸� �����Ͻðڽ��ϱ�(���� �� ������ %d��) : ", money);							
								inputMoney= sc.nextInt();
							} while(inputMoney>money);
								
						} else {
							System.out.println("�޴��� ���ư��ϴ�.");
							game=false;
							break;
							
						}
						for(int j=0;j<3;j++) {
							comInput = random.nextInt(6)+1;
							System.out.printf("��ǻ�� %d��° �ֻ��� �� : %d %n", j+1, comInput);
							comTotal+=comInput;
						}
						System.out.printf("��ǻ�� �ֻ��� �� �� : %d %n", comTotal);
						
						System.out.println("<< ���  >>");
						if(comTotal>total) {
							System.out.println("�й�");
							System.out.printf("- %d��!! %n", inputMoney);
							money-=inputMoney;
							lose++;
						} else if (total>comTotal) {
							System.out.println("�¸�!!");
							System.out.printf("+ %d��!! %n", inputMoney);
							money+=inputMoney;
							win++;
						} else {
							System.out.println("���º�!");
							draw++;
						}
					game=false;
					
					}
									
					break;
					
				case 2:
					System.out.printf("WIN : %d %n", win);
					System.out.printf("LOSE : %d %n", lose);
					System.out.printf("DRAW : %d %n", draw);
					System.out.printf("�� ������ : %d %n", money);
					break;					
					
				case 3:
					System.out.println("������ �����մϴ�.");
					run=false;
					break;
					
			}
			
		}
	}
};
