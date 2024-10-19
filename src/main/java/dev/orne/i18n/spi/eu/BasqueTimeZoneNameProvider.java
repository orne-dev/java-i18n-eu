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
import java.util.Optional;
import java.util.Properties;
import java.util.TimeZone;
import java.util.WeakHashMap;
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
    /** Data time formatter to extract zone display name. */
    private static final DateTimeFormatter TO_LONG = DateTimeFormatter.ofPattern(
            "zzzz",
            Locale.ENGLISH);

    /** The time zone names translations. */
    private Properties translations;
    /** The time zone names translations. */
    private final WeakHashMap<String, Optional<String>> names = new WeakHashMap<>();

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
            final String cacheKey = id + (daylight ? "-DST" : "");
            return this.names.computeIfAbsent(cacheKey, k -> {
                return Optional.ofNullable(getTranslations().getProperty(
                        getTranslationProperty(id, daylight)));
                
            }).orElse(null);
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
     * Returns the english-basque time zone names translations.
     * 
     * @return The english-basque time zone names translations.
     */
    synchronized @NotNull Properties getTranslations() {
        if (translations == null) {
            translations = new Properties();
            try (InputStream is = BasqueLocaleNameProvider.class.getResourceAsStream("timezones.properties")) {
                translations.load(is);
            } catch (final IOException e) {
                LOG.log(Level.SEVERE, "Error loading basque time zones names", e);
            }
        }
        return translations;
    }

    /**
     * Retrieves the specified time zone long name in English.
     * 
     * @param zoneId The time zone ID.
     * @param daylight If the name must be for daylight saving time.
     * @return The time zone long name.
     */
    static @NotNull String getTranslationProperty(
            final @NotNull String zoneId,
            final boolean daylight) {
        return getEnglishName(zoneId, daylight).replace(" ", "_");
    }

    /**
     * Retrieves the specified time zone long name in English.
     * 
     * @param zoneId The time zone ID.
     * @param daylight If the name must be for daylight saving time.
     * @return The time zone long name.
     */
    static @NotNull String getEnglishName(
            final @NotNull String zoneId,
            final boolean daylight) {
        return getReferenceTime(zoneId, daylight).format(TO_LONG);
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
