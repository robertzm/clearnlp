/**
 * Copyright 2014, Emory University
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
package edu.emory.clir.clearnlp.component.mode.pos;

import edu.emory.clir.clearnlp.component.evaluation.AbstractAccuracyEval;
import edu.emory.clir.clearnlp.dependency.DEPNode;
import edu.emory.clir.clearnlp.dependency.DEPTree;

/**
 * @since 3.0.0
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class POSEval extends AbstractAccuracyEval<String>
{
	@Override
	public void countCorrect(DEPTree sTree, String[] gTags)
	{
		int i, size = sTree.size();
		DEPNode node;
		
		n_total += size - 1;
		
		for (i=1; i<size; i++)
		{
			node = sTree.get(i);
			
			if (node.isPOSTag(gTags[i]))
				n_correct++;
		}
	}
	
//	public void countCorrect(DEPTree sTree, String[] gTags)
//	{
//		int i, correct = 0, size = sTree.size();
//		DEPNode node;
//		
//		for (i=1; i<size; i++)
//		{
//			node = sTree.get(i);
//			
//			if (node.isPOSTag(gTags[i]))
//				correct++;
//		}
//		
//		if (correct == size - 1) n_correct++;
//		n_total++;
//	}
}
