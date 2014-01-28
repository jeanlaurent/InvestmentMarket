import com.google.common.base.Charsets;
import org.fest.util.VisibleForTesting;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class InvestPlanComputer {

    public static void main(String[] args) {
        System.out.println(new InvestPlanComputer().compute(System.in));
    }

    public String compute(InputStream inputStream) {
        return computeAllBestPlans(readAllQuotations(inputStream));
    }

    @VisibleForTesting
    String compute(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(Charsets.UTF_8));
        return computeAllBestPlans(readAllQuotations(inputStream));
    }

    private List<Quotation> readAllQuotations(InputStream input) {
        List<Quotation> quotations = new ArrayList<Quotation>();
        QuotationFetcher quotationFetcher = new QuotationFetcher(input);
        while (quotationFetcher.hasNext()) {
            quotations.add(quotationFetcher.fetch());
        }
        return quotations;
    }

    public String computeAllBestPlans(List<Quotation> quotations) {
        Plans plans = new Plans();
        for (Quotation quotation : quotations) {
            plans.add(quotation.computeBestPlanFor1Year());
        }
        return plans.toString();
    }


}