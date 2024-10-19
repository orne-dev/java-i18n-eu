package dev.orne.i18n.spi.eu;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Currency;
import java.util.Locale;
import java.util.Properties;
import java.util.stream.Stream;

import javax.validation.constraints.NotNull;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
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
class EnglishCurrencyNamesTest {

    private static final Properties esData;
    static {
        try (final InputStream is = SpanishTimeZoneNamesTest.class.getResourceAsStream("currencies_en.properties")) {
            esData = new Properties();
            esData.load(is);
        } catch (IOException e) {
            throw new AssertionError("Error loading english currency names", e);
        }
    }

    @Test
    void testExtractData() {
        assertDoesNotThrow(() -> CurrencyDataExtractor.main());
    }

    /**
     * Test for {@link BasqueCurrencyNameProvider#getSymbol(String, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("currencyCodes")
    void testSymbol(
            final @NotNull Currency currency) {
        final BasqueCurrencyNameProvider provider = spy(new BasqueCurrencyNameProvider());
        willReturn(esData).given(provider).getCurrencies();
        String expected = currency.getSymbol(Locale.ENGLISH);
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
        final BasqueCurrencyNameProvider provider = spy(new BasqueCurrencyNameProvider());
        willReturn(esData).given(provider).getCurrencies();
        String expected = currency.getDisplayName(Locale.ENGLISH);
        String result = provider.getDisplayName(currency.getCurrencyCode(), Basque.LOCALE);
        assertEquals(
                expected,
                result == null ? expected : result,
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