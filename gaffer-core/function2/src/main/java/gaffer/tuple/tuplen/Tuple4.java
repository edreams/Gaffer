/*
 * Copyright 2016 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package gaffer.tuple.tuplen;

import gaffer.tuple.ArrayTuple;

/**
 * A {@link gaffer.tuple.Tuple} with four values of the specified generic types.
 * @param <A> Type of first tuple value.
 * @param <B> Type of second tuple value.
 * @param <C> Type of third tuple value.
 * @param <D> Type of fourth tuple value.
 */
public abstract class Tuple4<A, B, C, D> extends Tuple3<A, B, C> {
    /**
     * Get the value at index 3.
     * @return Value.
     */
    public D get3() {
        return (D) get(3);
    }

    /**
     * Put a value into index 3.
     * @param d Value to put.
     */
    public void put3(final D d) {
        put(3, d);
    }

    /**
     * @return New {@link gaffer.tuple.ArrayTuple} of size 4.
     */
    public static Tuple4 createTuple() {
        return new ArrayTuple(4);
    }
}
