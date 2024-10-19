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

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.spi.TimeZoneNameProvider;

import javax.validation.constraints.NotNull;

/**
 * Basque time zone name provider.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 */
public class BasqueTimeZoneNameProvider
extends TimeZoneNameProvider {

    /** The logger of the class. */
    private static final Logger LOG = Logger.getLogger(BasqueTimeZoneNameProvider.class.getName());

    /** Instant in December. */
    private static final Instant DECEMBER_INSTANT = LocalDateTime.now()
            .with(Month.DECEMBER)
            .toInstant(ZoneOffset.UTC);
    /** Instant in August. */
    private static final Instant AUGUST_INSTANT = LocalDateTime.now()
            .with(Month.AUGUST)
            .toInstant(ZoneOffset.UTC);
    /** Data time formatter to extract zone short name. */
    private static final DateTimeFormatter TO_SHORT = DateTimeFormatter.ofPattern(
            "z",
            Locale.ENGLISH);
    /** Suffix for daylight saving time zone properties. */
    private static final String DAYLIGHT_SUFFIX = ".dst";

    /** The time zone names data. */
    private Properties timezones;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDisplayName(
            final @NotNull String id,
            final boolean daylight,
            final int style,
            final @NotNull Locale locale) {
        if (Basque.LANGUAGE.equals(locale.getLanguage())
                && style == TimeZone.LONG) {
            final Properties data = getTimeZones();
            final String zoneProp = getZoneProperty(id, daylight);
            if (data.containsKey(zoneProp)) {
                return data.getProperty(zoneProp);
            }
            final String regionProp = getRegionProperty(id, daylight);
            if (data.containsKey(regionProp)) {
                return data.getProperty(regionProp);
            }
            return data.getProperty(getFallbackProperty(id, daylight));
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NotNull Locale[] getAvailableLocales() {
        return BasqueLocaleServiceProvider.LOCALES;
    }

    /**
     * Returns the language names for
     * <a href="http://www.rfc-editor.org/rfc/bcp/bcp47.txt">IETF BCP47</a>
     * language codes.
     * 
     * @return The language names.
     */
    synchronized @NotNull Properties getTimeZones() {
        if (timezones == null) {
            timezones = new Properties();
            try (InputStream is = BasqueLocaleNameProvider.class.getResourceAsStream("timezones.properties")) {
                timezones.load(is);
            } catch (final IOException e) {
                LOG.log(Level.SEVERE, "Error loading basque time zones names", e);
            }
        }
        return timezones;
    }

    /**
     * Returns the zone specific data property for specified time zone
     * and daylight saving time mode.
     * 
     * @param zoneId The time zone ID.
     * @param daylight If the property must be for daylight saving time.
     * @return The data property.
     */
    static String getZoneProperty(
            final @NotNull String zoneId,
            final boolean daylight) {
        return zoneId + (daylight ? DAYLIGHT_SUFFIX : "");
    }

    /**
     * Returns the region specific data property for specified time zone
     * and daylight saving time mode.
     * 
     * @param zoneId The time zone ID.
     * @param daylight If the property must be for daylight saving time.
     * @return The data property.
     */
    static String getRegionProperty(
            final @NotNull String zoneId,
            final boolean daylight) {
        final String region = getRegion(zoneId);
        final String shortName = getShortName(zoneId, daylight);
        String prop;
        if (region == null) {
            prop = shortName;
        } else {
            prop  = region + "/" + shortName;
        }
        return prop;
    }

    /**
     * Returns data property for specified time zone
     * and daylight saving time mode.
     * 
     * @param zoneId The time zone ID.
     * @param daylight If the property must be for daylight saving time.
     * @return The data property.
     */
    static String getFallbackProperty(
            final @NotNull String zoneId,
            final boolean daylight) {
        return getShortName(zoneId, daylight);
    }

    /**
     * Extract the region from the specified time zone ID, if any.
     * 
     * @param zoneId The time zone ID.
     * @return The time zone region.
     */
    static String getRegion(
            final @NotNull String zoneId) {
        String region = null;
        if (zoneId.split("/").length > 1) {
            region = zoneId.split("/")[0];
        }
        return region;
    }

    /**
     * Retrieves the specified time zone short name in English.
     * 
     * @param zoneId The time zone ID.
     * @param daylight If the name must be for daylight saving time.
     * @return The time zone short name.
     */
    static @NotNull String getShortName(
            final @NotNull String zoneId,
            final boolean daylight) {
        return getReferenceTime(zoneId, daylight).format(TO_SHORT);
    }

    /**
     * Computes a instant with the specified daylight saving time mode
     * for the specified time zone.
     * 
     * @param zoneId The time zone ID.
     * @param daylight If the instant must be for daylight saving time.
     * @return The time instant.
     */
    static @NotNull ZonedDateTime getReferenceTime(
            final @NotNull String zoneId,
            final boolean daylight) {
        final ZoneId zone = ZoneId.of(zoneId);
        final ZonedDateTime time;
        if (ZoneId.of(zoneId).getRules().isDaylightSavings(DECEMBER_INSTANT) == daylight) {
            time = ZonedDateTime.ofInstant(DECEMBER_INSTANT, zone);
        } else {
            time = ZonedDateTime.ofInstant(AUGUST_INSTANT, zone);
        }
        return time;
    }
}
