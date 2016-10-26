package com.msnishan.lab;

import com.msnishan.lab.dao.model.Address;
import com.msnishan.lab.dao.model.Language;
import com.msnishan.lab.dao.model.User;
import com.msnishan.lab.model.LanguageType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ksaleh on 9/26/16.
 */
public class Main {
    public static int computation = 0;
    public static Map<Integer, Integer> fibboMap = new HashMap<>();
    public static void main(String[] args) {


        SessionFactory sessionFactory = HibernateLab.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User previousUser = session.load(User.class, 1L);

        Language language1 = new Language();
        language1.setLanguageName("Java");
        language1.setLanguageType(LanguageType.COMPILED);

        Language language2 = new Language();
        language2.setLanguageName("VHDL");
        language2.setLanguageType(LanguageType.HDL);

        Language language3 = new Language();
        language3.setLanguageName("scala");
        language3.setLanguageType(LanguageType.FUNCTIONAL);

        List<Language> languages1 = Arrays.asList(language1, language2);
        List<Language> languages2 = Arrays.asList(language2, language3);


        previousUser.setLanguages(languages1);

        User user = new User();
        user.setFirstName("Khandekar");
        user.setLastName("Saleh");
        user.setMiddleName("Mohammad");
        user.setLanguages(languages2);

        session.save(user);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }



    public static int fibbo(int n) {
        int res;
        computation++;

        System.out.println("---> " + n);
        if (n <= 2 && n > 0) {
            res = 1;
        } else if (fibboMap.containsKey(n)) {
            res = fibboMap.get(n);
        }else {
            res =  fibbo(n - 1) + fibbo(n - 2);
            System.out.println(res);
            fibboMap.put(n, res);
        }
        return res;
    }
}
