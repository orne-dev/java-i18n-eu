# Locale-Sensitive Services SPI Basque (Euskera) language extension - Changelog

## 1.0.1 - 2025-06-14

### Fixed

- Fix Temurin JRE 23 basque language support differences.
    - Add support for XCG currency.

## 1.0.0 - 2024-11-24

### Added

- Add full basque language support.
    - Add class `dev.orne.i18n.spi.eu.Basque`.
    - Add class `dev.orne.i18n.spi.eu.BasqueBreakIteratorProvider`.
    - Add class `dev.orne.i18n.spi.eu.BasqueCalendarDataProvider`.
    - Add class `dev.orne.i18n.spi.eu.BasqueCalendarNameProvider`.
    - Add class `dev.orne.i18n.spi.eu.BasqueCollatorProvider`.
    - Add class `dev.orne.i18n.spi.eu.BasqueCurrencyNameProvider`.
    - Add class `dev.orne.i18n.spi.eu.BasqueDateFormatProvider`.
    - Add class `dev.orne.i18n.spi.eu.BasqueDateFormatSymbolsProvider`.
    - Add class `dev.orne.i18n.spi.eu.BasqueDecimalFormatSymbolsProvider`.
    - Add class `dev.orne.i18n.spi.eu.BasqueLocaleNameProvider`.
    - Add class `dev.orne.i18n.spi.eu.BasqueLocaleServiceProvider`.
    - Add class `dev.orne.i18n.spi.eu.BasqueNumberFormatProvider`.
    - Add class `dev.orne.i18n.spi.eu.BasqueTimeZoneNameProvider`.
- Mimic behavior of Temurin JRE 23 basque language support.
