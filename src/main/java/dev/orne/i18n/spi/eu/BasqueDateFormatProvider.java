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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.spi.DateFormatProvider;
import java.util.Locale;

import javax.validation.constraints.NotNull;

/**
 * Basque date format provider.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 */
public class BasqueDateFormatProvider
extends DateFormatProvider {

    /** Time formats. */
    static final String[] TIME_FORMATS = new String[] {
            "HH:mm:ss (zzzz)",
            "HH:mm:ss (z)",
            "HH:mm:ss",
            "HH:mm"
    };
    /** Date formats. */
    static final String[] DATE_FORMATS = new String[] {
            "y('e')'ko' MMMM'ren' d('a'), EEEE",
            "y('e')'ko' MMMM'ren' d('a')",
            "y('e')'ko' MMM d('a')",
            "yy/M/d"
    };
    /** Date-time format. */
    static final String DATE_TIME_FORMAT = "%s (%s)";

    /**
     * Creates a new instance.
     */
    public BasqueDateFormatProvider() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DateFormat getDateInstance(
            final int style,
            final @NotNull Locale locale) {
        return new SimpleDateFormat(
                getDateFormat(style),
                locale);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DateFormat getTimeInstance(
            final int style,
            final @NotNull Locale locale) {
        return new SimpleDateFormat(
                getTimeFormat(style),
                locale);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DateFormat getDateTimeInstance(
            final int dateStyle,
            final int timeStyle,
            final @NotNull Locale locale) {
        return new SimpleDateFormat(
                String.format(
                        DATE_TIME_FORMAT,
                        getDateFormat(dateStyle),
                        getTimeFormat(timeStyle)),
                locale);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NotNull Locale[] getAvailableLocales() {
        return BasqueLocaleServiceProvider.LOCALES;
    }

    /**
     * Returns the date format for the specified style.
     * 
     * @param style The date style.
     * @return The date format.
     */
    public static @NotNull String getDateFormat(
            int style) {
        if (style < 0 || style >= DATE_FORMATS.length) {
            style = DateFormat.SHORT;
        }
        return DATE_FORMATS[style];
    }

    /**
     * Returns the time format for the specified style.
     * 
     * @param style The time style.
     * @return The time format.
     */
    public static @NotNull String getTimeFormat(
            int style) {
        if (style < 0 || style >= TIME_FORMATS.length) {
            style = DateFormat.SHORT;
        }
        return TIME_FORMATS[style];
    }
}
