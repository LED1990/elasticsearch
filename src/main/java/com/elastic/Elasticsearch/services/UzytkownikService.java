package com.elastic.Elasticsearch.services;

import com.elastic.Elasticsearch.model.Uzytkownik;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Created by artur on 2018-02-04.
 */
public interface UzytkownikService {
    Uzytkownik zapisz(Uzytkownik uzytkownik);

    void delete(Uzytkownik uzytkownik);

    Uzytkownik findUzytkownik(String id);

    Iterable<Uzytkownik> findUzytkownicy();

    Page<Uzytkownik> findByNazwisko(String nazwisko, PageRequest pageRequest);

    List<Uzytkownik> findByImie(String imie);

    List<Uzytkownik> findByImieAndNazwisko(String imie, String nazwisko);

}
