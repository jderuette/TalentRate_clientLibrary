/*
Copyright [2019] [Jérémie "Djer13" DERUETTE]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package fr.talentRate.client;

import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.hateoas.mediatype.PropertyUtils;

/**
 * @author djer13
 */
public final class ApiHelper {
    /** Default date formatter for Birth Day.*/
    public static final DateFormat BIRTH_DAY_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

    /** Default date formatter for Day and Hours.*/
    public static final DateFormat DAY_AND_HOUR_FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    /** Logger.*/
    private static final Logger LOG = LogManager.getLogger();

    /** Utility Class.*/
    private ApiHelper() {

    }

    /**
     * Thanks to Sean Patrick Floyd.
     * More : https://stackoverflow.com/questions/4050087/how-to-obtain-the-last-path-segment-of-an-uri.
     * @param url Url to use to extract Id
     * @return The last Path segment of the URL.
     */
    private static String getLastBitFromUrl(final String url) {
        // return url.replaceFirst("[^?]*/(.*?)(?:\\?.*)","$1);" <-- incorrect
        return url.replaceFirst(".*/([^/?]+).*", "$1");
    }

    /**
     * Extract an object Id from an (api) URI.
     * @param uri the URI to search for ID.
     * @return An ID (Long) if possible, else null.
     */
    public static Long extractId(final URI uri) {
        Long internalId = null;
        if (null != uri) {
            String lastChar = getLastBitFromUrl(uri.getPath());
            try {
                internalId = Long.valueOf(lastChar);
            } catch (NumberFormatException nfe) {
                LOG.warn("Not possible to extract the ID from URI %s, tne last part is not a Number", uri, nfe);
                internalId = null;
            }
        }

        return internalId;
    }

    /**
     * Thanks to https://stackoverflow.com/questions/35863581/how-to-filter-null-values-from-hashmapstring-string.
     * @param anObject Object to analyze to extract non null properties
     * @return A Map containing only properties with <b>NOT NULL</b> value
     */
    public static Map<String, Object> extractModifications(final Object anObject) {
        Map<String, Object> modifiedData = PropertyUtils.extractPropertyValues(anObject);
        modifiedData.values().removeIf(Objects::isNull);

        return modifiedData;
    }

}
