package searchCodingTst.basicjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DivideConquerFarm {
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] res = paperCnt(paper, N, 0, 0);
        System.out.println(res[0]);
    }
    
    public static int[] paperCnt(int[][] paper, int N, int startI, int startJ) {
    
    }
    }
}
