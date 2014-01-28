import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Joiner.on;

public class Plans {
    private List<InvestPlan> investPlans;

    public Plans() {
        investPlans = new ArrayList<>();
    }

    public void add(InvestPlan bestInvestPlan) {
        investPlans.add(bestInvestPlan);
    }

    public String toString() {
        List<String> plansAsString = new ArrayList<>();
        int i = 1;
        for (InvestPlan investPlan : investPlans) {
            plansAsString.add("Case #" + (i++) + ": " + investPlan.toString());
        }
        return on("\n").join(plansAsString);
    }
}
