package com.msnishan.lab.dao.model;

import com.msnishan.lab.model.LanguageType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ksaleh on 10/22/16.
 */
@Entity
@Table(name = "LANGUAGES", catalog = "hibernate")
public class Language {

    @Id
    @GeneratedValue
    @Column(name = "LANGUAGE_ID")
    private long languageId;

    @Column(name = "LANGUAGE_NAME", nullable = false)
    private String languageName;

    @Column(name = "LANGUAGE_TYPE")
    @Enumerated(EnumType.STRING)
    private LanguageType languageType;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "languages")
    private List<User> users = new ArrayList<>();

    public Language() {
    }

    public long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(long languageId) {
        this.languageId = languageId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public LanguageType getLanguageType() {
        return languageType;
    }

    public void setLanguageType(LanguageType languageType) {
        this.languageType = languageType;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Language language = (Language) o;

        if (languageId != language.languageId) return false;
        if (languageName != null ? !languageName.equals(language.languageName) : language.languageName != null)
            return false;
        if (languageType != language.languageType) return false;
        return users != null ? users.equals(language.users) : language.users == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (languageId ^ (languageId >>> 32));
        result = 31 * result + (languageName != null ? languageName.hashCode() : 0);
        result = 31 * result + (languageType != null ? languageType.hashCode() : 0);
        result = 31 * result + (users != null ? users.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Language{" +
                "languageId=" + languageId +
                ", languageName='" + languageName + '\'' +
                ", languageType=" + languageType +
                ", users=" + users +
                '}';
    }
}
