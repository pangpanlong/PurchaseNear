package cn.purchasenear.v1.jedis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {
	
	private Properties pros;
	private String host;
	private String port;
	private String maxActive;
	private String maxIdle;
	private String testOnBorrow;
	private String maxWait;
	private JedisPool jedisPool;
	private static JedisUtil jedisUtil;
	private Jedis jedis = null;
	private String pwd;

	public static JedisUtil getInstance() {
		jedisUtil = new JedisUtil();
		return jedisUtil;
	}

	private JedisUtil() { 
		init();
		initialPool();
	}

	private void init() {
		InputStream in = null;
		try {
			pros = new Properties();
			in = this.getClass().getResourceAsStream("/redis.properties");
			pros.load(in);
			
			host = pros.getProperty("redis.host");
			port = pros.getProperty("redis.port");
			pwd = pros.getProperty("redis.pwd");
			
			maxActive = pros.getProperty("redis.pool.maxActive");
			maxWait = pros.getProperty("redis.pool.maxWait");
			maxIdle = pros.getProperty("redis.pool.maxIdle");
			testOnBorrow = pros.getProperty("redis.pool.testOnBorrow");
					
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	private void initialPool() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxActive(Integer.parseInt(maxActive));
		config.setMaxIdle(Integer.parseInt(maxIdle));
		config.setMaxWait(Long.parseLong(maxWait));
		config.setTestOnBorrow("true".equals(testOnBorrow));
		jedisPool = new JedisPool(config, host,Integer.parseInt(port),0,pwd);
	}

	public Jedis getJedis() {
		return jedisPool.getResource();
	}

	/**
	 * 释放被损坏的jedis.
	 * 
	 * @param jd
	 */
	public void releaseBrokenJedis(Jedis jd) {
		jedisPool.returnBrokenResource(jd);
		jd = null;
	}

	/**
	 * 从连接池中释放jedis
	 * 
	 * @param jd
	 */
	public void releaseJedis(Jedis jd) {
		jedisPool.returnResource(jd);
		jd = null;
	}
	
	
	public  Long del(String ... keys) throws Exception {
		jedis = getJedis();
		Long delNums = jedis.del(keys);
		releaseJedis(jedis);
		return delNums;
	}
	
	
	
	public Long  expire(String key,int seconds)throws Exception{
		jedis = getJedis();
		Long result =  jedis.expire(key, seconds) ;
		releaseJedis(jedis);
		return result;
	}
	
	public Boolean exists(String key) throws Exception {
		jedis = getJedis();
		Boolean result =  jedis.exists(key);
		releaseJedis(jedis);
		return result;	
	}

	
	public String set(String key,String value) throws Exception {
		jedis = getJedis();
		String result =  jedis.set(key, value);
		releaseJedis(jedis);
		return result;	
	}
	
	
	public String get(String key) throws Exception {
		jedis = getJedis();
		String result =  jedis.get(key);
		releaseJedis(jedis);
		return result;	
	}
	



}
