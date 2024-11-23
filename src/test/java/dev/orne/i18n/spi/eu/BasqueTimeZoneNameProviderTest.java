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

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.TimeZone;
import java.util.stream.Stream;

import javax.validation.constraints.NotNull;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Unit tests for {@code BasqueTimeZoneNameProvider}.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 * @see BasqueTimeZoneNameProvider
 */
@Tag("ut")
class BasqueTimeZoneNameProviderTest
extends AbstractBasqueProviderTest<BasqueTimeZoneNameProvider> {

    /**
     * Creates a new instance.
     */
    BasqueTimeZoneNameProviderTest() {
        super(new BasqueTimeZoneNameProvider());
    }

    /**
     * Test for {@link BasqueTimeZoneNameProvider#getDisplayName(String, boolean, int, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("timeZoneIds")
    void testGetDisplayName(
            final @NotNull String zoneId) {
        assertNotNull(provider.getDisplayName(zoneId, false, TimeZone.SHORT, Basque.LOCALE));
        assertNotNull(provider.getDisplayName(zoneId, false, TimeZone.SHORT, Basque.LOCALE_ES));
        assertNotNull(provider.getDisplayName(zoneId, false, TimeZone.SHORT, Basque.LOCALE_FR));
        assertNotNull(provider.getDisplayName(zoneId, false, TimeZone.LONG, Basque.LOCALE));
        assertNotNull(provider.getDisplayName(zoneId, false, TimeZone.LONG, Basque.LOCALE_ES));
        assertNotNull(provider.getDisplayName(zoneId, false, TimeZone.LONG, Basque.LOCALE_FR));
        assertNotNull(provider.getDisplayName(zoneId, true, TimeZone.SHORT, Basque.LOCALE));
        assertNotNull(provider.getDisplayName(zoneId, true, TimeZone.SHORT, Basque.LOCALE_ES));
        assertNotNull(provider.getDisplayName(zoneId, true, TimeZone.SHORT, Basque.LOCALE_FR));
        assertNotNull(provider.getDisplayName(zoneId, false, TimeZone.LONG, Basque.LOCALE));
        assertNotNull(provider.getDisplayName(zoneId, false, TimeZone.LONG, Basque.LOCALE_ES));
        assertNotNull(provider.getDisplayName(zoneId, false, TimeZone.LONG, Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueTimeZoneNameProvider#getGenericDisplayName(String, int, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("timeZoneIds")
    void testGetGenericDisplayName(
            final @NotNull String zoneId) {
        assertNotNull(provider.getGenericDisplayName(zoneId, TimeZone.SHORT, Basque.LOCALE));
        assertNotNull(provider.getGenericDisplayName(zoneId, TimeZone.SHORT, Basque.LOCALE_ES));
        assertNotNull(provider.getGenericDisplayName(zoneId, TimeZone.SHORT, Basque.LOCALE_FR));
        assertNotNull(provider.getGenericDisplayName(zoneId, TimeZone.LONG, Basque.LOCALE));
        assertNotNull(provider.getGenericDisplayName(zoneId, TimeZone.LONG, Basque.LOCALE_ES));
        assertNotNull(provider.getGenericDisplayName(zoneId, TimeZone.LONG, Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueTimeZoneNameProvider#getDisplayName(String, boolean, int, Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_23,
            disabledReason = "JRE > 23 test")
    @ParameterizedTest
    @MethodSource("timeZoneIds")
    void testGetDisplayNameShortStandardLatestCldr(
            final @NotNull String zoneId) {
        TimeZone tz = TimeZone.getTimeZone(zoneId);
        assertEquals(
                tz.getDisplayName(false, TimeZone.SHORT, Basque.LOCALE),
                provider.getDisplayName(zoneId, false, TimeZone.SHORT, Basque.LOCALE));
        assertEquals(
                tz.getDisplayName(false, TimeZone.SHORT, Basque.LOCALE_ES),
                provider.getDisplayName(zoneId, false, TimeZone.SHORT, Basque.LOCALE_ES));
        assertEquals(
                tz.getDisplayName(false, TimeZone.SHORT, Basque.LOCALE_FR),
                provider.getDisplayName(zoneId, false, TimeZone.SHORT, Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueTimeZoneNameProvider#getDisplayName(String, boolean, int, Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_23,
            disabledReason = "JRE > 23 test")
    @ParameterizedTest
    @MethodSource("timeZoneIds")
    void testGetDisplayNameLongStandardLatestCldr(
            final @NotNull String zoneId) {
        TimeZone tz = TimeZone.getTimeZone(zoneId);
        assertEquals(
                tz.getDisplayName(false, TimeZone.LONG, Basque.LOCALE),
                provider.getDisplayName(zoneId, false, TimeZone.LONG, Basque.LOCALE));
        assertEquals(
                tz.getDisplayName(false, TimeZone.LONG, Basque.LOCALE_ES),
                provider.getDisplayName(zoneId, false, TimeZone.LONG, Basque.LOCALE_ES));
        assertEquals(
                tz.getDisplayName(false, TimeZone.LONG, Basque.LOCALE_FR),
                provider.getDisplayName(zoneId, false, TimeZone.LONG, Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueTimeZoneNameProvider#getDisplayName(String, boolean, int, Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_23,
            disabledReason = "JRE > 23 test")
    @ParameterizedTest
    @MethodSource("timeZoneIds")
    void testGetDisplayNameShortDaylightLatestCldr(
            final @NotNull String zoneId) {
        TimeZone tz = TimeZone.getTimeZone(zoneId);
        assertEquals(
                tz.getDisplayName(true, TimeZone.SHORT, Basque.LOCALE),
                provider.getDisplayName(zoneId, true, TimeZone.SHORT, Basque.LOCALE));
        assertEquals(
                tz.getDisplayName(true, TimeZone.SHORT, Basque.LOCALE_ES),
                provider.getDisplayName(zoneId, true, TimeZone.SHORT, Basque.LOCALE_ES));
        assertEquals(
                tz.getDisplayName(true, TimeZone.SHORT, Basque.LOCALE_FR),
                provider.getDisplayName(zoneId, true, TimeZone.SHORT, Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueTimeZoneNameProvider#getDisplayName(String, boolean, int, Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_23,
            disabledReason = "JRE > 23 test")
    @ParameterizedTest
    @MethodSource("timeZoneIds")
    void testGetDisplayNameLongDaylightLatestCldr(
            final @NotNull String zoneId) {
        TimeZone tz = TimeZone.getTimeZone(zoneId);
        assertEquals(
                tz.getDisplayName(true, TimeZone.LONG, Basque.LOCALE),
                provider.getDisplayName(zoneId, true, TimeZone.LONG, Basque.LOCALE));
        assertEquals(
                tz.getDisplayName(true, TimeZone.LONG, Basque.LOCALE_ES),
                provider.getDisplayName(zoneId, true, TimeZone.LONG, Basque.LOCALE_ES));
        assertEquals(
                tz.getDisplayName(true, TimeZone.LONG, Basque.LOCALE_FR),
                provider.getDisplayName(zoneId, true, TimeZone.LONG, Basque.LOCALE_FR));
    }

    /**
     * Source of time zone IDs for {@code testTimeZoneName}.
     * 
     * @return The time zone IDs.
     */
    static Stream<Arguments> timeZoneIds() {
        final ArrayList<String> list = new ArrayList<>(ZoneId.getAvailableZoneIds());
        Collections.sort(list);
        return list.stream()
                .filter(id -> !id.contains("GMT-") && !id.contains("GMT+"))
                .map(id -> Arguments.of(id));
    }
}
