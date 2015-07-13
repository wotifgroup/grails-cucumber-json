/*
 * #%L
 * grails-cucumber-json
 * %%
 * Copyright (C) 2013 - 2015 Wotif Group
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.wotifgroup.cucumber.rest

import groovy.json.JsonSlurper
import groovyx.net.http.ContentType

/**
 * User: gcurrey
 * Date: 18/06/12
 * Time: 5:05 PM
 */
class ResourceLoader extends Closure {
    private String resourceDirectory = "src/test/resources"

    private CucumberRest cucumberRest

    ResourceLoader(Object theTarget, CucumberRest cucumberRest) {
        super(theTarget)
        this.cucumberRest = cucumberRest
    }

    protected doCall(Object[] args) {
        def slurper;
        ContentType type = args[1]
        if (type == ContentType.XML) {
            slurper = new XmlSlurper()
        } else {
            slurper = new JsonSlurper()
        }
        cucumberRest.loadRequest("${resourceDirectory}/${type.name().toLowerCase()}", args[0] as String, slurper, type);
    }

    public void setResourceDirectory(String resourceDirectory) {
        this.resourceDirectory = resourceDirectory
    }
}
