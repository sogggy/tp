package seedu.address.testutil;

import java.util.List;
import java.util.Optional;

import seedu.address.model.budget.Budget;
import seedu.address.model.budget.Name;
import seedu.address.model.budget.Threshold;
import seedu.address.model.expenditure.Expenditure;

/**
 * A utility class to help with building Budget objects.
 */
public class BudgetBuilder {

    public static final String DEFAULT_NAME = "Temasek Hall Basketball";
    public static final String DEFAULT_THRESHOLD = "500";

    private Name name;
    private Optional<Threshold> threshold;
    private List<Expenditure> expenditures;

    /**
     * Creates a {@code BudgetBuilder} with the default details.
     */
    public BudgetBuilder() {
        name = new Name(DEFAULT_NAME);
        threshold = Optional.of(new Threshold(DEFAULT_THRESHOLD));
        expenditures = TypicalExpenditures.getTypicalExpenditures();
    }

    /**
     * Initializes the BudgetBuilder with the data of {@code budgetToCopy}.
     */
    public BudgetBuilder(Budget budgetToCopy) {
        name = new Name(budgetToCopy.getName());
        threshold = Optional.of(new Threshold(budgetToCopy.getThreshold()));
        expenditures = budgetToCopy.getExpenditures();
    }

    /**
     * Sets the {@code Name} of the {@code Budget} that we are building.
     */
    public BudgetBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Sets the {@code Threshold} of the {@code Budget} that we are building.
     */
    public BudgetBuilder withThreshold(String threshold) {
        this.threshold = Optional.of(new Threshold(threshold));
        return this;
    }

    /**
     * Sets the {@code Expenditures} of the {@code Budget} that we are building.
     */
    public BudgetBuilder withExpenditures(List<Expenditure> expenditures) {
        this.expenditures = expenditures;
        return this;
    }

    /**
     * Builds the {@code BudgetBuilder} object into a {@code Budget} object.
     */
    public Budget build() {
        if (threshold.isPresent()) {
            return new Budget(name, threshold.get(), expenditures);
        }
        return new Budget(name, expenditures);
    }
}
