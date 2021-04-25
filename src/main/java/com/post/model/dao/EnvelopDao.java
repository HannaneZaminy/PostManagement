package com.post.model.dao;

import com.post.model.entity.Envelope;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EnvelopDao {
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    public static Envelope findEnvelopByCoustomer(int trackingNumber, String userName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Envelope envelope = session.get(Envelope.class, trackingNumber);
        envelope = (Envelope) session.createQuery("FROM Envelope e WHERE e.customer.UserName = :userName AND e.trackingNumber=:trakingNumber").setParameter("userName", userName)
                .uniqueResult();
        return envelope;
    }

    public static Envelope findEnvelop(int trackingNumber) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Envelope envelope = session.get(Envelope.class, trackingNumber);
        return envelope;
    }

    @SuppressWarnings("unchecked")
    @Deprecated
    public static List<Envelope> fetchAllEnvelop() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Envelope.class);
        List<Envelope> envelopes = criteria.list();
        transaction.commit();
        session.close();
        System.out.println("*"+envelopes.size());
        return envelopes;
    }

    public static List<Envelope> fetch() {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            List clerks = session.createQuery(
                    " FROM Envelope "
            ).list();
            transaction.commit();
            System.out.println("FETCH CLERKS COMPLETED...");
            return clerks;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;

    }

}

