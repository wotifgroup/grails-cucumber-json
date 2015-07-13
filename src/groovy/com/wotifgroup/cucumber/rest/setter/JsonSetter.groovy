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
package com.wotifgroup.cucumber.rest.setter

import com.wotifgroup.cucumber.rest.ExpressionUtil
import net.sf.json.JSONArray

import static com.wotifgroup.cucumber.rest.ExpressionUtil.parseStringToType

/**
 * User: gcurrey
 * Date: 8/08/13
 * Time: 2:16 PM
 */
class JsonSetter extends Setter{
    public void set(def parent, def child, String value, def settings = [:]) {
        parent."$child" = parseStringToType(value, settings.dateFormat)
    }

    public void clear(def parent, def child, def value = null, def settings = [:]) {
        parent."$child" = ""
    }

    public void remove(def parent, def child, def value = null, def settings = [:]) {
        parent.remove(child)
    }

    public void nullify(def parent, def child, def value = null, def settings = [:]) {
        parent."$child" = null
    }

    public void add(def parent, def child, String value, def settings = [:]) {
        if (parent."$child" == null) {
            parent."$child" = new JSONArray()
        }

        if (parent."$child" instanceof List) {
            parent."$child".add(parseStringToType(value))
        }
    }
}
