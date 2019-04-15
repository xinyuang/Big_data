package stormDemo;

import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

//first
public class wordCountSplit extends BaseRichBolt{
	private OutputCollector collector;
	@Override
	public void execute(Tuple tuple) {
		// TODO Auto-generated method stub
		String data = tuple.getStringByField("sentence");
		
		String[] words = data.split(" ");
		for(String w:words) {
			collector.emit(new Values(w,1));
		}
	}

	@Override
	public void prepare(Map arg0, TopologyContext arg1, OutputCollector collector) {
		// TODO Auto-generated method stub
		this.collector = collector;
		
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declare) {
		// TODO Auto-generated method stub
		declare.declare(new Fields("word","count"));
	}

}
