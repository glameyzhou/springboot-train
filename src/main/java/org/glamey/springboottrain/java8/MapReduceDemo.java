package org.glamey.springboottrain.java8;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author zhouyang.zhou
 * @date 2017.12.23.20
 */
public class MapReduceDemo {

    private static final List<UserDomain> userDomains = Lists.newArrayList();

    static {
        userDomains.add(new UserDomain("glamey", "格莱美", 33, 33000d, UserDomain.Status.FREE));
        userDomains.add(new UserDomain("zhangsan", "张三", 30, 30000d, UserDomain.Status.BUSY));
        userDomains.add(new UserDomain("lisi", "李四", 31, 31000d, UserDomain.Status.FREE));
        userDomains.add(new UserDomain("lisi", "李四", 31, 31000d, UserDomain.Status.FREE));
        userDomains.add(new UserDomain("wangwu", "王五", 32, 32000d, UserDomain.Status.BUSY));
        userDomains.add(new UserDomain("wangwu", "王五", 32, 32000d, UserDomain.Status.BUSY));
        userDomains.add(new UserDomain("zhaoliu", "赵六", 33, 33000d, UserDomain.Status.FREE));
    }


    public static void main(String[] args) {
//        handlerFilter();
//        handlerMapper();
//        handlerOrder();
//        handlerGroupBy();

        handlerSkip();


    }

    private static void handlerSkip() {
        userDomains.stream()
                .distinct()
                .skip(2)
                .limit(2)
                .forEachOrdered(System.out::println);
    }

    private static void handlerGroupBy() {
        //先按照状态分组，再按照年龄分组
        Map<UserDomain.Status, Map<Integer, List<UserDomain>>> collect = userDomains.stream()
                .collect(Collectors.groupingBy(UserDomain::getStatus, Collectors.groupingBy(UserDomain::getAge)));

        for (Map.Entry<UserDomain.Status, Map<Integer, List<UserDomain>>> entry : collect.entrySet()) {
            UserDomain.Status status = entry.getKey();
            System.out.println(status);
            Map<Integer, List<UserDomain>> map = entry.getValue();
            for (Map.Entry<Integer, List<UserDomain>> e : map.entrySet()) {
                System.out.println(e.getKey() + " --> " + e.getValue());
            }

            System.out.println("--------");
        }


    }

    private static void handlerOrder() {
        userDomains.stream()
                .sorted((v1, v2) -> {
                    int salaryCompared = v1.getSalary().compareTo(v2.getSalary());
                    if (salaryCompared == 0) {
                        return v1.getCode().compareTo(v2.getCode());
                    }
                    return salaryCompared;
                })
                .forEach(System.out::println);


        //测试倒序排列
        List<String> list = Lists.newArrayList("a", "b", "c", "d");
        list.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

    }

    private static void handlerMapper() {
        //所有的状态
        userDomains.stream()
                .map(UserDomain::getStatus)
                .collect(Collectors.toSet())
                .forEach(System.out::println);


        //所有的薪水统计
        Optional<Double> sumSalary = userDomains.stream()
                .map(UserDomain::getSalary)
                .reduce((s1, s2) -> s1 + s2);
        System.out.println(sumSalary.get());
    }

    private static void handlerFilter() {
        System.out.println(userDomains.stream().count());
        userDomains.stream()
                .distinct()
                .filter(value -> value.getStatus().equals(UserDomain.Status.BUSY))
                .forEach(System.out::println);


    }
}
