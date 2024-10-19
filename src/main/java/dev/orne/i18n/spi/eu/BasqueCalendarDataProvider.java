package dev.orne.i18n.spi.eu;

import java.util.Calendar;
import java.util.Locale;
import java.util.spi.CalendarDataProvider;

import javax.validation.constraints.NotNull;

/**
 * Basque calendar data provider.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 */
public class BasqueCalendarDataProvider
extends CalendarDataProvider {

    /**
     * {@inheritDoc}
     */
    @Override
    public int getFirstDayOfWeek(
            final @NotNull Locale locale) {
        return Calendar.MONDAY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMinimalDaysInFirstWeek(
            final @NotNull Locale locale) {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NotNull Locale[] getAvailableLocales() {
        return BasqueLocaleServiceProvider.LOCALES;
    }
}
