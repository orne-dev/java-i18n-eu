# Locale-Sensitive Services SPI Basque (Euskera) language extension

Provides basque language support for Java [Locale-Sensitive Services SPI][java i18n spi].

Note that Java supports basque language since JRE 11.
This extension provides same resources as JRE 21 for applications that cannot
upgrade from Java 8.

For an up-to-date internalization support consider using [ICU4J][icu4j],
which provides basque language support out-of-the-box.

## Status

[![License][status.license.badge]][status.license]
[![Latest version][status.maven.badge]][status.maven]
[![Javadoc][status.javadoc.badge]][javadoc]
[![Maven site][status.site.badge]][site]

| Latest Release | Develop |
| :------------: | :-------------: |
| [![Build Status][status.latest.ci.badge]][status.latest.ci] | [![Build Status][status.dev.ci.badge]][status.dev.ci] |
| [![Coverage][status.latest.cov.badge]][status.latest.cov] | [![Coverage][status.dev.cov.badge]][status.dev.cov] |

## Features

The library provides the following features (unchecked features are planned and
unimplemented):

- [X] LocaleServiceProvider
- [X] LocaleNameProvider
- [X] CalendarNameProvider
- [X] CalendarDataProvider
- [X] CurrencyNameProvider
- [X] TimeZoneNameProvider
- [X] BreakIteratorProvider
- [X] CollatorProvider
- [X] DateFormatProvider
- [X] DateFormatSymbolsProvider
- [X] DecimalFormatSymbolsProvider
- [X] NumberFormatProvider

## Usage

The binaries can be obtained from [Maven Central][status.maven] with the
`dev.orne:basque-locale-extension` coordinates:

```xml
<dependency>
  <groupId>dev.orne</groupId>
  <artifactId>basque-locale-extension</artifactId>
  <version>1.0.0</version>
</dependency>
```

Java requires the language extensions to be included in the JRE's
`lib/etx/` directory.

## Further information

For further information refer to the [Maven Site][site] and [Javadoc][javadoc].

[site]: https://orne-dev.github.io/java-i18n-eu/
[javadoc]: https://javadoc.io/doc/dev.orne/basque-locale-extension
[status.license]: http://www.gnu.org/licenses/gpl-3.0.txt
[status.license.badge]: https://img.shields.io/github/license/orne-dev/java-i18n-eu
[status.maven]: https://search.maven.org/artifact/dev.orne/basque-locale-extension
[status.maven.badge]: https://img.shields.io/maven-central/v/dev.orne/basque-locale-extension.svg?label=Maven%20Central
[status.javadoc.badge]: https://javadoc.io/badge2/dev.orne/basque-locale-extension/javadoc.svg
[status.site.badge]: https://img.shields.io/website?url=https%3A%2F%2Forne-dev.github.io%2Fjava-i18n-eu%2F
[status.latest.ci]: https://github.com/orne-dev/java-i18n-eu/actions/workflows/release.yml
[status.latest.ci.badge]: https://github.com/orne-dev/java-i18n-eu/actions/workflows/release.yml/badge.svg?branch=master
[status.latest.cov]: https://sonarcloud.io/dashboard?id=orne-dev_java-i18n-eu
[status.latest.cov.badge]: https://sonarcloud.io/api/project_badges/measure?project=orne-dev_java-i18n-eu&metric=coverage
[status.dev.ci]: https://github.com/orne-dev/java-i18n-eu/actions/workflows/build.yml
[status.dev.ci.badge]: https://github.com/orne-dev/java-i18n-eu/actions/workflows/build.yml/badge.svg?branch=develop
[status.dev.cov]: https://sonarcloud.io/dashboard?id=orne-dev_java-i18n-eu&branch=develop
[status.dev.cov.badge]: https://sonarcloud.io/api/project_badges/measure?project=orne-dev_java-i18n-eu&metric=coverage&branch=develop
[java i18n spi]: https://docs.oracle.com/javase/tutorial/i18n/locale/services.html
[kirolak eu]: https://code.google.com/archive/p/java-basque-locale/
[icu4j]: https://unicode-org.github.io/icu/userguide/icu4j/
