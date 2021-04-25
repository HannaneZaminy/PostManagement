package com.post.service;

import com.post.model.entity.*;
import com.post.model.dao.CustomerDao;
import com.post.model.dao.EmployeeDao;
import com.post.model.dao.EnvelopDao;
import com.post.model.dao.EnvelopeInformationDao;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PostService {
    public static void registerCustomer(String password,
                                        Long phone,
                                        String email,
                                        String state,
                                        String city,
                                        String address,
                                        String name,
                                        String userName) {
        Address address4 = new Address(state, city, address);
        Customer customer = new Customer(password, phone, email, address4, name, userName);
        CustomerDao.save(customer);

    }


    public static void registerEmployee(String password,
                                        Long phone,
                                        String email,
                                        String state,
                                        String city,
                                        String address,
                                        String name,
                                        String userName) {
        Address addresss = new Address(state, city, address);
        Employee employee = new Employee(password, phone, email, addresss, name, userName);
        EmployeeDao.save(employee);

    }

    public static boolean checkLogin(String userName, String password) {
        Customer customer = CustomerDao.findCustomer(userName);
        if (customer != null && customer.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
    public static boolean checkLoginForEmployee(String userName, String password) {
        Employee employee = EmployeeDao.findEmployee(userName);
        if (employee != null && employee.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public static boolean checkRegisterByUsername(String userName) {
        Customer checkDuplicateUsername = CustomerDao.findCustomer(userName);

        if (checkDuplicateUsername != null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkRegisterByEmail(String email) {
        Customer checkDuplicateEmail = CustomerDao.checkDuplicateEmail(email);

        if (checkDuplicateEmail != null) {
            return true;
        } else {
            return false;
        }
    }
    private static List<EnvelopeInformation> getEnvelopInformation(Envelope envelope) {
        List<EnvelopeInformation> allEnvelopeInformationList = EnvelopeInformationDao.fetchAllEnvelop();
        List<EnvelopeInformation> envelopeInformations = allEnvelopeInformationList.stream().filter(envelopeInformation -> envelopeInformation.getEnvelope() == envelope).collect(Collectors.toList());
        return envelopeInformations;
    }

//    private static EnvelopeStatus checkTheStatusForCustomerGetlastStatus(int trackingNumber) {
//        EnvelopeInformation envelopeInformation = EnvelopDao.checkThestatus(trackingNumber);
//        EnvelopeStatus envelopeStatus = envelopeInformation.getEnvelopeStatus();
//        return envelopeStatus;
//    }

  /*      public static String checkTheStatusForCustomer(int trackingNumber) {
        EnvelopeStatus envelopeStatus = checkTheStatusForCustomerGetlastStatus(trackingNumber);
        Date date = checkTheStatusForCustomerGetTime(trackingNumber);
        String result = null;
        if (envelopeStatus == EnvelopeStatus.Pending) {
            result = "Your order has been successfully registered in " + date + " and is awaiting confirmation";
        } else {
            result ="Customization with this profile is not registered for you!!";
        }
        return result;
    }*/

    public static String checkTheStatusForCustomer(int trackingNumber, String username) {
        String result = null;
        Envelope envelope = checkMachCustomerAndEnvelope(trackingNumber, username);
        if (envelope != null) {
            List<EnvelopeInformation> envelopInformation = getEnvelopInformation(envelope);
            Date registerTime = envelopInformation.get(1).getDateTime();
            Date acceptTime = envelopInformation.get(2).getDateTime();
            Date sendingTime = envelopInformation.get(3).getDateTime();
            Date deliveryTime = envelopInformation.get(4).getDateTime();

        } else {
            result = "Customization with this profile is not registered for you!!";
        }
        return result;
    }

    public static Envelope checkMachCustomerAndEnvelope(int trackingNumber, String username) {
        Customer customer = CustomerDao.findCustomer(username);
        Envelope envelop = EnvelopDao.findEnvelop(trackingNumber);
        if (envelop.getCustomer().getUserName().equals(customer.getUserName())){
            return envelop;
        }
        return null;
    }





}
