package matrix;

public class Working {
	public static void main(String[] args) {
		Matrix<Integer> matrix=new Matrix<Integer>(4,4);
		int count=1;
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				matrix.getVertex(i, j).setValue(count);
				count++;
			}
		}
		System.out.println(matrix+"\n"+matrix.getVertex(1, 1).getNear_by_verices());
	}
}
