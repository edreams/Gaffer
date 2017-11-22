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
package uk.gov.gchq.gaffer.spark.serialisation.kryo.impl.datasketches.theta;

import com.yahoo.sketches.theta.Sketch;
import com.yahoo.sketches.theta.UpdateSketch;
import uk.gov.gchq.gaffer.spark.serialisation.kryo.KryoSerializerTest;

import static org.junit.Assert.assertEquals;

public class SketchKryoSerializerTest extends KryoSerializerTest<Sketch> {
    private static final double DELTA = 0.01D;

    @Override
    protected void shouldCompareSerialisedAndDeserialisedObjects(final Sketch obj, final Sketch deserialised) {
        assertEquals(obj.getEstimate(), deserialised.getEstimate(), DELTA);
    }

    @Override
    public Class<Sketch> getTestClass() {
        return Sketch.class;
    }

    @Override
    public Sketch getTestObject() {
        final UpdateSketch sketch = UpdateSketch.builder().build();
        sketch.update(1.0D);
        sketch.update(2.0D);
        sketch.update(3.0D);
        return sketch;
    }
}
