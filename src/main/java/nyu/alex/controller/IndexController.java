package nyu.alex.controller;

import com.alibaba.fastjson.JSON;
import nyu.alex.dao.entity.Airport;
import nyu.alex.dao.entity.Flight;
import nyu.alex.dao.mapper.IAirplaneDao;
import nyu.alex.dao.entity.Airplane;
import nyu.alex.dao.mapper.IAirportDao;
import nyu.alex.dao.mapper.IFlightDao;
import nyu.alex.service.BaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/index")
@CrossOrigin("http://localhost:3000/*")
public class IndexController {

    @Resource
    private IAirplaneDao airplaneDao;

    @Resource
    private BaseService baseService;

    @Resource
    private IFlightDao flightDao;


    /**
     * Search for upcoming flights for all users with filters.
     * @param flight
     * @return
     */
    @PostMapping("/searchFlights")
    @ResponseBody
    public String searchFlights(@RequestBody Flight flight) {
        return JSON.toJSONString(baseService.searchFlights(flight));
    }


    /**
     * Search for upcoming flights for all users without filters(default view).
     * @return
     */
    @GetMapping("/findAllFlights")
    @ResponseBody
    public String findAllFlights(){
        return JSON.toJSONString(baseService.findAllFlights());
    }


    /**
     * Search all available airports, auxiliary functionality for filtered search.
     * @return
     */
    @GetMapping("/searchAirports")
    @ResponseBody
    public String searchAllAirport(){
        List<Airport> airports = baseService.searchAirports();
        List<String> results = new ArrayList<>();
        for(Airport airport:airports){
            results.add(airport.getAirportName());
        }
        return JSON.toJSONString(results);
    }
}
