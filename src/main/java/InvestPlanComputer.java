import org.fest.util.VisibleForTesting;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Charsets.*;

public class InvestPlanComputer {

    public static void main(String[] args) {
        System.out.println(new InvestPlanComputer().compute(System.in));
    }

    public String compute(InputStream inputStream) {
        return computeAllBestPlans(readAllQuotations(inputStream));
    }

    @VisibleForTesting
    String compute(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(UTF_8));
        return computeAllBestPlans(readAllQuotations(inputStream));
    }

    private List<Quote> readAllQuotations(InputStream input) {
        List<Quote> quotes = new ArrayList<>();
        AllQuotations allQuotations = new AllQuotations(input);
        while (allQuotations.hasNext()) {
            quotes.add(allQuotations.next());
        }
        return quotes;
    }

    public String computeAllBestPlans(List<Quote> quotes) {
        Plans plans = new Plans();
        quotes.forEach(quote -> plans.add(quote.computeBestPlanFor1Year()));
        return plans.toString();
    }


}