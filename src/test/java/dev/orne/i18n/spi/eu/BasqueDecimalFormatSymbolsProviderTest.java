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
import java.util.Locale;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.JRE;

/**
 * Unit tests for {@code BasqueDecimalFormatSymbolsProvider}.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 * @see BasqueDecimalFormatSymbolsProvider
 */
@Tag("ut")
class BasqueDecimalFormatSymbolsProviderTest
extends AbstractBasqueProviderTest<BasqueDecimalFormatSymbolsProvider> {

    /**
     * Creates a new instance.
     */
    BasqueDecimalFormatSymbolsProviderTest() {
        super(new BasqueDecimalFormatSymbolsProvider());
    }

    /**
     * Test for {@link BasqueDecimalFormatSymbolsProvider#getInstance(Locale)}.
     */
    @Test
    void testGetInstance() {
        DecimalFormatSymbols result = provider.getInstance(Basque.LOCALE);
        assertNotNull(result.getCurrency());
        assertNotNull(result.getCurrencySymbol());
        assertNotNull(result.getExponentSeparator());
        assertNotNull(result.getInfinity());
        assertNotNull(result.getInternationalCurrencySymbol());
        assertNotNull(result.getNaN());
        result = provider.getInstance(Basque.LOCALE_ES);
        assertNotNull(result.getCurrency());
        assertNotNull(result.getCurrencySymbol());
        assertNotNull(result.getExponentSeparator());
        assertNotNull(result.getInfinity());
        assertNotNull(result.getInternationalCurrencySymbol());
        assertNotNull(result.getNaN());
        result = provider.getInstance(Basque.LOCALE_FR);
        assertNotNull(result.getCurrency());
        assertNotNull(result.getCurrencySymbol());
        assertNotNull(result.getExponentSeparator());
        assertNotNull(result.getInfinity());
        assertNotNull(result.getInternationalCurrencySymbol());
        assertNotNull(result.getNaN());
    }

    /**
     * Test for {@link BasqueDecimalFormatSymbolsProvider#getInstance(Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_21,
            disabledReason = "JRE > 21 test")
    @Test
    void testGetInstanceLatestCldr() {
        assertSymbolsEquals(
                DecimalFormatSymbols.getInstance(Basque.LOCALE),
                provider.getInstance(Basque.LOCALE));
        assertSymbolsEquals(
                DecimalFormatSymbols.getInstance(Basque.LOCALE_ES),
                provider.getInstance(Basque.LOCALE_ES));
        assertSymbolsEquals(
                DecimalFormatSymbols.getInstance(Basque.LOCALE_FR),
                provider.getInstance(Basque.LOCALE_FR));
    }

    private void assertSymbolsEquals(
            final DecimalFormatSymbols expected,
            final DecimalFormatSymbols result) {
        assertEquals(expected.getCurrency(), result.getCurrency());
        assertEquals(expected.getCurrencySymbol(), result.getCurrencySymbol());
        assertEquals(expected.getDecimalSeparator(), result.getDecimalSeparator());
        assertEquals(expected.getDigit(), result.getDigit());
        assertEquals(expected.getExponentSeparator(), result.getExponentSeparator());
        assertEquals(expected.getGroupingSeparator(), result.getGroupingSeparator());
        assertEquals(expected.getInfinity(), result.getInfinity());
        assertEquals(expected.getInternationalCurrencySymbol(), result.getInternationalCurrencySymbol());
        assertEquals(expected.getMinusSign(), result.getMinusSign());
        assertEquals(expected.getMonetaryDecimalSeparator(), result.getMonetaryDecimalSeparator());
        assertEquals(expected.getNaN(), result.getNaN());
        assertEquals(expected.getPatternSeparator(), result.getPatternSeparator());
        assertEquals(expected.getPercent(), result.getPercent());
        assertEquals(expected.getPerMill(), result.getPerMill());
        assertEquals(expected.getZeroDigit(), result.getZeroDigit());
        assertEquals(expected, result);
    }
}
