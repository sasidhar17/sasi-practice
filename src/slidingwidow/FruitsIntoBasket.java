package slidingwidow;

import java.util.HashMap;

public class FruitsIntoBasket {

    public static int fruits(int[] fruits) {
        int start = 0;
        HashMap<Integer, Integer> basket = new HashMap<>();
        int maxFruit = 0;

        for(int end = 0; end < fruits.length; end++) {
           basket.put(fruits[end], basket.getOrDefault(fruits[end], 0) + 1);

           while (basket.size() > 2) {
               basket.put(fruits[start], basket.get(fruits[start] - 1));
               if (basket.get(fruits[start]) == 0) {
                   basket.remove(fruits[start]);
               }
               start++;
           }
           maxFruit = Math.max(maxFruit, end -start +1);
        }

        return maxFruit;
    }
}
