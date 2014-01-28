import lombok.Data;

@Data
public class InvestPlan {
    private final Integer bestBuyIndex;
    private final Integer bestSellIndex;
    private final Integer profit;

    public String toString() {
        return bestBuyIndex + " " + bestSellIndex + " " + profit;
    }

    public boolean isBetterThan(InvestPlan anotherInvestPlan) {
        return profit > anotherInvestPlan.getProfit();
    }

}
