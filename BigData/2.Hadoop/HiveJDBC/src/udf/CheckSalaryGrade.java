package udf;

import org.apache.hadoop.hive.ql.exec.UDF;

public class CheckSalaryGrade extends UDF{
	public String evaluate(String salary){
		int sal = Integer.parseInt(salary);
		
		if(sal < 1000) return "Grade A";
		else if(sal>=1000 && sal<3000) return "Grade B";
		else return "Grade C";
	}
}
