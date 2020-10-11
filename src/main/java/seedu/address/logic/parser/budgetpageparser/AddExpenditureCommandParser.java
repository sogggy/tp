package seedu.address.logic.parser.budgetpageparser;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.budget.AddExpenditureCommand;
import seedu.address.logic.commands.budget.CloseBudgetCommand;
import seedu.address.logic.parser.*;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.expenditure.Date;
import seedu.address.model.expenditure.Expenditure;
import seedu.address.model.expenditure.ExpenditureName;
import seedu.address.model.expenditure.Price;
import seedu.address.model.person.*;
import seedu.address.model.tag.Tag;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.*;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

public class AddExpenditureCommandParser implements Parser<AddExpenditureCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the CloseBudgetCommand
     * and returns an CloseBudgetCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddExpenditureCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_PRICE);

        if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_PRICE)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddExpenditureCommand.MESSAGE_USAGE));
        }

        ExpenditureName name = ParserUtil.parseExpenditureName(argMultimap.getValue(PREFIX_NAME).get());
        Price price = ParserUtil.parsePrice(argMultimap.getValue(PREFIX_PRICE).get());
        Date date = new Date(LocalDate.now().toString());
        Expenditure expenditure = new Expenditure(name, price, date, new HashSet<Tag>());

        return new AddExpenditureCommand(expenditure);
    }



    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
