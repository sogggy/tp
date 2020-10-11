package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.expenditure.Date;
import seedu.address.model.expenditure.Expenditure;
import seedu.address.model.expenditure.ExpenditureName;
import seedu.address.model.expenditure.Price;
import seedu.address.model.tag.Tag;

public class JsonAdaptedExpenditure {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Expenditure's %s field is missing!";
    private final String name;
    private final String price;
    private final String createdOn;
    private final List<JsonAdaptedTag> tags = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedExpenditure} with the given expenditure details.
     */
    @JsonCreator
    public JsonAdaptedExpenditure(@JsonProperty("name") String name, @JsonProperty("price") String price,
                             @JsonProperty("createdOn") String createdOn,
                             @JsonProperty("tagged") List<JsonAdaptedTag> tags) {
        this.name = name;
        this.price = price;
        this.createdOn = createdOn;
        if (tags != null) {
            this.tags.addAll(tags);
        }
    }

    /**
     * Converts a given {@code Expenditure} into this class for Jackson use.
     */
    public JsonAdaptedExpenditure(Expenditure expenditure) {
        name = expenditure.getExpenditureName().value;
        price = expenditure.getPrice().value;
        createdOn = expenditure.getCreatedOn().toString();
        tags.addAll(expenditure.getTags().stream()
                .map(JsonAdaptedTag::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted expenditure object into the model's {@code Expenditure} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted expenditure.
     */
    public Expenditure toModelType() throws IllegalValueException {
        final List<Tag> expenditureTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tags) {
            expenditureTags.add(tag.toModelType());
        }

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, ExpenditureName.class.getSimpleName()));
        }
        if (!ExpenditureName.isValidName(name)) {
            throw new IllegalValueException(ExpenditureName.MESSAGE_CONSTRAINTS);
        }
        final ExpenditureName modelExpenditureName = new ExpenditureName(name);

        if (price == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Price.class.getSimpleName()));
        }
        if (!Price.isValidPrice(price)) {
            throw new IllegalValueException(Price.MESSAGE_CONSTRAINTS);
        }
        final Price modelPrice = new Price(price);

        if (createdOn == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Date.class.getSimpleName()));
        }
        if (!Date.isValidDate(createdOn)) {
            throw new IllegalValueException(Date.MESSAGE_CONSTRAINTS);
        }
        final Date modelCreatedOn = new Date(createdOn);

        final Set<Tag> modelTags = new HashSet<>(expenditureTags);

        return new Expenditure(modelExpenditureName, modelPrice, modelCreatedOn, modelTags);
    }
}
