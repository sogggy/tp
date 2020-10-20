package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.budget.Budget;

/**
 * A utility class containing a list of {@code Budgets} objects to be used in tests.
 */
public class TypicalBudgets {

    public static final Budget TEMASEK_HALL_BASKETBALL = new BudgetBuilder()
            .withName("Temasek Hall Basketball")
            .withThreshold("500.00")
            .withExpenditures(TypicalExpenditures.getTypicalExpenditures())
            .build();
    public static final Budget TEMASEK_HALL_MARKETING = new BudgetBuilder()
            .withName("Temasek Hall Marketing")
            .withThreshold("2200.00")
            .withExpenditures(TypicalExpenditures.getTypicalExpenditures())
            .build();
    public static final Budget OCTOBER_BUDGET = new BudgetBuilder()
            .withName("October Budget")
            .withThreshold("300.00")
            .withExpenditures(TypicalExpenditures.getTypicalExpenditures())
            .build();
    public static final Budget MONTHLY_BILLS = new BudgetBuilder()
            .withName("Monthly Bills")
            .withThreshold("250.00")
            .withExpenditures(TypicalExpenditures.getTypicalExpenditures())
            .build();
    public static final Budget NUS_HACKERS_MONTHLY_BUDGET = new BudgetBuilder()
            .withName("Nus Hackers Monthly Budget")
            .withThreshold("450.00")
            .withExpenditures(TypicalExpenditures.getTypicalExpenditures())
            .build();
    public static final Budget NUS_FINTECH_SOCIETY_MONTHLY_BUDGET = new BudgetBuilder()
            .withName("NUS Fintech Society Monthly Budget")
            .withThreshold("400.00")
            .withExpenditures(TypicalExpenditures.getTypicalExpenditures())
            .build();
    public static final Budget TEMBUSU_COLLEGE_ANNUAL_DND_FUND = new BudgetBuilder()
            .withName("Tembusu College Annual DnD Fund")
            .withThreshold("300.00")
            .withExpenditures(TypicalExpenditures.getTypicalExpenditures())
            .build();

    private TypicalBudgets() {} // prevents instantiation

    public static List<Budget> getTypicalBudgets() {
        return new ArrayList<>(Arrays.asList(TEMASEK_HALL_BASKETBALL, TEMASEK_HALL_MARKETING, OCTOBER_BUDGET,
                MONTHLY_BILLS, NUS_HACKERS_MONTHLY_BUDGET,
                NUS_FINTECH_SOCIETY_MONTHLY_BUDGET, TEMBUSU_COLLEGE_ANNUAL_DND_FUND));
    }
}
