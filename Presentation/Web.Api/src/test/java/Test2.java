import java.util.ArrayList;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {


        List<String> slist = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            slist.add(String.valueOf(i));
        }


        int size = slist.size();

        for (int i = 0; i < size; ++i) {


            System.out.println("主动匹配的:" + slist.get(i));

            for (int n = i + 1; n < size; n++) {

                System.out.println(slist.get(n));

            }

            System.out.println("下一个");

        }

    }

}
