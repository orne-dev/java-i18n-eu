package dev.orne.i18n.spi.eu;

import java.util.Locale;

/**
 * Constants for basque language.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 */
public final class Basque {

    /** The basque language ISO 639 code. */
    public static final String LANGUAGE = "eu";
    /** The basque language locale. */
    public static final Locale LOCALE = new Locale(LANGUAGE);
    /** The southern basque country locale. */
    public static final Locale LOCALE_ES = new Locale(LANGUAGE, "ES");
    /** The northern basque country locale. */
    public static final Locale LOCALE_FR = new Locale(LANGUAGE, "FR");

    /**
     * Private constructor.
     */
    private Basque() {
        // Utility class
    }
}
