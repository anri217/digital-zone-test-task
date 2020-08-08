package com.anri.digitalzonetesttask.services;

import com.anri.digitalzonetesttask.domain.VisitLog;

import java.time.LocalDate;

public interface VisitLogService {

    void save(VisitLog visitLog);

    Long getVisitsCountByCurDay();

    Long getDistUsersCountByCurDay();

    Long getVisitsCountByPeriod(LocalDate firstDate, LocalDate secondDate);

    Long getDistUsersCountByPeriod(LocalDate firstDate, LocalDate secondDate);

    Long getPermanentUsersCountByPeriod(LocalDate firstDate, LocalDate secondDate);
}
