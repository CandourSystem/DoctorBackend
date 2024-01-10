package org.cs.jwt.controller;

import java.util.List;

import org.cs.jwt.dto.DetailsStatus;
import org.cs.jwt.services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {
    @Autowired
    DashboardService dashboardService;

   




    @CrossOrigin
    @GetMapping("/dashboard/industry/{organizationid}/{stationid}")
    @ResponseBody
    public List<Object[]> getOrganizationStationParameterValues(
            @PathVariable(required = true) final Integer organizationid,
            @PathVariable(required = true) final Integer stationid) {

        return dashboardService.getOrganizationStationParameterValues(organizationid,stationid);
    }
    @CrossOrigin
    @GetMapping("/dashboard/industry/parameter/average/{period}/{organizationid}/{stationid}")
    @ResponseBody
    public List<Object[]> getOrganizationStationParameterAverageValuesOverperiod(
        @PathVariable(required = true) final String period,
            @PathVariable(required = true) final Integer organizationid,
            @PathVariable(required = true) final Integer stationid) {

        return dashboardService.getOrganizationStationParameterAverageValuesOverperiod(period,organizationid,stationid);
    }

    @CrossOrigin
    @GetMapping("/dashboard/industry/fetchindustrytypestatusdetails")
    @ResponseBody
    public List<DetailsStatus> fetchindustrytypestatusdetails(@RequestHeader("Authorization") String token) {

        return dashboardService.fetchindustrytypestatusdetails(token);
    }
    @CrossOrigin
    @GetMapping("/dashboard/industry/fetchorganizationtypestatusdetails")
    @ResponseBody
    public List<DetailsStatus> fetchorganizationtypedetails(@RequestHeader("Authorization") String token) {

        return dashboardService.fetchorganizationtypedetails(token);
    } 
}
