package sort.MR;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class EmpMapper extends Mapper<LongWritable, Text, Emp, NullWritable>{
	@Override
	protected void map(LongWritable key1, Text value1, Mapper<LongWritable, Text, Emp, NullWritable>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		String data = value1.toString();
		String[] words = data.split(",");
		Emp emp = new Emp();
		emp.setEmpno(Integer.parseInt(words[0]));
		emp.setEname(words[1]);
		emp.setJob(words[2]);
		emp.setMgr(Integer.parseInt(words[3]));
		emp.setHiredate(words[4]);
		emp.setSal(Integer.parseInt(words[5]));
		emp.setComm(Integer.parseInt(words[6]));
		emp.setDeptno(Integer.parseInt(words[7]));		
		context.write(emp, NullWritable.get());
	}
}
