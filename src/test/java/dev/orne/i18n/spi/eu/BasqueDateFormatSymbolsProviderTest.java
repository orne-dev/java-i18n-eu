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

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.JRE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit tests for {@code BasqueDateFormatSymbolsProvider}.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-11
 * @since 1.0
 * @see BasqueDateFormatSymbolsProvider
 */
@Tag("ut")
class BasqueDateFormatSymbolsProviderTest
extends AbstractBasqueProviderTest<BasqueDateFormatSymbolsProvider> {

    private static final Logger LOG = LoggerFactory.getLogger(BasqueDateFormatSymbolsProviderTest.class);

    /**
     * Creates a new instance.
     */
    BasqueDateFormatSymbolsProviderTest() {
        super(new BasqueDateFormatSymbolsProvider());
    }

    /**
     * Test for {@link BasqueDateFormatSymbolsProvider#getInstance(Locale)}.
     */
    @Test
    void testGetInstance() {
        final DateFormatSymbols result = provider.getInstance(Basque.LOCALE);
        assertNotNull(result.getAmPmStrings());
        assertEquals(2, result.getAmPmStrings().length);
        assertNotNull(result.getWeekdays());
        assertEquals(8, result.getWeekdays().length);
        assertNotNull(result.getShortWeekdays());
        assertEquals(8, result.getShortWeekdays().length);
        assertNotNull(result.getMonths());
        assertEquals(13, result.getMonths().length);
        assertNotNull(result.getShortMonths());
        assertEquals(13, result.getShortMonths().length);
        assertNotNull(result.getAmPmStrings());
        assertEquals(2, result.getAmPmStrings().length);
        assertNotNull(result.getEras());
        assertEquals(2, result.getEras().length);
        assertNotNull(result.getLocalPatternChars());
        assertEquals(
                DateFormatSymbols.getInstance(Locale.ENGLISH).getLocalPatternChars(),
                result.getLocalPatternChars());
        assertNotNull(result.getZoneStrings());
        final String[][] zones = result.getZoneStrings();
        for (int i = 0; i < zones.length; i++) {
            final String[] zone = zones[i];
            assertNotNull(zone[0]);
            assertNotNull(zone[1]);
            assertNotNull(zone[2]);
            assertNotNull(zone[3]);
            assertNotNull(zone[4]);
            if (zone.length > 5) {
                assertNotNull(zone[5]);
                assertNotNull(zone[6]);
            }
        }
    }

    /**
     * Test for {@link BasqueDateFormatSymbolsProvider#getInstance(Locale)}.
     */
    @Test
    void testGetInstanceEs() {
        final DateFormatSymbols result = provider.getInstance(Basque.LOCALE_ES);
        assertNotNull(result.getAmPmStrings());
        assertEquals(2, result.getAmPmStrings().length);
        assertNotNull(result.getWeekdays());
        assertEquals(8, result.getWeekdays().length);
        assertNotNull(result.getShortWeekdays());
        assertEquals(8, result.getShortWeekdays().length);
        assertNotNull(result.getMonths());
        assertEquals(13, result.getMonths().length);
        assertNotNull(result.getShortMonths());
        assertEquals(13, result.getShortMonths().length);
        assertNotNull(result.getAmPmStrings());
        assertEquals(2, result.getAmPmStrings().length);
        assertNotNull(result.getEras());
        assertEquals(2, result.getEras().length);
        assertNotNull(result.getLocalPatternChars());
        assertEquals(
                DateFormatSymbols.getInstance(Locale.ENGLISH).getLocalPatternChars(),
                result.getLocalPatternChars());
        assertNotNull(result.getZoneStrings());
        final String[][] zones = result.getZoneStrings();
        for (int i = 0; i < zones.length; i++) {
            final String[] zone = zones[i];
            assertNotNull(zone[0]);
            assertNotNull(zone[1]);
            assertNotNull(zone[2]);
            assertNotNull(zone[3]);
            assertNotNull(zone[4]);
            if (zone.length > 5) {
                assertNotNull(zone[5]);
                assertNotNull(zone[6]);
            }
        }
    }

    /**
     * Test for {@link BasqueDateFormatSymbolsProvider#getInstance(Locale)}.
     */
    @Test
    void testGetInstanceFr() {
        final DateFormatSymbols result = provider.getInstance(Basque.LOCALE_FR);
        assertNotNull(result.getAmPmStrings());
        assertEquals(2, result.getAmPmStrings().length);
        assertNotNull(result.getWeekdays());
        assertEquals(8, result.getWeekdays().length);
        assertNotNull(result.getShortWeekdays());
        assertEquals(8, result.getShortWeekdays().length);
        assertNotNull(result.getMonths());
        assertEquals(13, result.getMonths().length);
        assertNotNull(result.getShortMonths());
        assertEquals(13, result.getShortMonths().length);
        assertNotNull(result.getAmPmStrings());
        assertEquals(2, result.getAmPmStrings().length);
        assertNotNull(result.getEras());
        assertEquals(2, result.getEras().length);
        assertNotNull(result.getLocalPatternChars());
        assertEquals(
                DateFormatSymbols.getInstance(Locale.ENGLISH).getLocalPatternChars(),
                result.getLocalPatternChars());
        assertNotNull(result.getZoneStrings());
        final String[][] zones = result.getZoneStrings();
        for (int i = 0; i < zones.length; i++) {
            final String[] zone = zones[i];
            assertNotNull(zone[0]);
            assertNotNull(zone[1]);
            assertNotNull(zone[2]);
            assertNotNull(zone[3]);
            assertNotNull(zone[4]);
            if (zone.length > 5) {
                assertNotNull(zone[5]);
                assertNotNull(zone[6]);
            }
        }
    }

    /**
     * Test for {@link BasqueDateFormatSymbolsProvider#getInstance(Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_23,
            disabledReason = "JRE > 23 test")
    @Test
    void testGetInstanceLatestCldr() {
        final DateFormatSymbols expected = DateFormatSymbols.getInstance(Basque.LOCALE);
        final DateFormatSymbols result = provider.getInstance(Basque.LOCALE);
        logInvalidZonesConfiguration(expected.getZoneStrings(), result.getZoneStrings());
        assertSymbolsEquals(expected, result);
    }

    /**
     * Test for {@link BasqueDateFormatSymbolsProvider#getInstance(Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_23,
            disabledReason = "JRE > 23 test")
    @Test
    void testGetInstanceLatestCldrEs() {
        assertSymbolsEquals(
                DateFormatSymbols.getInstance(Basque.LOCALE_ES),
                provider.getInstance(Basque.LOCALE_ES));
    }

    /**
     * Test for {@link BasqueDateFormatSymbolsProvider#getInstance(Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_23,
            disabledReason = "JRE > 23 test")
    @Test
    void testGetInstanceLatestCldrFr() {
        assertSymbolsEquals(
                DateFormatSymbols.getInstance(Basque.LOCALE_FR),
                provider.getInstance(Basque.LOCALE_FR));
    }

    private void assertSymbolsEquals(
            final DateFormatSymbols expected,
            final DateFormatSymbols result) {
        assertArrayEquals(
                expected.getAmPmStrings(),
                result.getAmPmStrings());
        assertArrayEquals(
                expected.getWeekdays(),
                result.getWeekdays());
        assertArrayEquals(
                expected.getShortWeekdays(),
                result.getShortWeekdays());
        assertArrayEquals(
                expected.getMonths(),
                result.getMonths());
        assertArrayEquals(
                expected.getShortMonths(),
                result.getShortMonths());
        assertArrayEquals(
                expected.getEras(),
                result.getEras());
        assertEquals(
                expected.getLocalPatternChars(),
                result.getLocalPatternChars());
        assertNotNull(result.getZoneStrings());
        final String[][] expectedZones = expected.getZoneStrings();
        final String[][] zones = result.getZoneStrings();
        assertZonesEquals(expectedZones, zones);
    }

    private void assertZonesEquals(
            final String[][] expectedZones,
            final String[][] zones) {
        final HashMap<String, String[]> values = new HashMap<>();
        for (int i = 0; i < expectedZones.length; i++) {
            final String[] expectedZone = expectedZones[i];
            values.put(expectedZone[0], expectedZone);
        }
        for (int i = 0; i < zones.length; i++) {
            final String[] zone = zones[i];
            final String id = zone[0];
            if (values.containsKey(id)) {
                assertArrayEquals(values.get(id), zone);
            }
        }
    }

    private void logInvalidZonesConfiguration(
            final String[][] expectedZones,
            final String[][] zones) {
        if (LOG.isDebugEnabled()) {
            final HashMap<String, String[]> values = new HashMap<>();
            for (int i = 0; i < expectedZones.length; i++) {
                final String[] expectedZone = expectedZones[i];
                values.put(expectedZone[0], expectedZone);
            }
            final ArrayList<String> failures = new ArrayList<>();
            for (int i = 0; i < zones.length; i++) {
                final String[] zone = zones[i];
                final String id = zone[0];
                if (values.containsKey(id) && !Arrays.equals(values.get(id), zone)) {
                    failures.add(id);
                }
            }
            Collections.sort(failures);
            for (final String id : failures) {
                final String[] expectedZone = values.get(id);
                if (expectedZone.length > 6) {
                    LOG.debug("{}={}",
                            expectedZone[0],
                            expectedZone[6]);
                    LOG.debug("{}{}={}",
                            expectedZone[0],
                            BasqueTimeZoneNameProvider.LONG_SUFFIX,
                            expectedZone[5]);
                }
                LOG.debug("{}{}={}",
                        expectedZone[0],
                        BasqueTimeZoneNameProvider.STANDARD_SUFFIX,
                        expectedZone[2]);
                LOG.debug("{}{}{}={}",
                        expectedZone[0],
                        BasqueTimeZoneNameProvider.STANDARD_SUFFIX,
                        BasqueTimeZoneNameProvider.LONG_SUFFIX,
                        expectedZone[1]);
                LOG.debug("{}{}={}",
                        expectedZone[0],
                        BasqueTimeZoneNameProvider.DAYLIGHT_SUFFIX,
                        expectedZone[4]);
                LOG.debug("{}{}{}={}",
                        expectedZone[0],
                        BasqueTimeZoneNameProvider.DAYLIGHT_SUFFIX,
                        BasqueTimeZoneNameProvider.LONG_SUFFIX,
                        expectedZone[3]);
                
            }
        }
    }
}
