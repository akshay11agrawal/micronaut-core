/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.kotlin.processing.visitor.order;

import io.micronaut.inject.ast.ClassElement;
import io.micronaut.inject.visitor.TypeElementVisitor;
import io.micronaut.inject.visitor.VisitorContext;

import java.util.ArrayList;
import java.util.List;

public class MyVisitor1 implements TypeElementVisitor<VisitMyAnnotation, Object> {

    static List<String> ORDER = new ArrayList<>();

    @Override
    public void start(VisitorContext visitorContext) {
        ORDER.clear();
    }

    @Override
    public void visitClass(ClassElement element, VisitorContext context) {
        ORDER.add(getClass().getSimpleName() + " " + element.getName());
    }

    @Override
    public int getOrder() {
        return 1;
    }
}