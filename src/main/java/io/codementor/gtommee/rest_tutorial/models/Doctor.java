package io.codementor.gtommee.rest_tutorial.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "doctors")

public class Doctor {
    @Id
    private String id;
    private String name;
    private String branch;
    private ArrayList<Branch> branches;
    private ArrayList<Consultation> consultations;


    public ArrayList<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(ArrayList<Consultation> consultations) {
        this.consultations = consultations;
    }

    public void setBranch(String branch){
        this.branch=branch;
    }
    public String getBranch(){
        return this.branch;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List getBranches() {
        return branches;
    }

    public void setBranches(List branches) {
        this.branches = (ArrayList<Branch>) branches;
    }
}