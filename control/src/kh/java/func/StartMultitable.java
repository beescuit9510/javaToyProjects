package kh.java.func;

public class StartMultitable {
	
	public void multiplacationTable() {
		
		for(int i=1;i<10;i++) {
			for(int j=1;j<10;j++) {
				System.out.printf("%d * %d = %d \t",i,j,i*j);
			}
			System.out.println();
		}
	}
	
	public void multiplacationTable2() {
		for(int i=1;i<10;i++) {
			for(int j=2;j<10;j++) {
				System.out.printf("%d * %d = %d \t",j, i,i*j);				
			}
			System.out.println();
		}

	}
	
	public void star1() {
		for(int i=0;i<5;i++) {
			System.out.printf("*");
		}
	}
	
	public void star2() {
		for(int i=0;i<5;i++) {
			System.out.println("*");
		}
	}
	
	public void star3() {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.printf("*");
			}
			System.out.println();
		}
	}
	
	public void star4() {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.printf("%d",i+1);
			}
			System.out.println();
		}
	}
	
	public void star5() {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.printf("%d",j+1);
			}
			System.out.println();
		} 
	}
	
	public void star6() {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.printf("%d",j+i+1);
			}
			System.out.println();
		} 
		
	}
	
	public void star7() {
		for(int i=5;i>0;i--) {
			for(int j=0;j<5;j++) {
				System.out.printf("%d",j+i);
			}
			System.out.println();
		}
		
	}
	
	public void star8() {
		for(int i=0;i<5;i++) {
			for(int j=0;j<i+1;j++) {
				System.out.printf("*");
			}
			System.out.println();
		}
	}
	
	public void star9() {
		for(int i=5;i>0;i--) {
			for(int j=0;j<i;j++) {
				System.out.printf("*");
			}
			System.out.println();
		}
	}
	
	public void star10() {
		for(int i=0;i<5;i++) {
			for(int k=i;k>0;k--){
				System.out.printf(" ");				
			}
			for(int j=i;j<5;j++) {
				System.out.printf("*");		
			}
			System.out.println();
		}
	}
	
	public void $star10() {
		for(int i=0;i<5;i++) {
			for(int j=i;j>0;j--) {
				System.out.printf(" ");
			}
			for(int k=i;k<5;k++) {
				System.out.printf("*");
			}
			System.out.println();
		}
	}
	
	
	public void star11() {
		for(int i=0;i<5;i++) {
			for(int k=i;k<4;k++) {
				System.out.printf(" ");
			}
			for(int j=i+1;j>0;j--) {
				System.out.printf("*");
			}
			System.out.println();
			
		}
	}
	
	
	public void $star11() {
		for(int i=0;i<5;i++) {
			for(int j=i;j>0;j--) {
				System.out.printf(" ");
			}
			for(int k=i-5;k<0;k++) {
				System.out.printf("*");
			}
			System.out.println();
		}
	}
	
	public void star12() {
		
		for(int i=5;i>0;i--) {
			for(int k=i-5;k<0;k++) {
				System.out.printf("*");
			}
			for(int j=i;j>0;j--) {
				System.out.printf(" ");
			}
			System.out.println();
			
		}
		for(int i=5;i>0;i--) {
			for(int j=i;j>0;j--) {
				System.out.printf("*");
			}
			System.out.println();
			
		}
	
	}
	
	public void $star12() {
		for(int i=0;i<10;i++) {
			if(i<6) {
				for(int j=i;j>0;j--) {
					System.out.printf("A");
				}
			} else {
				for(int k=0;k<10-i;k++) {
					System.out.printf("B");
				}
			}
			System.out.println();
			
			
		}
	}
	
	
	public void $$Star12() {
		for(int i=0;i<10;i++) {
				for(int j= i<6? i:10-i;j>0;j--) {
					System.out.printf("*");					
			}
			System.out.println();
		}
		
	}
	
	
	public void star13() {
		for(int i=10;i>0;i--) {
			for(int j=i-5;j>0;j--) {
				System.out.printf("*");
			}
			for(int k=i-6;k<0;k++) {
				System.out.printf("*");
			}
			System.out.println();
		}
			
	}
	
	public void $star13() {
		for(int i=0;i<9;i++) {
			for(int j= i<4?i:-i+8;j<5;j++) {
				System.out.printf("*");
			}System.out.println();
		}
	}
	
	
	public void star14() {
		for(int i=5;i>0;i--) {
			for(int k=i;k<5;k++) {
				System.out.printf("B");
			}
			for(int j=i;j>0;j--) {
				System.out.printf("A");
			}
			System.out.println();
		}
		
	}
	
	public void star16() {
		int num = 0;
		for(int i=0;i<5;i++) {
			num++;
			for(int k=i;k<4;k++) {
				System.out.printf(" ");
			}
			for(int j=i+num;j>0;j--) {
				System.out.printf("*");
			}
			System.out.println();
		}
	}
	
	public void star17() {
		int num = 0;
		for(int i=0;i<5;i++) {
			num++;
			for(int k=i;k>0;k--) {
				System.out.printf(" ");
			}
			for(int j=i+num;j<10;j++) {
				System.out.printf("*");
			}
			System.out.println();
		}
	}
	
	
	public void star18() {
		int num = 0;
		for(int i=0;i<5;i++) {
			num++;
			for(int k=i;k<4;k++) {
				System.out.printf(" ");
			}
			for(int j=i+num;j>0;j--) {
				System.out.printf("*");
			}
			System.out.println();
		}
		for(int i=0;i<4;i++) {
			num--; 
			for(int k=i+1;k>0;k--) {
				System.out.printf(" ");
			}
			for(int j=i-num;j<3;j++) {
				System.out.printf("*");
			}
			System.out.println();
		}
	}
	
	
	public void star19() {
		
		int num=0;
		for(int i=0;i<5;i++) {
			num++;
			for(int j=i+4;j<9;j++) {
				System.out.printf("*");
			}
			for(int k=i+num;k>0;k--) {
				System.out.printf(" ");
			}
			for(int j=i+4;j<9;j++) {
				System.out.printf("*");
			}
			System.out.println();
		}
		for(int i=0;i<4;i++) {
			num--;
			for(int j=i+2;j>0;j--) {
				System.out.printf("*");
			}
			for(int k=i-num-3;k<0;k++) {
				System.out.printf(" ");
			}
			for(int j=i+2;j>0;j--) {
				System.out.printf("*");
			}
			System.out.println();
		}
		
	}
	
	public void star20() {
		for(int i=0; i<5;i++) {
			for(int j=i+6;j>5;j--) {
				System.out.printf("*");
			}
			for(int k=i+9;k>3*i;k--) {
				System.out.printf(" ");
			}
			for(int j=i+6;j>5;j--) {
				System.out.printf("*");
			}
			System.out.println();
		}
		
		for(int i=0; i<4; i++) {
			for(int j=i;j<4;j++) {
				System.out.printf("*");
			}
			for(int k=(i+1)*2; k>-1; k--) {
				System.out.printf(" ");	
			}
			for(int j=i;j<4;j++) {
				System.out.printf("*");
			}
			System.out.println();
		}
	}
	
	public void star21() {
		for(int i=0;i<5;i++) {
			for(int k=i+1;k>0;k--) {
				System.out.printf(" ");
			}
			for(int j=(i*2)-9;j<0;j++) {
				System.out.printf("*");
			}
			System.out.println();
		}
		for(int i=0;i<4;i++) {
			for(int k=i-4;k<0;k++) {
				System.out.printf(" ");
			}
			for(int j=(2)*(i+1)+1;j>0;j--) {
				System.out.printf("*");
			}
			System.out.println();
		}
	}

}
