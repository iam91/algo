package tag.math.random;

import tag.SolBase;

public class Rand10 {
    // https://leetcode.com/problems/implement-rand10-using-rand7/description/
    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     * @return a random integer in the range 1 to 7
     */
    class Solution extends SolBase {
        public int rand10() {
            int row, col, idx;
            do {
                row = rand7();
                col = rand7();
                idx = col + (row - 1) * 7;
            } while (idx > 40);
            return 1 + (idx - 1) % 10;
        }
    }
}
