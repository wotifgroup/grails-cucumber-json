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

import static com.wotifgroup.cucumber.rest.ExpressionUtil.parseStringToType

/**
 * User: gcurrey
 * Date: 8/08/13
 * Time: 2:16 PM
 */
class XmlSetter extends Setter {
    @Override
    void set(parent, child, String value, def settings = [:]) {
        parent."${child}" = parseStringToType(value, settings.dateFormat)
    }

    @Override
    void clear(parent, child, value, def settings = [:]) {
        parent."${child}" = null;
    }

    @Override
    void remove(parent, child, value, def settings = [:]) {
        parent."${child}".replaceNode {}
    }

    @Override
    void nullify(parent, child, value, def settings = [:]) {
        parent."${child}" = null;
    }

    @Override
    void add(parent, child, String value, def settings = [:]) {
        parent.appendNode {
            "${child}"(parseStringToType(value, settings.dateFormat))
        }
    }
}
