import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main3 {
    HashMap<Integer, ArrayList<Integer>> exclusiveMap = new HashMap<Integer, ArrayList<Integer>>() {{
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
    ArrayList<Integer> totalNums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33));
    ArrayList<List<Integer>> totalSelectedNums = new ArrayList<>();
    public void test() {
        selectedValidNum(1, new ArrayList<>(), new ArrayList<>());
    }

    public void selectedValidNum(int begin, ArrayList<Integer> selectedNums, ArrayList<Integer> totalExclusiveNums) {
        ArrayList<Integer> optionalNums = new ArrayList<>();
        if (begin == 1) {
            selectedNums.add(1);
            //互斥数组需要叠加
            totalExclusiveNums.addAll(exclusiveMap.get(1));
            System.out.println("totalExclusiveNums is" + totalExclusiveNums);
            begin++;
        }
        //todo::递归结束的条件
        if (selectedNums.size() >= 6) {
            System.out.println("selectedNums111 is" + selectedNums);
            return;
        }
        // 第一个数是1，接下来获取第二个数所有的可能性
        for (int i = begin; i <= totalNums.size(); i++) {
            // 判断第二个数是否合法
            // 1. 当前数是否已经在selectedNums里面
            // 2. 当前数的互斥数是否包含在selectedNums里面
            // 3. 当前数是否在总的互斥数组里面
            boolean existedInSelectNums = selectedNums.contains(i);
            boolean existedInExclusive = exclusiveMap.get(i)!= null && exclusiveMap.get(i).stream().anyMatch(e -> selectedNums.contains(e));
            boolean existedInTotalExclusive = totalExclusiveNums.stream().anyMatch(e -> selectedNums.contains(e));
            if (!existedInSelectNums && !existedInExclusive && !existedInTotalExclusive) {
                //组装下一个数的optionalNums
                optionalNums.add(i);
            }
        }

        //根据组装的optionalNums来组装selectedNums
        System.out.println("selectedNums is" + selectedNums);
        System.out.println("optionalNums is" + optionalNums);
        for (int i = 0; i < optionalNums.size(); i++) {
            // i=19 -》 进来了 19 28 30

            // 选择第二个数，并重新计算第三个数的optionNums
            Integer currentSelectedNum = optionalNums.get(i);
            selectedNums.add(currentSelectedNum);
            // 只有互斥数被设置了，才会加入totalExclusiveNums中
            if (exclusiveMap.get(currentSelectedNum) != null) {
                totalExclusiveNums.addAll(exclusiveMap.get(currentSelectedNum));
            }
            if (selectedNums.size() == 6) {
                totalSelectedNums.add(selectedNums);
                System.out.println("已经被选中的数据"+ totalSelectedNums);
                // 如果optional里面还有值，则继续选最后一位数，如果没有，则往前再选一位
                selectedNums.remove(5);
                break;
            }
            //计算第三个数，进入递归optionalNums要重新计算
            selectedValidNum(currentSelectedNum+1, selectedNums, totalExclusiveNums);
        }
    }
}
