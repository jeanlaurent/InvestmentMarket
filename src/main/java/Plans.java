import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Joiner.on;

public class Plans {
    private List<Plan> allPlans;

    public Plans() {
        allPlans = new ArrayList<>();
    }

    public void add(Plan bestPlan) {
        allPlans.add(bestPlan);
    }

    public String toString() {
        List<String> plansAsString = new ArrayList<>();
        int i = 1;
        for (Plan plan : allPlans) {
            plansAsString.add("Case #" + (i++) + ": " + plan.toString());
        }
        return on("\n").join(plansAsString);
    }
}
