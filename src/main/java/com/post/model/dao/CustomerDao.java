package com.post.model.dao;

import com.post.model.entity.Customer;
import com.post.model.entity.Employee;
import com.post.model.entity.Envelope;
import com.post.enums.EnvelopeStatus;
import com.post.enums.EnvelopeType;
import com.post.enums.PostType;
import com.post.model.entity.EnvelopeInformation;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class CustomerDao {
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static void save(Customer customer) {
        // open session
        Session session = sessionFactory.openSession();
        // begin a transaction
        session.beginTransaction();
        // use the session to save the contact
        session.save(customer);
        // commit transaction
        session.getTransaction().commit();
        // close the session
        session.close();
    }

    public static Customer findCustomer(String userName) {
        Transaction transaction = null;
        Customer customer = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            customer = (Customer) session.createQuery("FROM Customer C WHERE C.UserName = :userName").setParameter("userName", userName)
                    .uniqueResult();
            return customer;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
      return customer;
    }
    public static Customer checkDuplicateEmail( String email) {
        Transaction transaction = null;
        Customer customer = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            customer = (Customer) session.createQuery("FROM Customer C WHERE C.email = :email").setParameter("email", email)
                    .uniqueResult();
            return customer;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return customer;
    }

    public static Envelope requestNonDocumentPost(String username, float weight, String sours, String end, PostType postType) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, username);
        Envelope envelope = new Envelope();
        envelope.setWeight(weight);
        envelope.setSourceAddress(sours);
        envelope.setDestinationAddress(end);
        envelope.setLastStatus(EnvelopeStatus.Registered);
        envelope.setEnvelopeType(EnvelopeType.Non_document);
        envelope.setPostType(postType);
        customer.getEnvelopes().add(envelope);
        envelope.setCustomer(customer);
        EnvelopeInformation envelopeInformation = new EnvelopeInformation();
        envelopeInformation.setDateTime(new Date());
        envelopeInformation.setEnvelopeStatus(EnvelopeStatus.Registered);
        envelopeInformation.setEnvelope(envelope);
        envelope.getEnvelopeInformations().add(envelopeInformation);
        transaction.commit();
        session.close();
        return envelope;
    }
    public static Envelope requestDocumentPost(String username, float weight, String sours, String end, PostType postType,float height,float lenght,float width ,String material) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, username);
        Envelope envelope = new Envelope();
        envelope.setWeight(weight);
        envelope.setSourceAddress(sours);
        envelope.setDestinationAddress(end);
        envelope.setLastStatus(EnvelopeStatus.Registered);
        envelope.setEnvelopeType(EnvelopeType.Document);
        envelope.setPostType(postType);
        envelope.setHeight(height);
        envelope.setLength(lenght);
        envelope.setPackageMaterial(material);
        envelope.setWidth(width);

        customer.getEnvelopes().add(envelope);
        envelope.setCustomer(customer);

        EnvelopeInformation envelopeInformation = new EnvelopeInformation();
        envelopeInformation.setDateTime(new Date());
        envelopeInformation.setEnvelopeStatus(EnvelopeStatus.Registered);
        envelopeInformation.setEnvelope(envelope);
        envelope.getEnvelopeInformations().add(envelopeInformation);
        transaction.commit();
        session.close();
        return envelope;
    }
    @SuppressWarnings("unchecked")
    @Deprecated
    public static List<Customer> fetchAllCustomer() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Customer.class);
        List<Customer> customers = criteria.list();
        session.close();
        System.out.println("*"+customers.size());
        return customers;
    }
    public static List<Customer> fetch() {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            List clerks = session.createQuery(
                    " FROM Customer "
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
