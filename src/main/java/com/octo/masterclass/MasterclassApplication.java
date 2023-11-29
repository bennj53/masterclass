package com.octo.masterclass;

import com.octo.masterclass.domain.entity.Ingredient;
import com.octo.masterclass.domain.entity.Plat;
import com.octo.masterclass.infra.repository.DataBasePlatDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MasterclassApplication {

    @Autowired
    DataBasePlatDAO platRepository;

    public static void main(String[] args) {
        SpringApplication.run(MasterclassApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoData(DataBasePlatDAO dataBasePlatDAO) {
        Ingredient moules = new Ingredient("moule", true, 0);
        Ingredient riz = new Ingredient("riz", false, 0);
        Ingredient safran = new Ingredient("safran", false, 0);
        Ingredient pimentRouge = new Ingredient("piment rouge", false, 3);
        Ingredient vinaigre = new Ingredient("vinaigre", false, 0);
        List<Ingredient> ingredientsPaella = List.of(moules, riz, pimentRouge, safran);
        List<Ingredient> ingredientsRizVinaigre = List.of(riz, vinaigre);
        List<Ingredient> ingredientsMoulesAuPiment = List.of(moules, pimentRouge);

        Plat paella = new Plat("paëlla", 15.50, ingredientsPaella);
        Plat rizVinaigre = new Plat("riz vinaigré", 5.0, ingredientsRizVinaigre);
        Plat moulesAuPiment = new Plat("moules pimentés", 12.50, ingredientsMoulesAuPiment);

        return args -> {
            dataBasePlatDAO.saveAll(List.of(paella, rizVinaigre, moulesAuPiment));
        };
    }
}
