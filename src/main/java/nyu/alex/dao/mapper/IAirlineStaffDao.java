package nyu.alex.dao.mapper;

import nyu.alex.dao.entity.*;
import nyu.alex.utils.dataUtils.TicketInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IAirlineStaffDao {

    //用于登录注册校验
    AirlineStaff findAirlineStaffByName(String userName);

    //需要修改
    List<Customer> findAllCustomerPeriod(@Param("type") String timespanType, @Param("interval")Integer timespan);

    //需要修改
    List<BookingAgent> findTopKBookingAgentEachPeriod(@Param("type")String timespanType,@Param("K")Integer K,@Param("interval")Integer timespan);

    List<TicketInfo> findAmountOfTicketsEachPeriod(@Param("year")int[] year);

    void insertNewAirplane(Airplane airplane);

    void insertNewAirport(Airport airport);

    void insertNewFlight(Flight flight);

    void insertNewFlights(Flight flight);

    void insertNewAirlineStaff(AirlineStaff airlineStaff);

    void updateFlight(Flight flight);

    void updateFlights(Flight flight);

    void deleteFlight(@Param("flightNumber") String flightNumber,@Param("airlineName") String airlineName);

    void deleteFlights(@Param("key")Map<String, String> mapping) ;

    void updateAirlineStaff(AirlineStaff airlineStaff);

}