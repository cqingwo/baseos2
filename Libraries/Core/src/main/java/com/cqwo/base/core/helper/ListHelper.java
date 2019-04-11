package com.cqwo.base.core.helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListHelper {


    // 删除ArrayList中重复元素，保持顺序
    public static void removeDuplicateWithOrder(List list) {
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Object element : list) {
            if (set.add(element)) {
                newList.add(element);
            }
        }
        list.clear();
        list.addAll(newList); //System.out.println(" remove duplicate " + list);
    }
}
