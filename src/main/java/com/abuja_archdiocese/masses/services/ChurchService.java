package com.abuja_archdiocese.masses.services;

import com.abuja_archdiocese.masses.models.entities.Activity;
import com.abuja_archdiocese.masses.models.entities.Church;
import com.abuja_archdiocese.masses.models.repositories.ActivityRepository;
import com.abuja_archdiocese.masses.models.repositories.ChurchRepository;
import com.abuja_archdiocese.masses.models.response.BaseResponseObject;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChurchService {

    ChurchRepository churchRepository;
    ActivityRepository activityRepository;
    private BaseResponseObject responseObject = new BaseResponseObject();

    public ChurchService(ChurchRepository churchRepository,
                         ActivityRepository activityRepository)
    {
        this.churchRepository = churchRepository;
        this.activityRepository = activityRepository;
    }

    public BaseResponseObject saveChurch(Church church) {
        try {
             Church churchResponse = churchRepository.save(church);
             responseObject.setData(churchResponse);
             responseObject.setMessage("Church saved successful");
        } catch (DataAccessException e) {
             responseObject.setMessage("Couldn't save church due to: " + e.getMessage());
             return responseObject;
        }
        return responseObject;
    }

    public BaseResponseObject listChurches() {
        List<Church> churches = new ArrayList<>();
        try {
            churchRepository.findAll().forEach(churches::add);
            responseObject.setData(churches);
            responseObject.setMessage("Church list retrieval successful");
        } catch (DataAccessException e) {
            responseObject.setMessage("Church list retrieval error: " + e.getMessage());
            return responseObject;
        }
        return responseObject;
    }

    public BaseResponseObject saveActivity(Activity activity) {
        try {
            Activity savedActivity = activityRepository.save(activity);
            responseObject.setData(savedActivity);
            responseObject.setMessage("Activity save successful");
        } catch (DataAccessException e) {
            responseObject.setMessage("Save activity error: " + e.getMessage());
            return responseObject;
        }
        return responseObject;
    }

    public BaseResponseObject listActivities() {
        List<Activity> activities = new ArrayList<>();
        try {
            activityRepository.findAll().forEach(activities::add);
            responseObject.setData(activities);
            responseObject.setMessage("Activity list retrieval successful");
        } catch (DataAccessException e) {
            responseObject.setMessage("Activity list retrieval error: " + e.getMessage());
            return responseObject;
        }
        return  responseObject;
    }
}
