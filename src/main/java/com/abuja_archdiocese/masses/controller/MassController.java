package com.abuja_archdiocese.masses.controller;

import com.abuja_archdiocese.masses.models.entities.Activity;
import com.abuja_archdiocese.masses.models.entities.Church;
import com.abuja_archdiocese.masses.models.repositories.ChurchRepository;
import com.abuja_archdiocese.masses.models.response.BaseResponseObject;
import com.abuja_archdiocese.masses.services.ChurchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MassController {
    @Autowired
    ChurchRepository churchRepository;

    ChurchService churchService;

    public MassController(ChurchService churchService) {
        this.churchService = churchService;
    }

    @GetMapping("/church")
    public ResponseEntity<BaseResponseObject> listChurches() {
        BaseResponseObject responseObject = churchService.listChurches();
        if (responseObject.getData() != null)
            return new ResponseEntity<>(responseObject, HttpStatus.FOUND);
        else return new ResponseEntity<>(responseObject, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/church")
    public ResponseEntity<BaseResponseObject> addChurch(@RequestBody Church church) {
        BaseResponseObject responseObject = churchService.saveChurch(church);
        if (responseObject.getData() != null)
            return new ResponseEntity<>(responseObject, HttpStatus.CREATED);
        else return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/church/activity")
    public ResponseEntity<BaseResponseObject> listActivities() {
        BaseResponseObject responseObject = churchService.listActivities();
        if (responseObject.getData() != null)
            return new ResponseEntity<>(responseObject, HttpStatus.FOUND);
        else return new ResponseEntity<>(responseObject, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/church/activity")
    public ResponseEntity<BaseResponseObject> addActivity(@RequestBody Activity activity) {
        BaseResponseObject responseObject = churchService.saveActivity(activity);
        if (responseObject.getData() != null)
            return new ResponseEntity<>(responseObject, HttpStatus.CREATED);
        else return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
    }

}
