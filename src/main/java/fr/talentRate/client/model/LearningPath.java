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
 * Manage LearningPaths. A Learning path is a set of Skill trainable.
 * @author djer13
 */
@RemoteResource("/learningPaths")
public class LearningPath {

    /** Learning path ID.*/
    private Long id;

    /** Learning path name. Ex "House of Code".*/
    private String name;

    /** Training of this LearningPath.*/
    private Set<Train> trained;

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
     * @return The trained
     */
    public Set<Train> getTrained() {
        return trained;
    }

    /**
     * @param newTrained The trained to set
     */
    public void setTrained(final Set<Train> newTrained) {
        this.trained = newTrained;
    }

    /**
     * Add a trainable Skill (with an achievable threshold). You should use addSkill instead of this low level method.
     * @param train A trainable Skill;
     */
    public void addTrained(final Train train) {
        if (null == this.trained) {
            this.trained = new HashSet<>();
        }
        this.trained.add(train);
        train.setLearningPath(this);
    }

    /**
     * Add a skill to this LearningPath with an achievable threshold.
     * @param skill The skill to be learned
     * @param achievableThreshold The maximum level attainable
     */
    public void addSkill(final Skill skill, final Integer achievableThreshold) {
        Train train = new Train();
        train.setSkill(skill);
        train.setAchievableThreshold(achievableThreshold);

        addTrained(train);
    }

}
