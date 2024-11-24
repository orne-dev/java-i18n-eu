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
import java.text.DateFormatSymbols;
import java.time.ZoneId;
import java.time.zone.ZoneRulesException;
import java.util.HashMap;
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

    /** Time zone standard name property suffix. */
    static final String STANDARD_SUFFIX = ".std";
    /** Time zone daylight saving time name property suffix. */
    static final String DAYLIGHT_SUFFIX = ".dst";
    /** Time zone long name property suffix. */
    static final String LONG_SUFFIX = ".long";

    /** The time zone names in {@code DateFormatSymbols} format. */
    private static String[][] names;
    /** The time zone aliases. */
    private final HashMap<String, String> aliases = new HashMap<>();
    /** The time zone names by zone ID. */
    private final HashMap<String, String[]> index = new HashMap<>();

    /**
     * Creates a new instance.
     */
    public BasqueTimeZoneNameProvider() {
        super();
        for (final String[] zone : getNames()) {
            index.put(zone[0], zone);
        }
        aliases.put("GMT0", "GMT");
        aliases.put("Etc/GMT0", "GMT");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDisplayName(
            final @NotNull String id,
            final boolean daylight,
            final int style,
            final @NotNull Locale locale) {
        final String[] zone = getNames(id);
        if (zone == null) {
            return null;
        }
        if (daylight) {
            if (style == TimeZone.LONG) {
                return zone[3];
            } else {
                return zone[4];
            }
        } else {
            if (style == TimeZone.LONG) {
                return zone[1];
            } else {
                return zone[2];
            }
        }
    }

    @Override
    public String getGenericDisplayName(
            final String id,
            final int style,
            final Locale locale) {
        final String[] zone = getNames(id);
        if (zone == null || zone.length < 7) {
            return null;
        }
        if (style == TimeZone.LONG) {
            return zone[5];
        } else {
            return zone[6];
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NotNull Locale[] getAvailableLocales() {
        return BasqueLocaleServiceProvider.LOCALES;
    }

    /**
     * Returns The time zone names in {@code DateFormatSymbols} format.
     * 
     * @return The time zone names in {@code DateFormatSymbols} format.
     * @see DateFormatSymbols#getZoneStrings()
     */
    static synchronized @NotNull String[][] getNames() {
        if (names == null) {
            final Properties translations = new Properties();
            try (InputStream is = BasqueLocaleNameProvider.class.getResourceAsStream("timezones.properties")) {
                translations.load(is);
            } catch (final IOException e) {
                LOG.log(Level.SEVERE, "Error loading basque time zones names", e);
            }
            names = ((DateFormatSymbols) DateFormatSymbols.getInstance(Locale.ENGLISH).clone())
                    .getZoneStrings();
            for (int i = 0; i < names.length; i++) {
                final String[] zone = names[i];
                zone[1] = translations.getProperty(zone[0] + STANDARD_SUFFIX + LONG_SUFFIX, zone[1]);
                zone[2] = translations.getProperty(zone[0] + STANDARD_SUFFIX, zone[2]);
                zone[3] = translations.getProperty(zone[0] + DAYLIGHT_SUFFIX + LONG_SUFFIX, zone[3]);
                zone[4] = translations.getProperty(zone[0] + DAYLIGHT_SUFFIX, zone[4]);
                if (zone.length > 5) {
                    zone[5] = translations.getProperty(zone[0] + LONG_SUFFIX, zone[5]);
                }
                if (zone.length > 6) {
                    zone[6] = translations.getProperty(zone[0], zone[6]);
                }
            }
        }
        return names;
    }

    /**
     * Retrieves the time zone names for the specified ID, trying 
     * 
     * @param id The time zone ID.
     * @return The time zone names in {@code DateFormatSymbols} format, if found.
     */
    private String[] getNames(
            final @NotNull String id) {
        String[] zone = this.index.get(this.aliases.getOrDefault(id, id));
        if (zone == null) {
            try {
                zone = this.index.get(ZoneId.of(id).normalized().getId());
            } catch (final ZoneRulesException ignore) {
                // Ignore
            }
        }
        return zone;
    }
}
