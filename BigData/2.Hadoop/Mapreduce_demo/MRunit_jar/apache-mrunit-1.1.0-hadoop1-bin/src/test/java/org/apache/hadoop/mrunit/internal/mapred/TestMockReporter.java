/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.mrunit.internal.mapred;

import static org.junit.Assert.assertTrue;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.InputSplit;
import org.apache.hadoop.mrunit.ExpectedSuppliedException;
import org.apache.hadoop.mrunit.internal.mapred.MockReporter;
import org.junit.Rule;
import org.junit.Test;

public class TestMockReporter {

  @Rule
  public final ExpectedSuppliedException thrown = ExpectedSuppliedException
      .none();

  @Test
  public void testGetInputSplitForMapper() {
    final InputSplit split = new MockReporter(MockReporter.ReporterType.Mapper,
        null, new Path("/")).getInputSplit();
    assertTrue(null != split);
  }

  // reporter is contractually obligated to throw an exception
  // if the reducer tries to grab the input split.
  @Test
  public void testGetInputSplitForReducer() {
    thrown.expectMessage(UnsupportedOperationException.class,
        "Reducer cannot call getInputSplit()");
    new MockReporter(MockReporter.ReporterType.Reducer, null, null).getInputSplit();
  }
}
