package com.aqumon.zzx.stream;

import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Stream.concat;

/**
 * 补充：Stream合并流操作
 */
public class StreamConcat {

    /**
     * 合并2个流
     */
    @Test
    public void concatStreamTest1() {
        Stream<Integer> firstStream = Stream.of(1, 2, 3);
        Stream<Integer> secondStream = Stream.of(4, 5, 6);

        Stream<Integer> resultingStream = concat(firstStream, secondStream);

        System.out.println( resultingStream.collect(Collectors.toList()) );
    }

    /**
     * 合并多个流Stream
     */
    @Test
    public void concatStreamTest2() {
        Stream<Integer> first = Stream.of(1, 2);
        Stream<Integer> second = Stream.of(3,4);
        Stream<Integer> third = Stream.of(5, 6);
        Stream<Integer> fourth = Stream.of(7,8);

        Stream<Integer> resultingStream = concat(first, concat(second, concat(third, fourth)));

        System.out.println( resultingStream.collect(Collectors.toList()) );
    }

    /**
     * 不同类型流的合并
     */
    @Test
    public void concatStreamTest3() {
        Integer[] arr = {1, 2, 3, 4, 5, 6};
        Stream<Integer> arr1 = Stream.of(arr);
        Stream<String> stringStream = Stream.of("a", "b", "x", "d");
        Stream<? extends Serializable> concat = Stream.concat(arr1, stringStream);
        concat.forEach(str-> System.out.println(str));
    }


}
