package seedu.address.testutil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.expenditure.Date;
import seedu.address.model.expenditure.Expenditure;
import seedu.address.model.tag.Tag;

/**
 * A utility class containing a list of {@code Expenditure} objects to be used in tests.
 */
public class TypicalExpenditures {
    public static final Tag DEFAULT_TAG = new Tag("Apparel");

    public static final Expenditure SHIRT = new ExpenditureBuilder().withName("Shirt")
            .withPrice("85.50").withCreatedOn(new Date(LocalDate.now().toString()))
            .withTag(DEFAULT_TAG)
            .build();
    public static final Expenditure PANTS = new ExpenditureBuilder().withName("Pants")
            .withPrice("100.50").withCreatedOn(new Date(LocalDate.now().toString()))
            .withTag(DEFAULT_TAG)
            .build();
    public static final Expenditure BELT = new ExpenditureBuilder().withName("Belt")
            .withPrice("50.90").withCreatedOn(new Date(LocalDate.now().toString()))
            .withTag(DEFAULT_TAG)
            .build();
    public static final Expenditure SHOES = new ExpenditureBuilder().withName("Shoes")
            .withPrice("89.90").withCreatedOn(new Date(LocalDate.now().toString()))
            .withTag(DEFAULT_TAG)
            .build();
    public static final Expenditure GLOVES = new ExpenditureBuilder().withName("Gloves")
            .withPrice("10.90").withCreatedOn(new Date(LocalDate.now().toString()))
            .withTag(DEFAULT_TAG)
            .build();
    public static final Expenditure WATCH = new ExpenditureBuilder().withName("Watch")
            .withPrice("369.90").withCreatedOn(new Date(LocalDate.now().toString()))
            .withTag(DEFAULT_TAG)
            .build();

    private TypicalExpenditures() {} // prevents instantiation

    public static List<Expenditure> getTypicalExpenditures() {
        return new ArrayList<>(Arrays.asList(SHIRT, PANTS, BELT, SHOES, GLOVES, WATCH));
    }
}
