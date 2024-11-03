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

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import javax.validation.constraints.NotNull;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit tests for {@code BasqueLocaleNameProvider}.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-11
 * @since 1.0
 * @see BasqueLocaleNameProvider
 */
@Tag("ut")
class BasqueLocaleNameProviderTest
extends AbstractBasqueProviderTest<BasqueLocaleNameProvider> {

    private static final Logger LOG = LoggerFactory.getLogger(BasqueLocaleNameProviderTest.class);

    /**
     * Creates a new instance.
     */
    BasqueLocaleNameProviderTest() {
        super(new BasqueLocaleNameProvider());
    }

    /**
     * Test for {@link BasqueLocaleNameProvider#getDisplayLanguage(String, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("languageCodes")
    void testGetDisplayLanguage(
            final @NotNull String language) {
        if (provider.getDisplayLanguage(language, Basque.LOCALE) == null) {
            LOG.debug("{}{}=",
                    BasqueLocaleNameProvider.LANGUAGE_PREFIX,
                    language);
        }
        assertNotNull(provider.getDisplayLanguage(language, Basque.LOCALE));
        assertNotNull(provider.getDisplayLanguage(language, Basque.LOCALE_ES));
        assertNotNull(provider.getDisplayLanguage(language, Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueLocaleNameProvider#getDisplayCountry(String, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("countryCodes")
    void testGetDisplayCountry(
            final @NotNull String country) {
        assertNotNull(provider.getDisplayCountry(country, Basque.LOCALE));
        assertNotNull(provider.getDisplayCountry(country, Basque.LOCALE_ES));
        assertNotNull(provider.getDisplayCountry(country, Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueLocaleNameProvider#getDisplayVariant(String, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("variantLocales")
    void testGetDisplayVariant(
            final @NotNull Locale locale) {
        assertNotNull(provider.getDisplayVariant(locale.getVariant(), Basque.LOCALE));
        assertNotNull(provider.getDisplayVariant(locale.getVariant(), Basque.LOCALE_ES));
        assertNotNull(provider.getDisplayVariant(locale.getVariant(), Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueLocaleNameProvider#getDisplayScript(String, Locale)}.
     */
    @ParameterizedTest
    @MethodSource("scriptLocales")
    void testGetDisplayScript(
            final @NotNull Locale locale) {
        assertNotNull(provider.getDisplayScript(locale.getScript(), Basque.LOCALE));
        assertNotNull(provider.getDisplayScript(locale.getScript(), Basque.LOCALE_ES));
        assertNotNull(provider.getDisplayScript(locale.getScript(), Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueLocaleNameProvider#getDisplayLanguage(String, Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_21,
            disabledReason = "JRE > 21 test")
    @ParameterizedTest
    @MethodSource("languageCodes")
    void testGetDisplayLanguageLatestCldr(
            final @NotNull String language) {
        final Locale locale = new Locale(language);
        String expected = locale.getDisplayCountry(Basque.LOCALE);
        String result = provider.getDisplayLanguage(language, Basque.LOCALE);
        if (!expected.isEmpty() && !Objects.equals(expected, result)) {
            LOG.debug("{}{}={}",
                    BasqueLocaleNameProvider.LANGUAGE_PREFIX,
                    language,
                    expected);
        }
        if (!expected.isEmpty()) {
            assertEquals(expected, result);
        }
        expected = locale.getDisplayCountry(Basque.LOCALE_ES);
        result = provider.getDisplayLanguage(language, Basque.LOCALE_ES);
        if (!expected.isEmpty()) {
            assertEquals(expected, result);
        }
        expected = locale.getDisplayCountry(Basque.LOCALE_FR);
        result = provider.getDisplayLanguage(language, Basque.LOCALE_FR);
        if (!expected.isEmpty()) {
            assertEquals(expected, result);
        }
    }

    /**
     * Test for {@link BasqueLocaleNameProvider#getDisplayCountry(String, Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_21,
            disabledReason = "JRE > 21 test")
    @ParameterizedTest
    @MethodSource("countryCodes")
    void testGetDisplayCountryLatestCldr(
            final @NotNull String country) {
        final Locale locale = new Locale("en", country);
        final String expected = locale.getDisplayCountry(Basque.LOCALE);
        final String result = provider.getDisplayCountry(country, Basque.LOCALE);
        if (!Objects.equals(expected, result)) {
            LOG.debug("{}{}={}",
                    BasqueLocaleNameProvider.COUNTRY_PREFIX,
                    country,
                    expected);
        }
        assertEquals(expected, result);
        assertEquals(
                locale.getDisplayCountry(Basque.LOCALE_ES),
                provider.getDisplayCountry(country, Basque.LOCALE_ES));
        assertEquals(
                locale.getDisplayCountry(Basque.LOCALE_FR),
                provider.getDisplayCountry(country, Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueLocaleNameProvider#getDisplayVariant(String, Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_21,
            disabledReason = "JRE > 21 test")
    @ParameterizedTest
    @MethodSource("variantLocales")
    void testGetDisplayVariantLatestCldr(
            final @NotNull Locale locale) {
        final String expected = locale.getDisplayVariant(Basque.LOCALE);
        final String result = provider.getDisplayVariant(locale.getVariant(), Basque.LOCALE);
        if (!Objects.equals(expected, result)) {
            LOG.debug("{}{}={}",
                    BasqueLocaleNameProvider.VARIANT_PREFIX,
                    locale.getVariant(),
                    expected);
        }
        assertEquals(expected, result);
        assertEquals(
                locale.getDisplayVariant(Basque.LOCALE_ES),
                provider.getDisplayVariant(locale.getVariant(), Basque.LOCALE_ES));
        assertEquals(
                locale.getDisplayVariant(Basque.LOCALE_FR),
                provider.getDisplayVariant(locale.getVariant(), Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueLocaleNameProvider#getDisplayScript(String, Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_21,
            disabledReason = "JRE > 21 test")
    @ParameterizedTest
    @MethodSource("scriptLocales")
    void testGetDisplayScriptLatestCldr(
            final @NotNull Locale locale) {
        final String expected = locale.getDisplayScript(Basque.LOCALE);
        final String result = provider.getDisplayScript(locale.getScript(), Basque.LOCALE);
        if (!Objects.equals(expected, result)) {
            LOG.debug("{}{}={}",
                    BasqueLocaleNameProvider.SCRIPT_PREFIX,
                    locale.getScript(),
                    expected);
        }
        assertEquals(expected, result);
        assertEquals(
                locale.getDisplayScript(Basque.LOCALE_ES),
                provider.getDisplayScript(locale.getScript(), Basque.LOCALE_ES));
        assertEquals(
                locale.getDisplayScript(Basque.LOCALE_FR),
                provider.getDisplayScript(locale.getScript(), Basque.LOCALE_FR));
    }

    /**
     * Source of language codes.
     * 
     * @return The language codes.
     */
    static Stream<Arguments> languageCodes() {
        final ArrayList<String> list = new ArrayList<>(Arrays.asList(Locale.getISOLanguages()));
        Collections.sort(list);
        return list.stream().map(id -> Arguments.of(id));
    }

    /**
     * Source of country codes.
     * 
     * @return The country codes.
     */
    static Stream<Arguments> countryCodes() {
        final ArrayList<String> list = new ArrayList<>(Arrays.asList(Locale.getISOCountries()));
        Collections.sort(list);
        return list.stream().map(id -> Arguments.of(id));
    }

    /**
     * Source of locales with variant codes.
     * 
     * @return The locales with variant codes.
     */
    static Stream<Arguments> variantLocales() {
        final Map<String, Locale> variants = new HashMap<>();
        Arrays.asList(Locale.getAvailableLocales()).stream()
                .filter(locale -> locale.getVariant() != null)
                .forEach(locale -> variants.put(locale.getVariant(), locale));
        final ArrayList<Locale> list = new ArrayList<>(variants.values());
        Collections.sort(list, (l1, l2) -> l1.getVariant().compareTo(l2.getVariant()));
        return list.stream().map(locale -> Arguments.of(locale));
    }

    /**
     * Source of locales with script codes.
     * 
     * @return The locales with script codes.
     */
    static Stream<Arguments> scriptLocales() {
        final Map<String, Locale> scripts = new HashMap<>();
        Arrays.asList(Locale.getAvailableLocales()).stream()
                .filter(locale -> locale.getScript() != null)
                .forEach(locale -> scripts.put(locale.getScript(), locale));
        final ArrayList<Locale> list = new ArrayList<>(scripts.values());
        Collections.sort(list, (l1, l2) -> l1.getScript().compareTo(l2.getScript()));
        return list.stream().map(locale -> Arguments.of(locale));
    }
}
