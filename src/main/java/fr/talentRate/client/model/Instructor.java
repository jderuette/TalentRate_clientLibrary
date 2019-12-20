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
import java.util.HashSet;
import java.util.Set;

import uk.co.blackpepper.bowman.annotation.RemoteResource;
import uk.co.blackpepper.bowman.annotation.ResourceId;

/**
 * Manage instructors.
 * @author djer13
 */
@RemoteResource("/instructors")
public class Instructor {

    /** Instructor ID.*/
    private Long id;

    /** Instructor Name.*/
    private String name;

    /** Instructor first name.*/
    private String firstName;

    /** Instructor birth date.*/
    private Date birthdate;

    /** Skill this instructor can teach.*/
    private Set<Skill> instructed;

    /** Test created by this instructor. */
    private Set<Test> tests;

    /** Courses animated by this instructor.*/
    private Set<Course> courses;

    /**
     * @return the id
     */
    @ResourceId
    public Long getId() {
        return id;
    }

    /**
     * @param newId the id to set
     */
    public void setId(final Long newId) {
        this.id = newId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param newName the name to set
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param newFirstName the firstName to set
     */
    public void setFirstName(final String newFirstName) {
        this.firstName = newFirstName;
    }

    /**
     * @return the birth date
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * @param newBirthdate the birth date to set
     */
    public void setBirthdate(final Date newBirthdate) {
        this.birthdate = newBirthdate;
    }

    /**
     * @return the instructed
     */
    public Set<Skill> getInstructed() {
        return instructed;
    }

    /**
     * @param newInstructed the instructed to set
     */
    public void setInstructed(final Set<Skill> newInstructed) {
        this.instructed = newInstructed;
    }

    /**
     * Add a skill this instructor can teach.
     * @param skill the Skill
     */
    public void addInstructed(final Skill skill) {
        if (null == this.instructed) {
            this.instructed = new HashSet<>();
        }
        this.instructed.add(skill);
        skill.addInstructor(this);
    }

    /**
     * @return the tests
     */
    public Set<Test> getTests() {
        return tests;
    }

    /**
     * @param newTests the tests to set
     */
    public void setTests(final Set<Test> newTests) {
        this.tests = newTests;
    }

    /**
     * Add a Test created by this instructor.
     * @param test a New Test
     */
    public void addTest(final Test test) {
        if (null == this.tests) {
            this.tests = new HashSet<>();
        }
        this.tests.add(test);
        test.setCreator(this);
    }

    /**
     * @return the courses
     */
    public Set<Course> getCourses() {
        return courses;
    }

    /**
     * @param newCourses the courses to set
     */
    public void setCourses(final Set<Course> newCourses) {
        this.courses = newCourses;
    }

}
