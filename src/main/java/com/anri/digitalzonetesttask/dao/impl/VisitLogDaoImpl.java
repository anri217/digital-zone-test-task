package com.anri.digitalzonetesttask.dao.impl;

import com.anri.digitalzonetesttask.dao.VisitLogDao;
import com.anri.digitalzonetesttask.domain.VisitLog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class VisitLogDaoImpl implements VisitLogDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(VisitLog visitLog) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(visitLog);
        transaction.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Long getVisitsCountByCurDay() {
        LocalDate curDay = LocalDate.now();
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Long> countList = session.createQuery("select count(*) from VisitLog where actionDate = :curDay").
                setParameter("curDay", curDay).list();
        transaction.commit();
        session.close();
        return countList.size() != 0 ? countList.get(0) : Long.valueOf(0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Long getDistUsersCountByCurDay() {
        LocalDate curDay = LocalDate.now();
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Long> countList = session.createQuery("select count(distinct username) from VisitLog where " +
                "actionDate = :curDay").setParameter("curDay", curDay).list();
        transaction.commit();
        session.close();
        return countList.size() != 0 ? countList.get(0) : Long.valueOf(0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Long getVisitsCountByPeriod(LocalDate firstDate, LocalDate secondDate) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Long> countList = session.createQuery("select count(*) from VisitLog where " +
                "actionDate >= :firstDate and actionDate <= :secondDate").setParameter("firstDate", firstDate).
                setParameter("secondDate", secondDate).list();
        transaction.commit();
        session.close();
        return countList.size() != 0 ? countList.get(0) : Long.valueOf(0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Long getDistUsersCountByPeriod(LocalDate firstDate, LocalDate secondDate) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Long> countList = session.createQuery("select count(distinct username) from VisitLog where " +
                "actionDate >= :firstDate and actionDate <= :secondDate").setParameter("firstDate", firstDate).
                setParameter("secondDate", secondDate).list();
        transaction.commit();
        session.close();
        return countList.size() != 0 ? countList.get(0) : Long.valueOf(0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Long getPermanentUsersCountByPeriod(LocalDate firstDate, LocalDate secondDate) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Long> countList = session.createQuery("select count(username) from VisitLog where " +
                "actionDate >= :firstDate and actionDate <= :secondDate " +
                "group by username having count(distinct webSite) >= 10").setParameter("firstDate", firstDate).
                setParameter("secondDate", secondDate).list();
        transaction.commit();
        session.close();
        return countList.size() != 0 ? countList.get(0) : Long.valueOf(0);
    }
}
