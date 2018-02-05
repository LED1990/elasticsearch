package com.elastic.Elasticsearch.repository;

import com.elastic.Elasticsearch.model.Uzytkownik;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


/**
 * Created by artur on 2018-02-04.
 */
public interface UzytkownicyRepo extends ElasticsearchRepository<Uzytkownik, String> {
    List<Uzytkownik> findByImie(String imie);

    Page<Uzytkownik> findByNazwisko(String nazwisko, Pageable pageable);

    List<Uzytkownik> findByImieAndNazwisko(String imie, String nazwisko);
}
