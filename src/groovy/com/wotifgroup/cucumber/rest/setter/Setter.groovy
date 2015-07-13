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
import groovyx.net.http.ContentType
import net.sf.json.JSONArray

/**
 * User: gcurrey
 * Date: 8/08/13
 * Time: 2:17 PM
 */
abstract class Setter {

    public static final XmlSetter XML_SETTER = new XmlSetter();
    public static final JsonSetter JSON_SETTER = new JsonSetter();

    public static Setter getSetter(def type) {
        if (type == ContentType.XML) {
            return XML_SETTER
        } else {
            return JSON_SETTER
        }
    }

    public abstract void set(def parent, def child, String value, def settings);

    public abstract void clear(def parent, def child, def value, def settings);

    public abstract void remove(def parent, def child, def value, def settings);

    public abstract void nullify(def parent, def child, def value, def settings);

    public abstract void add(def parent, def child, String value, def settings);
}
