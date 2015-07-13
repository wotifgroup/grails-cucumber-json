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

import cucumber.runtime.io.FileResourceLoader

/**
 * User: gcurrey
 * Date: 8/01/13
 * Time: 12:38 PM
 */
class FileUtil {
    static def loadFileResource(String name, String directory) {
        FileResourceLoader resourceLoader = new FileResourceLoader();

        def resources = resourceLoader.resources(directory, name);
        def resourcesIterator = resources.iterator()

        if (resourcesIterator.hasNext()) {
            return resourcesIterator.next().getInputStream().text;
        } else {
            throw new RuntimeException("Unable to load file resource $directory/$name")
        }
    }
}
