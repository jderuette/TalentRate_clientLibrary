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

import uk.co.blackpepper.bowman.annotation.RemoteResource;
import uk.co.blackpepper.bowman.annotation.ResourceId;

/**
 * Manage controls. A control capture a level obtainable for a Skill.
 * @author djer13
 */
@RemoteResource("/controls")
public class Control {

    /** A Skill. */
    private Skill skill;

    /** A test.*/
    private Test test;

    /** Maximum point obtainable in this test for this skill.*/
    private Integer maximum;

    /**
     * @return The skill
     */
    @ResourceId
    public Skill getSkill() {
        return skill;
    }

    /**
     * @param newSkill The skill to set
     */
    @ResourceId
    public void setSkill(final Skill newSkill) {
        this.skill = newSkill;
    }

    /**
     * @return The test
     */
    public Test getTest() {
        return test;
    }

    /**
     * @param newTest The test to set
     */
    public void setTest(final Test newTest) {
        this.test = newTest;
    }

    /**
     * @return The maximum
     */
    public Integer getMaximum() {
        return maximum;
    }

    /**
     * @param newMaximum The maximum to set
     */
    public void setMaximum(final Integer newMaximum) {
        this.maximum = newMaximum;
    }

}
