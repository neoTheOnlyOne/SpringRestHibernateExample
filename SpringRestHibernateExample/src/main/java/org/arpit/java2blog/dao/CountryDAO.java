package org.arpit.java2blog.dao;

import java.util.List;

import org.arpit.java2blog.model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFctory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List getAllCountries() {
		Session session = this.sessionFactory.getCurrentSession();
		List countries = session.createQuery("").list();
		return countries;
	}

	public Country getCountry(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Country country = (Country) session.load(Country.class, new Integer(id));
		return country;
	}
	
	public Country addCountry(Country country) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(country);
		return country;
	}
	
	public void updateCountry(Country country) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(country);
	}
	
	public void deleteCountry(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Country c = (Country)session.load(Country.class, new Integer(id));
		if(c != null) {
			session.delete(c);
		}
	}
}
