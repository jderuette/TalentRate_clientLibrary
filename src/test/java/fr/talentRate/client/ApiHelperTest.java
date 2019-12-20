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
import java.net.URISyntaxException;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import fr.talentRate.client.model.Student;

/**
 * Check API Helper.
 * @author djer13
 *
 */
public class ApiHelperTest {

    /**
     * Classic URL with ObjectType and a ID.
     * @throws URISyntaxException When URL to test is malformed
     */
    @Test
    public void testExtractId() throws URISyntaxException {
        final Long objectId = 22L;
        String url = "http://www.mySite.fr/segment1/" + objectId;
        URI uri = new URI(url);

        Long id = ApiHelper.extractId(uri);

        Assert.assertEquals("Bad Id extracted for URL", id, objectId);
    }

    /**
     * Classic URL with ObjectType and a ID but the ID is a String.
     * @throws URISyntaxException When URL to test is malformed
     */
    @Test
    public void testExtractIdNotANumber() throws URISyntaxException {
        final String objectId = "Bob";
        String url = "http://www.mySite.fr/segment1/" + objectId;
        URI uri = new URI(url);

        Long id = ApiHelper.extractId(uri);

        Assert.assertNull("Not number ID should not be extracted", id);
    }

    /**
     * Invalid URL.
     * @throws URISyntaxException When URL to test is malformed
     */
    @Test
    public void testExtractIdnvalidURI() throws URISyntaxException {
        final String objectId = "Oops";
        String url = "not_a_url___" + objectId;
        URI uri = new URI(url);

        Long id = ApiHelper.extractId(uri);

        Assert.assertNull("Not number ID should not be extracted", id);
    }

    /**
     * Simple Object, with null and non null properties.
     * @throws URISyntaxException When URL to test is malformed
     */
    @Test
    public void testExtractModifications() throws URISyntaxException {
        Student aStudent = new Student();

        aStudent.setid(new URI("/students/25"));
        aStudent.setName("A new Name");

        Map<String, Object> extractedDatas = ApiHelper.extractModifications(aStudent);

        Assert.assertNotNull("Some properties are Not null", extractedDatas);
        Assert.assertEquals("Bad Number of non Null properties detected", 2, extractedDatas.size());
    }

    /**
     * Simple Object, with null and non null properties.
     * @throws URISyntaxException When URL to test is malformed
     */
    @Test
    public void testExtractModificationsOnlyNullProperties() throws URISyntaxException {
        Student aStudent = new Student();

        Map<String, Object> extractedDatas = ApiHelper.extractModifications(aStudent);

        Assert.assertNotNull("Even with no properties should not be NULL", extractedDatas);
        Assert.assertEquals("Bad Number of non Null properties detected", 0, extractedDatas.size());
    }

}
