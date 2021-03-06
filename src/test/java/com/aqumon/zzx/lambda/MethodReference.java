package com.aqumon.zzx.lambda;

import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author zhangzx
 *
 * 三种方法引用
 */
public class MethodReference {

    /**
     *  1. 指向静态方法的方法引用
     *
     * (args) -> ClassName.staticMethod(args);
     * ClassName::staticMethod;
     * 如果是一个对象调用它的静态方法时，我们就可以使用这个方法了
     */
    public void test1() {
        Consumer<String> consumer1
                = (String number) -> Integer.parseInt(number);

        Consumer<String> consumer2
                = Integer::parseInt;
    }

    @Test
    public void testOne() {
        List<Integer> list = Arrays.asList(82,22,34,50,9);
//        list.sort((a, b) -> a.compareTo(b));
        list.sort(Integer::compare);
        System.out.println(list);
    }

    /**
     * 2. 指向任意类型实例方法的方法引用
     *
     * (args) -> args.instanceMethod();
     * ClassName::instanceMethod;
     * 如果调用传入参数的实例方法
     *
     * (实例方法相对于静态方法（或者叫类方法）而言，它就是没有 static 前缀的一类一般方法，被对象拥有
     * 特点是定义的时候前面没有 static 前缀，本类中直接调用的时候必须也在实例方法内，否则调用前必须先实例出一个对象。)
     *
     */
    public void test2() {
        Consumer<String> consumer1
                = (String str) -> str.length();

        Consumer<String> consumer2
                = String::length;
    }

    @Test
    public void testTwo() {
        String s = "汤键";
        Supplier<Integer> s1 = () -> s.length();
        System.out.println(s1.get());
        Supplier<Integer> s2 = s::length;
        System.out.println(s2.get());
    }



    /**
     * 3. 指向现有对象的实例方法的方法引用
     *
     * (args) -> object.instanceMethod(args);
     * object::instanceMethod;
     * 如果外部对象调用它自己的方法
     *
     * 实例方法引用，顾名思义就是调用已经存在的实例的方法，与静态方法引用不同的是类要先实例化，静态方法引用类无需实例化，直接用类名去调用。
     */
    public void test3() {
        StringBuilder stringBuilder = new StringBuilder();

        Consumer<String> consumer1
                = (String str) -> stringBuilder.append(str);

        Consumer<String> consumer2
                = stringBuilder::append;
    }

    @Test
    public void testThree() {
//        TestInstanceReference test = new TestInstanceReference();
        User user = new User("汤键",32);
        Supplier<String> supplier = () -> user.getName();
        System.out.println("Lambda表达式输出结果：" + supplier.get());

        Supplier<String> supplier2 = user::getName;
        System.out.println("实例方法引用输出结果：" + supplier2.get());
    }

    @Data
    class User {

        private String name;
        private Integer age;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }



}
