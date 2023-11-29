package com.octo.masterclass.api;

import com.octo.masterclass.fixtures.PlatFixture;
import com.octo.masterclass.domain.entity.Plat;
import com.octo.masterclass.infra.repository.DataBasePlatDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class PlatControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private final List<Plat> expectedPlats = PlatFixture.tousLesPlats();

    @MockBean
    private DataBasePlatDAO platRepositoryMocked;

    @Test
    public void testGetAllPlats() throws Exception {
        when(platRepositoryMocked.findAll()).thenReturn(expectedPlats);

        mockMvc.perform(MockMvcRequestBuilders.get("/plats")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .json(
                        """
                        [
                            {
                                "nom":"paëlla",
                                "prix":15.5,
                                "ingredients":[
                                        {"nom":"moule","allergene":true,"kipik":0},
                                        {"nom":"riz","allergene":false,"kipik":0},
                                        {"nom":"piment rouge","allergene":false,"kipik":3},
                                        {"nom":"safran","allergene":false,"kipik":0}
                                    ]
                            },
                            {
                                "nom":"riz vinaigré",
                                "prix":5.0,
                                "ingredients":[
                                        {"nom":"riz","allergene":false,"kipik":0},
                                        {"nom":"vinaigre","allergene":false,"kipik":0}
                                    ]
                            },
                            {
                                "nom":"moules pimentées",
                                "prix":12.0,
                                "ingredients":[
                                        {"nom":"moule","allergene":true,"kipik":0},
                                        {"nom":"piment rouge","allergene":false,"kipik":3}
                                    ]
                            }
                        ]
                        """))
                .andDo(print());
    }

    @Test
    public void testSupprimerPlat() throws Exception {
        when(platRepositoryMocked.findById(1L)).thenReturn(Optional.ofNullable(expectedPlats.get(0)));
        mockMvc.perform(MockMvcRequestBuilders.delete("/plats/delete/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

//    @Test
//    public void testAjouterPlat() throws Exception {
//        Plat platAAjouter = new Plat("nouveau plat", 20.0, List.of());
//        when(platRepositoryMocked.save(platAAjouter)).thenReturn(platAAjouter);
//
//        String platJson = objectMapper.writeValueAsString(platAAjouter);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/plats")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(platJson)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(
//                        MockMvcResultMatchers.content()
//                                .json(platJson)
//                )
//                .andDo(print());
//    }
}