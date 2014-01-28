import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class Plans {
    private List<InvestPlan> investPlans;

    public Plans() {
        investPlans = new ArrayList<InvestPlan>();
    }

    public void add(InvestPlan bestInvestPlan) {
        investPlans.add(bestInvestPlan);
    }

    public String toString() {
        List<String> plansAsString = new ArrayList<String>();
        int i = 1;
        for(InvestPlan investPlan: investPlans) {
            plansAsString.add("Case" + format(" #%d: ", i++) + investPlan.toString());
        }
        return Joiner.on("\n").join(plansAsString);
    }
}
