package com.anri.digitalzonetesttask.controller;

import com.anri.digitalzonetesttask.domain.VisitLog;
import com.anri.digitalzonetesttask.dto.DailyStatisticsDto;
import com.anri.digitalzonetesttask.dto.PeriodStatisticsDto;
import com.anri.digitalzonetesttask.services.VisitLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/visits")
public class VisitLogController {

    private  VisitLogService visitLogService;

    @Autowired
    public void setVisitLogService(VisitLogService visitLogService){
        this.visitLogService = visitLogService;
    }

    @PostMapping("/create")
    public DailyStatisticsDto addVisitLog(@RequestBody @Valid List<VisitLog> visitLogs){
        for (VisitLog visitLog : visitLogs) {
            visitLogService.save(visitLog);
        }
        Long visitsCountByCurDay = visitLogService.getVisitsCountByCurDay();
        Long distUsersCountByCurDay = visitLogService.getDistUsersCountByCurDay();
        return new DailyStatisticsDto(visitsCountByCurDay, distUsersCountByCurDay);
    }

    @GetMapping("?from={from}&to={to}") //example: localhost:808/visits?from=dd.MM.yyyy&to=dd.MM.yyyy
    public PeriodStatisticsDto getVisitLogByPeriod(@PathVariable String from, @PathVariable String to){
        PeriodStatisticsDto periodStatisticsDto = new PeriodStatisticsDto();
        String europeanDatePattern = "dd.MM.yyyy";
        DateTimeFormatter datePattern = DateTimeFormatter.ofPattern(europeanDatePattern);
        LocalDate firstDate = LocalDate.parse(from, datePattern);
        LocalDate secondDate = LocalDate.parse(to, datePattern);
        Long visitsCountByPeriod = visitLogService.getVisitsCountByPeriod(firstDate, secondDate);
        Long distUsersCountByPeriod = visitLogService.getDistUsersCountByPeriod(firstDate, secondDate);
        Long permanentUsersCountByPeriod = visitLogService.getPermanentUsersCountByPeriod(firstDate, secondDate);
        periodStatisticsDto.setVisitsCountByPeriod(visitsCountByPeriod);
        periodStatisticsDto.setDistUsersCountByPeriod(distUsersCountByPeriod);
        periodStatisticsDto.setPermanentUsersCountByPeriod(permanentUsersCountByPeriod);
        return periodStatisticsDto;
    }
}
