package udf;

import org.apache.hadoop.hive.ql.exec.UDF;

public class MyConcatString extends UDF{
	// evaluate
	public String evaluate(String a,String b){
		return a+"**************"+b;
	}
}
