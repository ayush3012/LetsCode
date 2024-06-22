package com.example.config;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.entity.Account;
import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionConfig;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.ManagementCenterConfig;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizePolicy;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

@Configuration
public class HazelcastConfig {
	
	@Bean
    public Config cacheConfig() {
        return new Config().setInstanceName("hazel-instance")
        		.addMapConfig(new MapConfig()
        				.setName("Account")
        				.setTimeToLiveSeconds(3000)
        				.setEvictionConfig(new EvictionConfig()
        						.setSize(200).setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE)
        						.setEvictionPolicy(EvictionPolicy.LRU)));
    }
	
	/*@Bean
	public Config hazelCastConfigBean() {
		return new Config().setManagementCenterConfig(
				new ManagementCenterConfig());

	}

	@Bean
	public HazelcastInstance hazelcastInstance(Config hazelCastConfigBean) {
		return Hazelcast.newHazelcastInstance(hazelCastConfigBean);
	}

	@Bean
	public Map<Integer, Account> cache(HazelcastInstance hazelcastInstance) {
		return hazelcastInstance.getMap("cache");
	}*/
}
