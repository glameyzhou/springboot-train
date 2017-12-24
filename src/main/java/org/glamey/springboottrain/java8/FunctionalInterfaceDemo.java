package org.glamey.springboottrain.java8;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author zhouyang.zhou
 * @date 2017.12.23.23
 */
public class FunctionalInterfaceDemo {

    public static void main(String[] args) {

        // Consumer
        List<String> list = Lists.newArrayList("a", "b", "c");
        list.forEach(s -> System.out.println(s));
        System.out.println("--------->");


        //Supplier
        List<Integer> randomList = generate(10, () -> new Random().nextInt(100));
        randomList.stream().forEach(System.out::println);
        System.out.println("--------->");

        //Function
        String subString = stringHandler("abc", s -> s.substring(2));
        System.out.println(subString);
        System.out.println("--------->");


        //Predicate
        List<Integer> numList = Lists.newArrayList(1, 2, 3, 4, 5, 6);
        List<Integer> collect = numList.stream().filter(s -> s > 3).collect(Collectors.toList());
        collect.forEach(System.out::println);


        //默认构造函数
        List<UserDomain> userDomains = generate(3, UserDomain::new);
        userDomains.forEach(System.out::println);

    }

    private static String stringHandler(String source, Function<String, String> function) {
        return function.apply(source);
    }

    private static <T> List<T> generate(int count, Supplier<T> supplier) {
        List<T> list = Lists.newArrayListWithCapacity(count);
        for (int i = 0; i < count; i++) {
            list.add(supplier.get());
        }
        return list;
    }
}
