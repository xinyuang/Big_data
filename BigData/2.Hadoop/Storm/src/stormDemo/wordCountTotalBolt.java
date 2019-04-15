package stormDemo;

import java.util.HashMap;
import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

//Third
public class wordCountTotalBolt extends BaseRichBolt {
	
	private OutputCollector collector;
	private Map<String, Integer> result = new HashMap<>();
	
	@Override
	public void execute(Tuple tuple) {
		// TODO Auto-generated method stub
		String word = tuple.getStringByField("word");
		int count = tuple.getIntegerByField("count");
		if (result.containsKey(word)) {
			int total = result.get(word);
			result.put(word, total + count);
		}else {
			result.put(word,count);
		}
		System.out.println("total is " + result);
		this.collector.emit(new Values(word, result.get(word)));
	}

	@Override
	public void prepare(Map arg0, TopologyContext arg1, OutputCollector collector) {
		// TODO Auto-generated method stub
		this.collector = collector;
		
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declare) {
		// TODO Auto-generated method stub
		declare.declare(new Fields("word","total"));
	}
	

}
