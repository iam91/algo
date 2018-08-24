package tag.topk;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Median {
    private PriorityQueue<Integer> upper;
    private PriorityQueue<Integer> lower;

    public Median() {
        upper = new PriorityQueue<>();
        lower = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
    }

    public void addNum(int num) {
        if(upper.size() == 0) {
            upper.offer(num);
            return;
        }

        if(upper.size() == lower.size()) {
            if(num > upper.peek()) {
                upper.offer(num);
            } else {
                if(num < lower.peek()) {
                    upper.offer(lower.poll());
                    lower.offer(num);
                } else {
                    upper.offer(num);
                }
            }
        } else {
            if(num > upper.peek()) {
                lower.offer(upper.poll());
                upper.offer(num);
            } else {
                lower.offer(num);
            }
        }
    }

    public double findMedian() {
        if(upper.size() == lower.size()) {
            return (upper.peek() + lower.peek()) / 2.0;
        } else {
            return upper.peek();
        }
    }

    public static void main(String[] args) {
        Median m = new Median();
        m.addNum(-1);
        m.addNum(-2);
        m.addNum(-3);
        m.addNum(-4);
        m.addNum(-5);
        System.out.println(m.findMedian());
    }
}
