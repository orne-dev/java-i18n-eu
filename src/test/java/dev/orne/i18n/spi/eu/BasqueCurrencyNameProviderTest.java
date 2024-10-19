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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.stream.Stream;

import javax.validation.constraints.NotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger LOG = LoggerFactory.getLogger(BasqueCurrencyNameProviderTest.class);

    private static final Locale SPANISH = new Locale("es");

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
    @ParameterizedTest
    @MethodSource("currencyCodes")
    void testSymbol(
            final @NotNull Currency currency) {
        final BasqueCurrencyNameProvider provider = new BasqueCurrencyNameProvider();
        String expectedSp = currency.getSymbol(SPANISH);
        String expectedEn = currency.getSymbol(Locale.ENGLISH);
        String result = provider.getSymbol(currency.getCurrencyCode(), Basque.LOCALE);
        assertTrue(
                expectedSp.equals(result) || expectedEn.equals(result),
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
