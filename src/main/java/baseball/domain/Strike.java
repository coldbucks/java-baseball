package baseball.domain;

import java.util.HashMap;

public class Strike {
    private static final int STRIKE_LOWER_BOUND = 0;
    private static final int STRIKE_UPPER_BOUND = 3;
    private static final int STRIKE_OUT = 3;
    private static final HashMap<Integer, Strike> CACHE = new HashMap<>();

    static {
        for (int i = STRIKE_LOWER_BOUND; i <= STRIKE_UPPER_BOUND; i++) {
            CACHE.put(i, new Strike(i));
        }
    }

    private Integer count;

    private Strike(Integer count) {
        validate(count);
        this.count = count;
    }

    public boolean isStrikeOut() {
        return count.equals(STRIKE_OUT);
    }

    public static Strike valueOf(int count) {
        validate(count);
        return CACHE.get(count);
    }

    private static void validate(Integer number) {
        if (number < STRIKE_LOWER_BOUND || STRIKE_UPPER_BOUND < number) {
            throw new BaseballGameException();
        }
    }
}