import lombok.Data;

import java.util.List;

@Data
public class Quote {
    public static final int MAX_MONTH = 12;
    private final int amount;
    private final List<Integer> marketPrices;

    public InvestPlan computeBestPlanFor1Year() {
        InvestPlan bestInvestPlan = new BadInvestPlan();
        for (int buyMonth = 1; buyMonth <= MAX_MONTH - 1; buyMonth++) {
            for (int sellMonth = buyMonth + 1; sellMonth <= MAX_MONTH; sellMonth++) {
                InvestPlan investPlan = getInvestPlanFor(buyMonth, sellMonth);
                if (investPlan.isBetterThan(bestInvestPlan)) {
                    bestInvestPlan = investPlan;
                }
            }
        }
        return (bestInvestPlan);
    }

    private InvestPlan getInvestPlanFor(int buyMonth, int sellMonth) {
        int buyPrice = marketPrices.get(buyMonth - 1);
        int sellPrice = marketPrices.get(sellMonth - 1);
        int profit = (amount / buyPrice) * (sellPrice - buyPrice);
        return new InvestPlan(buyMonth, sellMonth, profit);
    }
}
