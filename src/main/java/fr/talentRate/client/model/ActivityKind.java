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

import java.util.Set;

import uk.co.blackpepper.bowman.annotation.RemoteResource;
import uk.co.blackpepper.bowman.annotation.ResourceId;

/**
 * Manage activities Kind.
 * @author djer13
 */
@RemoteResource("/activityKind")
public class ActivityKind {

    /** Activity Id.*/
    private Long id;

    /** Activity Name. */
    private String name;

    /** All course of this Kind.*/
    private Set<Activity> activities;

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
     * @return the courses
     */
    public Set<Activity> getActivities() {
        return activities;
    }

    /**
     * @param newActivity the activities to set
     */
    public void setActivities(final Set<Activity> newActivity) {
        this.activities = newActivity;
    }
}
