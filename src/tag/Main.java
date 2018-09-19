package tag;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int k = Integer.parseInt(sc.nextLine());
//        String s1 = sc.nextLine();
//        String s2 = sc.nextLine();
//
//        HashMap<String , Integer> map = new HashMap<>();
//
//        int startIdx = 0, endIdx = k;
//        int n1 = s1.length();
//        int n2 = s2.length();
//        
//        while(endIdx <= n1) {
//            map.putIfAbsent(s1.substring(startIdx, endIdx), 0);
//            startIdx++;
//            endIdx++;
//        }
//        
//        startIdx = 0;
//        endIdx = k;
//        while(endIdx <= n2) {
//            String sub = s2.substring(startIdx, endIdx);
//            if(map.containsKey(sub)) {
//                map.put(sub, map.get(sub) + 1);
//            }
//            startIdx ++;
//            endIdx ++;
//        }
//
//        int result = 0;
//        for (String key : map.keySet()) {
//            result = result + map.get(key);
//        }
//
//        System.out.println(result);
//    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        int cnt = 0;

        for(int i=1; i <= x; i++){
            for(int j=1; j <= y; j++){
                for(int k = Math.min(z,i+j-1); k >= 1; k--){
                    if(Math.abs(i-j) < k && k < i + j) {
                        cnt += k - Math.abs(i - j);
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}