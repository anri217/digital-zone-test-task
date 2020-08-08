package com.anri.digitalzonetesttask.services.impl;

import com.anri.digitalzonetesttask.dao.VisitLogDao;
import com.anri.digitalzonetesttask.domain.VisitLog;
import com.anri.digitalzonetesttask.services.VisitLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VisitLogServiceImpl implements VisitLogService {
    private VisitLogDao visitLogDao;

    @Autowired
    public void setVisitLogDao(VisitLogDao visitLogDao){
        this.visitLogDao = visitLogDao;
    }

    @Override
    public void save(VisitLog visitLog) {
        visitLogDao.save(visitLog);
    }

    @Override
    public Long getVisitsCountByCurDay() {
        return visitLogDao.getVisitsCountByCurDay();
    }

    @Override
    public Long getDistUsersCountByCurDay() {
        return visitLogDao.getDistUsersCountByCurDay();
    }

    @Override
    public Long getVisitsCountByPeriod(LocalDate firstDate, LocalDate secondDate) {
        return visitLogDao.getVisitsCountByPeriod(firstDate, secondDate);
    }

    @Override
    public Long getDistUsersCountByPeriod(LocalDate firstDate, LocalDate secondDate) {
        return visitLogDao.getDistUsersCountByPeriod(firstDate, secondDate);
    }

    @Override
    public Long getPermanentUsersCountByPeriod(LocalDate firstDate, LocalDate secondDate) {
        return visitLogDao.getPermanentUsersCountByPeriod(firstDate, secondDate);
    }
}
