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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.stream.Stream;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Unit tests for {@code BasqueDateFormatProvider}.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-11
 * @since 1.0
 * @see BasqueDateFormatProvider
 */
@Tag("ut")
class BasqueDateFormatProviderTest
extends AbstractBasqueProviderTest<BasqueDateFormatProvider> {

    /**
     * Creates a new instance.
     */
    BasqueDateFormatProviderTest() {
        super(new BasqueDateFormatProvider());
    }

    /**
     * Test for {@link BasqueDateFormatProvider#getDateInstance(int, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("dateStyles")
    void testGetDateInstance(
            final int style) {
        assertNotNull(provider.getDateInstance(style, Basque.LOCALE));
        assertNotNull(provider.getDateInstance(style, Basque.LOCALE_ES));
        assertNotNull(provider.getDateInstance(style, Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueDateFormatProvider#getTimeInstance(int, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("timeStyles")
    void testGetTimeInstance(
            final int style) {
        assertNotNull(provider.getTimeInstance(style, Basque.LOCALE));
        assertNotNull(provider.getTimeInstance(style, Basque.LOCALE_ES));
        assertNotNull(provider.getTimeInstance(style, Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueDateFormatProvider#getDateTimeInstance(int, int, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("dateTimeStyles")
    void testGetDateTimeInstance(
            final int dateStyle,
            final int timeStyle) {
        assertNotNull(provider.getDateTimeInstance(dateStyle, timeStyle, Basque.LOCALE));
        assertNotNull(provider.getDateTimeInstance(dateStyle, timeStyle, Basque.LOCALE_ES));
        assertNotNull(provider.getDateTimeInstance(dateStyle, timeStyle, Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueDateFormatProvider#getDateInstance(int, Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_21,
            disabledReason = "JRE > 21 test")
    @ParameterizedTest
    @MethodSource("dateStyles")
    void testGetDateInstanceLatestCldr(
            final int style) {
        assertFormatEquals(
                DateFormat.getDateInstance(style, Basque.LOCALE),
                provider.getDateInstance(style, Basque.LOCALE));
        assertFormatEquals(
                DateFormat.getDateInstance(style, Basque.LOCALE_ES),
                provider.getDateInstance(style, Basque.LOCALE_ES));
        assertFormatEquals(
                DateFormat.getDateInstance(style, Basque.LOCALE_FR),
                provider.getDateInstance(style, Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueDateFormatProvider#getTimeInstance(int, Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_21,
            disabledReason = "JRE > 21 test")
    @ParameterizedTest
    @MethodSource("timeStyles")
    void testGetTimeInstanceLatestCldr(
            final int style) {
        assertFormatEquals(
                DateFormat.getTimeInstance(style, Basque.LOCALE),
                provider.getTimeInstance(style, Basque.LOCALE));
        assertFormatEquals(
                DateFormat.getTimeInstance(style, Basque.LOCALE_ES),
                provider.getTimeInstance(style, Basque.LOCALE_ES));
        assertFormatEquals(
                DateFormat.getTimeInstance(style, Basque.LOCALE_FR),
                provider.getTimeInstance(style, Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueDateFormatProvider#getDateTimeInstance(int, int, Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_23,
            disabledReason = "JRE > 23 test")
    @ParameterizedTest
    @MethodSource("dateTimeStyles")
    void testGetDateTimeInstanceLatestCldr(
            final int dateStyle,
            final int timeStyle) {
        assertFormatEquals(
                DateFormat.getDateTimeInstance(dateStyle, timeStyle, Basque.LOCALE),
                provider.getDateTimeInstance(dateStyle, timeStyle, Basque.LOCALE));
        assertFormatEquals(
                DateFormat.getDateTimeInstance(dateStyle, timeStyle, Basque.LOCALE_ES),
                provider.getDateTimeInstance(dateStyle, timeStyle, Basque.LOCALE_ES));
        assertFormatEquals(
                DateFormat.getDateTimeInstance(dateStyle, timeStyle, Basque.LOCALE_FR),
                provider.getDateTimeInstance(dateStyle, timeStyle, Basque.LOCALE_FR));
    }

    private void assertFormatEquals(
            final DateFormat expected,
            final DateFormat result) {
        final long now = System.currentTimeMillis();
        expected.getCalendar().setTimeInMillis(now);
        result.getCalendar().setTimeInMillis(now);
        assertEquals(
                expected.getCalendar(),
                result.getCalendar());
        assertEquals(
                expected.getNumberFormat(),
                result.getNumberFormat());
        assertEquals(
                expected.getTimeZone(),
                result.getTimeZone());
        assertEquals(
                expected.isLenient(),
                result.isLenient());
        assertEquals(
                expected.getClass(),
                result.getClass());
        if (expected instanceof SimpleDateFormat) {
            final SimpleDateFormat simpleExpected = (SimpleDateFormat) expected;
            final SimpleDateFormat simpleResult = (SimpleDateFormat) result;
            assertEquals(
                    simpleExpected.get2DigitYearStart().toInstant().with(ChronoField.MILLI_OF_SECOND, 0),
                    simpleResult.get2DigitYearStart().toInstant().with(ChronoField.MILLI_OF_SECOND, 0));
            assertEquals(
                    simpleExpected.getDateFormatSymbols(),
                    simpleResult.getDateFormatSymbols());
            assertEquals(
                    simpleExpected.toPattern(),
                    simpleResult.toPattern());
        }
    }

    /**
     * Source of date styles.
     * 
     * @return The date styles.
     */
    static Stream<Arguments> dateStyles() {
        return Stream.of(
                Arguments.of(DateFormat.SHORT),
                Arguments.of(DateFormat.MEDIUM),
                Arguments.of(DateFormat.LONG),
                Arguments.of(DateFormat.FULL));
    }

    /**
     * Source of time styles.
     * 
     * @return The time styles.
     */
    static Stream<Arguments> timeStyles() {
        return Stream.of(
                Arguments.of(DateFormat.SHORT),
                Arguments.of(DateFormat.MEDIUM),
                Arguments.of(DateFormat.LONG),
                Arguments.of(DateFormat.FULL));
    }

    /**
     * Source of date-time styles.
     * 
     * @return The date-time styles.
     */
    static Stream<Arguments> dateTimeStyles() {
        return dateStyles()
                .flatMap(date -> timeStyles()
                        .map(time -> Arguments.of(date.get()[0], time.get()[0])));
    }
}
