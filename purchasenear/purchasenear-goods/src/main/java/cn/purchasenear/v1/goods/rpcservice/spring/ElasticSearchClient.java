package cn.purchasenear.v1.goods.rpcservice.spring;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class ElasticSearchClient {
	
	
	// cluster-nodes="ip:9300,ip:9300" cluster-name="elasticsearch"
	private static volatile TransportClient client;
	final static Lock lock = new ReentrantLock();
	/**
	 * 
	 * @Description 初始化客户端
	 * @param clusterNodes 多个集群节点用逗号分隔："ip:9300,ip:9300"
	 * @param clusterName 如：elasticsearch
	 */
	public static void initClient(String clusterNodes, String clusterName) {
		if (client == null) {
			lock.lock();
			try {
				if (client == null) {
					Settings settings = ImmutableSettings.settingsBuilder()
							.put("client.transport.sniff", true)
							.put("client", true).put("data", false)
							.put("clusterName", clusterName).build();

					client = new TransportClient(settings);
					for (String clusterNode : clusterNodes.split(",")) {
						String ip = clusterNode.split(":")[0];
						String port = clusterNode.split(":")[1];
						client.addTransportAddress(new InetSocketTransportAddress(
								ip, Integer.parseInt(port)));
					}
				}
			} finally {
				lock.unlock();
			}
		}
	}
	
	public static TransportClient getClient(){
		return client;
	}

}
