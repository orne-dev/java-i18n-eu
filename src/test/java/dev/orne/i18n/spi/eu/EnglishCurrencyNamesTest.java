package dev.orne.i18n.spi.eu;

/*-
 * #%L
 * basque-locale-extension
 * %%
 * Copyright (C) 2024 Orne Developments
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;
import java.util.stream.Stream;

import javax.validation.constraints.NotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit tests for {@code BasqueCurrencyNameProvider}.
 * Tests that the English test resources output same results as reference
 * JREs (8, 11, 17 and 21 to date).
 * The point of these tests is to detect data changes in incoming JREs
 * to update/improve real Basque resources, which are expected to produce
 * updated results even with old JREs.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 * @see BasqueCurrencyNameProvider
 */
@Tag("ut")
@ExtendWith(MockitoExtension.class)
class EnglishCurrencyNamesTest {

    private static final Logger LOG = LoggerFactory.getLogger(EnglishCurrencyNamesTest.class);

    /** The provider instance to test. */
    private @Spy BasqueCurrencyNameProvider provider;

    private static final Properties data;
    static boolean dataFixed;
    static {
        try (final InputStream is = EnglishCurrencyNamesTest.class.getResourceAsStream("currencies_en.properties")) {
            data = new Properties();
            data.load(is);
        } catch (IOException e) {
            throw new AssertionError("Error loading english currency names", e);
        }
    }

    @BeforeAll
    static void extractEnglishNames() {
        ArrayList<Currency> currencies = new ArrayList<>(Currency.getAvailableCurrencies());
        Collections.sort(currencies, (c1, c2) -> c1.getCurrencyCode().compareTo(c2.getCurrencyCode()));
        HashMap<String, String> names = new HashMap<>();
        HashMap<String, String> symbols = new HashMap<>();
        for (Currency currency : currencies) {
            final String code = currency.getCurrencyCode();
            final String symbol = currency.getSymbol(Locale.ENGLISH);
            final String name = currency.getDisplayName(Locale.ENGLISH);
            LOG.debug("{} : {} ({})", code, symbol, name);
            names.put(code, name);
            symbols.put(code, symbol);
        }
        ArrayList<String> ids = new ArrayList<>(names.keySet());
        Collections.sort(ids);
        LOG.info("### Currencies data ###");
        for (String id : ids) {
            LOG.info("{}={}", id, names.get(id));
            LOG.info("{}.symbol={}", id, symbols.get(id));
        }
    }

    /**
     * Test for {@link BasqueCurrencyNameProvider#getSymbol(String, Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_21,
            disabledReason = "JRE > 21 test")
    @ParameterizedTest
    @MethodSource("currencyCodes")
    void testSymbol(
            final @NotNull Currency currency) {
        assertSymbol(currency);
    }

    /**
     * Test for {@link BasqueCurrencyNameProvider#getSymbol(String, Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_17, max = JRE.JAVA_17,
            disabledReason = "JRE 17 only test")
    @ParameterizedTest
    @MethodSource("currencyCodes")
    void testSymbolJre17(
            final @NotNull Currency currency) {
        withJre17Data();
        assertSymbol(currency);
    }

    /**
     * Test for {@link BasqueCurrencyNameProvider#getSymbol(String, Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_11,
            disabledReason = "JRE 11 only test")
    @ParameterizedTest
    @MethodSource("currencyCodes")
    void testSymbolJre11(
            final @NotNull Currency currency) {
        withJre11Data();
        assertSymbol(currency);
    }

    /**
     * Test for {@link BasqueCurrencyNameProvider#getSymbol(String, Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_8,
            disabledReason = "JRE 8 only test")
    @ParameterizedTest
    @MethodSource("currencyCodes")
    void testSymbolJre8(
            final @NotNull Currency currency) {
        withJre8Data();
        assertSymbol(currency);
    }

    void assertSymbol(
            final @NotNull Currency currency) {
        willReturn(data).given(provider).getCurrencies();
        String expected = currency.getSymbol(Locale.ENGLISH);
        String result = provider.getSymbol(currency.getCurrencyCode(), Basque.LOCALE);
        assertEquals(
                expected,
                result,
                () -> String.format("Unexpected symbol for currency '%s'", currency.getCurrencyCode()));
    }

    /**
     * Test for {@link BasqueCurrencyNameProvider#getDisplayName(String, Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_21,
            disabledReason = "JRE > 21 test")
    @ParameterizedTest
    @MethodSource("currencyCodes")
    void testDisplayName(
            final @NotNull Currency currency) {
        assertDisplayName(currency);
    }

    /**
     * Test for {@link BasqueCurrencyNameProvider#getDisplayName(String, Locale)} on JRE17.
     */
    @EnabledForJreRange(min = JRE.JAVA_17, max = JRE.JAVA_17,
            disabledReason = "JRE 17 only test")
    @ParameterizedTest
    @MethodSource("currencyCodes")
    void testDisplayNameJre17(
            final @NotNull Currency currency) {
        withJre17Data();
        assertDisplayName(currency);
    }

    /**
     * Test for {@link BasqueCurrencyNameProvider#getDisplayName(String, Locale)} on JRE11.
     */
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_11,
            disabledReason = "JRE 11 only test")
    @ParameterizedTest
    @MethodSource("currencyCodes")
    void testDisplayNameJre11(
            final @NotNull Currency currency) {
        withJre11Data();
        assertDisplayName(currency);
    }

    /**
     * Test for {@link BasqueCurrencyNameProvider#getDisplayName(String, Locale)} on JRE11.
     */
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_8,
            disabledReason = "JRE 8 only test")
    @ParameterizedTest
    @MethodSource("currencyCodes")
    void testDisplayNameJre8(
            final @NotNull Currency currency) {
        withJre8Data();
        assertDisplayName(currency);
    }

    void assertDisplayName(
            final @NotNull Currency currency) {
        willReturn(data).given(provider).getCurrencies();
        String expected = currency.getDisplayName(Locale.ENGLISH);
        String result = provider.getDisplayName(currency.getCurrencyCode(), Basque.LOCALE);
        assertEquals(
                expected,
                result,
                () -> String.format("Unexpected name for currency '%s'", currency.getCurrencyCode()));
    }

    static synchronized void withJre17Data() {
        if (!dataFixed) {
            try (final InputStream is = EnglishCurrencyNamesTest.class.getResourceAsStream("currencies_en.jre17.properties")) {
                data.load(is);
            } catch (IOException e) {
                throw new AssertionError("Error loading english JRE 17 currency names", e);
            }
            dataFixed = true;
        }
    }

    static synchronized void withJre11Data() {
        if (!dataFixed) {
            try (final InputStream is = EnglishCurrencyNamesTest.class.getResourceAsStream("currencies_en.jre11.properties")) {
                data.load(is);
            } catch (IOException e) {
                throw new AssertionError("Error loading english JRE 11 currency names", e);
            }
            dataFixed = true;
        }
    }

    static synchronized void withJre8Data() {
        if (!dataFixed) {
            try (final InputStream is = EnglishCurrencyNamesTest.class.getResourceAsStream("currencies_en.jre8.properties")) {
                data.load(is);
            } catch (IOException e) {
                throw new AssertionError("Error loading english JRE 8 currency names", e);
            }
            dataFixed = true;
        }
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
