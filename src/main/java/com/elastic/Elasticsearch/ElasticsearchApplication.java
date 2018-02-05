package com.elastic.Elasticsearch;

import com.elastic.Elasticsearch.model.Uzytkownik;
import com.elastic.Elasticsearch.services.UzytkownikService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import java.util.Map;

@Slf4j
@SpringBootApplication
public class ElasticsearchApplication implements CommandLineRunner {

    @Autowired
    ElasticsearchOperations elasticsearchOperations;

    @Autowired
    UzytkownikService uzytkownikService;

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        printElasticSearchInfo();

        uzytkownikService.zapisz(new Uzytkownik("1", "imie1", "surname1"));
        uzytkownikService.zapisz(new Uzytkownik("2", "imie2", "surname2"));
        uzytkownikService.zapisz(new Uzytkownik("3", "imie3", "surname3"));
        uzytkownikService.zapisz(new Uzytkownik("4", "imie22", "surname22"));
        uzytkownikService.zapisz(new Uzytkownik("5", "imie11", "surname11"));
        uzytkownikService.zapisz(new Uzytkownik("6", "imie11", "surname11"));
        uzytkownikService.zapisz(new Uzytkownik("7", "imie11", "surname11"));
        uzytkownikService.zapisz(new Uzytkownik("7", "imie7", "surname7"));
        uzytkownikService.zapisz(new Uzytkownik("1", "imie8", "surname8"));
    }

    //useful for debug, print elastic search details
    private void printElasticSearchInfo() {

        System.out.println("--ElasticSearch--");
        Client client = elasticsearchOperations.getClient();
        Map<String, String> asMap = client.settings().getAsMap();

        asMap.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
        System.out.println("--ElasticSearch--");
    }
}
