package io.codementor.gtommee.rest_tutorial.Controllers;
import io.codementor.gtommee.rest_tutorial.models.Doctor;
import io.codementor.gtommee.rest_tutorial.repositories.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class DoctorRestController {

    @Autowired
    private DoctorsRepository rep;


    @GetMapping(value = "/getAllDoctors")
    public List<Doctor> getAllPets() {
        return rep.findAll();
    }

    
    @GetMapping(value ="/{id}")
    public Optional<Doctor> getById(@PathVariable("id") String id){
        return rep.findById(id);
    }
}

