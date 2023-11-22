package com.octo.masterclass.api;

import com.octo.masterclass.exceptions.PlatNotFoundException;
import com.octo.masterclass.persistence.Plat;
import com.octo.masterclass.persistence.PlatRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plats")
public class PlatController {

    private final PlatRepository platRepository;

    public PlatController(PlatRepository platRepository) {
        this.platRepository = platRepository;
    }

    @GetMapping
    public Iterable<Plat> getAllPlats(){
       return this.platRepository.findAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    public void supprimerPlat(@PathVariable Long id) throws RuntimeException {
        if(this.platRepository.findById(id).isEmpty()){
            throw new PlatNotFoundException(id.toString());
        }

        this.platRepository.deleteById(id);
    }

    @PostMapping
    public Plat ajouterPlat(@RequestBody Plat plat){
        return this.platRepository.save(plat);
    }
}
