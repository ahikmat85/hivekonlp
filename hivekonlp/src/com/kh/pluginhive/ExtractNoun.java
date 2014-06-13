package com.kh.pluginhive;

import java.util.LinkedList;

import kr.ac.kaist.swrc.jhannanum.comm.Eojeol;
import kr.ac.kaist.swrc.jhannanum.comm.Sentence;
import kr.ac.kaist.swrc.jhannanum.hannanum.Workflow;
import kr.ac.kaist.swrc.jhannanum.hannanum.WorkflowFactory;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

@Description(name = "ExtractNoun", value = "")
public class ExtractNoun extends UDF {

	public Text evaluate(Text input) {
		if (input == null)
			return null;
		return new Text(JNHelper.getInstance().extractNouns(FilterHelper.filter(input.toString())));
	}
	
	
}
