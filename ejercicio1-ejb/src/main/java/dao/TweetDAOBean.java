/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.Tweet;
import models.TweetsBySentiment;

/**
 *
 * @author sergio
 */
@Stateless
public class TweetDAOBean implements TweetDAOBeanLocal {
    @PersistenceContext(unitName = "sentiment_PU")
    private EntityManager em;
    
    @Override
    public void persist(final Tweet tweet) {
        try {
            em.persist(tweet);
            em.flush();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void persist(List<Tweet> tweets) {
        try {
            Iterator<Tweet> ite = tweets.iterator();
            while(ite.hasNext())
                persist(ite.next());
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TweetsBySentiment> groupedBySentiment(final String topic) {
        try{
            return em.createNamedQuery("TweetsBySentiment").setParameter(1, topic).getResultList();
        }catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Tweet> byTopic(final String topic) {
        try{
            return em.createNamedQuery("Tweets.byTopic").setParameter("topic", topic).getResultList();
        }catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Tweet> byTopic(final String topic, final Integer count) {
        try{
            return em.createNamedQuery("Tweets.byTopic").setParameter("topic", topic).setMaxResults(count).getResultList();
        }catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
}
