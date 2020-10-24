package com.hengyunsoft.platform.config.solr;

import com.hengyunsoft.platform.search.manager.HengYunSolr;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass({HttpSolrClient.class, CloudSolrClient.class})
public class SolrConfiguration {
    private HengYunSolr solrClient;
    //以逗号隔开多个zookeeper实例
    @Value("${Solr.zkHosts}")
    private String zkHosts;
    /***
     * 新创建集合分片数量
     */
    @Value("${Solr.numShards}")
    private int numShards;
    /***
     * 新创建集合副本数
     */
    @Value("${Solr.numReplicas}")
    private int numReplicas;

    @Bean
    @ConditionalOnMissingBean
    public HengYunSolr solrClient() {
        this.solrClient = this.createSolrClient();
        return this.solrClient;
    }

    private HengYunSolr createSolrClient() {
        CloudSolrClient.Builder builder = new CloudSolrClient.Builder();
        builder.withZkHost(zkHosts);
        CloudSolrClient client = builder.build();
        client.setZkClientTimeout(20000);
        client.setZkConnectTimeout(1000);
        client.connect();
        HengYunSolr hengYunSolr = new HengYunSolr(client, numShards, numReplicas);
        return hengYunSolr;
    }

}
