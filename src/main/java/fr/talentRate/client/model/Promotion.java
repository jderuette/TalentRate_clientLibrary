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

import uk.co.blackpepper.bowman.annotation.RemoteResource;
import uk.co.blackpepper.bowman.annotation.ResourceId;

/**
 * Manage promotions.
 *
 * @author djer13
 */
@RemoteResource("/promotions")
public class Promotion {

    /** Promotion id.*/
    private URI id;

    /** Class Name. Ex : "House of Code 2019".*/
    private String name;

    /**
     * @return the id
     */
    @ResourceId
    public URI getId() {
        return id;
    }

    /**
     * @param newId the id to set
     */
    public void setId(final URI newId) {
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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final int bufferInitialSize = 50;
        StringBuilder builder = new StringBuilder(bufferInitialSize);
        builder.append("Promotions [id=").append(getId()).append(", name=").append(getName()).append(']');
        return builder.toString();
    }

}
