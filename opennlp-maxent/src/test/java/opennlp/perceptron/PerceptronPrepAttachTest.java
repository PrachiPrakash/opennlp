/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package opennlp.perceptron;

import static opennlp.PrepAttachDataUtil.createTrainingStream;
import static opennlp.PrepAttachDataUtil.testModel;

import java.io.IOException;

import opennlp.model.AbstractModel;
import opennlp.model.TwoPassDataIndexer;

import org.junit.Test;

/**
 * Test for perceptron training and use with the ppa data.
 */
public class PerceptronPrepAttachTest {

  @Test
  public void testPerceptronOnPrepAttachData() throws IOException {
    AbstractModel model = 
        new PerceptronTrainer().trainModel(5000, 
        new TwoPassDataIndexer(createTrainingStream(), 1, false), 1);

    testModel(model, 0.7613270611537509);
  }
}
