package com.msnishan.lab;

import com.msnishan.lab.dao.model.Address;
import com.msnishan.lab.dao.model.Language;
import com.msnishan.lab.dao.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by ksaleh on 10/16/16.
 */
public class HibernateLab {

    public static SessionFactory getSessionFactory() {

        return new Configuration()
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Address.class)
                    .addAnnotatedClass(Language.class)
                    .buildSessionFactory();

    }
}
