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

import java.util.Date;

import uk.co.blackpepper.bowman.annotation.RemoteResource;
import uk.co.blackpepper.bowman.annotation.ResourceId;

/**
 * Manage Course. a Course is a pariod of time, assigned to an instructor for a promotion.
 * @author djer13
 */
@RemoteResource("/courses")
public class Course {

    /** Course ID.*/
    private Long id;

    /** Course description. */
    private String description;

    /** Course start Date and Time.*/
    private Date startDate;

    /** Course end Date and Time.*/
    private Date endDate;

    /** Instructor for this course.*/
    private Instructor instructor;
    /** Promotion following this course. */

    private Promotion promotion;

    /**
     * @return The id
     */
    @ResourceId
    public Long getId() {
        return id;
    }

    /**
     * @param newId The id to set
     */
    public void setId(final Long newId) {
        this.id = newId;
    }

    /**
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param newDescription The description to set
     */
    public void setDescription(final String newDescription) {
        this.description = newDescription;
    }

    /**
     * @return The startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param newStartDate The startDate to set
     */
    public void setStartDate(final Date newStartDate) {
        this.startDate = newStartDate;
    }

    /**
     * @return The endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param newEndDate Rhe endDate to set
     */
    public void setEndDate(final Date newEndDate) {
        this.endDate = newEndDate;
    }

    /**
     * @return Rhe instructor
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * @param newInstructor Rhe instructor to set
     */
    public void setInstructor(final Instructor newInstructor) {
        this.instructor = newInstructor;
    }

    /**
     * @return Rhe promotion
     */
    public Promotion getPromotion() {
        return promotion;
    }

    /**
     * @param newPromotion Rhe promotion to set
     */
    public void setPromotion(final Promotion newPromotion) {
        this.promotion = newPromotion;
    }

}
