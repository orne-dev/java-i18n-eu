package dev.orne.i18n.spi.eu;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import java.io.IOException;
import java.io.InputStream;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Properties;
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
class SpanishTimeZoneNamesTest {

    private static final DateTimeFormatter TO_LONG = DateTimeFormatter.ofPattern(
            "zzzz",
            new Locale("es"));
    private static final Properties esData;
    static {
        try (final InputStream is = SpanishTimeZoneNamesTest.class.getResourceAsStream("timezones_es.properties")) {
            esData = new Properties();
            esData.load(is);
        } catch (IOException e) {
            throw new AssertionError("Error loading spanish time zone names", e);
        }
    }

    @Test
    void testExtractData() {
        assertDoesNotThrow(() -> TimeZoneDataExtractor.main());
    }

    /**
     * Test for {@link BasqueTimeZoneNameProvider#getDisplayName(String, boolean, int, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("timeZoneIds")
    void testTimeZoneLongName(
            final @NotNull String zoneId) {
        final BasqueTimeZoneNameProvider provider = spy(new BasqueTimeZoneNameProvider());
        willReturn(esData).given(provider).getTimeZones();
        final ZonedDateTime time = BasqueTimeZoneNameProvider.getReferenceTime(zoneId, false);
        String expected = time.format(TO_LONG);
        String result = provider.getDisplayName(zoneId, false, TimeZone.LONG, Basque.LOCALE);
        assertEquals(
                expected,
                result == null ? expected : result,
                () -> String.format("Unexpected name for Zone '%s'", zoneId));
    }

    /**
     * Test for {@link BasqueTimeZoneNameProvider#getDisplayName(String, boolean, int, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("timeZoneIds")
    void testTimeZoneDstLongName(
            final @NotNull String zoneId) {
        final BasqueTimeZoneNameProvider provider = spy(new BasqueTimeZoneNameProvider());
        willReturn(esData).given(provider).getTimeZones();
        final ZonedDateTime time = BasqueTimeZoneNameProvider.getReferenceTime(zoneId, true);
        String expected = time.format(TO_LONG);
        String result = provider.getDisplayName(zoneId, true, TimeZone.LONG, Basque.LOCALE);
        assertEquals(
                expected,
                result == null ? expected : result,
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
