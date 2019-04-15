package stormDemo;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.generated.StormTopology;
import org.apache.storm.hdfs.bolt.HdfsBolt;
import org.apache.storm.hdfs.bolt.format.DefaultFileNameFormat;
import org.apache.storm.hdfs.bolt.format.DelimitedRecordFormat;
import org.apache.storm.hdfs.bolt.rotation.FileSizeRotationPolicy;
import org.apache.storm.hdfs.bolt.rotation.FileSizeRotationPolicy.Units;
import org.apache.storm.hdfs.bolt.sync.CountSyncPolicy;
import org.apache.storm.redis.bolt.RedisStoreBolt;
import org.apache.storm.redis.common.config.JedisPoolConfig;
import org.apache.storm.redis.common.mapper.RedisDataTypeDescription;
import org.apache.storm.redis.common.mapper.RedisStoreMapper;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.ITuple;

public class wordCountTopology {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			TopologyBuilder builder = new TopologyBuilder();
			builder.setSpout("wordcount_spout", new wordCountSpout());
			builder.setBolt("wordCount_split", new wordCountSplit()).shuffleGrouping("wordcount_spout");
			builder.setBolt("wordCount_total", new wordCountTotalBolt()).fieldsGrouping("wordCount_split", new Fields("word"));
//			builder.setBolt("wordCount_redis", createRedisBolt()).shuffleGrouping("wordCount_total");
//			builder.setBolt("wordCount_hdfs", createHDFSBolt()).shuffleGrouping("wordCount_total");
			builder.setBolt("wordCount_hbase", new WordCountHBaseBolt()).shuffleGrouping("wordCount_total");
			StormTopology topology = builder.createTopology();
			Config conf = new Config();
			
			// 2 ways to submit storm topology
			//1 local mode
			LocalCluster cluster = new LocalCluster();
			cluster.submitTopology("myWordCount", conf, topology);
			//2 cluster mode
//			StormSubmitter.submitTopology("myWordCount", conf, topology);
			
		
	}

	private static IRichBolt createHDFSBolt() {
		// TODO Auto-generated method stub
		HdfsBolt bolt = new HdfsBolt();
		bolt.withFsUrl("hdfs://192.168.137.111:9000");
		bolt.withFileNameFormat(new DefaultFileNameFormat().withPath("/stormdata"));		
		bolt.withRecordFormat(new DelimitedRecordFormat().withFieldDelimiter("|"));
		bolt.withRotationPolicy(new FileSizeRotationPolicy(5.0f,Units.MB));
		bolt.withSyncPolicy(new CountSyncPolicy(1000));	
		return bolt;
	}

	private static IRichBolt createRedisBolt() {
		// TODO Auto-generated method stub
		JedisPoolConfig.Builder builder = new JedisPoolConfig.Builder();
		builder.setHost("192.168.137.111");
		builder.setPort(6379);
		JedisPoolConfig poolConfig = builder.build();
		
		return new RedisStoreBolt(poolConfig, new RedisStoreMapper() {

			@Override
			public String getKeyFromTuple(ITuple tuple) {
				// TODO Auto-generated method stub
				return tuple.getStringByField("word");
			}

			@Override
			public String getValueFromTuple(ITuple tuple) {
				// TODO Auto-generated method stub
				return String.valueOf(tuple.getIntegerByField("total"));
			}

			@Override
			public RedisDataTypeDescription getDataTypeDescription() {
				// TODO Auto-generated method stub
				return new RedisDataTypeDescription(RedisDataTypeDescription.RedisDataType.HASH, "wordcount");
			}
			
		
		});
	}

}
