package kz.solvatech.coffeemachine.service.impl;

import kz.solvatech.coffeemachine.dto.PublicHolidayDTO;
import kz.solvatech.coffeemachine.service.OperationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class OperationalServiceImpl implements OperationalService {

    @Autowired
    private RestTemplate restTemplate;
    private final Set<LocalDate> holidays = new HashSet<>();

    @Override
    public boolean isWorkingHours() {
        return isCoffeeMachineOperational();
    }

    private boolean isCoffeeMachineOperational(){
        LocalDateTime now = LocalDateTime.now();
        LocalTime currentTime = now.toLocalTime();
        LocalDate currentDate = now.toLocalDate();

        if(currentTime.isBefore(LocalTime.of(8,0)) || currentTime.isAfter(LocalTime.of(17,0))){
            return false;
        }
        if(isWeekend(currentDate)){
            return false;
        }
        if(isHoliday(currentDate)){
            return false;
        }
        return true;


    }
    private boolean isWeekend(LocalDate date){
        return date.getDayOfWeek().getValue()>=6;
    }
    private boolean isHoliday(LocalDate date){
        if(holidays.isEmpty()){
            fetchHolidays();
        }
        return holidays.contains(date);
    }

    @Cacheable("holidays")
    public void fetchHolidays(){
        String countryCode = "KZ";
        String apiUrl = String.format("https://date.nager.at/api/v3/publicholidays/2025/%s", countryCode);

        PublicHolidayDTO[] publicHolidays = restTemplate.getForObject(apiUrl,PublicHolidayDTO[].class);
        if(publicHolidays != null){
            for(PublicHolidayDTO holiday : publicHolidays){
                holidays.add(holiday.getDate());
            }
        }
    }
}
