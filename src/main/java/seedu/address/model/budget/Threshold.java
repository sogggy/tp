package seedu.address.model.budget;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class Threshold {
    public static final String MESSAGE_CONSTRAINTS =
            "Thresholds can be empty or contain only numbers, and it can have at most 2 decimal places.";
    public static final String VALIDATION_REGEX = "^$|[0-9]+(\\.[0-9]?[0-9])?$";
    private final String value;

    /**
     * Constructs a {@code Threshold}.
     *
     * @param threshold A valid threshold.
     */
    public Threshold(String threshold) {
        requireNonNull(threshold);
        checkArgument(isValid(threshold), MESSAGE_CONSTRAINTS);
        value = threshold;
    }

    public String getThreshold() {
        return this.value;
    }

    /**
     * Returns true if a given string is a valid threshold.
     */
    public static boolean isValid(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Threshold // instanceof handles nulls
                && value.equals(((Threshold) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
