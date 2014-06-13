package com.kh.pluginhive;

import java.util.LinkedList;

import javax.print.attribute.standard.Finishings;

import kr.ac.kaist.swrc.jhannanum.comm.Eojeol;
import kr.ac.kaist.swrc.jhannanum.comm.Sentence;
import kr.ac.kaist.swrc.jhannanum.hannanum.Workflow;
import kr.ac.kaist.swrc.jhannanum.hannanum.WorkflowFactory;

public class JNHelper {
	Workflow workflow;
	static JNHelper self;
	final int maxLength = 8;

	public static JNHelper getInstance() {
		if (self == null) {
			self = new JNHelper();
		}
		return self;
	}

	public JNHelper() {
		String path = "/handic"; // path to base
		//String path = "/Users/ahikmat/Documents/kh/handic"; //path to base
		// folder
		workflow = WorkflowFactory.getPredefinedWorkflow(path,
				WorkflowFactory.WORKFLOW_NOUN_EXTRACTOR);
		try {
			workflow.activateWorkflow(true);
		} catch (Exception ex) {
			ex.printStackTrace();
			// output=ex.getMessage();
		}
	}

	protected void finalize() {
		workflow.close();
		self = null;
	}

	public String extractNouns(String document) {
		String output = "";
		String word;
		if (document.length() > 1) {
			try {
				workflow.analyze(document);

				LinkedList<Sentence> resultList = workflow
						.getResultOfDocument(new Sentence(0, 0, false));
				for (Sentence s : resultList) {
					Eojeol[] eojeolArray = s.getEojeols();
					for (int i = 0; i < eojeolArray.length; i++) {
						if (eojeolArray[i].length > 0) {
							String[] morphemes = eojeolArray[i].getMorphemes();
							word="";
							for (int j = 0; j < morphemes.length; j++) {
								word = word + morphemes[j];
							}
							if(word.length()<maxLength)
								output =output + word+" " ;
						}
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				// output=ex.getMessage();

			}
		}
		return output;

	}
}