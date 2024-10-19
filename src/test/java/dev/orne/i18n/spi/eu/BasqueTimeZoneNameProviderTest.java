package dev.orne.i18n.spi.eu;

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
