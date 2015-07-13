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

import groovyx.net.http.ContentType


/**
 * User: gcurrey
 * Date: 19/06/12
 * Time: 11:29 AM
 */
class DoAction extends Closure {
    def urlBase = System.getProperty("testing.functional.baseUrl")
    private CucumberRest cucumberRest
    private String action

    DoAction(String action, Object theTarget, CucumberRest cucumberRest) {
        super(theTarget)
        this.cucumberRest = cucumberRest
        this.action = action
    }

    protected doCall(Object[] args) {
        if (!urlBase) {
            throw new Exception("Unable to determine the base url to post to.  Currently urlBase is [${urlBase}].  Either set this on JsonAction or set -Dtesting.functional.baseUrl")
        } else {
            if(args.length == 2){
                cucumberRest.setRequestPayloadType(args[1] as ContentType)
            }
            cucumberRest.doRequest(action, urlBase, args[0])
        }
    }

    public void setUrlBase(String urlBase){
        this.urlBase = urlBase
    }
}
