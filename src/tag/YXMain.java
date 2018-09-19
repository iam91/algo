package tag;

import java.util.*;

public class YXMain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] val = in.nextLine().split(" ");
        int n = Integer.valueOf(val[0]);
        int m = Integer.valueOf(val[1]);
        int k = Integer.valueOf(val[2]);

        String wordLine = in.nextLine();
        Set<String> words = new HashSet<>();
        for(String w: wordLine.split(" ")) words.add(w);

        HashMap<String, Set<String>> map = new HashMap<>();
        HashMap<String, Integer> order = new HashMap<>();
        for(int i = 0; i < m; i++) {
            String addr = in.nextLine();
            String content = in.nextLine();

            HashSet<String> set = new HashSet<>();
            for(String cont: content.split(" ")) {
                set.add(cont);
            }
            map.put(addr, set);
            order.put(addr, i);
        }

        boolean flag = true;
        HashMap<String, Integer> spams = new HashMap<>();
        while(flag) {
            flag = false;
            List<String> tt = new ArrayList<>();
            for(String addr: map.keySet()) {
                Set<String> set = map.get(addr);

                int cnt = 0;
                for(String w: words) {
                    if(set.contains(w)) cnt++;
                }
                if(cnt >= k) {
                    flag = true;
                    for(String w: set) {
                        words.add(w);
                    }
                    spams.put(addr, order.get(addr));
                    tt.add(addr);
                }
            }
            for(String ttt: tt) map.remove(ttt);
        }
        List<Map.Entry<String, Integer>> sp = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: spams.entrySet()) {
            sp.add(entry);
        }

        Collections.sort(sp, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        for(Map.Entry<String, Integer> o: sp) {
            System.out.println(o.getKey());
        }
    }
}
