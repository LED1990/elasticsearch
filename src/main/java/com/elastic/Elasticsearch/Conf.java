package com.elastic.Elasticsearch;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

/**
 * Created by artur on 2018-02-04.
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.elastic.Elasticsearch.repository")
public class Conf {
    @Value("${elasticsearch.host}")
    private String elasticHost;

    @Value("${elasticsearch.port}")
    private int elasticPort;

    @Value("${elasticsearch.clustername}")
    private String elasticCluster;

    @Bean
    public Client client() throws Exception{
        Settings elasticSettings = Settings.settingsBuilder()
                .put("cluster.name",elasticCluster)
                .build();

        return TransportClient.builder()
                .settings(elasticSettings)
                .build()
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(elasticHost),elasticPort));
    }

    @Bean
    ElasticsearchOperations elasticsearchOperations() throws Exception{
        return new ElasticsearchTemplate(client());
    }
}
