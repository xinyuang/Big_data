package MRpartition;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class partitioner extends Partitioner<IntWritable, Emp>{

	@Override
	public int getPartition(IntWritable k2, Emp v2, int numTask) {
		// TODO Auto-generated method stub
		int deptno = v2.getDeptno();
		if(deptno == 10) {
			return 1%numTask;
		} else if (deptno == 20) {
			return 2%numTask;
		} else {
			return 3%numTask;
		}
	}
	
}
