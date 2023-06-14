package cn.edu.ctgu;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void testRemoveEmptyList() {
        // 初始化空列表
        List<Object> list = new LinkedList<>();

        // 移除不存在的元素
        boolean result = list.remove("element");

        // 断言返回结果为false，且列表为空
        assertFalse(result);
        assertTrue(list.isEmpty());
    }
    @Test
    void testRemoveNonExistingElement() {
        // 初始化包含元素的列表
        List<String> list = new LinkedList<>();
        list.add("element1");
        list.add("element2");
        list.add("element3");

        // 移除不存在的元素
        boolean result = list.remove("nonExistingElement");

        // 断言返回结果为false，且列表不变
        assertFalse(result);
        assertEquals(3, list.size());
    }
    @Test
    void testRemoveExistingElement() {
        // 初始化包含元素的列表
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // 移除存在的元素
        boolean result = list.remove(Integer.valueOf(2));

        // 断言返回结果为true，且列表中不包含被移除的元素
        assertTrue(result);
        assertFalse(list.contains(2));
    }
    @Test
    void testRemoveExistingNullElement() {
        // 初始化包含null元素的列表
        List<String> list = new LinkedList<>();
        list.add("element1");
        list.add(null);
        list.add("element2");

        // 移除null元素
        boolean result = list.remove(null);

        // 断言返回结果为true，且列表中不包含null元素
        assertTrue(result);
        assertFalse(list.contains(null));
    }
    @Test
    void testRemoveDuplicateElement() {
        // 初始化包含重复元素的列表
        List<String> list = new LinkedList<>();
        list.add("element1");
        list.add("element2");
        list.add("element1");
        list.add("element3");

        // 移除第一个出现的重复元素
        boolean result = list.remove("element1");

        // 断言返回结果为true，且列表中只剩下一个"element1"元素
        assertTrue(result);
        assertEquals(3, list.size());
        assertTrue(list.contains("element1"));
    }





}