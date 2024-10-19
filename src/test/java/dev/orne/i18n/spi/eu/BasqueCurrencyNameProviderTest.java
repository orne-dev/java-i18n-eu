package dev.orne.i18n.spi.eu;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Currency;
import java.util.Locale;
import java.util.stream.Stream;

import javax.validation.constraints.NotNull;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Unit tests for {@code BasqueCurrencyNameProvider}.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 * @see BasqueCurrencyNameProvider
 */
@Tag("ut")
class BasqueCurrencyNameProviderTest {

    private static final Locale SPANISH = new Locale("es");

    /**
     * Test for {@link BasqueCurrencyNameProvider#getSymbol(String, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("currencyCodes")
    void testSymbol(
            final @NotNull Currency currency) {
        final BasqueCurrencyNameProvider provider = new BasqueCurrencyNameProvider();
        String expected = currency.getSymbol(SPANISH);
        String result = provider.getSymbol(currency.getCurrencyCode(), Basque.LOCALE);
        assertEquals(
                expected,
                result == null ? expected : result,
                () -> String.format("Unexpected symbol for currency '%s'", currency.getCurrencyCode()));
    }

    /**
     * Test for {@link BasqueCurrencyNameProvider#getDisplayName(String, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("currencyCodes")
    void testDisplayName(
            final @NotNull Currency currency) {
        final BasqueCurrencyNameProvider provider = new BasqueCurrencyNameProvider();
        String notExpected = currency.getDisplayName(SPANISH);
        String result = provider.getDisplayName(currency.getCurrencyCode(), Basque.LOCALE);
        assertNotEquals(
                notExpected,
                result == null ? notExpected : result,
                () -> String.format("Unexpected name for currency '%s'", currency.getCurrencyCode()));
    }

    /**
     * Source of currency codes.
     * 
     * @return The currency codes.
     */
    static Stream<Arguments> currencyCodes() {
        final ArrayList<Currency> list = new ArrayList<>(Currency.getAvailableCurrencies());
        Collections.sort(list, (c1, c2) -> c1.getCurrencyCode().compareTo(c2.getCurrencyCode()));
        return list.stream().map(id -> Arguments.of(id));
    }
}