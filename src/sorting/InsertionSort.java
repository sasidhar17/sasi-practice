package sorting;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class InsertionSort {
    public static List<Integer> sortList(List<Integer> unsortedList) {
        for (int i = 0; i < unsortedList.size(); i++) {
            int current = i;
            // gets the smallest element and inserts at current index
            while (current > 0 && unsortedList.get(current) < unsortedList.get(current - 1)) {
                int temp = unsortedList.get(current);
                // swaps current smaller element with the element before it
                unsortedList.set(current, unsortedList.get(current - 1));
                unsortedList.set(current - 1, temp);
                current--;
            }
        }
        return unsortedList;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> unsortedList = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        List<Integer> res = sortList(unsortedList);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
