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

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.spi.NumberFormatProvider;
import java.util.Locale;

import javax.validation.constraints.NotNull;

/**
 * Basque number format provider.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 */
public class BasqueNumberFormatProvider
extends NumberFormatProvider {

    /** The integer format. */
    public static final String INTEGER_FORMAT = "#,##0;-#,##0";
    /** The number format. */
    public static final String NUMBER_FORMAT = "#,##0.###;-#,##0.###";
    /** The percent format. */
    public static final String PERCENT_FORMAT = "%#,##0";
    /** The currency format. */
    public static final String CURRENCY_FORMAT = "#,##0 ¤;-#,##0 ¤";

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFormat getCurrencyInstance(
            final @NotNull Locale locale) {
        if (Basque.LANGUAGE.equals(locale.getLanguage())) {
            return new DecimalFormat(
                    CURRENCY_FORMAT,
                    DecimalFormatSymbols.getInstance(locale));
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFormat getIntegerInstance(
            final @NotNull Locale locale) {
        if (Basque.LANGUAGE.equals(locale.getLanguage())) {
            return new DecimalFormat(
                    INTEGER_FORMAT,
                    DecimalFormatSymbols.getInstance(locale));
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFormat getNumberInstance(
            final @NotNull Locale locale) {
        if (Basque.LANGUAGE.equals(locale.getLanguage())) {
            return new DecimalFormat(
                    NUMBER_FORMAT,
                    DecimalFormatSymbols.getInstance(locale));
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFormat getPercentInstance(
            final @NotNull Locale locale) {
        if (Basque.LANGUAGE.equals(locale.getLanguage())) {
            return new DecimalFormat(
                    PERCENT_FORMAT,
                    DecimalFormatSymbols.getInstance(locale));
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
}
