import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yang 2021-07-12 21:38
 */
public class MyTest {
    public static void main(String[] args) {
        int t = 0;
        while (true) {
            if (++t > 1) break;
        }
        System.out.println(t);

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(0, 1);
        System.out.println(map.get(0));

        String[] s = new String[3];
        String s1 = "123";
        s[0] = s1;

        String a = "01234";
        System.out.println(a.substring(1, 3));

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list.get(0));

        char b = 97;
        System.out.println(b);
        int c = b;
        System.out.println(c);

        HashMap<String, String> map1 = new HashMap<>();
        map1.put("p", "");
        map1.put("q", null);
        System.out.println(map1);

        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("a", 11);
        System.out.println(map2.get("a"));

        HashMap<Integer, Integer> e = new HashMap<>();
        HashMap<Integer, Integer> d = new HashMap<>();
        ArrayList<Map<Integer, Integer>> maps = new ArrayList<>();
        for (Map<Integer, Integer> integerMap : maps) {
            integerMap.put(1, 2);
        }
        System.out.println(maps);
        System.out.println(e);
        System.out.println(d);

        int[] arr = {1, 2, 3};
        Arrays.stream(arr)
                .filter(i -> i > 1)
                .map(i -> i + 10)
                .forEach(System.out::println);

        System.out.println(Arrays.toString(new int[1]) + "  new int[1] 为");

        System.out.println(System.getProperty("user.dir"));

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        System.out.println(list1.get(0));

        HashMap<String, String> map3 = new HashMap<>();
        map3.put("1", "1");
        map3.put("1", "2");
        System.out.println(map3);

        System.out.println(13 / 6);

        ArrayList<Integer> list2 = new ArrayList<>();
        System.out.println("12/30 test");
        list2.add(2);
        list2.add(3);
        System.out.println(list2);
        System.out.println(list2.remove(0));
        System.out.println(list2.remove(0));
        System.out.println(list2);

        System.out.println(1/2);

        System.out.println((int) 1e9 + 7);
        System.out.println(Integer.MAX_VALUE);

        int[] ints = new int[1 + 1];
        Arrays.fill(ints,3);
        System.out.println(Arrays.toString(ints));

        int aa = 'a';
        int zz = 'z';
        System.out.println(aa);
        System.out.println(zz);
    }
}
