package dev.orne.i18n.spi.eu;

/*-
 * #%L
 * basque-locale-extension
 * %%
 * Copyright (C) 2021 - 2024 Orne Developments
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

import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.IntFunction;
import java.util.spi.CalendarNameProvider;

import javax.validation.constraints.NotNull;

/**
 * Basque calendar names provider.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 */
public class BasqueCalendarNameProvider
extends CalendarNameProvider {

    /** Gregorian calendar type. */
    static final String GREGORIAN_CALENDAR = "gregory";
    /** Buddhist calendar type. */
    static final String BUDDHIST_CALENDAR = "buddhist";
    /** Japanese calendar type. */
    static final String JAPANESE_CALENDAR = "japanese";
    /** Minguo (Republic of China) calendar type. */
    static final String MINGUO_CALENDAR = "roc";
    /** Islamic calendar type. */
    static final String ISLAMIC_CALENDAR = "islamic";

    /** Long Gregorian calendar era names. */
    static final String[] GREGORIAN_ERAS_LONG = new String[] {
            "Kristo aurreko",
            "Kristo ondoko"
    };
    /** Short Gregorian calendar era names. */
    static final String[] GREGORIAN_ERAS_SHORT = new String[] {
            "K.a.",
            "K.o."
    };
    /** Long Buddhist calendar era names. */
    static final String[] BUDDHIST_ERAS_LONG = new String[] {
            "Buda aurreko",
            "Buda ondoko"
    };
    /** Short Buddhist calendar era names. */
    static final String[] BUDDHIST_ERAS_SHORT = new String[] {
            "B.a.",
            "B.o."
    };
    /** Long Japanese calendar era names. */
    static final String[] JAPANESE_ERAS_LONG = new String[] {
            "Seireki aurreko",
            "Meiji aroko",
            "Taisho aroko",
            "Showa aroko",
            "Heisei aroko",
            "Reiwa aroko",
    };
    /** Short Japanese calendar era names. */
    static final String[] JAPANESE_ERAS_SHORT = new String[] {
            "S.a.",
            "M.u.",
            "T.u.",
            "S.u.",
            "H.u.",
            "R.u."
    };
    /** Long Republic of China calendar era names. */
    static final String[] MINGUO_ERAS_LONG = new String[] {
            "Minguo aurreko",
            "Minguo ondoko"
    };
    /** Short Republic of China calendar era names. */
    static final String[] MINGUO_ERAS_SHORT = new String[] {
            "M.a.",
            "M.o."
    };
    /** Long Islamic calendar era names. */
    static final String[] ISLAMIC_ERAS_LONG = new String[] {
            "Hejira aurreko",
            "Hejira ondoko"
    };
    /** Short Islamic calendar era names. */
    static final String[] ISLAMIC_ERAS_SHORT = new String[] {
            "H.a.",
            "H.o."
    };
    /** Long month names. */
    static final String[] MONTHS_LONG = new String[] {
            "Urtarrila",
            "Otsaila",
            "Martxoa",
            "Apirila",
            "Maiatza",
            "Ekaina",
            "Uztaila",
            "Abuztua",
            "Iraila",
            "Urria",
            "Azaroa",
            "Abendua"
    };
    /** Short month names. */
    static final String[] MONTHS_SHORT = new String[] {
            "Urt",
            "Ots",
            "Mar",
            "Api",
            "Mai",
            "Eka",
            "Uzt",
            "Abu",
            "Ira",
            "Urr",
            "Aza",
            "Abe"
    };
    /** Narrow month names. */
    static final String[] MONTHS_NARROW = new String[] {
            "U",
            "O",
            "M",
            "A",
            "M",
            "E",
            "U",
            "A",
            "I",
            "U",
            "A",
            "A"
    };

    /** Long weekday names. */
    static final String[] WEEKDAYS_LONG = new String[] {
            null,
            "Igandea",
            "Astelehena",
            "Asteartea",
            "Asteazkena",
            "Osteguna",
            "Ostirala",
            "Larunbata"
    };
    /** Short weekday names. */
    static final String[] WEEKDAYS_SHORT = new String[] {
            null,
            "Ig.",
            "Al.",
            "As.",
            "Az.",
            "Og.",
            "Or.",
            "Lr."
    };
    /** Narrow weekday names. */
    static final String[] WEEKDAYS_NARROW = new String[] {
            null,
            "I",
            "A",
            "A",
            "A",
            "O",
            "O",
            "L"
    };
    /** AM-PM markers. */
    static final String[] AMPM_MARKERS = new String[] {
            "AM",
            "PM"
    };

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Integer> getDisplayNames(
            final String calendarType,
            final int field,
            final int style,
            final @NotNull Locale locale) {
        if (Basque.LANGUAGE.equals(locale.getLanguage())) {
            final IntFunction<String[]> fnc = getFieldNamesFunction(calendarType, field);
            if (style == Calendar.ALL_STYLES) {
                return mergeNames(fnc, Calendar.SHORT_FORMAT, Calendar.LONG_FORMAT);
            } else {
                return mergeNames(fnc, style);
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDisplayName(
            final String calendarType,
            final int field,
            final int value,
            final int style,
            final @NotNull Locale locale) {
        if (Basque.LANGUAGE.equals(locale.getLanguage())) {
            final IntFunction<String[]> fnc = getFieldNamesFunction(calendarType, field);
            if (fnc == null) {
                return null;
            } else {
                return getValueName(fnc, style, value);
            }
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
     * Returns the function to retrieve the specified calendar field value
     * names.
     * 
     * @param field The calendar field.
     * @return The function to retrieve the field value names, or {@code null}
     * if field is not supported.
     */
    static IntFunction<String[]> getFieldNamesFunction(
            final String calendarType,
            final int field) {
        switch (field) {
            case Calendar.ERA:
                if (GREGORIAN_CALENDAR.equals(calendarType)) {
                    return BasqueCalendarNameProvider::getGregorianEraNames;
                } else if (BUDDHIST_CALENDAR.equals(calendarType)) {
                    return BasqueCalendarNameProvider::getBuddhistEraNames;
                } else if (ISLAMIC_CALENDAR.equals(calendarType)) {
                    return BasqueCalendarNameProvider::getIslamicEraNames;
                } else if (JAPANESE_CALENDAR.equals(calendarType)) {
                    return BasqueCalendarNameProvider::getJapaneseEraNames;
                } else if (MINGUO_CALENDAR.equals(calendarType)) {
                    return BasqueCalendarNameProvider::getMinguoEraNames;
                } else {
                    return null;
                }
            case Calendar.MONTH:
                return BasqueCalendarNameProvider::getMonthNames;
            case Calendar.DAY_OF_WEEK:
                return BasqueCalendarNameProvider::getWeekdayNames;
            case Calendar.AM_PM:
                return BasqueCalendarNameProvider::getAmPmNames;
            default:
                return null;
        }
    }

    /**
     * Returns the specified calendar field value name in the specified format style.
     * 
     * @param namesProvider The calendar field value names provider, may be {@code null}.
     * @param style The name format style.
     * @param value The calendar field value.
     * @return The value name, or {@code null} if unknown or not supported.
     */
    static Map<String, Integer> mergeNames(
            final IntFunction<String[]> namesProvider,
            final int... styles) {
        if (namesProvider == null) {
            return null;
        }
        final Map<String, Integer> result = new HashMap<>();
        for (final int style : styles) {
            final String[] names = namesProvider.apply(style);
            if (names == null) {
                continue;
            }
            for (int i = 0; i < names.length; i++) {
                result.put(names[i], i);
            }
        }
        if (result.isEmpty()) {
            return null;
        } else {
            return result;
        }
    }

    /**
     * Returns the specified calendar field value name in the specified format style.
     * 
     * @param namesProvider The calendar field value names provider, may be {@code null}.
     * @param style The name format style.
     * @param value The calendar field value.
     * @return The value name, or {@code null} if unknown or not supported.
     */
    static String getValueName(
            final IntFunction<String[]> namesProvider,
            final int style,
            final int value) {
        final String[] names = namesProvider == null ? null : namesProvider.apply(style);
        if (names == null ||
                names.length == 0 ||
                value < 0 ||
                value >= names.length) {
            return null;
        } else {
            return names[value];
        }
    }

    /**
     * Returns the Gregorian calendar era names in the specified style.
     * 
     * @param style The format style.
     * @return The era names.
     */
    static @NotNull String[] getGregorianEraNames(
            int style) {
        switch(style) {
            case Calendar.SHORT_FORMAT:
            case Calendar.SHORT_STANDALONE:
            case Calendar.NARROW_FORMAT:
            case Calendar.NARROW_STANDALONE:
                return GREGORIAN_ERAS_SHORT;
            case Calendar.LONG_FORMAT:
            case Calendar.LONG_STANDALONE:
            default:
                return GREGORIAN_ERAS_LONG;
        }
    }

    /**
     * Returns the Buddhist calendar era names in the specified style.
     * 
     * @param style The format style.
     * @return The era names.
     */
    static @NotNull String[] getBuddhistEraNames(
            int style) {
        switch(style) {
            case Calendar.SHORT_FORMAT:
            case Calendar.SHORT_STANDALONE:
            case Calendar.NARROW_FORMAT:
            case Calendar.NARROW_STANDALONE:
                return BUDDHIST_ERAS_SHORT;
            case Calendar.LONG_FORMAT:
            case Calendar.LONG_STANDALONE:
            default:
                return BUDDHIST_ERAS_LONG;
        }
    }

    /**
     * Returns the Japanese calendar era names in the specified style.
     * 
     * @param style The format style.
     * @return The era names.
     */
    static @NotNull String[] getJapaneseEraNames(
            int style) {
        switch(style) {
            case Calendar.SHORT_FORMAT:
            case Calendar.SHORT_STANDALONE:
            case Calendar.NARROW_FORMAT:
            case Calendar.NARROW_STANDALONE:
                return JAPANESE_ERAS_SHORT;
            case Calendar.LONG_FORMAT:
            case Calendar.LONG_STANDALONE:
            default:
                return JAPANESE_ERAS_LONG;
        }
    }

    /**
     * Returns the Minguo calendar era names in the specified style.
     * 
     * @param style The format style.
     * @return The era names.
     */
    static @NotNull String[] getMinguoEraNames(
            int style) {
        switch(style) {
            case Calendar.SHORT_FORMAT:
            case Calendar.SHORT_STANDALONE:
            case Calendar.NARROW_FORMAT:
            case Calendar.NARROW_STANDALONE:
                return MINGUO_ERAS_SHORT;
            case Calendar.LONG_FORMAT:
            case Calendar.LONG_STANDALONE:
            default:
                return MINGUO_ERAS_LONG;
        }
    }

    /**
     * Returns the Islamic calendar era names in the specified style.
     * 
     * @param style The format style.
     * @return The era names.
     */
    static @NotNull String[] getIslamicEraNames(
            int style) {
        switch(style) {
            case Calendar.SHORT_FORMAT:
            case Calendar.SHORT_STANDALONE:
            case Calendar.NARROW_FORMAT:
            case Calendar.NARROW_STANDALONE:
                return ISLAMIC_ERAS_SHORT;
            case Calendar.LONG_FORMAT:
            case Calendar.LONG_STANDALONE:
            default:
                return ISLAMIC_ERAS_LONG;
        }
    }

    /**
     * Returns the month names in the specified style.
     * 
     * @param style The format style.
     * @return The month names.
     */
    static @NotNull String[] getMonthNames(
            final int style) {
        switch(style) {
            case Calendar.NARROW_FORMAT:
            case Calendar.NARROW_STANDALONE:
                return MONTHS_NARROW;
            case Calendar.SHORT_FORMAT:
            case Calendar.SHORT_STANDALONE:
                return MONTHS_SHORT;
            case Calendar.LONG_FORMAT:
            case Calendar.LONG_STANDALONE:
            default:
                return MONTHS_LONG;
        }
    }

    /**
     * Returns the weekday names in the specified style.
     * 
     * @param style The format style.
     * @return The weekday names.
     */
    static @NotNull String[] getWeekdayNames(
            final int style) {
        switch(style) {
            case Calendar.NARROW_FORMAT:
            case Calendar.NARROW_STANDALONE:
                return WEEKDAYS_NARROW;
            case Calendar.SHORT_FORMAT:
            case Calendar.SHORT_STANDALONE:
                return WEEKDAYS_SHORT;
            case Calendar.LONG_FORMAT:
            case Calendar.LONG_STANDALONE:
            default:
                return WEEKDAYS_LONG;
        }
    }

    /**
     * Returns the AM/PM marker names in the specified style.
     * 
     * @param style The format style.
     * @return The AM/PM marker names.
     */
    static @NotNull String[] getAmPmNames(
            final int style) {
        return AMPM_MARKERS;
    }
}
