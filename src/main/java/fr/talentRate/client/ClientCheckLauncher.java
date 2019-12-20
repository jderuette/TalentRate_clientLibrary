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
import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.talentRate.client.model.Promotion;
import fr.talentRate.client.model.Student;
import uk.co.blackpepper.bowman.Client;
import uk.co.blackpepper.bowman.ClientFactory;
import uk.co.blackpepper.bowman.Configuration;

/**
 * A class to check if client library works Well. Similar to an Integration test.
 * @author djer13
 */
public final class ClientCheckLauncher {

    /** utility Class.*/
    private ClientCheckLauncher() {

    }

    /** Logger. */
    private static final Logger LOG = LogManager.getLogger();

    /**
     * The main entry Point to launch a "test".
     * @param args program arguments
     * @throws ParseException if date is invalid
     * @throws URISyntaxException if an URI is malformed.
     */
    public static void main(final String[] args) throws ParseException, URISyntaxException {
        ClientFactory factory = Configuration.builder().setBaseUri("http://localhost:8080").build()
                .buildClientFactory();

        Client<Student> studentsApi = factory.create(Student.class);

        Client<Promotion> promotionsApi = factory.create(Promotion.class);

        System.out.println("===== Student before TESTS ====");
        for (Student stud : studentsApi.getAll()) {
            System.out.println(stud);
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("Creating a new Student");
        }

        Student studient1 = new Student();
        studient1.setName("BOB");
        studient1.setFirstName("boby");
        studient1.setBirthdate(ApiHelper.BIRTH_DAY_FORMATTER.parse("1988-5-38"));
        URI createdStudentURI = studentsApi.post(studient1);

        System.out.println("===== Student after adding ONE ====");
        for (Student stud : studentsApi.getAll()) {
            System.out.println(stud);
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("creating the a new promotion");
        }

        Promotion aTestProm = new Promotion();
        aTestProm.setName("Un test");
        URI createdPromoUri = promotionsApi.post(aTestProm);
        Promotion testPromo = promotionsApi.get(createdPromoUri);

        if (LOG.isDebugEnabled()) {
            LOG.debug("Modifying the created Student : %s", createdStudentURI);
        }
        Student stud2Modified = studentsApi.get(createdStudentURI);
        stud2Modified.setName("Jérôme");

        //        Iterator<Promotions> itPromo = stud2Modified.getPromotions().iterator();
        //        while (itPromo.hasNext()) {
        //            Promotions promo = itPromo.next();
        //            if (promo.getName().contains("Java")) {
        //                itPromo.remove();
        //            }
        //        }

        Promotion javaAvance19Promo = promotionsApi.get(new URI("http://localhost:8080/promotions/5"));

        stud2Modified.addPromotion(javaAvance19Promo);
        stud2Modified.addPromotion(testPromo);

        Student afterUpdatStudent = studentsApi.patch(stud2Modified.getId(), stud2Modified);

        System.out.println("======================= Updated Student : " + afterUpdatStudent);

        System.out.println("===== Student after updating ONE : " + afterUpdatStudent.getId() + " ("
                + ApiHelper.extractId(afterUpdatStudent.getId()) + ") ====");
        Iterable<Student> allStudents = studentsApi.getAll();
        for (Student stud : allStudents) {
            System.out.println(stud);
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("Deleting created Datas, student %s and promo %s", createdStudentURI, createdPromoUri);
        }
        //Clean Data Test
        studentsApi.delete(createdStudentURI);
        promotionsApi.delete(createdPromoUri);

    }

}
