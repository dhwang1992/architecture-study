import java.util.*;
import java.util.stream.Collectors;

public class Main1 {

    HashMap<Integer, ArrayList<Integer>> numMap = new HashMap<Integer, ArrayList<Integer>>() {{
        put(1, new ArrayList<>(Arrays.asList(6, 9, 12, 16, 33)));
        put(2, new ArrayList<>(Arrays.asList(1, 8, 9, 22, 32)));
        put(3, new ArrayList<>(Arrays.asList(4, 6, 13, 23, 30)));
        put(4, new ArrayList<>(Arrays.asList(3, 8, 20, 23, 32)));
        put(5, new ArrayList<>(Arrays.asList(1, 2, 3, 8, 32)));
        put(6, new ArrayList<>(Arrays.asList(1, 3, 10, 22, 30)));
        put(7, new ArrayList<>(Arrays.asList(3, 23, 25, 28, 32)));
        put(8, new ArrayList<>(Arrays.asList(16, 2, 32, 11, 15)));
        put(9, new ArrayList<>(Arrays.asList(16, 1, 2, 8, 10)));
        put(10, new ArrayList<>(Arrays.asList(25, 33, 6, 17, 23)));
        put(11, new ArrayList<>(Arrays.asList(12, 8, 31, 16, 18)));
        put(12, new ArrayList<>(Arrays.asList(1, 2, 11, 32, 33)));
        put(13, new ArrayList<>(Arrays.asList(3, 22, 27, 30, 33)));
        put(14, new ArrayList<>(Arrays.asList(2, 17, 21, 22, 25)));
        put(15, new ArrayList<>(Arrays.asList(1, 3, 8, 23, 25)));
        put(16, new ArrayList<>(Arrays.asList(1, 8, 9, 22, 23)));
        put(17, new ArrayList<>(Arrays.asList(10, 14, 16, 29, 32)));
        put(18, new ArrayList<>(Arrays.asList(8, 11, 25, 21, 30)));
        put(19, new ArrayList<>(Arrays.asList(21, 22, 30, 9, 33)));
        put(20, new ArrayList<>(Arrays.asList(30, 32, 4, 8, 33)));
        put(21, new ArrayList<>(Arrays.asList(18, 19, 31, 1, 14)));
        put(22, new ArrayList<>(Arrays.asList(2, 33, 6, 13, 14)));
        put(23, new ArrayList<>(Arrays.asList(4, 7, 10, 16, 29)));
        put(24, new ArrayList<>(Arrays.asList(2, 5, 1, 16, 33)));
        put(25, new ArrayList<>(Arrays.asList(7, 10, 18, 22, 29)));
        put(26, new ArrayList<>(Arrays.asList(28, 21, 8, 9, 25)));
        put(27, new ArrayList<>(Arrays.asList(1, 13, 22, 32, 9)));
        put(28, new ArrayList<>(Arrays.asList(30, 7, 26, 2, 16)));
        put(29, new ArrayList<>(Arrays.asList(3, 8, 11, 16, 21)));
        put(30, new ArrayList<>(Arrays.asList(18, 28, 6, 13, 20)));
        put(31, new ArrayList<>(Arrays.asList(9, 14, 15, 21, 29)));
        put(32, new ArrayList<>(Arrays.asList(2, 8, 4, 17, 20)));
        put(33, new ArrayList<>(Arrays.asList(1, 22, 10, 13, 30)));
    }};
    ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33));


    void test() {
        for (int j = 1; j <= 28; j++) {
            ArrayList<Integer> winners = new ArrayList<>(Arrays.asList(j));
            ArrayList<Integer> totalExclusion = numMap.get(j);

            findAllPossibilities(winners, getLeftAvailableNumbers(new ArrayList<>(nums.subList(j, 33)), totalExclusion), 5);
        }
    }

    ArrayList<Integer> getLeftAvailableNumbers(List<Integer> numbers, ArrayList<Integer> exclusion) {
        return new ArrayList<>(numbers.stream().filter(n -> !exclusion.contains(n)).collect(Collectors.toList()));
    }

    void findAllPossibilities(List<Integer> winners, ArrayList<Integer> numbers, int supposedNum) {
//        System.out.println("winners..." + winners);
//        System.out.println("numbers..." + numbers);
//        System.out.println("supposedNum..." + supposedNum);
        if(numbers.size() > supposedNum && winners.size() != 6) {
            for (int index = 0; index < numbers.size(); index++) {
                List<Integer> newWinners = winners.subList(0, 6 - supposedNum);
                ArrayList<Integer> indexExclusions = numMap.get(numbers.get(index));
                boolean isExclusiveWithWinners = indexExclusions.stream().anyMatch(exclusion -> newWinners.contains(exclusion));
                if (isExclusiveWithWinners) {
                    continue;
                }
                newWinners.add(numbers.get(index));

                //System.out.println("index..." + index + "...supposedNum.." + supposedNum);
                if (index != numbers.size() - 1) {
                    ArrayList<Integer> leftNumbers = getLeftAvailableNumbers(numbers.subList(index + 1, numbers.size()), indexExclusions);
                    findAllPossibilities(newWinners, leftNumbers, supposedNum - 1);
                } else {
                    if (newWinners.size() == 6) {
                        if(isValidWinners(newWinners))
                            System.out.println(newWinners);
                    }
                }
            }
        } else{
            if (supposedNum == 0 || winners.size() == 6) {
//                System.out.println( "刚好有六个." + winners);
                if(isValidWinners(winners))
                    System.out.println(winners);
            }else if (numbers.size() == supposedNum) {
                winners.addAll(numbers);
//                System.out.println( "...刚好剩三个." + winners);
                if(isValidWinners(winners))
                    System.out.println(winners);
            }
        }

    }
    boolean isValidWinners(List<Integer> winners) {
        Integer sum = winners.get(0) + winners.get(1) + winners.get(2) + winners.get(3) + winners.get(4)
        + winners.get(5);
        return winners.get(0) % 2 == 0 && winners.get(1) % 2 == 0
                && winners.get(2) %2 ==0 && winners.get(3)%2 == 1
                && winners.get(4)%2 ==1 && winners.get(5)%2 == 0
                && winners.get(0)< 9 && winners.get(1) <= 11
                && winners.get(2) > 11 & winners.get(2) < 16 && winners.get(3) <=22
                && winners.get(5) > 25 && winners.get(4) > 22
                &&(sum >=81 && sum < 120)
                ;
    }
}
