/*
 * Copyright 2017 Crown Copyright
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
package uk.gov.gchq.gaffer.spark.serialisation.kryo.impl.datasketches.sampling;

import com.yahoo.sketches.sampling.ReservoirItemsUnion;
import uk.gov.gchq.gaffer.spark.serialisation.kryo.KryoSerializerTest;

import static org.junit.Assert.assertArrayEquals;

public class ReservoirStringsUnionKryoSerializerTest extends KryoSerializerTest<ReservoirItemsUnion> {

    @Override
    protected void shouldCompareSerialisedAndDeserialisedObjects(final ReservoirItemsUnion obj, final ReservoirItemsUnion deserialised) {
        assertArrayEquals(obj.getResult().getSamples(), deserialised.getResult().getSamples());
    }

    @Override
    public Class<ReservoirItemsUnion> getTestClass() {
        return ReservoirItemsUnion.class;
    }

    @Override
    public ReservoirItemsUnion<String> getTestObject() {
        final ReservoirItemsUnion<String> union = ReservoirItemsUnion.newInstance(20);
        union.update("1");
        union.update("2");
        union.update("3");
        return union;
    }
}
