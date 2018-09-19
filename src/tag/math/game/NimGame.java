package tag.math.game;

public class NimGame {
    // https://leetcode.com/problems/nim-game/description/

    public boolean canWinNim(int n) {
        return (n % 4) != 0;
    }
}
