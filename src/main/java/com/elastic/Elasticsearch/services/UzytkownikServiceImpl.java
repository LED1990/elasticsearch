package com.elastic.Elasticsearch.services;

import com.elastic.Elasticsearch.model.Uzytkownik;
import com.elastic.Elasticsearch.repository.UzytkownicyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by artur on 2018-02-04.
 */
@Service
public class UzytkownikServiceImpl implements UzytkownikService {

    @Autowired
    UzytkownicyRepo uzytkownicyRepo;

    @Override
    public Uzytkownik zapisz(Uzytkownik uzytkownik) {
        return uzytkownicyRepo.save(uzytkownik);
    }

    @Override
    public void delete(Uzytkownik uzytkownik) {
        uzytkownicyRepo.delete(uzytkownik);
    }

    @Override
    public Uzytkownik findUzytkownik(String id) {
        return uzytkownicyRepo.findOne(id);
    }

    @Override
    public Iterable<Uzytkownik> findUzytkownicy() {
        return uzytkownicyRepo.findAll();
    }

    @Override
    public Page<Uzytkownik> findByNazwisko(String nazwisko, PageRequest pageRequest) {
        return uzytkownicyRepo.findByNazwisko(nazwisko, pageRequest);
    }

    @Override
    public List<Uzytkownik> findByImie(String imie) {
        return uzytkownicyRepo.findByImie(imie);
    }

    @Override
    public List<Uzytkownik> findByImieAndNazwisko(String imie, String nazwisko) {
        return uzytkownicyRepo.findByImieAndNazwisko(imie, nazwisko);
    }


}
