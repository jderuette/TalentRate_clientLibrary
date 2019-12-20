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

import uk.co.blackpepper.bowman.annotation.RemoteResource;
import uk.co.blackpepper.bowman.annotation.ResourceId;

/**
 * Manage activities. Activity is a sub part of a course. Instructors create activity in their courses.
 * @author djer13
 */
@RemoteResource("/activities")
public class Activity {

    /** Activity ID.*/
    private URI id;

    /** Activity description. */
    private String description;

    /** Activity start Date and Time.*/
    private Date startDate;

    /** Activity end Date and Time.*/
    private Date endDate;

    /** Activity belong to this course.*/
    private Course course;

    /** Kind of activity. */
    private ActivityKind kind;

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
    public void setId(final URI newId) {
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
     * @param newEndDate The endDate to set
     */
    public void setEndDate(final Date newEndDate) {
        this.endDate = newEndDate;
    }

    /**
     * @return The course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * @param newCourse The course to set
     */
    public void setCourse(final Course newCourse) {
        this.course = newCourse;
    }

    /**
     * @return The kind
     */
    public ActivityKind getKind() {
        return kind;
    }

    /**
     * @param newKind The kind to set
     */
    public void setKind(final ActivityKind newKind) {
        this.kind = newKind;
    }

}
