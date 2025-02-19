/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.kafka.coordinator.group.runtime;

import java.util.List;
import java.util.Objects;

/**
 * The result of an operation applied to a state machine. The result
 * contains a list of records and a response.
 *
 * @param <T> The type of the response.
 * @param <U> The type of the record.
 */
public class CoordinatorResult<T, U> {
    /**
     * The records.
     */
    private final List<U> records;

    /**
     * The response.
     */
    private final T response;

    /**
     * Constructs a Result with records and a response.
     *
     * @param records   A non-null list of records.
     * @param response  A response or null.
     */
    public CoordinatorResult(
        List<U> records,
        T response
    ) {
        this.records = Objects.requireNonNull(records);
        this.response = response;
    }

    /**
     * @return The list of records.
     */
    public List<U> records() {
        return records;
    }

    /**
     * @return The response.
     */
    public T response() {
        return response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoordinatorResult<?, ?> result = (CoordinatorResult<?, ?>) o;

        if (!records.equals(result.records)) return false;
        return response.equals(result.response);
    }

    @Override
    public int hashCode() {
        int result = records.hashCode();
        result = 31 * result + response.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Result(records=" + records +
            ", response=" + response +
            ")";
    }
}
