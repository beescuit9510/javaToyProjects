package MySort;

public class BubbleSort {

	public static void main(String[] args) {

		int[] list = { 1,2,3,4,9, 8, 7, 2, 1, 3, 10, 12, 16 };
		bubbleSort2(list);

	}

	public static void swap(int[] list, int idx1, int idx2) {

		for (int i = 0; i < list.length - 1; i++) {
			if (i == idx2) {
				System.out.printf(list[i] + " <- ");
				continue;
			}
			System.out.print(list[i] + " ");
		}
		System.out.println();

		int box = list[idx1];
		list[idx1] = list[idx2];
		list[idx2] = box;
	}

	public static void bubbleSort(int[] list) {

		int len = list.length;
		int compare = 0;

		for (int i = 0; i < len - 1; i++) {
			int exchg = 0;
			for (int j = len - 1; j > i; j--) {
				compare++;
				if (list[j] < list[j - 1]) {
					swap(list, j, j-1);
					exchg++;
				}
			}
			if(exchg==0) {
				break;
			}
			
		}
		System.out.printf("�� %d�� �� �߽��ϴ�.", compare);
		System.out.println();
		System.out.println("��� : ");
		
		for (int i : list) {
			System.out.print(i + "\t");

		}
	}
	
	
//	������ �˰��� ! 
//	���� ����Ʈ �պκ��� ���ĵǾ��ִٸ� last�� len-1 �ʱⰪ�� �����״�
//	���̻� ������ �ʾƵ���.
	
	public static void bubbleSort2(int[] list) {
		int len = list.length;
		int last = 0;
		int compare = 0;
		
		while(last < len-1) {
			
			int lastExch = len-1;
			
			for(int i = len-1; i > last; i--) {
				compare++;
				if(list[i-1]> list[i]) {
					swap(list, i-1, i);
					lastExch = i;
				}
			}
			last = lastExch;
			
		}

		System.out.printf("�� %d�� �� �߽��ϴ�.", compare);
		System.out.println("��� : ");
		
		
		for (int i : list) {
			System.out.print(i + "\t");
			
		}
	}

}
