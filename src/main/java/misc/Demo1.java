package misc;

public class Demo1 {
	public static void main(String[] args) {
		String [][] aa = new String[4][4];
		
		for(int i = 0; i < 4;i++){
			for(int j=0;j<4;j++){
				aa[i][j] = " * ";
			}
		}
		
		for(int i = 0; i < 4;i++){
			for(int j=0;j<4;j++){
				System.out.print(aa[i][j]);
			}
			System.out.println();
		}
	}
}
