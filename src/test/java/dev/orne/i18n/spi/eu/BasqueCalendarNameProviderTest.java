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

import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Unit tests for {@code BasqueCalendarNameProvider}.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 * @see BasqueCalendarNameProvider
 */
@Tag("ut")
class BasqueCalendarNameProviderTest
extends AbstractBasqueProviderTest<BasqueCalendarNameProvider> {

    /**
     * Creates a new instance.
     */
    BasqueCalendarNameProviderTest() {
        super(new BasqueCalendarNameProvider());
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getDisplayNames(String, int, int, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("typeFieldStyle")
    void testGetDisplayNames(
            final String type,
            final int field,
            final int style) {
        if (field == Calendar.DAY_OF_WEEK && (style & Calendar.NARROW_FORMAT) != 0) {
            assertNull(provider.getDisplayNames(type, field, style, Basque.LOCALE));
            assertNull(provider.getDisplayNames(type, field, style, Basque.LOCALE_ES));
            assertNull(provider.getDisplayNames(type, field, style, Basque.LOCALE_FR));
        } else if (field == Calendar.ERA
                || field == Calendar.MONTH
                || field == Calendar.DAY_OF_WEEK
                || field == Calendar.AM_PM) {
            assertNotNull(provider.getDisplayNames(type, field, style, Basque.LOCALE));
            assertNotNull(provider.getDisplayNames(type, field, style, Basque.LOCALE_ES));
            assertNotNull(provider.getDisplayNames(type, field, style, Basque.LOCALE_FR));
        } else {
            assertNull(provider.getDisplayNames(type, field, style, Basque.LOCALE));
            assertNull(provider.getDisplayNames(type, field, style, Basque.LOCALE_ES));
            assertNull(provider.getDisplayNames(type, field, style, Basque.LOCALE_FR));
        }
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getDisplayName(String, int, int, int, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("typesErasStyles")
    void testGetDisplayName_Era(
            final String type,
            final int value,
            final int style) {
        final int values;
        switch (type) {
            case BasqueCalendarNameProvider.GREGORIAN_CALENDAR:
                values = BasqueCalendarNameProvider.GREGORIAN_ERAS_LONG.length;
                break;
            case BasqueCalendarNameProvider.BUDDHIST_CALENDAR:
                values = BasqueCalendarNameProvider.BUDDHIST_ERAS_LONG.length;
                break;
            case BasqueCalendarNameProvider.JAPANESE_CALENDAR:
                values = BasqueCalendarNameProvider.JAPANESE_ERAS_LONG.length;
                break;
            case BasqueCalendarNameProvider.MINGUO_CALENDAR:
                values = BasqueCalendarNameProvider.MINGUO_ERAS_LONG.length;
                break;
            case BasqueCalendarNameProvider.ISLAMIC_CALENDAR:
                values = BasqueCalendarNameProvider.ISLAMIC_ERAS_LONG.length;
                break;
            default:
                values = 0;
                break;
        }
        if (value < values) {
            assertNotNull(provider.getDisplayName(type, Calendar.ERA, value, style, Basque.LOCALE));
            assertNotNull(provider.getDisplayName(type, Calendar.ERA, value, style, Basque.LOCALE_ES));
            assertNotNull(provider.getDisplayName(type, Calendar.ERA, value, style, Basque.LOCALE_FR));
        } else {
            assertNull(provider.getDisplayName(type, Calendar.ERA, value, style, Basque.LOCALE));
            assertNull(provider.getDisplayName(type, Calendar.ERA, value, style, Basque.LOCALE_ES));
            assertNull(provider.getDisplayName(type, Calendar.ERA, value, style, Basque.LOCALE_FR));
        }
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getDisplayName(String, int, int, int, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("typesMonthsStyles")
    void testGetDisplayName_Month(
            final String type,
            final int value,
            final int style) {
        assertNotNull(provider.getDisplayName(type, Calendar.MONTH, value, style, Basque.LOCALE));
        assertNotNull(provider.getDisplayName(type, Calendar.MONTH, value, style, Basque.LOCALE_ES));
        assertNotNull(provider.getDisplayName(type, Calendar.MONTH, value, style, Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getDisplayName(String, int, int, int, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("typesWeekdaysStyles")
    void testGetDisplayName_Weekday(
            final String type,
            final int value,
            final int style) {
        if ((style & Calendar.NARROW_FORMAT) == 0) {
            assertNotNull(provider.getDisplayName(type, Calendar.DAY_OF_WEEK, value, style, Basque.LOCALE));
            assertNotNull(provider.getDisplayName(type, Calendar.DAY_OF_WEEK, value, style, Basque.LOCALE_ES));
            assertNotNull(provider.getDisplayName(type, Calendar.DAY_OF_WEEK, value, style, Basque.LOCALE_FR));
        } else {
            assertNull(provider.getDisplayName(type, Calendar.DAY_OF_WEEK, value, style, Basque.LOCALE));
            assertNull(provider.getDisplayName(type, Calendar.DAY_OF_WEEK, value, style, Basque.LOCALE_ES));
            assertNull(provider.getDisplayName(type, Calendar.DAY_OF_WEEK, value, style, Basque.LOCALE_FR));
        }
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getDisplayName(String, int, int, int, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("typesAmPmStyles")
    void testGetDisplayName_AmPm(
            final String type,
            final int value,
            final int style) {
        assertNotNull(provider.getDisplayName(type, Calendar.AM_PM, value, style, Basque.LOCALE));
        assertNotNull(provider.getDisplayName(type, Calendar.AM_PM, value, style, Basque.LOCALE_ES));
        assertNotNull(provider.getDisplayName(type, Calendar.AM_PM, value, style, Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getDisplayName(String, int, int, int, Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_21,
            disabledReason = "JRE >= 21 test")
    @ParameterizedTest
    @MethodSource("typeFieldStyle")
    void testGetDisplayNameLatestCldr(
            final String type,
            final int field,
            final int style) {
        final Calendar calendar = new Calendar.Builder()
                .setCalendarType(type)
                .build();
        Map<String, Integer> expected = calendar.getDisplayNames(field, style, Basque.LOCALE);
        Map<String, Integer> result = provider.getDisplayNames(type, field, style, Basque.LOCALE);
        assertEquals(expected, result);
        expected = calendar.getDisplayNames(field, style, Basque.LOCALE_ES);
        result = provider.getDisplayNames(type, field, style, Basque.LOCALE_ES);
        assertEquals(expected, result);
        expected = calendar.getDisplayNames(field, style, Basque.LOCALE_FR);
        result = provider.getDisplayNames(type, field, style, Basque.LOCALE_FR);
        assertEquals(expected, result);
    }

    static Stream<String> calendarTypes() {
        return Calendar.getAvailableCalendarTypes().stream();
    }

    static Stream<Integer> calendarFields() {
        return Stream.of(
                Calendar.ERA,
                Calendar.YEAR,
                Calendar.MONTH,
                Calendar.WEEK_OF_YEAR,
                Calendar.WEEK_OF_MONTH,
                Calendar.DATE,
                Calendar.DAY_OF_MONTH,
                Calendar.DAY_OF_YEAR,
                Calendar.DAY_OF_WEEK,
                Calendar.DAY_OF_WEEK_IN_MONTH,
                Calendar.AM_PM,
                Calendar.HOUR,
                Calendar.HOUR_OF_DAY,
                Calendar.MINUTE,
                Calendar.SECOND,
                Calendar.MILLISECOND,
                Calendar.ZONE_OFFSET,
                Calendar.DST_OFFSET);
    }

    static Stream<Integer> calendarStyles() {
        return Stream.of(
                Calendar.LONG_FORMAT,
                Calendar.LONG_STANDALONE,
                Calendar.SHORT_FORMAT,
                Calendar.SHORT_STANDALONE,
                Calendar.NARROW_FORMAT,
                Calendar.NARROW_STANDALONE,
                Calendar.ALL_STYLES);
    }

    static Stream<Integer> calendarValues() {
        return IntStream.range(-1, Calendar.UNDECIMBER + 1)
                .boxed();
    }

    static Stream<Integer> eras() {
        return IntStream.range(0, 8)
                .boxed();
    }

    static Stream<Integer> months() {
        return IntStream.range(Calendar.JANUARY, Calendar.UNDECIMBER)
                .boxed();
    }

    static Stream<Integer> weekdays() {
        return IntStream.range(Calendar.SUNDAY, Calendar.SATURDAY)
                .boxed();
    }

    static Stream<Arguments> typesStyles() {
        return calendarTypes()
                .flatMap(type -> calendarStyles().map(style -> Arguments.of(type, style)));
    }

    static Stream<Arguments> typesErasStyles() {
        return calendarTypes()
                .flatMap(type -> eras().map(era -> Arguments.of(type, era)))
                .flatMap(prev -> calendarStyles().map(style -> Arguments.of(prev.get()[0], prev.get()[1], style)));
    }

    static Stream<Arguments> typesMonthsStyles() {
        return calendarTypes()
                .flatMap(type -> months().map(month -> Arguments.of(type, month)))
                .flatMap(prev -> calendarStyles().map(style -> Arguments.of(prev.get()[0], prev.get()[1], style)));
    }

    static Stream<Arguments> typesWeekdaysStyles() {
        return calendarTypes()
                .flatMap(type -> weekdays().map(weekday -> Arguments.of(type, weekday)))
                .flatMap(prev -> calendarStyles().map(style -> Arguments.of(prev.get()[0], prev.get()[1], style)));
    }

    static Stream<Arguments> typesAmPmStyles() {
        return calendarTypes()
                .flatMap(type -> Stream.of(
                        Arguments.of(type, Calendar.AM),
                        Arguments.of(type, Calendar.PM)))
                .flatMap(prev -> calendarStyles().map(style -> Arguments.of(prev.get()[0], prev.get()[1], style)));
    }

    static Stream<Arguments> typeFieldStyle() {
        return calendarTypes()
                .flatMap(type -> calendarFields().map(field -> Arguments.of(type, field)))
                .flatMap(prev -> calendarStyles().map(style -> Arguments.of(prev.get()[0], prev.get()[1], style)));
    }
}
