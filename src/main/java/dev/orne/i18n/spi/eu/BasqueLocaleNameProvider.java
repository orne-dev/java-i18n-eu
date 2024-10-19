package dev.orne.i18n.spi.eu;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.spi.LocaleNameProvider;

import javax.validation.constraints.NotNull;

/**
 * Basque locale name provider.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 */
public class BasqueLocaleNameProvider
extends LocaleNameProvider {

    /** The logger of the class. */
    private static final Logger LOG = Logger.getLogger(BasqueLocaleNameProvider.class.getName());

    /** The language names. */
    private static Properties languages;
    /** The country names. */
    private static Properties countries;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDisplayLanguage(
            final @NotNull String languageCode,
            final @NotNull Locale locale) {
        if (Basque.LANGUAGE.equals(locale.getLanguage())) {
            return getLanguages().getProperty(languageCode);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDisplayCountry(
            final @NotNull String countryCode,
            final @NotNull Locale locale) {
        if (Basque.LANGUAGE.equals(locale.getLanguage())) {
            return getCountries().getProperty(countryCode);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDisplayVariant(
            final @NotNull String variant,
            final @NotNull Locale locale) {
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
    static synchronized @NotNull Properties getLanguages() {
        if (languages == null) {
            languages = new Properties();
            try (InputStream is = BasqueLocaleNameProvider.class.getResourceAsStream("languages.properties")) {
                languages.load(is);
            } catch (final IOException e) {
                LOG.log(Level.SEVERE, "Error loading basque language names", e);
            }
        }
        return languages;
    }

    /**
     * Returns the country names for
     * <a href="http://www.rfc-editor.org/rfc/bcp/bcp47.txt">IETF BCP47</a>
     * language codes.
     * 
     * @return The country names.
     */
    static synchronized @NotNull Properties getCountries() {
        if (countries == null) {
            countries = new Properties();
            try (InputStream is = BasqueLocaleNameProvider.class.getResourceAsStream("countries.properties")) {
                countries.load(is);
            } catch (final IOException e) {
                LOG.log(Level.SEVERE, "Error loading basque country names", e);
            }
        }
        return countries;
    }
}
