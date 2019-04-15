package stormDemo;

import org.apache.storm.redis.common.mapper.RedisDataTypeDescription;
import org.apache.storm.redis.common.mapper.RedisStoreMapper;
import org.apache.storm.tuple.ITuple;

public class RedisSotreMapper implements RedisStoreMapper {

	@Override
	public String getKeyFromTuple(ITuple arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValueFromTuple(ITuple arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RedisDataTypeDescription getDataTypeDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
