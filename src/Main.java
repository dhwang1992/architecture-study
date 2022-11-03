import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33);
        List<Integer> selectedNums = new ArrayList<>();

        HashMap<Integer, List<Integer>> numMap = new HashMap<>();
        numMap.put(1, Arrays.asList(6, 9, 12, 16, 33));
        numMap.put(2, Arrays.asList(1, 8, 9, 22, 32));
        numMap.put(3, Arrays.asList(4, 6, 13, 23, 30));
        numMap.put(4, Arrays.asList(3, 8, 20, 23, 32));
        numMap.put(5, Arrays.asList(1, 2, 3, 8, 32));
        numMap.put(6, Arrays.asList(1, 3, 10, 22, 30));
        numMap.put(7, Arrays.asList(3, 23, 25, 28, 32));
        numMap.put(8, Arrays.asList(2, 11, 15, 16, 32));


        int j = 0;

        for (int i = 0; i < 6; i++) {
            Integer selectedNum = nums.get(j); //选出来的是2
            List<Integer> exclusive = numMap.get(selectedNum);
            boolean exist = selectedNums.stream().anyMatch(s -> s != null && exclusive.contains(s));
            if (exist) {
                j++;
                continue;
            }
            j++;
            if (selectedNums.size() == 6) {
                break;
            }
        }
        System.out.println(selectedNums);
    }
}
