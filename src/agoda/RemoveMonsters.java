package agoda;

import java.util.Arrays;

public class RemoveMonsters {
    public static int eliminateMaximum(int[] dist, int[] speed) {
        double[] arrival = new double[dist.length];
        for(int i = 0; i < dist.length; i++) {
            arrival[i] = (double) dist[i] / speed[i];
        }

        Arrays.sort(arrival);
        int monstersEliminated = 0;
        for(int i = 0; i < arrival.length; i++) {
            if(arrival[i] <= i) {
                break;
            }
            monstersEliminated++;
        }

        return monstersEliminated;
    }

    public static void main(String[] args) {
        System.out.println(eliminateMaximum(new int[]{1,3,4}, new int[] {1,1,1}));
    }
}
