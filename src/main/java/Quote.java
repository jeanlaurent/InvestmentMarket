import lombok.Data;

import java.util.List;

@Data
public class Quote {
    public static final int MAX_MONTH = 12;
    private final int amount;
    private final List<Integer> marketPrices;

    public Plan computeBestPlanFor1Year() {
        Plan bestPlan = new BadPlan();
        for (int buyMonth = 1; buyMonth <= MAX_MONTH - 1; buyMonth++) {
            for (int sellMonth = buyMonth + 1; sellMonth <= MAX_MONTH; sellMonth++) {
                Plan plan = getInvestPlanFor(buyMonth, sellMonth);
                if (plan.isBetterThan(bestPlan)) {
                    bestPlan = plan;
                }
            }
        }
        return bestPlan;
    }

    private Plan getInvestPlanFor(int buyMonth, int sellMonth) {
        int buyPrice = marketPrices.get(buyMonth - 1);
        int sellPrice = marketPrices.get(sellMonth - 1);
        int profit = (amount / buyPrice) * (sellPrice - buyPrice);
        return new Plan(buyMonth, sellMonth, profit);
    }
}
