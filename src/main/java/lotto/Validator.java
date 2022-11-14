package lotto;

import java.util.List;

import static lotto.ErrorMessage.*;
import static lotto.domain.LottoConst.*;

public final class Validator {
    private static final Integer ZERO = 0;

    private Validator() {

    }

    public static void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PREFIX + NOT_INTEGER);
        }
    }

    public static void isNegative(String input) {
        if (Integer.parseInt(input) < ZERO) {
            throw new IllegalArgumentException(PREFIX + NEGATIVE);
        }
    }

    public static void isDividableWithThousand(String input) {
        if (Integer.parseInt(input) % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(PREFIX + NOT_DIVIDABLE_WITH_THOUSAND);
        }
    }

    public static void isValidPurchasePrice(String input) {
        isInteger(input);
        isNegative(input);
        isDividableWithThousand(input);
    }

    public static void isValidLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(PREFIX + INVALID_LOTTO_SIZE);
        }
    }

    public static void anyDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(PREFIX + DUPLICATED_NUMBER);
        }
    }

    public static void isValidNumberRange(List<Integer> numbers) {
        for (Integer number: numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(PREFIX + INVALID_LOTTO_NUMBER);
            }
        }
    }

    public static void isValidLotto(List<Integer> numbers) {
        isValidLottoSize(numbers);
        isValidNumberRange(numbers);
        anyDuplicatedNumber(numbers);
    }
}
