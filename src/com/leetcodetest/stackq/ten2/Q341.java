package com.leetcodetest.stackq.ten2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 扁平化嵌套列表迭代器
 */
public class Q341 {
    static public class NestedIterator implements Iterator<Integer> {

        List<Integer> list = new ArrayList<>();

        int index = 0;

        public NestedIterator(List<NestedInteger> nestedList) {
            for (NestedInteger integer : nestedList) {
                push2list(integer);
            }
        }

        private void push2list(NestedInteger integer) {
            if (integer.isInteger()) {
                list.add(integer.getInteger());
            } else {
                for (NestedInteger nestedInteger : integer.getList()) {
                    push2list(nestedInteger);
                }
            }
        }

        @Override
        public Integer next() {
            return list.get(index++);
        }

        @Override
        public boolean hasNext() {
            return index != list.size();
        }
    }
}
