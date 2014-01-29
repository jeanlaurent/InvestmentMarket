import lombok.Data;

import static com.google.common.base.Joiner.on;

@Data
public class Plan {
    private final Integer buyMonth;
    private final Integer sellMonth;
    private final Integer profit;

    public String toString() {
        return on(" ").join(buyMonth, sellMonth, profit);
    }

    public boolean isBetterThan(Plan plan) {
        return profit > plan.getProfit();
    }

}
