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

import java.text.DecimalFormatSymbols;
import java.util.Currency;
import java.util.Locale;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@code BasqueDecimalFormatSymbolsProvider}.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 * @see BasqueDecimalFormatSymbolsProvider
 */
@Tag("ut")
class BasqueDecimalFormatSymbolsProviderTest {

    private static final Locale SPANISH = new Locale("es");

    /** The provider instance to test. */
    private final BasqueDecimalFormatSymbolsProvider provider = new BasqueDecimalFormatSymbolsProvider();

    /**
     * Test for {@link BasqueDecimalFormatSymbolsProvider#getInstance(Locale)}.
     */
    @Test
    void testGetInstance() {
        assertNull(provider.getInstance(Locale.ENGLISH));
        final DecimalFormatSymbols esSymbols = DecimalFormatSymbols.getInstance(SPANISH);
        final DecimalFormatSymbols result = provider.getInstance(Basque.LOCALE);
        assertEquals(
                Currency.getInstance(BasqueDecimalFormatSymbolsProvider.CURRENCY_CODE),
                result.getCurrency());
        assertEquals(
                Currency.getInstance(BasqueDecimalFormatSymbolsProvider.CURRENCY_CODE).getSymbol(SPANISH),
                result.getCurrencySymbol());
        assertEquals(BasqueDecimalFormatSymbolsProvider.DECIMAL_SEPARATOR, result.getDecimalSeparator());
        assertEquals(esSymbols.getDigit(), result.getDigit());
        assertEquals(esSymbols.getExponentSeparator(), result.getExponentSeparator());
        assertEquals(BasqueDecimalFormatSymbolsProvider.GROUPING_SEPARATOR, result.getGroupingSeparator());
        assertEquals(esSymbols.getInfinity(), result.getInfinity());
        assertEquals(BasqueDecimalFormatSymbolsProvider.CURRENCY_CODE, result.getInternationalCurrencySymbol());
        assertEquals(BasqueDecimalFormatSymbolsProvider.MINUS_SIGN, result.getMinusSign());
        assertEquals(esSymbols.getMonetaryDecimalSeparator(), result.getMonetaryDecimalSeparator());
        assertEquals(esSymbols.getNaN(), result.getNaN());
        assertEquals(esSymbols.getPatternSeparator(), result.getPatternSeparator());
        assertEquals(BasqueDecimalFormatSymbolsProvider.PERCENT_SYMBOL, result.getPercent());
        assertEquals(BasqueDecimalFormatSymbolsProvider.PERMILL_SYMBOL, result.getPerMill());
        assertEquals(esSymbols.getZeroDigit(), result.getZeroDigit());
    }

    /**
     * Test for {@link BasqueDecimalFormatSymbolsProvider#getAvailableLocales()}.
     */
    @Test
    void testAvailableLocales() {
        assertTrue(provider.isSupportedLocale(Basque.LOCALE));
        assertTrue(provider.isSupportedLocale(Basque.LOCALE_ES));
        assertTrue(provider.isSupportedLocale(Basque.LOCALE_FR));
        assertFalse(provider.isSupportedLocale(Locale.FRENCH));
        assertFalse(provider.isSupportedLocale(Locale.FRANCE));
        assertFalse(provider.isSupportedLocale(new Locale("es")));
        assertFalse(provider.isSupportedLocale(new Locale("es", "ES")));
    }
}
