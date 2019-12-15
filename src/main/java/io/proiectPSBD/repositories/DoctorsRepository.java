package io.proiectPSBD.repositories;

import io.proiectPSBD.models.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface DoctorsRepository extends MongoRepository<Doctor, String> {


    Doctor findByid(String id);

    //proiectie
    @Query(value="{}", fields="{name : 1, _id : 0}")
    List<Doctor> findNameAndExcludeId();
}
