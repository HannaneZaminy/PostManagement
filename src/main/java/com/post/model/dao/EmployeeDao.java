package com.post.model.dao;

import com.post.model.entity.Customer;
import com.post.model.entity.Employee;
import com.post.model.entity.Envelope;
import com.post.enums.EnvelopeStatus;
import com.post.model.entity.EnvelopeInformation;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class EmployeeDao {
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    public static void save(Employee employee) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }
    public static void takeMoreOrder(int trackingNumber, String name,String description) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Envelope envelope = session.get(Envelope.class, trackingNumber);
        envelope.setEmployeeName(name);
        envelope.setLastStatus(EnvelopeStatus.accepted);
        EnvelopeInformation envelopeInformation=new EnvelopeInformation();
        envelopeInformation.setDateTime(new Date());
        envelopeInformation.setEmployeeName(name);
        envelopeInformation.setDescription(description);
        envelopeInformation.setEnvelopeStatus(EnvelopeStatus.accepted);
        envelopeInformation.setEnvelope(envelope);
        envelope.getEnvelopeInformations().add(envelopeInformation);
        transaction.commit();
        session.close();
    }
    public static void PendingOrder(int trackingNumber, String name,String description,EnvelopeStatus envelopeStatus) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Envelope envelope = session.get(Envelope.class, trackingNumber);
        envelope.setEmployeeName(name);
        envelope.setLastStatus(envelopeStatus);
        EnvelopeInformation envelopeInformation=new EnvelopeInformation();
        envelopeInformation.setDateTime(new Date());
        envelopeInformation.setEmployeeName(name);
        envelopeInformation.setDescription(description);
        envelopeInformation.setEnvelopeStatus(envelopeStatus);
        envelopeInformation.setEnvelope(envelope);
        envelope.getEnvelopeInformations().add(envelopeInformation);
        transaction.commit();
        session.close();
    }
    public static Employee findEmployee(String userName) {
        Transaction transaction = null;
        Employee employee = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            employee = (Employee) session.createQuery("FROM Employee E WHERE E.UserName = :userName").setParameter("userName", userName)
                    .uniqueResult();
            return employee;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return employee;
    }
    @SuppressWarnings("unchecked")
    @Deprecated
    public static List<Employee> fetchAllEmployee() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Employee.class);
        List<Employee> employees = criteria.list();
        session.close();
        System.out.println("*"+employees.size());
        return employees;
    }
    public static List<Employee> fetch() {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            List clerks = session.createQuery(
                    " FROM Employee "
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
