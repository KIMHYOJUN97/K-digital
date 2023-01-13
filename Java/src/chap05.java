import java.util.*;
import java.io.*;


public class chap05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] lotto = new int[6];

        for(int i=0;i<6;i++)
        {

            int random = (int) (Math.random() * 45 + 1);
            while(true){
                int flag = 0;
                for (int x : lotto) {
                    if (x == random) {
                        random = (int) (Math.random() * 45 + 1);
                    } else {
                        flag = 1;
                        break;
                    }
                }
                if(flag ==1) break;
            }

            lotto[i] = random;

        }

        for (int j = 0; j < lotto.length; j++) {
            for (int k = 0; k < lotto.length-1; k++) {
                if (lotto[k] > lotto[k + 1]) {
                    int tmp = lotto[k];
                    lotto[k] = lotto[k + 1];
                    lotto[k+1] = tmp;
                }
            }
        }

        for (int x : lotto) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}
