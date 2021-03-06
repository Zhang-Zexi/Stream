package com.aqumon.zzx.stream;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Stream.concat;

/**
 * 流的四种构建形式
 */
public class StreamConstructor {

    /**
     * 由数值直接构建流
     */
    @Test
    public void streamFromValue() {
//        String a = "11";
        Stream stream = Stream.of(1, 2, 3, 4, 5);
//        Stream stream1 = Stream.of(a, 2, 3, 4, 5);

        stream.forEach(System.out::println);
    }

    /**
     * 通过数组构建流
     */
    @Test
    public void streamFromArray() {
        int[] numbers = {1, 2, 3, 4, 5};

        IntStream stream = Arrays.stream(numbers);
        stream.forEach(System.out::println);
    }

    /**
     * 通过文件生成流
     * @throws IOException
     */
    @Test
    public void streamFromFile() throws IOException {
        // TODO 此处替换为本地文件的地址全路径
        String filePath = "D:\\02-Workspace\\Stream\\src\\test\\java\\com\\aqumon\\zzx\\stream\\StreamConstructor.java";

        Stream<String> stream = Files.lines(
                Paths.get(filePath));

        stream.forEach(System.out::println);
    }

    /**
     * 通过函数生成流（无限流）
     */
    @Test
    public void streamFromFunction() {

//        1.迭代的方式生成流（初始值+生成方法）
//        Stream stream = Stream.iterate(0, n -> n + 2);

//        2.迭代器生成流（随机生成）
        Stream stream = Stream.generate(Math::random);

        stream.limit(100)
                .forEach(System.out::println);

    }

}
