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

import java.util.HashSet;
import java.util.Set;

import uk.co.blackpepper.bowman.annotation.RemoteResource;
import uk.co.blackpepper.bowman.annotation.ResourceId;

/**
 * Manage Tests. A test is a list of CheckPoint (Control).
 * @author djer13
 */
@RemoteResource("/tests")
public class Test {

    /** Test Id.*/
    private Long id;

    /** test Name. */
    private String name;

    /** Instructor who plan this Test.*/
    private Instructor creator;

    /** All skill checked by this test.*/
    private Set<Control> controls;

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
     * @return the creator
     */
    public Instructor getCreator() {
        return creator;
    }

    /**
     * @param newCreator the creator to set
     */
    public void setCreator(final Instructor newCreator) {
        this.creator = newCreator;
    }

    /**
     * @return the controls
     */
    public Set<Control> getControls() {
        return controls;
    }

    /**
     * @param newControls the controls to set
     */
    public void setControls(final Set<Control> newControls) {
        this.controls = newControls;
    }

    /**
     * A Skill checked in this Test.
     * @param control the control point
     */
    public void addControl(final Control control) {
        if (null == this.controls) {
            this.controls = new HashSet<>();
        }
        this.controls.add(control);
        control.setTest(this);
    }
}
