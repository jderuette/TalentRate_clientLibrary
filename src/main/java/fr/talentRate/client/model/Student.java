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
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;
import uk.co.blackpepper.bowman.annotation.ResourceId;

/**
 * Manage Students.
 * @author djer13
 */
@RemoteResource("/students")
public class Student {

    /** Student Id.*/
    private URI id;

    /**Student Name.*/
    private String name;

    /** Student first name.*/
    private String firstName;

    /** Student birth date.*/
    private Date birthdate;

    /** Promotions this student Belong to.*/
    private Set<Promotion> promotions;

    /**
     * @return The id
     */
    @ResourceId
    public URI getId() {
        return id;
    }

    /**
     * @param newId The id to set
     */
    public void setid(final URI newId) {
        this.id = newId;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param newName The name to set
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * @return The firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param newFirstName The firstName to set
     */
    public void setFirstName(final String newFirstName) {
        this.firstName = newFirstName;
    }

    /**
     * @return The birth date
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * @param newBirthdate The birth date to set
     */
    public void setBirthdate(final Date newBirthdate) {
        this.birthdate = newBirthdate;
    }

    /**
     * @return The promotions
     */
    @LinkedResource
    public Set<Promotion> getPromotions() {
        return promotions;
    }

    /**
     * Add a promotion to the current Student.
     * @param newPromitions The new promotion to add.
     */
    public void addPromotion(final Promotion newPromitions) {
        if (null == this.promotions) {
            this.promotions = new HashSet<>();
        }
        getPromotions().add(newPromitions);

    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final int intialBufferSize = 100;
        StringBuilder builder = new StringBuilder(intialBufferSize);
        builder.append("Students [apiId=").append(getId()).append(", name=").append(getName()).append(", firstName=")
                .append(getFirstName()).append(", birthdate=").append(getBirthdate()).append(", promotions=")
                .append(getPromotions()).append(']');
        return builder.toString();
    }

}
