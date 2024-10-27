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
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junitpioneer.jupiter.cartesian.ArgumentSets;
import org.junitpioneer.jupiter.cartesian.CartesianTest;

/**
 * Unit tests for {@code BasqueCalendarNameProvider}.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 * @see BasqueCalendarNameProvider
 */
@Tag("ut")
class BasqueCalendarNameProviderTest {

    /** The provider instance to test. */
    private final BasqueCalendarNameProvider provider = new BasqueCalendarNameProvider();

    /**
     * Test for {@link BasqueCalendarNameProvider#getGregorianEraNames(int)}.
     */
    @Test
    void testGetGregorianEraNames() {
        assertArrayEquals(
                BasqueCalendarNameProvider.GREGORIAN_ERAS_LONG,
                BasqueCalendarNameProvider.getGregorianEraNames(Calendar.LONG_FORMAT));
        assertArrayEquals(
                BasqueCalendarNameProvider.GREGORIAN_ERAS_LONG,
                BasqueCalendarNameProvider.getGregorianEraNames(Calendar.LONG_STANDALONE));
        assertArrayEquals(
                BasqueCalendarNameProvider.GREGORIAN_ERAS_SHORT,
                BasqueCalendarNameProvider.getGregorianEraNames(Calendar.SHORT_FORMAT));
        assertArrayEquals(
                BasqueCalendarNameProvider.GREGORIAN_ERAS_SHORT,
                BasqueCalendarNameProvider.getGregorianEraNames(Calendar.SHORT_STANDALONE));
        assertArrayEquals(
                BasqueCalendarNameProvider.GREGORIAN_ERAS_SHORT,
                BasqueCalendarNameProvider.getGregorianEraNames(Calendar.NARROW_FORMAT));
        assertArrayEquals(
                BasqueCalendarNameProvider.GREGORIAN_ERAS_SHORT,
                BasqueCalendarNameProvider.getGregorianEraNames(Calendar.NARROW_STANDALONE));
        assertArrayEquals(
                BasqueCalendarNameProvider.GREGORIAN_ERAS_LONG,
                BasqueCalendarNameProvider.getGregorianEraNames(Integer.MAX_VALUE));
        assertArrayEquals(
                BasqueCalendarNameProvider.GREGORIAN_ERAS_LONG,
                BasqueCalendarNameProvider.getGregorianEraNames(Integer.MIN_VALUE));
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getBuddhistEraNames(int)}.
     */
    @Test
    void testGetBuddhistEraNames() {
        assertArrayEquals(
                BasqueCalendarNameProvider.BUDDHIST_ERAS_LONG,
                BasqueCalendarNameProvider.getBuddhistEraNames(Calendar.LONG_FORMAT));
        assertArrayEquals(
                BasqueCalendarNameProvider.BUDDHIST_ERAS_LONG,
                BasqueCalendarNameProvider.getBuddhistEraNames(Calendar.LONG_STANDALONE));
        assertArrayEquals(
                BasqueCalendarNameProvider.BUDDHIST_ERAS_SHORT,
                BasqueCalendarNameProvider.getBuddhistEraNames(Calendar.SHORT_FORMAT));
        assertArrayEquals(
                BasqueCalendarNameProvider.BUDDHIST_ERAS_SHORT,
                BasqueCalendarNameProvider.getBuddhistEraNames(Calendar.SHORT_STANDALONE));
        assertArrayEquals(
                BasqueCalendarNameProvider.BUDDHIST_ERAS_SHORT,
                BasqueCalendarNameProvider.getBuddhistEraNames(Calendar.NARROW_FORMAT));
        assertArrayEquals(
                BasqueCalendarNameProvider.BUDDHIST_ERAS_SHORT,
                BasqueCalendarNameProvider.getBuddhistEraNames(Calendar.NARROW_STANDALONE));
        assertArrayEquals(
                BasqueCalendarNameProvider.BUDDHIST_ERAS_LONG,
                BasqueCalendarNameProvider.getBuddhistEraNames(Integer.MAX_VALUE));
        assertArrayEquals(
                BasqueCalendarNameProvider.BUDDHIST_ERAS_LONG,
                BasqueCalendarNameProvider.getBuddhistEraNames(Integer.MIN_VALUE));
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getJapaneseEraNames(int)}.
     */
    @Test
    void testGetJapaneseEraNames() {
        assertArrayEquals(
                BasqueCalendarNameProvider.JAPANESE_ERAS_LONG,
                BasqueCalendarNameProvider.getJapaneseEraNames(Calendar.LONG_FORMAT));
        assertArrayEquals(
                BasqueCalendarNameProvider.JAPANESE_ERAS_LONG,
                BasqueCalendarNameProvider.getJapaneseEraNames(Calendar.LONG_STANDALONE));
        assertArrayEquals(
                BasqueCalendarNameProvider.JAPANESE_ERAS_SHORT,
                BasqueCalendarNameProvider.getJapaneseEraNames(Calendar.SHORT_FORMAT));
        assertArrayEquals(
                BasqueCalendarNameProvider.JAPANESE_ERAS_SHORT,
                BasqueCalendarNameProvider.getJapaneseEraNames(Calendar.SHORT_STANDALONE));
        assertArrayEquals(
                BasqueCalendarNameProvider.JAPANESE_ERAS_SHORT,
                BasqueCalendarNameProvider.getJapaneseEraNames(Calendar.NARROW_FORMAT));
        assertArrayEquals(
                BasqueCalendarNameProvider.JAPANESE_ERAS_SHORT,
                BasqueCalendarNameProvider.getJapaneseEraNames(Calendar.NARROW_STANDALONE));
        assertArrayEquals(
                BasqueCalendarNameProvider.JAPANESE_ERAS_LONG,
                BasqueCalendarNameProvider.getJapaneseEraNames(Integer.MAX_VALUE));
        assertArrayEquals(
                BasqueCalendarNameProvider.JAPANESE_ERAS_LONG,
                BasqueCalendarNameProvider.getJapaneseEraNames(Integer.MIN_VALUE));
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getMinguoEraNames(int)}.
     */
    @Test
    void testGetMinguoEraNames() {
        assertArrayEquals(
                BasqueCalendarNameProvider.MINGUO_ERAS_LONG,
                BasqueCalendarNameProvider.getMinguoEraNames(Calendar.LONG_FORMAT));
        assertArrayEquals(
                BasqueCalendarNameProvider.MINGUO_ERAS_LONG,
                BasqueCalendarNameProvider.getMinguoEraNames(Calendar.LONG_STANDALONE));
        assertArrayEquals(
                BasqueCalendarNameProvider.MINGUO_ERAS_SHORT,
                BasqueCalendarNameProvider.getMinguoEraNames(Calendar.SHORT_FORMAT));
        assertArrayEquals(
                BasqueCalendarNameProvider.MINGUO_ERAS_SHORT,
                BasqueCalendarNameProvider.getMinguoEraNames(Calendar.SHORT_STANDALONE));
        assertArrayEquals(
                BasqueCalendarNameProvider.MINGUO_ERAS_SHORT,
                BasqueCalendarNameProvider.getMinguoEraNames(Calendar.NARROW_FORMAT));
        assertArrayEquals(
                BasqueCalendarNameProvider.MINGUO_ERAS_SHORT,
                BasqueCalendarNameProvider.getMinguoEraNames(Calendar.NARROW_STANDALONE));
        assertArrayEquals(
                BasqueCalendarNameProvider.MINGUO_ERAS_LONG,
                BasqueCalendarNameProvider.getMinguoEraNames(Integer.MAX_VALUE));
        assertArrayEquals(
                BasqueCalendarNameProvider.MINGUO_ERAS_LONG,
                BasqueCalendarNameProvider.getMinguoEraNames(Integer.MIN_VALUE));
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getIslamicEraNames(int)}.
     */
    @Test
    void testGetIslamicEraNames() {
        assertArrayEquals(
                BasqueCalendarNameProvider.ISLAMIC_ERAS_LONG,
                BasqueCalendarNameProvider.getIslamicEraNames(Calendar.LONG_FORMAT));
        assertArrayEquals(
                BasqueCalendarNameProvider.ISLAMIC_ERAS_LONG,
                BasqueCalendarNameProvider.getIslamicEraNames(Calendar.LONG_STANDALONE));
        assertArrayEquals(
                BasqueCalendarNameProvider.ISLAMIC_ERAS_SHORT,
                BasqueCalendarNameProvider.getIslamicEraNames(Calendar.SHORT_FORMAT));
        assertArrayEquals(
                BasqueCalendarNameProvider.ISLAMIC_ERAS_SHORT,
                BasqueCalendarNameProvider.getIslamicEraNames(Calendar.SHORT_STANDALONE));
        assertArrayEquals(
                BasqueCalendarNameProvider.ISLAMIC_ERAS_SHORT,
                BasqueCalendarNameProvider.getIslamicEraNames(Calendar.NARROW_FORMAT));
        assertArrayEquals(
                BasqueCalendarNameProvider.ISLAMIC_ERAS_SHORT,
                BasqueCalendarNameProvider.getIslamicEraNames(Calendar.NARROW_STANDALONE));
        assertArrayEquals(
                BasqueCalendarNameProvider.ISLAMIC_ERAS_LONG,
                BasqueCalendarNameProvider.getIslamicEraNames(Integer.MAX_VALUE));
        assertArrayEquals(
                BasqueCalendarNameProvider.ISLAMIC_ERAS_LONG,
                BasqueCalendarNameProvider.getIslamicEraNames(Integer.MIN_VALUE));
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getMonthNames(int)}.
     */
    @Test
    void testGetMonthNames() {
        assertArrayEquals(
                BasqueCalendarNameProvider.MONTHS_LONG,
                BasqueCalendarNameProvider.getMonthNames(Calendar.LONG_FORMAT));
        assertArrayEquals(
                BasqueCalendarNameProvider.MONTHS_LONG,
                BasqueCalendarNameProvider.getMonthNames(Calendar.LONG_STANDALONE));
        assertArrayEquals(
                BasqueCalendarNameProvider.MONTHS_SHORT,
                BasqueCalendarNameProvider.getMonthNames(Calendar.SHORT_FORMAT));
        assertArrayEquals(
                BasqueCalendarNameProvider.MONTHS_SHORT,
                BasqueCalendarNameProvider.getMonthNames(Calendar.SHORT_STANDALONE));
        assertArrayEquals(
                BasqueCalendarNameProvider.MONTHS_NARROW,
                BasqueCalendarNameProvider.getMonthNames(Calendar.NARROW_FORMAT));
        assertArrayEquals(
                BasqueCalendarNameProvider.MONTHS_NARROW,
                BasqueCalendarNameProvider.getMonthNames(Calendar.NARROW_STANDALONE));
        assertArrayEquals(
                BasqueCalendarNameProvider.MONTHS_LONG,
                BasqueCalendarNameProvider.getMonthNames(Integer.MAX_VALUE));
        assertArrayEquals(
                BasqueCalendarNameProvider.MONTHS_LONG,
                BasqueCalendarNameProvider.getMonthNames(Integer.MIN_VALUE));
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getWeekdayNames(int)}.
     */
    @Test
    void testGetWeekdayNames() {
        assertArrayEquals(
                BasqueCalendarNameProvider.WEEKDAYS_LONG,
                BasqueCalendarNameProvider.getWeekdayNames(Calendar.LONG_FORMAT));
        assertArrayEquals(
                BasqueCalendarNameProvider.WEEKDAYS_LONG,
                BasqueCalendarNameProvider.getWeekdayNames(Calendar.LONG_STANDALONE));
        assertArrayEquals(
                BasqueCalendarNameProvider.WEEKDAYS_SHORT,
                BasqueCalendarNameProvider.getWeekdayNames(Calendar.SHORT_FORMAT));
        assertArrayEquals(
                BasqueCalendarNameProvider.WEEKDAYS_SHORT,
                BasqueCalendarNameProvider.getWeekdayNames(Calendar.SHORT_STANDALONE));
        assertArrayEquals(
                BasqueCalendarNameProvider.WEEKDAYS_NARROW,
                BasqueCalendarNameProvider.getWeekdayNames(Calendar.NARROW_FORMAT));
        assertArrayEquals(
                BasqueCalendarNameProvider.WEEKDAYS_NARROW,
                BasqueCalendarNameProvider.getWeekdayNames(Calendar.NARROW_STANDALONE));
        assertArrayEquals(
                BasqueCalendarNameProvider.WEEKDAYS_LONG,
                BasqueCalendarNameProvider.getWeekdayNames(Integer.MAX_VALUE));
        assertArrayEquals(
                BasqueCalendarNameProvider.WEEKDAYS_LONG,
                BasqueCalendarNameProvider.getWeekdayNames(Integer.MIN_VALUE));
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getAmPmNames(int)}.
     */
    @Test
    void testGetAmPmNames() {
        assertArrayEquals(
                BasqueCalendarNameProvider.AMPM_MARKERS,
                BasqueCalendarNameProvider.getAmPmNames(Calendar.LONG_FORMAT));
        assertArrayEquals(
                BasqueCalendarNameProvider.AMPM_MARKERS,
                BasqueCalendarNameProvider.getAmPmNames(Calendar.LONG_STANDALONE));
        assertArrayEquals(
                BasqueCalendarNameProvider.AMPM_MARKERS,
                BasqueCalendarNameProvider.getAmPmNames(Calendar.SHORT_FORMAT));
        assertArrayEquals(
                BasqueCalendarNameProvider.AMPM_MARKERS,
                BasqueCalendarNameProvider.getAmPmNames(Calendar.SHORT_STANDALONE));
        assertArrayEquals(
                BasqueCalendarNameProvider.AMPM_MARKERS,
                BasqueCalendarNameProvider.getAmPmNames(Calendar.NARROW_FORMAT));
        assertArrayEquals(
                BasqueCalendarNameProvider.AMPM_MARKERS,
                BasqueCalendarNameProvider.getAmPmNames(Calendar.NARROW_STANDALONE));
        assertArrayEquals(
                BasqueCalendarNameProvider.AMPM_MARKERS,
                BasqueCalendarNameProvider.getAmPmNames(Integer.MAX_VALUE));
        assertArrayEquals(
                BasqueCalendarNameProvider.AMPM_MARKERS,
                BasqueCalendarNameProvider.getAmPmNames(Integer.MIN_VALUE));
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getValueName(IntFunction, int, int)}.
     */
    @Test
    void testGetValueName() {
        assertNull(BasqueCalendarNameProvider.getValueName(
                null,
                Calendar.LONG_FORMAT,
                0));
        assertNull(BasqueCalendarNameProvider.getValueName(
                BasqueCalendarNameProvider::getMonthNames,
                Calendar.LONG_FORMAT,
                -1));
        assertNull(BasqueCalendarNameProvider.getValueName(
                BasqueCalendarNameProvider::getMonthNames,
                Calendar.LONG_FORMAT,
                BasqueCalendarNameProvider.MONTHS_LONG.length));
        assertNull(BasqueCalendarNameProvider.getValueName(
                style -> new String[0],
                Calendar.LONG_FORMAT,
                BasqueCalendarNameProvider.MONTHS_LONG.length));
        assertEquals(
                BasqueCalendarNameProvider.MONTHS_LONG[0],
                BasqueCalendarNameProvider.getValueName(
                    BasqueCalendarNameProvider::getMonthNames,
                    Calendar.LONG_FORMAT,
                    0));
        assertEquals(
                BasqueCalendarNameProvider.MONTHS_LONG[3],
                BasqueCalendarNameProvider.getValueName(
                    BasqueCalendarNameProvider::getMonthNames,
                    Calendar.LONG_FORMAT,
                    3));
        assertEquals(
                BasqueCalendarNameProvider.MONTHS_SHORT[0],
                BasqueCalendarNameProvider.getValueName(
                    BasqueCalendarNameProvider::getMonthNames,
                    Calendar.SHORT_FORMAT,
                    0));
        assertEquals(
                BasqueCalendarNameProvider.MONTHS_NARROW[0],
                BasqueCalendarNameProvider.getValueName(
                    BasqueCalendarNameProvider::getMonthNames,
                    Calendar.NARROW_FORMAT,
                    0));
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#mergeNames(IntFunction, int...)}.
     */
    @Test
    void testMergeNames() {
        assertNull(BasqueCalendarNameProvider.mergeNames(
                null));
        assertNull(
                BasqueCalendarNameProvider.mergeNames(
                    BasqueCalendarNameProvider::getMonthNames));
        Map<String, Integer> result = BasqueCalendarNameProvider.mergeNames(
                BasqueCalendarNameProvider::getMonthNames,
                Calendar.LONG_FORMAT);
        assertEquals(
                BasqueCalendarNameProvider.MONTHS_LONG.length,
                result.size());
        assertEquals(
                Calendar.JANUARY,
                result.get(BasqueCalendarNameProvider.MONTHS_LONG[0]));
        result = BasqueCalendarNameProvider.mergeNames(
                BasqueCalendarNameProvider::getMonthNames,
                Calendar.LONG_FORMAT,
                Calendar.SHORT_FORMAT);
        assertEquals(
                BasqueCalendarNameProvider.MONTHS_LONG.length
                    + BasqueCalendarNameProvider.MONTHS_SHORT.length,
                result.size());
        assertEquals(
                Calendar.JANUARY,
                result.get(BasqueCalendarNameProvider.MONTHS_LONG[0]));
        assertEquals(
                Calendar.JANUARY,
                result.get(BasqueCalendarNameProvider.MONTHS_SHORT[0]));
        result = BasqueCalendarNameProvider.mergeNames(
                format -> format == Calendar.LONG_FORMAT ? BasqueCalendarNameProvider.MONTHS_LONG : null,
                Calendar.LONG_FORMAT,
                Calendar.SHORT_FORMAT);
        assertEquals(
                BasqueCalendarNameProvider.MONTHS_LONG.length,
                result.size());
        assertEquals(
                Calendar.JANUARY,
                result.get(BasqueCalendarNameProvider.MONTHS_LONG[0]));
        assertEquals(
                null,
                result.get(BasqueCalendarNameProvider.MONTHS_SHORT[0]));
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getFieldNamesFunction}.
     */
    @CartesianTest
    @CartesianTest.MethodFactory("testGetFieldNamesFunction")
    void testGetFieldNamesFunction(
            final String calendarType,
            final int field) {
        final IntFunction<String[]> result = BasqueCalendarNameProvider.getFieldNamesFunction(
                calendarType,
                field);
        switch (field) {
            case Calendar.ERA:
                if (calendarType == null) {
                    assertNotNull(result);
                    assertSame(
                            BasqueCalendarNameProvider.getGregorianEraNames(Calendar.LONG_FORMAT),
                            result.apply(Calendar.LONG_FORMAT));
                } else {
                    
                    switch (calendarType) {
                    case BasqueCalendarNameProvider.GREGORIAN_CALENDAR:
                        assertNotNull(result);
                        assertSame(
                                BasqueCalendarNameProvider.getGregorianEraNames(Calendar.LONG_FORMAT),
                                result.apply(Calendar.LONG_FORMAT));
                        break;
                    case BasqueCalendarNameProvider.BUDDHIST_CALENDAR:
                        assertNotNull(result);
                        assertSame(
                                BasqueCalendarNameProvider.getBuddhistEraNames(Calendar.LONG_FORMAT),
                                result.apply(Calendar.LONG_FORMAT));
                        break;
                    case BasqueCalendarNameProvider.JAPANESE_CALENDAR:
                        assertNotNull(result);
                        assertSame(
                                BasqueCalendarNameProvider.getJapaneseEraNames(Calendar.LONG_FORMAT),
                                result.apply(Calendar.LONG_FORMAT));
                        break;
                    case BasqueCalendarNameProvider.MINGUO_CALENDAR:
                        assertNotNull(result);
                        assertSame(
                                BasqueCalendarNameProvider.getMinguoEraNames(Calendar.LONG_FORMAT),
                                result.apply(Calendar.LONG_FORMAT));
                        break;
                    case BasqueCalendarNameProvider.ISLAMIC_CALENDAR:
                        assertNotNull(result);
                        assertSame(
                                BasqueCalendarNameProvider.getIslamicEraNames(Calendar.LONG_FORMAT),
                                result.apply(Calendar.LONG_FORMAT));
                        break;
                    default:
                        assertNull(result);
                        break;
                    }
                }
                break;
            case Calendar.MONTH:
                assertNotNull(result);
                assertSame(
                        BasqueCalendarNameProvider.getMonthNames(Calendar.LONG_FORMAT),
                        result.apply(Calendar.LONG_FORMAT));
                break;
            case Calendar.DAY_OF_WEEK:
                assertNotNull(result);
                assertSame(
                        BasqueCalendarNameProvider.getWeekdayNames(Calendar.LONG_FORMAT),
                        result.apply(Calendar.LONG_FORMAT));
                break;
            case Calendar.AM_PM:
                assertNotNull(result);
                assertSame(
                        BasqueCalendarNameProvider.getAmPmNames(Calendar.LONG_FORMAT),
                        result.apply(Calendar.LONG_FORMAT));
                break;
            default:
                assertNull(result);
                break;
        }
    }

    static ArgumentSets testGetFieldNamesFunction() {
        return ArgumentSets
                .argumentsForFirstParameter(calendarTypes())
                .argumentsForNextParameter(calendarFields());
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getDisplayNames(String, int, int, Locale)}.
     */
    @CartesianTest
    @CartesianTest.MethodFactory("testGetDisplayNames")
    void testGetDisplayNames(
            final String calendarType,
            final int field,
            final int style,
            final Locale locale) {
        final Map<String, Integer> result = provider.getDisplayNames(calendarType, field, style, locale);
        if (Basque.LANGUAGE.equals(locale.getLanguage())) {
            if (style == Calendar.ALL_STYLES) {
                assertEquals(
                        BasqueCalendarNameProvider.mergeNames(
                            BasqueCalendarNameProvider.getFieldNamesFunction(calendarType, field),
                            Calendar.LONG_FORMAT,
                            Calendar.SHORT_FORMAT),
                        result);
            } else {
                assertEquals(
                        BasqueCalendarNameProvider.mergeNames(
                            BasqueCalendarNameProvider.getFieldNamesFunction(calendarType, field),
                            style),
                        result);
            }
        } else {
            assertNull(result);
        }
    }

    static ArgumentSets testGetDisplayNames() {
        return ArgumentSets
                .argumentsForFirstParameter(calendarTypes())
                .argumentsForNextParameter(calendarFields())
                .argumentsForNextParameter(calendarStyles())
                .argumentsForNextParameter(testLocales());
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getDisplayName(String, int, int, int, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("eras")
    void testGetDisplayName_Era_Long(
            final int value) {
        assertEquals(
                eraName(BasqueCalendarNameProvider.GREGORIAN_ERAS_LONG, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.LONG_FORMAT,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.GREGORIAN_ERAS_LONG, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.LONG_STANDALONE,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.BUDDHIST_ERAS_LONG, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.BUDDHIST_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.LONG_FORMAT,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.BUDDHIST_ERAS_LONG, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.BUDDHIST_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.LONG_STANDALONE,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.JAPANESE_ERAS_LONG, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.JAPANESE_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.LONG_FORMAT,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.JAPANESE_ERAS_LONG, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.JAPANESE_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.LONG_STANDALONE,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.ISLAMIC_ERAS_LONG, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.ISLAMIC_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.LONG_FORMAT,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.ISLAMIC_ERAS_LONG, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.ISLAMIC_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.LONG_STANDALONE,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.MINGUO_ERAS_LONG, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.MINGUO_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.LONG_FORMAT,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.MINGUO_ERAS_LONG, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.MINGUO_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.LONG_STANDALONE,
                    Basque.LOCALE));
        assertNull(
                provider.getDisplayName(
                    "unsupported-calendar",
                    Calendar.ERA,
                    value,
                    Calendar.LONG_FORMAT,
                    Basque.LOCALE));
        assertNull(
                provider.getDisplayName(
                    "unsupported-calendar",
                    Calendar.ERA,
                    value,
                    Calendar.LONG_STANDALONE,
                    Basque.LOCALE));
        assertNull(
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.LONG_FORMAT,
                    Locale.ENGLISH));
        assertNull(
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.LONG_STANDALONE,
                    Locale.ENGLISH));
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getDisplayName(String, int, int, int, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("eras")
    void testGetDisplayName_Era_Short(
            final int value) {
        assertEquals(
                eraName(BasqueCalendarNameProvider.GREGORIAN_ERAS_SHORT, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.SHORT_FORMAT,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.GREGORIAN_ERAS_SHORT, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.SHORT_STANDALONE,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.BUDDHIST_ERAS_SHORT, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.BUDDHIST_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.SHORT_FORMAT,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.BUDDHIST_ERAS_SHORT, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.BUDDHIST_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.SHORT_STANDALONE,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.JAPANESE_ERAS_SHORT, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.JAPANESE_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.SHORT_FORMAT,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.JAPANESE_ERAS_SHORT, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.JAPANESE_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.SHORT_STANDALONE,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.ISLAMIC_ERAS_SHORT, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.ISLAMIC_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.SHORT_FORMAT,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.ISLAMIC_ERAS_SHORT, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.ISLAMIC_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.SHORT_STANDALONE,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.MINGUO_ERAS_SHORT, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.MINGUO_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.SHORT_FORMAT,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.MINGUO_ERAS_SHORT, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.MINGUO_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.SHORT_STANDALONE,
                    Basque.LOCALE));
        assertNull(
                provider.getDisplayName(
                    "unsupported-calendar",
                    Calendar.ERA,
                    value,
                    Calendar.SHORT_FORMAT,
                    Basque.LOCALE));
        assertNull(
                provider.getDisplayName(
                    "unsupported-calendar",
                    Calendar.ERA,
                    value,
                    Calendar.SHORT_STANDALONE,
                    Basque.LOCALE));
        assertNull(
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.SHORT_FORMAT,
                    Locale.ENGLISH));
        assertNull(
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.SHORT_STANDALONE,
                    Locale.ENGLISH));
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getDisplayName(String, int, int, int, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("eras")
    void testGetDisplayName_Era_Narrow(
            final int value) {
        assertEquals(
                eraName(BasqueCalendarNameProvider.GREGORIAN_ERAS_SHORT, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.NARROW_FORMAT,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.GREGORIAN_ERAS_SHORT, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.NARROW_STANDALONE,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.BUDDHIST_ERAS_SHORT, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.BUDDHIST_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.NARROW_FORMAT,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.BUDDHIST_ERAS_SHORT, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.BUDDHIST_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.NARROW_STANDALONE,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.JAPANESE_ERAS_SHORT, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.JAPANESE_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.NARROW_FORMAT,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.JAPANESE_ERAS_SHORT, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.JAPANESE_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.NARROW_STANDALONE,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.ISLAMIC_ERAS_SHORT, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.ISLAMIC_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.NARROW_FORMAT,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.ISLAMIC_ERAS_SHORT, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.ISLAMIC_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.NARROW_STANDALONE,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.MINGUO_ERAS_SHORT, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.MINGUO_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.NARROW_FORMAT,
                    Basque.LOCALE));
        assertEquals(
                eraName(BasqueCalendarNameProvider.MINGUO_ERAS_SHORT, value),
                provider.getDisplayName(
                    BasqueCalendarNameProvider.MINGUO_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.NARROW_STANDALONE,
                    Basque.LOCALE));
        assertNull(
                provider.getDisplayName(
                    "unsupported-calendar",
                    Calendar.ERA,
                    value,
                    Calendar.NARROW_FORMAT,
                    Basque.LOCALE));
        assertNull(
                provider.getDisplayName(
                        "unsupported-calendar",
                    Calendar.ERA,
                    value,
                    Calendar.NARROW_STANDALONE,
                    Basque.LOCALE));
        assertNull(
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.NARROW_FORMAT,
                    Locale.ENGLISH));
        assertNull(
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.ERA,
                    value,
                    Calendar.NARROW_STANDALONE,
                    Locale.ENGLISH));
    }

    private String eraName(
            final String[] names,
            final int value) {
        if (value < 0 || value >= names.length) {
            return null;
        } else {
            return names[value];
        }
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getDisplayName(String, int, int, int, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("months")
    void testGetDisplayName_Month_Long(
            final int value) {
        final String expected;
        if (Calendar.UNDECIMBER == value) {
            expected = null;
        } else {
            expected = BasqueCalendarNameProvider.MONTHS_LONG[value];
        }
        assertEquals(
                expected,
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.MONTH,
                    value,
                    Calendar.LONG_FORMAT,
                    Basque.LOCALE));
        assertEquals(
                expected,
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.MONTH,
                    value,
                    Calendar.LONG_STANDALONE,
                    Basque.LOCALE));
        assertEquals(
                expected,
                provider.getDisplayName(
                    "any-calendar",
                    Calendar.MONTH,
                    value,
                    Calendar.LONG_FORMAT,
                    Basque.LOCALE));
        assertNull(provider.getDisplayName(
                BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                Calendar.MONTH,
                value,
                Calendar.LONG_FORMAT,
                Locale.ENGLISH));
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getDisplayName(String, int, int, int, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("months")
    void testGetDisplayName_Month_Short(
            final int value) {
        final String expected;
        if (Calendar.UNDECIMBER == value) {
            expected = null;
        } else {
            expected = BasqueCalendarNameProvider.MONTHS_SHORT[value];
        }
        assertEquals(
                expected,
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.MONTH,
                    value,
                    Calendar.SHORT_FORMAT,
                    Basque.LOCALE));
        assertEquals(
                expected,
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.MONTH,
                    value,
                    Calendar.SHORT_STANDALONE,
                    Basque.LOCALE));
        assertEquals(
                expected,
                provider.getDisplayName(
                    "any-calendar",
                    Calendar.MONTH,
                    value,
                    Calendar.SHORT_FORMAT,
                    Basque.LOCALE));
        assertNull(provider.getDisplayName(
                BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                Calendar.MONTH,
                value,
                Calendar.SHORT_FORMAT,
                Locale.ENGLISH));
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getDisplayName(String, int, int, int, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("months")
    void testGetDisplayName_Month_Narrow(
            final int value) {
        final String expected;
        if (Calendar.UNDECIMBER == value) {
            expected = null;
        } else {
            expected = BasqueCalendarNameProvider.MONTHS_NARROW[value];
        }
        assertEquals(
                expected,
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.MONTH,
                    value,
                    Calendar.NARROW_FORMAT,
                    Basque.LOCALE));
        assertEquals(
                expected,
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.MONTH,
                    value,
                    Calendar.NARROW_STANDALONE,
                    Basque.LOCALE));
        assertEquals(
                expected,
                provider.getDisplayName(
                    "any-calendar",
                    Calendar.MONTH,
                    value,
                    Calendar.NARROW_FORMAT,
                    Basque.LOCALE));
        assertNull(provider.getDisplayName(
                BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                Calendar.MONTH,
                value,
                Calendar.NARROW_FORMAT,
                Locale.ENGLISH));
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getDisplayName(String, int, int, int, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("weekdays")
    void testGetDisplayName_Weekday_Long(
            final int value) {
        final String expected = BasqueCalendarNameProvider.WEEKDAYS_LONG[value];
        assertEquals(
                expected,
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.DAY_OF_WEEK,
                    value,
                    Calendar.LONG_FORMAT,
                    Basque.LOCALE));
        assertEquals(
                expected,
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.DAY_OF_WEEK,
                    value,
                    Calendar.LONG_STANDALONE,
                    Basque.LOCALE));
        assertEquals(
                expected,
                provider.getDisplayName(
                    "any-calendar",
                    Calendar.DAY_OF_WEEK,
                    value,
                    Calendar.LONG_FORMAT,
                    Basque.LOCALE));
        assertNull(provider.getDisplayName(
                BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                Calendar.DAY_OF_WEEK,
                value,
                Calendar.LONG_FORMAT,
                Locale.ENGLISH));
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getDisplayName(String, int, int, int, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("weekdays")
    void testGetDisplayName_Weekday_Short(
            final int value) {
        final String expected = BasqueCalendarNameProvider.WEEKDAYS_SHORT[value];
        assertEquals(
                expected,
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.DAY_OF_WEEK,
                    value,
                    Calendar.SHORT_FORMAT,
                    Basque.LOCALE));
        assertEquals(
                expected,
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.DAY_OF_WEEK,
                    value,
                    Calendar.SHORT_STANDALONE,
                    Basque.LOCALE));
        assertEquals(
                expected,
                provider.getDisplayName(
                    "any-calendar",
                    Calendar.DAY_OF_WEEK,
                    value,
                    Calendar.SHORT_FORMAT,
                    Basque.LOCALE));
        assertNull(provider.getDisplayName(
                BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                Calendar.DAY_OF_WEEK,
                value,
                Calendar.SHORT_FORMAT,
                Locale.ENGLISH));
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getDisplayName(String, int, int, int, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("weekdays")
    void testGetDisplayName_Weekday_Narrow(
            final int value) {
        final String expected = BasqueCalendarNameProvider.WEEKDAYS_NARROW[value];
        assertEquals(
                expected,
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.DAY_OF_WEEK,
                    value,
                    Calendar.NARROW_FORMAT,
                    Basque.LOCALE));
        assertEquals(
                expected,
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.DAY_OF_WEEK,
                    value,
                    Calendar.NARROW_STANDALONE,
                    Basque.LOCALE));
        assertEquals(
                expected,
                provider.getDisplayName(
                    "any-calendar",
                    Calendar.DAY_OF_WEEK,
                    value,
                    Calendar.NARROW_FORMAT,
                    Basque.LOCALE));
        assertNull(provider.getDisplayName(
                BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                Calendar.DAY_OF_WEEK,
                value,
                Calendar.NARROW_FORMAT,
                Locale.ENGLISH));
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getDisplayName(String, int, int, int, Locale)}.
     */
    @ParameterizedTest
    @ValueSource(ints = { Calendar.AM, Calendar.PM })
    void testGetDisplayName_AmPm_Long(
            final int value) {
        final String expected = BasqueCalendarNameProvider.AMPM_MARKERS[value];
        assertEquals(
                expected,
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.AM_PM,
                    value,
                    Calendar.LONG_FORMAT,
                    Basque.LOCALE));
        assertEquals(
                expected,
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.AM_PM,
                    value,
                    Calendar.LONG_STANDALONE,
                    Basque.LOCALE));
        assertEquals(
                expected,
                provider.getDisplayName(
                    "any-calendar",
                    Calendar.AM_PM,
                    value,
                    Calendar.LONG_FORMAT,
                    Basque.LOCALE));
        assertNull(provider.getDisplayName(
                BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                Calendar.AM_PM,
                value,
                Calendar.LONG_FORMAT,
                Locale.ENGLISH));
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getDisplayName(String, int, int, int, Locale)}.
     */
    @ParameterizedTest
    @ValueSource(ints = { Calendar.AM, Calendar.PM })
    void testGetDisplayName_AmPm_Short(
            final int value) {
        final String expected = BasqueCalendarNameProvider.AMPM_MARKERS[value];
        assertEquals(
                expected,
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.AM_PM,
                    value,
                    Calendar.SHORT_FORMAT,
                    Basque.LOCALE));
        assertEquals(
                expected,
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.AM_PM,
                    value,
                    Calendar.SHORT_STANDALONE,
                    Basque.LOCALE));
        assertEquals(
                expected,
                provider.getDisplayName(
                    "any-calendar",
                    Calendar.AM_PM,
                    value,
                    Calendar.SHORT_FORMAT,
                    Basque.LOCALE));
        assertNull(provider.getDisplayName(
                BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                Calendar.AM_PM,
                value,
                Calendar.SHORT_FORMAT,
                Locale.ENGLISH));
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getDisplayName(String, int, int, int, Locale)}.
     */
    @ParameterizedTest
    @ValueSource(ints = { Calendar.AM, Calendar.PM })
    void testGetDisplayName_AmPm_Narrow(
            final int value) {
        final String expected = BasqueCalendarNameProvider.AMPM_MARKERS[value];
        assertEquals(
                expected,
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.AM_PM,
                    value,
                    Calendar.NARROW_FORMAT,
                    Basque.LOCALE));
        assertEquals(
                expected,
                provider.getDisplayName(
                    BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                    Calendar.AM_PM,
                    value,
                    Calendar.NARROW_STANDALONE,
                    Basque.LOCALE));
        assertEquals(
                expected,
                provider.getDisplayName(
                    "any-calendar",
                    Calendar.AM_PM,
                    value,
                    Calendar.NARROW_FORMAT,
                    Basque.LOCALE));
        assertNull(provider.getDisplayName(
                BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                Calendar.AM_PM,
                value,
                Calendar.NARROW_FORMAT,
                Locale.ENGLISH));
    }

    /**
     * Test for {@link BasqueCalendarNameProvider#getAvailableLocales()}.
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

    static Stream<String> calendarTypes() {
        return Stream.of(
                BasqueCalendarNameProvider.GREGORIAN_CALENDAR,
                BasqueCalendarNameProvider.BUDDHIST_CALENDAR,
                BasqueCalendarNameProvider.JAPANESE_CALENDAR,
                BasqueCalendarNameProvider.MINGUO_CALENDAR,
                BasqueCalendarNameProvider.ISLAMIC_CALENDAR,
                "unsupported");
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

    static Stream<Arguments> eras() {
        return IntStream.range(0, 8)
                .boxed()
                .map(Arguments::of);
    }

    static Stream<Arguments> months() {
        return Stream.of(
                Arguments.of(Calendar.JANUARY),
                Arguments.of(Calendar.FEBRUARY),
                Arguments.of(Calendar.MARCH),
                Arguments.of(Calendar.APRIL),
                Arguments.of(Calendar.MAY),
                Arguments.of(Calendar.JUNE),
                Arguments.of(Calendar.JULY),
                Arguments.of(Calendar.AUGUST),
                Arguments.of(Calendar.SEPTEMBER),
                Arguments.of(Calendar.OCTOBER),
                Arguments.of(Calendar.NOVEMBER),
                Arguments.of(Calendar.DECEMBER),
                Arguments.of(Calendar.UNDECIMBER)
            );
    }

    static Stream<Arguments> weekdays() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(Calendar.SUNDAY),
                Arguments.of(Calendar.MONDAY),
                Arguments.of(Calendar.TUESDAY),
                Arguments.of(Calendar.WEDNESDAY),
                Arguments.of(Calendar.THURSDAY),
                Arguments.of(Calendar.FRIDAY),
                Arguments.of(Calendar.SATURDAY)
            );
    }

    static Stream<Locale> testLocales() {
        return Stream.of(
                Basque.LOCALE,
                Basque.LOCALE_ES,
                Basque.LOCALE_FR,
                Locale.ENGLISH,
                new Locale("es"));
    }
}
