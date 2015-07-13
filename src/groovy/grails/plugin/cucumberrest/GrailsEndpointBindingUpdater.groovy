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
package grails.plugin.cucumberrest

import com.wotifgroup.cucumber.rest.EndpointBindingUpdater

/**
 * User: gcurrey
 * Date: 18/06/12
 * Time: 3:36 PM
 */
class GrailsEndpointBindingUpdater extends EndpointBindingUpdater {

    static final CONFIG_NAME = "Config.groovy"
    static final CONFIG_PATH = ["grails-app", "conf", CONFIG_NAME].join(File.separator)

    GrailsEndpointBindingUpdater(Binding binding) {
        super(binding)
    }

    void initialize() {
        super.initialize()

        def configObject = new ConfigSlurper("TEST").parse(new File(CONFIG_PATH).toURL())
        def urlBase = configObject.grails.serverURL ?: System.getProperty("grails.testing.functional.baseUrl")

        setBaseUrl(urlBase)
        setResourceLoaderBaseDir("test/cucumber/json")
    }

    public static def isGrailsApplication(){
        try{
            Class.forName("grails.util.Environment")
            return new File(CONFIG_PATH).exists()
        } catch (Exception e){
            false
        }
    }
}
