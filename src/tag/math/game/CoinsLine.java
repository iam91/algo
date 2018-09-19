package tag.math.game;

public class CoinsLine {
    // https://www.lintcode.com/problem/coins-in-a-line/description
    /**
     * @param n: An integer
     * @return: A boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        return (n % 3) != 0;
    }
}
