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

import java.text.ChoiceFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.JRE;

/**
 * Unit tests for {@code BasqueNumberFormatProvider}.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-11
 * @since 1.0
 * @see BasqueNumberFormatProvider
 */
@Tag("ut")
class BasqueNumberFormatProviderTest
extends AbstractBasqueProviderTest<BasqueNumberFormatProvider> {

    /**
     * Creates a new instance.
     */
    BasqueNumberFormatProviderTest() {
        super(new BasqueNumberFormatProvider(
                new BasqueDecimalFormatSymbolsProvider()::getInstance));
    }

    /**
     * Test for {@link BasqueNumberFormatProvider#BasqueNumberFormatProvider()}.
     */
    @Test
    void testConstructor() {
        BasqueNumberFormatProvider result = new BasqueNumberFormatProvider();
        assertNotNull(result.getSymbolsProvider());
        assertEquals(
                DecimalFormatSymbols.getInstance(Basque.LOCALE),
                result.getSymbolsProvider().apply(Basque.LOCALE));
    }

    /**
     * Test for {@link BasqueNumberFormatProvider#getIntegerInstance(Locale)}.
     */
    @Test
    void testGetIntegerInstance() {
        assertNotNull(provider.getIntegerInstance(Basque.LOCALE));
        assertNotNull(provider.getIntegerInstance(Basque.LOCALE_ES));
        assertNotNull(provider.getIntegerInstance(Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueNumberFormatProvider#getNumberInstance(Locale)}.
     */
    @Test
    void testGetNumberInstance() {
        assertNotNull(provider.getNumberInstance(Basque.LOCALE));
        assertNotNull(provider.getNumberInstance(Basque.LOCALE_ES));
        assertNotNull(provider.getNumberInstance(Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueNumberFormatProvider#getPercentInstance(Locale)}.
     */
    @Test
    void testGetPercentInstance() {
        assertNotNull(provider.getPercentInstance(Basque.LOCALE));
        assertNotNull(provider.getPercentInstance(Basque.LOCALE_ES));
        assertNotNull(provider.getPercentInstance(Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueNumberFormatProvider#getCurrencyInstance(Locale)}.
     */
    @Test
    void testGetCurrencyInstance() {
        assertNotNull(provider.getCurrencyInstance(Basque.LOCALE));
        assertNotNull(provider.getCurrencyInstance(Basque.LOCALE_ES));
        assertNotNull(provider.getCurrencyInstance(Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueNumberFormatProvider#getIntegerInstance(Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_21,
            disabledReason = "JRE > 21 test")
    @Test
    void testGetIntegerInstanceLatestCldr() {
        assertFormatsEquals(
                NumberFormat.getIntegerInstance(Basque.LOCALE),
                provider.getIntegerInstance(Basque.LOCALE));
        assertFormatsEquals(
                NumberFormat.getIntegerInstance(Basque.LOCALE_ES),
                provider.getIntegerInstance(Basque.LOCALE_ES));
        assertFormatsEquals(
                NumberFormat.getIntegerInstance(Basque.LOCALE_FR),
                provider.getIntegerInstance(Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueNumberFormatProvider#getNumberInstance(Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_21,
            disabledReason = "JRE > 21 test")
    @Test
    void testGetNumberInstanceLatestCldr() {
        assertFormatsEquals(
                NumberFormat.getNumberInstance(Basque.LOCALE),
                provider.getNumberInstance(Basque.LOCALE));
        assertFormatsEquals(
                NumberFormat.getNumberInstance(Basque.LOCALE_ES),
                provider.getNumberInstance(Basque.LOCALE_ES));
        assertFormatsEquals(
                NumberFormat.getNumberInstance(Basque.LOCALE_FR),
                provider.getNumberInstance(Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueNumberFormatProvider#getPercentInstance(Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_21,
            disabledReason = "JRE > 21 test")
    @Test
    void testGetPercentInstanceLatestCldr() {
        assertFormatsEquals(
                NumberFormat.getPercentInstance(Basque.LOCALE),
                provider.getPercentInstance(Basque.LOCALE));
        assertFormatsEquals(
                NumberFormat.getPercentInstance(Basque.LOCALE_ES),
                provider.getPercentInstance(Basque.LOCALE_ES));
        assertFormatsEquals(
                NumberFormat.getPercentInstance(Basque.LOCALE_FR),
                provider.getPercentInstance(Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueNumberFormatProvider#getCurrencyInstance(Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_21,
            disabledReason = "JRE > 21 test")
    @Test
    void testGetCurrencyInstanceLatestCldr() {
        assertFormatsEquals(
                NumberFormat.getCurrencyInstance(Basque.LOCALE),
                provider.getCurrencyInstance(Basque.LOCALE));
        assertFormatsEquals(
                NumberFormat.getCurrencyInstance(Basque.LOCALE_ES),
                provider.getCurrencyInstance(Basque.LOCALE_ES));
        assertFormatsEquals(
                NumberFormat.getCurrencyInstance(Basque.LOCALE_FR),
                provider.getCurrencyInstance(Basque.LOCALE_FR));
    }

    private void assertFormatsEquals(
            final NumberFormat expected,
            final NumberFormat result) {
        assertEquals(expected.getCurrency(), result.getCurrency());
        assertEquals(expected.getMaximumFractionDigits(), result.getMaximumFractionDigits());
        assertEquals(expected.getMaximumIntegerDigits(), result.getMaximumIntegerDigits());
        assertEquals(expected.getMinimumFractionDigits(), result.getMinimumFractionDigits());
        assertEquals(expected.getMinimumIntegerDigits(), result.getMinimumIntegerDigits());
        assertEquals(expected.getRoundingMode(), result.getRoundingMode());
        assertEquals(expected.isGroupingUsed(), result.isGroupingUsed());
        assertEquals(expected.isParseIntegerOnly(), result.isParseIntegerOnly());
        assertEquals(expected.getClass(), result.getClass());
        if (expected instanceof ChoiceFormat) {
            final ChoiceFormat expectedSubtype = (ChoiceFormat) expected;
            final ChoiceFormat resultSubtype = (ChoiceFormat) result;
            assertArrayEquals(expectedSubtype.getFormats(), resultSubtype.getFormats());
            assertArrayEquals(expectedSubtype.getLimits(), resultSubtype.getLimits());
        } else if (expected instanceof DecimalFormat) {
            final DecimalFormat expectedSubtype = (DecimalFormat) expected;
            final DecimalFormat resultSubtype = (DecimalFormat) result;
            assertEquals(expectedSubtype.getDecimalFormatSymbols(), resultSubtype.getDecimalFormatSymbols());
            assertEquals(expectedSubtype.getGroupingSize(), resultSubtype.getGroupingSize());
            assertEquals(expectedSubtype.getMultiplier(), resultSubtype.getMultiplier());
            assertEquals(expectedSubtype.getNegativePrefix(), resultSubtype.getNegativePrefix());
            assertEquals(expectedSubtype.getNegativeSuffix(), resultSubtype.getNegativeSuffix());
            assertEquals(expectedSubtype.getPositivePrefix(), resultSubtype.getPositivePrefix());
            assertEquals(expectedSubtype.getPositiveSuffix(), resultSubtype.getPositiveSuffix());
            assertEquals(expectedSubtype.isDecimalSeparatorAlwaysShown(), resultSubtype.isDecimalSeparatorAlwaysShown());
            assertEquals(expectedSubtype.isParseBigDecimal(), resultSubtype.isParseBigDecimal());
        }
        assertEquals(expected, result);
    }
}
