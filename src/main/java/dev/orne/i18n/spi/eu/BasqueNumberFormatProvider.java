package dev.orne.i18n.spi.eu;

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
