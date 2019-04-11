import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinarySearch {
    public BinarySearch() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10000; i += 2) {             //往list加入逐渐增大1-10000的所有偶数，作为实验数组，很明显，他是有序的！
            list.add(i);                       //这里当然也可用数组
        }
        int low = 0;
        int high = list.size();
        int key = 3334;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (key == list.get(mid)) {
                System.out.println("此数值在list中的位置为：" + mid);
                break;
            }
            if (key > list.get(mid)) {
                low = mid + 1;          //当小于时，是low指针向后移动，high指针不变
            }
            if (key < list.get(mid)) {
                high = mid - 1;        //当大于时，是high指针向前移动，low指针不变
            }

        }
        if (low > high) {
            System.out.println("没有查到结果！");
        }
    }
//
//    public static void main(String[] args) {
//       new BinarySearch();
//    }

//    public static void main(String[] args) {
//        List<String> list = new ArrayList();
//        list.add("aa");
//        list.add("bb");
//        list.add("cc");
//        list.add("dd");
//        list.add("bb");
//        list.add("ee");
//        list.add("dd");
//        list.add("ff");
//        String temp = "";
//        for (int i = 0; i < list.size() -1; i++) {
//            temp = (String) list.get(i);
//            for (int j = i + 1; j < list.size(); j++) {
//                if (temp.equals(list.get(j))) {
//                    System.out.println("第" + (i + 1) + "跟第" + (j + 1) + "重复值：" + temp);
//                }
//            }
//        }
//
//        for (String s: list){
//
//        }
//
//    }

    public static void main(String[] args) {
        List<String> list = new LinkedList<String>();
        for (int i = 0; i < 5000; i++) {
            list.add("xiaotang");
        }

        long start = System.currentTimeMillis();
        int size = list.size();
        String str = null;
        for (int i = 0; i < size; i++) {
            str = list.get(i);
        }
        System.out.println("for + get(i)方法: "
                + (System.currentTimeMillis() - start));

        long start2 = System.currentTimeMillis();
        for (String str2 : list) {
        }
        System.out.println("Iterator(foreach)方法:" + (System.currentTimeMillis() - start2));

    }
}

