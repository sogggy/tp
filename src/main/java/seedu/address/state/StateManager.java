package seedu.address.state;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.model.budget.Threshold.NO_THRESHOLD_MESSAGE;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import seedu.address.state.budgetindex.BudgetIndex;

public class StateManager implements State {

    private BudgetIndex budgetIndex;
    private Page currentPage;
    private BooleanProperty isBudgetPageProp = new SimpleBooleanProperty(false);
    private StringProperty infoBoxSecondRowProp = new SimpleStringProperty(defaultValueTotalExpenditure());
    private StringProperty thresholdStringProp = new SimpleStringProperty(NO_THRESHOLD_MESSAGE);
    private String pageTitle;

    /**
     * Constructs a {@code StateManager} with the given {@code BudgetIndex} and {@code Page}.
     * @param budgetIndex current budget index NUSave is accessed in.
     * @param currentPage current page NUSave is accessed in.
     * @param pageTitle Title of the current page.
     */
    public StateManager(BudgetIndex budgetIndex, Page currentPage, String pageTitle) {
        requireAllNonNull(budgetIndex, currentPage, pageTitle);
        this.budgetIndex = budgetIndex;
        this.currentPage = currentPage;
        this.pageTitle = pageTitle;
    }

    //Clock timing on Budgets Page
    public static String defaultValueTotalExpenditure() {
        return new SimpleDateFormat("hh:mm a").format(Calendar.getInstance().getTime());
    }

    @Override
    public Optional<Integer> getBudgetIndex() {
        return this.budgetIndex.getBudgetIndex();
    }

    @Override
    public Page getPage() {
        return this.currentPage;
    }

    @Override
    public BooleanProperty getIsBudgetPageProp() {
        return this.isBudgetPageProp;
    }

    @Override
    public StringProperty getInfoBoxSecondRowProp() {
        return infoBoxSecondRowProp;
    }

    @Override
    public StringProperty getThresholdStringProp() {
        return thresholdStringProp;
    }

    @Override
    public boolean isBudgetPage() {
        return this.isBudgetPageProp.getValue();
    }

    @Override
    public String getPageTitle() {
        return this.pageTitle;
    }

    @Override
    public boolean isMain() {
        return this.currentPage == Page.MAIN;
    }

    @Override
    public boolean isBudget() {
        return this.currentPage == Page.BUDGET;
    }

    @Override
    public void setIsBudgetPage(boolean isBudgetPage) {
        this.isBudgetPageProp.setValue(isBudgetPage);
    }

    @Override
    public void setPage(Page page) {
        requireNonNull(page);
        this.currentPage = page;
        if (page == Page.BUDGET) {
            setIsBudgetPage(true);
        } else {
            setIsBudgetPage(false);
        }
    }

    @Override
    public void setTotalExpenditure(String expenditure) {
        requireNonNull(expenditure);
        this.infoBoxSecondRowProp.setValue(expenditure);
    }

    @Override
    public void setThresholdStringProp(String threshold) {
        requireNonNull(threshold);
        this.thresholdStringProp.setValue(threshold);
    }

    @Override
    public void setBudgetIndex(BudgetIndex index) {
        requireNonNull(index);
        this.budgetIndex = index;
    }

    @Override
    public void setPageTitle(String pageTitle) {
        requireNonNull(pageTitle);
        this.pageTitle = pageTitle;
    }
}
