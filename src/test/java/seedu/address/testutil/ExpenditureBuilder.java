package seedu.address.testutil;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import seedu.address.model.expenditure.Date;
import seedu.address.model.expenditure.Expenditure;
import seedu.address.model.expenditure.Name;
import seedu.address.model.expenditure.Price;
import seedu.address.model.tag.Tag;

/**
 * A utility class to help with building Expenditure objects.
 */
public class ExpenditureBuilder {
    public static final String DEFAULT_NAME = "Pants";
    public static final String DEFAULT_PRICE = "85.50";
    public static final String DEFAULT_TAG = "Apparel";

    private Name name;
    private Price price;
    private Date createdOn;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Creates a {@code ExpenditureBuilder} with the default details.
     */
    public ExpenditureBuilder() {
        name = new Name(DEFAULT_NAME);
        price = new Price(DEFAULT_PRICE);
        createdOn = new Date(LocalDate.now().toString());
        this.tags.add(new Tag(DEFAULT_TAG));
    }

    /**
     * Initializes the ExpenditureBuilder with the data of {@code expenditureToCopy}.
     */
    public ExpenditureBuilder(Expenditure expenditureToCopy) {
        name = expenditureToCopy.getName();
        price = expenditureToCopy.getPrice();
        createdOn = expenditureToCopy.getCreatedOn();
        tags.addAll(expenditureToCopy.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code Expenditure} that we are building.
     */
    public ExpenditureBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Sets the {@code Price} of the {@code Expenditure} that we are building.
     */
    public ExpenditureBuilder withPrice(String price) {
        this.price = new Price(price);
        return this;
    }

    /**
     * Sets the {@code createdOn} of the {@code Expenditure} that we are building.
     */
    public ExpenditureBuilder withCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    /**
     * Sets the {@code tags} of the {@code Expenditure} that we are building.
     */
    public ExpenditureBuilder withTags(Set<Tag> tags) {
        tags.addAll(tags);
        return this;
    }

    /**
     * Sets the {@code tags} of the {@code Expenditure} that we are building.
     */
    public ExpenditureBuilder withTag(Tag tag) {
        tags.add(tag);
        return this;
    }

    /**
     * Builds the {@code ExpenditureBuilder} object into a {@code Expenditure} object.
     */
    public Expenditure build() {
        return new Expenditure(name, price, createdOn, tags);
    }
}
