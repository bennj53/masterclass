//package com.octo.masterclass.api;
//
//import com.octo.masterclass.restaurant.*;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class PanierControllerTest {
//
//    @LocalServerPort
//    private int port;
//
//    private final TestRestTemplate restTemplate = new TestRestTemplate();
//    @Test
//    void testGetPanier(){
//        //Given
//        String url = "http://localhost:" + port + "/panier?id=0";
//        //When
//        ResponseEntity<Panier> responseEntity = restTemplate.getForEntity(url, Panier.class);
//        //Then
//        assertEquals("200 OK", responseEntity.getStatusCode().toString());
//    }
//
//    @Test
//    public void testAjouterPlatAuPanier() {
//        // Création d'un utilisateur et d'un plat pour le test
//        Panier panier = new Panier();
//        Utilisateur utilisateur = new Utilisateur("Bob", "Ladalle", panier);
//        Plat plat = new Principal("paëlla", 15.50, List.of(new Ingredient("riz", false, 0)), false);
//
//        // Construction de l'URL de l'endpoint
//        String url = "http://localhost:" + port + "/panier";
//
//        // Configuration des en-têtes de la requête (Content-Type)
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        // Création de l'entité HttpEntity avec l'utilisateur, le plat et les en-têtes
//        HttpEntity<Object> requestEntity = new HttpEntity<>(List.of(utilisateur, plat), headers);
//
//        // Envoi de la requête HTTP POST
//        ResponseEntity<Panier> responseEntity = restTemplate.postForEntity(url, requestEntity, Panier.class);
//
//        // Vérification du code de statut
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//
//        // Vérification du corps de la réponse
////        Panier panier = responseEntity.getBody();
////        assertEquals("Nom du plat", panier.getNomDuPlat()); // Exemple de vérification
//    }
//}