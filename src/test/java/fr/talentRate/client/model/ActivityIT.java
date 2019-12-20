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
package fr.talentRate.client.model;

import java.net.URI;
import java.text.ParseException;

import org.junit.Assert;
import org.junit.BeforeClass;

import fr.talentRate.client.ApiHelper;
import uk.co.blackpepper.bowman.Client;
import uk.co.blackpepper.bowman.ClientFactory;
import uk.co.blackpepper.bowman.Configuration;

/**
 * Integration test for activities.
 * @author djer13
 */
public class ActivityIT {

    /** The live Rest API server to send requests.*/
    private static final String HOST = "http://localhost:8080";

    /** activity APi entry Point.*/
    private static Client<Activity> activityApi;

    /** Initialize a Factory and the API entryPoint.*/
    @BeforeClass
    public static void beforeClass() {
        ClientFactory factory = Configuration.builder().setBaseUri(HOST).build().buildClientFactory();
        activityApi = factory.create(Activity.class);
    }

    /** Create a new **minimal** Activity.
     * @throws ParseException When Start/End of activity is malformed
     * */
    @org.junit.Test
    public void testCreate() throws ParseException {
        Activity anActivty = new Activity();
        anActivty.setDescription("An activity Test");
        anActivty.setStartDate(ApiHelper.DAY_AND_HOUR_FORMATTER.parse("2019-14-12T09:00:00"));
        anActivty.setEndDate(ApiHelper.DAY_AND_HOUR_FORMATTER.parse("2019-14-12T12:00:00"));

        URI newActivityURI = activityApi.post(anActivty);

        String expectedURIPatern = HOST + "/activities/[0-9]*";
        boolean isValid = newActivityURI.toString().matches(expectedURIPatern);
        Assert.assertNotNull("No URI sent by Server", newActivityURI);
        Assert.assertTrue("URI value : " + newActivityURI + " does not match " + expectedURIPatern, isValid);
    }

}
