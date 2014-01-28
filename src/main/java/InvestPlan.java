import lombok.Data;

import static com.google.common.base.Joiner.on;

@Data
public class InvestPlan {
    private final Integer bestBuyIndex;
    private final Integer bestSellIndex;
    private final Integer profit;

    public String toString() {
        return on(" ").join(bestBuyIndex, bestSellIndex, profit);
    }

    public boolean isBetterThan(InvestPlan anotherInvestPlan) {
        return profit > anotherInvestPlan.getProfit();
    }

}
