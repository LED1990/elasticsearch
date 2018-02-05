package com.elastic.Elasticsearch;

import com.elastic.Elasticsearch.model.Uzytkownik;
import com.elastic.Elasticsearch.services.UzytkownikService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ElasticsearchApplicationTests {

    @Autowired
    UzytkownikService uzytkownikService;

    private List<Uzytkownik> uzytkownikList;
    private Iterable<Uzytkownik> uzytkownicyIterable;

    @Before
    public void daneDoTestow() {
        uzytkownikList = new ArrayList<>();

//        uzytkownicyIterable= new LinkedList<>();
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void znajdzPoImie() {
        uzytkownikList = uzytkownikService.findByImie("imie8");
        for (Uzytkownik uzytkownik : uzytkownikList) {
            log.info("id: " + uzytkownik.getId() + " imie: " + uzytkownik.getImie() + " nazwisko: " + uzytkownik.getNazwisko());
            Assert.assertEquals("imie8", uzytkownik.getImie());
        }
    }

    @Test
    public void znajdzPoImieINazwisko() {
        String imie = "imie3";
        String nazwisko = "surname3";

        uzytkownikList = uzytkownikService.findByImieAndNazwisko(imie, nazwisko);
        for (Uzytkownik uzytkownik : uzytkownikList) {
            log.info("id: " + uzytkownik.getId() + " imie: " + uzytkownik.getImie() + " nazwisko: " + uzytkownik.getNazwisko());
            Assert.assertEquals(imie, uzytkownik.getImie());
            Assert.assertEquals(nazwisko, uzytkownik.getNazwisko());
        }
    }

    @Test
    public void znajdzWszytskichUzytkownikow() {
        uzytkownicyIterable = uzytkownikService.findUzytkownicy();
        List<Uzytkownik> listaUzytkownikow = new ArrayList<>();
        for (Uzytkownik uzytkownik : uzytkownicyIterable) {
            listaUzytkownikow.add(uzytkownik);
//            log.info("id: " + uzytkownik.getId() + " imie: " + uzytkownik.getImie() + " nazwisko: " + uzytkownik.getNazwisko());
        }
        Collections.sort(listaUzytkownikow, new Comparator<Uzytkownik>() {
            @Override
            public int compare(Uzytkownik o1, Uzytkownik o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        for (Uzytkownik uzytkownik : listaUzytkownikow) {
            log.info("id: " + uzytkownik.getId() + " imie: " + uzytkownik.getImie() + " nazwisko: " + uzytkownik.getNazwisko());
        }
    }

    @Test
    public void usunUzytkownika() {
        Uzytkownik uzytkownik = new Uzytkownik("3", "imie3", "surname3");
        uzytkownikService.delete(uzytkownik);
    }
}
