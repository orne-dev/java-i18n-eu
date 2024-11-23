package dev.orne.i18n.spi.eu.it;

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

import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.Month;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("it")
class BasqueExtensionIT {

    /** The basque language ISO 639 code. */
    public static final String LANGUAGE = "eu";
    /** The basque language locale. */
    public static final Locale LOCALE = new Locale(LANGUAGE);
    /** The southern basque country locale. */
    public static final Locale LOCALE_ES = new Locale(LANGUAGE, "ES");
    /** The northern basque country locale. */
    public static final Locale LOCALE_FR = new Locale(LANGUAGE, "FR");
    /** The southern basque time zone. */
    public static final TimeZone TIME_ZONE_ES = TimeZone.getTimeZone("Europe/Madrid");
    /** The northern basque time zone. */
    public static final TimeZone TIME_ZONE_FR = TimeZone.getTimeZone("Europe/Paris");

    @Test
    void testLocale() {
        assertTrue(Arrays.asList(Locale.getAvailableLocales()).contains(LOCALE));
        assertTrue(Arrays.asList(Locale.getAvailableLocales()).contains(LOCALE_ES));
        assertTrue(Arrays.asList(Locale.getAvailableLocales()).contains(LOCALE_FR));
        assertEquals("Euskara", LOCALE.getDisplayLanguage(LOCALE));
        assertEquals("Euskara", LOCALE_ES.getDisplayLanguage(LOCALE_ES));
        assertEquals("Euskara", LOCALE_FR.getDisplayLanguage(LOCALE_FR));
        assertEquals("Espainia", LOCALE_ES.getDisplayCountry(LOCALE_ES));
        assertEquals("Frantzia", LOCALE_FR.getDisplayCountry(LOCALE_FR));
    }

    @Test
    void testCurrency() {
        final Currency euro = Currency.getInstance("EUR");
        assertEquals(euro, Currency.getInstance(LOCALE_ES));
        assertEquals(euro, Currency.getInstance(LOCALE_FR));
        assertEquals("euroa", euro.getDisplayName(LOCALE));
        assertEquals("euroa", euro.getDisplayName(LOCALE_ES));
        assertEquals("euroa", euro.getDisplayName(LOCALE_FR));
        assertEquals("€", euro.getSymbol(LOCALE));
        assertEquals("€", euro.getSymbol(LOCALE_ES));
        assertEquals("€", euro.getSymbol(LOCALE_FR));
    }

    @Test
    void testNumberFormat() {
        final NumberFormat integerFormat = NumberFormat.getIntegerInstance(LOCALE_ES);
        final NumberFormat numberFormat = NumberFormat.getNumberInstance(LOCALE_ES);
        final NumberFormat percentFormat = NumberFormat.getPercentInstance(LOCALE_ES);
        final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(LOCALE_ES);
        assertEquals("1.000.000", integerFormat.format(1000000));
        assertEquals("−1.000.000", integerFormat.format(-1000000));
        assertEquals("1.000.000,123", numberFormat.format(1000000.123));
        assertEquals("−1.000.000,123", numberFormat.format(-1000000.123));
        assertEquals("%\u00A020", percentFormat.format(0.20));
        assertEquals("−%\u00A020", percentFormat.format(-0.20));
        assertEquals("1.000.000,30\u00A0€", currencyFormat.format(1000000.30));
        assertEquals("−1.000.000,30\u00A0€", currencyFormat.format(-1000000.30));
    }

    @Test
    void testUtilDateFormat() {
        final Calendar calendar = Calendar.getInstance(LOCALE_ES);
        calendar.set(Calendar.YEAR, 2024);
        calendar.set(Calendar.MONTH, Calendar.NOVEMBER);
        calendar.set(Calendar.DAY_OF_MONTH, 10);
        calendar.set(Calendar.HOUR_OF_DAY, 16);
        calendar.set(Calendar.MINUTE, 50);
        calendar.set(Calendar.SECOND, 36);
        calendar.set(Calendar.MILLISECOND, 427);
        calendar.setTimeZone(TIME_ZONE_ES);
        final Date date = calendar.getTime();
        assertEquals(
                "2024(e)ko azaroaren 10(a), igandea",
                DateFormat.getDateInstance(DateFormat.FULL, LOCALE_ES).format(date));
        assertEquals(
                "2024(e)ko azaroaren 10(a)",
                DateFormat.getDateInstance(DateFormat.LONG, LOCALE_ES).format(date));
        assertEquals(
                "2024(e)ko aza. 10(a)",
                DateFormat.getDateInstance(DateFormat.MEDIUM, LOCALE_ES).format(date));
        assertEquals(
                "24/11/10",
                DateFormat.getDateInstance(DateFormat.SHORT, LOCALE_ES).format(date));
        assertEquals(
                "16:50:36 (Europako erdialdeko ordu estandarra)",
                DateFormat.getTimeInstance(DateFormat.FULL, LOCALE_ES).format(date));
        assertEquals(
                "16:50:36 (CET)",
                DateFormat.getTimeInstance(DateFormat.LONG, LOCALE_ES).format(date));
        assertEquals(
                "16:50:36",
                DateFormat.getTimeInstance(DateFormat.MEDIUM, LOCALE_ES).format(date));
        assertEquals(
                "16:50",
                DateFormat.getTimeInstance(DateFormat.SHORT, LOCALE_ES).format(date));
        assertEquals(
                "2024(e)ko azaroaren 10(a), igandea (16:50:36 (Europako erdialdeko ordu estandarra))",
                DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, LOCALE_ES).format(date));
        assertEquals(
                "2024(e)ko azaroaren 10(a) (16:50:36 (CET))",
                DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, LOCALE_ES).format(date));
        assertEquals(
                "2024(e)ko aza. 10(a) (16:50:36)",
                DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, LOCALE_ES).format(date));
        assertEquals(
                "24/11/10 (16:50)",
                DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, LOCALE_ES).format(date));
    }

    @Test
    void testTimeDateFormat() {
        final ZonedDateTime date = ZonedDateTime.of(
                2024, Month.NOVEMBER.getValue(), 10,
                16, 50, 36, 4273,
                TIME_ZONE_ES.toZoneId());
        assertEquals(
                "igandea, azaroa 10, 2024",
                DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(LOCALE_ES).format(date));
        assertEquals(
                "azaroa 10, 2024",
                DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(LOCALE_ES).format(date));
        assertEquals(
                "aza. 10, 2024",
                DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(LOCALE_ES).format(date));
        assertEquals(
                "11/10/24",
                DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(LOCALE_ES).format(date));
        assertEquals(
                "4:50:36 PM CET",
                DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL).withLocale(LOCALE_ES).format(date));
        assertEquals(
                "4:50:36 PM CET",
                DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG).withLocale(LOCALE_ES).format(date));
        assertEquals(
                "4:50:36 PM",
                DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).withLocale(LOCALE_ES).format(date));
        assertEquals(
                "4:50 PM",
                DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(LOCALE_ES).format(date));
        assertEquals(
                "igandea, azaroa 10, 2024 4:50:36 PM CET",
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(LOCALE_ES).format(date));
        assertEquals(
                "azaroa 10, 2024 4:50:36 PM CET",
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(LOCALE_ES).format(date));
        assertEquals(
                "aza. 10, 2024 4:50:36 PM",
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(LOCALE_ES).format(date));
        assertEquals(
                "11/10/24 4:50 PM",
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(LOCALE_ES).format(date));
    }

    @Test
    void testTimeDatePatternFormat() {
        final ZonedDateTime date = ZonedDateTime.of(
                2024, Month.NOVEMBER.getValue(), 10,
                16, 50, 36, 4273,
                TIME_ZONE_ES.toZoneId());
        assertEquals(
                "2024(e)ko azaroaren 10(a), igandea",
                DateTimeFormatter.ofPattern("yyyy'(e)ko' LLLL'ren' dd'(a)', EEEE", LOCALE_ES).format(date));
        assertEquals(
                "2024(e)ko azaroaren 10(a)",
                DateTimeFormatter.ofPattern("yyyy'(e)ko' LLLL'ren' dd'(a)'", LOCALE_ES).format(date));
        assertEquals(
                "2024(e)ko aza. 10(a)",
                DateTimeFormatter.ofPattern("yyyy'(e)ko' LLL dd'(a)'", LOCALE_ES).format(date));
        assertEquals(
                "24/11/10",
                DateTimeFormatter.ofPattern("yy/MM/dd", LOCALE_ES).format(date));
        assertEquals(
                "16:50:36 (Europako erdialdeko ordu estandarra)",
                DateTimeFormatter.ofPattern("HH:mm:ss '('zzzz')'", LOCALE_ES).format(date));
        assertEquals(
                "16:50:36 (CET)",
                DateTimeFormatter.ofPattern("HH:mm:ss '('zzz')'", LOCALE_ES).format(date));
        assertEquals(
                "16:50:36",
                DateTimeFormatter.ofPattern("HH:mm:ss", LOCALE_ES).format(date));
        assertEquals(
                "16:50",
                DateTimeFormatter.ofPattern("HH:mm", LOCALE_ES).format(date));
        assertEquals(
                "2024(e)ko azaroaren 10(a), igandea 16:50:36 (Europako erdialdeko ordu estandarra)",
                DateTimeFormatter.ofPattern("yyyy'(e)ko' LLLL'ren' dd'(a)', EEEE HH:mm:ss '('zzzz')'", LOCALE_ES).format(date));
        assertEquals(
                "2024(e)ko azaroaren 10(a) 16:50:36 (CET)",
                DateTimeFormatter.ofPattern("yyyy'(e)ko' LLLL'ren' dd'(a)' HH:mm:ss '('zzz')'", LOCALE_ES).format(date));
        assertEquals(
                "2024(e)ko aza. 10(a) 16:50:36",
                DateTimeFormatter.ofPattern("yyyy'(e)ko' LLL dd'(a)' HH:mm:ss", LOCALE_ES).format(date));
        assertEquals(
                "24/11/10 16:50",
                DateTimeFormatter.ofPattern("yy/MM/dd HH:mm", LOCALE_ES).format(date));
    }
}
