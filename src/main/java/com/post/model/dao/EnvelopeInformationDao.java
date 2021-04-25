package com.post.model.dao;

import com.post.model.entity.Envelope;
import com.post.model.entity.EnvelopeInformation;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class EnvelopeInformationDao {
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    @SuppressWarnings("unchecked")
    @Deprecated
    public static List<EnvelopeInformation> fetchAllEnvelop() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(EnvelopeInformation.class);
        List<EnvelopeInformation> envelopeInformationList = criteria.list();
        session.close();
        return envelopeInformationList;
    }
    public static List<EnvelopeInformation> fetch() {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            List clerks = session.createQuery(
                    " FROM EnvelopeInformation "
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
