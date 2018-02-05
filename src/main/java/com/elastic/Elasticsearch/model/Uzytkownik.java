package com.elastic.Elasticsearch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by artur on 2018-02-04.
 */
//TODO: sprawdzić co będzie jak się typ zmieni liub usunie
@Document(indexName = "uzytkownik")
@AllArgsConstructor
@Data
public class Uzytkownik {
    @Id
    private String id;
    private String imie;
    private String nazwisko;
}
