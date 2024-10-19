package dev.orne.i18n.spi.eu;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeZoneDataExtractor {

    private static final Logger LOG = LoggerFactory.getLogger(TimeZoneDataExtractor.class);

    private static final DateTimeFormatter TO_SHORT = DateTimeFormatter.ofPattern(
            "z",
            new Locale("es"));
    private static final DateTimeFormatter TO_LONG = DateTimeFormatter.ofPattern(
            "zzzz",
            new Locale("es"));

    public static void main(String... args) {
        ArrayList<String> zoneIds = new ArrayList<>(ZoneId.getAvailableZoneIds());
        Collections.sort(zoneIds);
        HashMap<String, String> names = new HashMap<>();
        for (String zoneId : zoneIds) {
            final ZonedDateTime time = BasqueTimeZoneNameProvider.getReferenceTime(zoneId, false);
            final ZonedDateTime dstTime = BasqueTimeZoneNameProvider.getReferenceTime(zoneId, true);
            final String shortId = time.format(TO_SHORT);
            final String dstShortId = dstTime.format(TO_SHORT);
            final String name = time.format(TO_LONG);
            final String dstName = dstTime.format(TO_LONG);
            LOG.debug("{} NO DST: {} ({})", zoneId, shortId, name);
            LOG.debug("{}    DST: {} ({})", zoneId, dstShortId, dstName);
            if (!shortId.equals(name)) {
                if (names.containsKey(shortId)) {
                    if (!name.equals(names.get(shortId))) {
                        final String key = BasqueTimeZoneNameProvider.getRegionProperty(zoneId, false);
                        final String oldName = names.put(key, name);
                        if (oldName != null && !oldName.equals(name)) {
                            LOG.warn("WARN: {} changed from '{}' to '{}'", key, oldName, name);
                        }
                    }
                } else {
                    names.put(shortId, name);
                }
            }
            if (!dstShortId.equals(dstName)) {
                if (names.containsKey(dstShortId)) {
                    if (!dstName.equals(names.get(dstShortId))) {
                        final String key = BasqueTimeZoneNameProvider.getRegionProperty(zoneId, true);
                        final String oldDstName = names.put(key, dstName);
                        if (oldDstName != null && !oldDstName.equals(dstName)) {
                            LOG.warn("WARN: {} changed from '{}' to '{}'", key, oldDstName, dstName);
                        }
                    }
                } else {
                    names.put(dstShortId, dstName);
                }
            }
        }
        ArrayList<String> ids = new ArrayList<>(names.keySet());
        Collections.sort(ids);
        LOG.info("### Short ZoneIds data ###");
        for (String id : ids) {
            LOG.info("{}={}", id, names.get(id));
        }
    }
}
