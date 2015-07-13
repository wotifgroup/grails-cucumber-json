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
package com.wotifgroup.cucumber.glue

import com.wotifgroup.cucumber.rest.EndpointBindingUpdater

import static cucumber.api.groovy.Hooks.After
import static cucumber.api.groovy.Hooks.Before

def bindingUpdater

Before('@cucumberRest') {
    bindingUpdater = EndpointBindingUpdater.initialize(binding)
}

Before('@endpoint') {
    bindingUpdater = EndpointBindingUpdater.initialize(binding)
}

After('@cucumberRest') {
    if (bindingUpdater) {
        bindingUpdater.remove()
    }
}

After('@endpoint') {
    if (bindingUpdater) {
        bindingUpdater.remove()
    }
}
