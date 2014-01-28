public class BadInvestPlan extends InvestPlan {

    public BadInvestPlan() {
        super(-1, -1, 0);
    }

    @Override
    public String toString() {
        return "IMPOSSIBLE";
    }
}
