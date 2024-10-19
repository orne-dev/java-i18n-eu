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

import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.TimeZone;
import java.util.stream.Stream;

import javax.validation.constraints.NotNull;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
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
class BasqueTimeZoneNameProviderTest {

    private static final DateTimeFormatter TO_LONG = DateTimeFormatter.ofPattern(
            "zzzz",
            new Locale("es"));

    /** The provider instance to test. */
    private final BasqueTimeZoneNameProvider provider = new BasqueTimeZoneNameProvider();

    /**
     * Test for {@link BasqueTimeZoneNameProvider#getAvailableLocales()}.
     */
    @Test
    void testAvailableLocales() {
        assertTrue(provider.isSupportedLocale(Basque.LOCALE));
        assertTrue(provider.isSupportedLocale(Basque.LOCALE_ES));
        assertTrue(provider.isSupportedLocale(Basque.LOCALE_FR));
    }

    @Test
    void testGetReferenceTime() {
        assertEquals(Month.DECEMBER, BasqueTimeZoneNameProvider.getReferenceTime("Europe/Madrid", false).getMonth());
        assertEquals(Month.AUGUST, BasqueTimeZoneNameProvider.getReferenceTime("Europe/Madrid", true).getMonth());
        assertEquals(Month.AUGUST, BasqueTimeZoneNameProvider.getReferenceTime("Australia/Melbourne", false).getMonth());
        assertEquals(Month.DECEMBER, BasqueTimeZoneNameProvider.getReferenceTime("Australia/Melbourne", true).getMonth());
    }

    /**
     * Test for {@link BasqueTimeZoneNameProvider#getDisplayName(String, boolean, int, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("timeZoneIds")
    void testTimeZoneLongName(
            final @NotNull String zoneId) {
        final ZonedDateTime time = BasqueTimeZoneNameProvider.getReferenceTime(zoneId, false);
        String expected = time.format(TO_LONG);
        String result = provider.getDisplayName(zoneId, false, TimeZone.LONG, Basque.LOCALE);
        assertNotEquals(
                expected,
                result,
                () -> String.format("Unexpected name for Zone '%s'", zoneId));
    }

    /**
     * Test for {@link BasqueTimeZoneNameProvider#getDisplayName(String, boolean, int, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("timeZoneIds")
    void testTimeZoneDstLongName(
            final @NotNull String zoneId) {
        final ZonedDateTime time = BasqueTimeZoneNameProvider.getReferenceTime(zoneId, true);
        String expected = time.format(TO_LONG);
        String result = provider.getDisplayName(zoneId, true, TimeZone.LONG, Basque.LOCALE);
        assertNotEquals(
                expected,
                result,
                () -> String.format("Unexpected name for Zone '%s'", zoneId));
    }

    /**
     * Source of time zone IDs for {@code testTimeZoneName}.
     * 
     * @return The time zone IDs.
     */
    static Stream<Arguments> timeZoneIds() {
        final ArrayList<String> list = new ArrayList<>(ZoneId.getAvailableZoneIds());
        Collections.sort(list);
        return list.stream().map(id -> Arguments.of(id));
    }
}
