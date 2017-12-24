package org.glamey.springboottrain.java8;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhouyang.zhou
 * @date 2017.12.23.20
 */
public class MapReduceDemo {

    public static void main(String[] args) {

        List<String> list = Lists.newArrayList(
                "java",
                "java",
                "php",
                "python",
                "python",
                "goLang",
                "JavaScript"
        );


        System.out.println(list.stream().count());

        List<String> result = list.parallelStream()
                .distinct()
                .filter(s -> s.contains("p"))
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}
