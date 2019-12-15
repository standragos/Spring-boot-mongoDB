package io.proiectPSBD.Controllers;
import io.proiectPSBD.models.Doctor;
import io.proiectPSBD.repositories.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.Document;
import javax.validation.Valid;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@RestController
@RequestMapping("/")
public class DoctorRestController {

    @Autowired
    private DoctorsRepository dRep;

    @Autowired
    MongoTemplate mongoTemplate;

    //get all doctors
    @GetMapping(value = "/getAllDoctors")
    public List<Doctor> getAllDoctors() {
        return dRep.findAll();
    }

    //get by index
    @GetMapping(value ="/{id}")
    public Doctor getById(@PathVariable("id") String id){
        return dRep.findByid(id);
    }

    //update doctor
    @PutMapping(value = "/{id}")
    public void modifyDoctorById(@PathVariable("id") String id, @Valid @RequestBody Doctor doctors) {
        doctors.setId(id);
        dRep.save(doctors);
    }

    @GetMapping(value ="/exclude")
    public List<Doctor> excludeId(){
      return dRep.findNameAndExcludeId();
    }

    //delete a doctor
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePet(@PathVariable String  id) {
        dRep.delete(dRep.findByid(id));
    }

    @GetMapping(value="/aggregation")
    public Document printNoOfConsultations() {

        GroupOperation sumConsultations = group("consultation").count().as("noOfConsultations");
        SortOperation sortByCount = sort(Sort.Direction.ASC, "noOfConsultations");
        GroupOperation groupFirstAndLast = group().first("_id").as("minNoOfConsultations")
                .first("noOfConsultations").as("minConsultationCount").last("_id").as("maxConsultationDoctor")
                .last("noOfConsultations").as("maxConsultationCount");

        Aggregation aggregation = newAggregation(sumConsultations, sortByCount, groupFirstAndLast);

        AggregationResults<Doctor> result = mongoTemplate
                .aggregate(aggregation, "da", Doctor.class);

        Document document= (Document) result.getUniqueMappedResult();
        return document;
    }


}

