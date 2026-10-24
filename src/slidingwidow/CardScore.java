package slidingwidow;

/*
    Given an array of integers representing card values,
    write a function to calculate the maximum score you can achieve by
    picking exactly k cards.
    You must pick cards in order from either end.
    You can take some cards from the beginning, then switch to
    taking cards from the end, but you cannot skip cards or pick from the middle.

    maxScore([2, 11, 4, 5, 3, 9, 2], 3)
 */

public class CardScore {
    public static int maxScore(int[] cards, int k) {
        int currentScore = 0;

        for (int i = 0; i < k; i++) {
            currentScore += cards[i];
        }

        int maxScore = currentScore;

        for (int takenFromEnd = 1; takenFromEnd <= k; takenFromEnd++) {
            currentScore -= cards[k - takenFromEnd];
            currentScore += cards[cards.length - takenFromEnd];

            maxScore = Math.max(maxScore, currentScore);
        }
        return maxScore;
    }

    public static void main(String[] args) {
        int[] cards = {2, 11, 4, 5, 3, 9, 2};
        int k = 3;

        System.out.println(maxScore(cards, k)); // 17
    }

}
