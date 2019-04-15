package stormDemo;
//second

import java.util.Map;
import java.util.Random;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.apache.storm.utils.Utils;

public class wordCountSpout extends BaseRichSpout {
	private String[] datas = {"I love Beijing", "I love China", "Beijing is the capital of China"};

	//save output stream
	private SpoutOutputCollector collector;
	
	@Override
	public void nextTuple() {
		Utils.sleep(2000);
		// TODO Auto-generated method stub
		int random = (new Random()).nextInt(3);
		String data = datas[random];
		System.out.println("collect data: " + data);
		this.collector.emit(new Values(data));
		
	}

	@Override
	public void open(Map arg0, TopologyContext arg1, SpoutOutputCollector collector) {
		// TODO Auto-generated method stub
		this.collector = collector;
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declare) {
		// TODO Auto-generated method stub
		declare.declare(new Fields("sentence"));
	}
	
}
