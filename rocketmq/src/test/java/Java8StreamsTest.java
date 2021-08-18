import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @Project: test
 * @Pacakge: PACKAGE_NAME
 * @Author: liuxianglin
 * @Description: TODO
 * @Date: Created in 21:20 2021/7/13
 */
public class Java8StreamsTest {
    public static void main(String[] args) {
        // 过滤空字符串
//        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
//        strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList()).forEach(System.out::println);

        // 随机输出10个随机数
//        Random random = new Random();
//        random.ints().limit(10).forEach(System.out::println);

        // 获取对应的平方数
//        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 去重后计算平方数
//        numbers.stream().map(i -> i * i).distinct().forEach(System.out::println);
        // 去重后计算平方数，返回成集合
//        numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList()).forEach(System.out::println);

        // 获取空字符串的数量
//        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
//        long count = strings.stream().filter(string -> string.isEmpty()).count();
//        System.out.println(count);

        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

    }
}
