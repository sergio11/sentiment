/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.TweetDAOBeanLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import models.Tweet;
import models.TweetsBySentiment;

/**
 *
 * @author sergio
 */
@Stateless
public class TweetsServiceBean implements TweetsServiceBeanLocal {
    
    @EJB
    private TweetDAOBeanLocal tweetDAOBean;

    @Override
    public List<TweetsBySentiment> groupedBySentiment(final String topic) {
        return tweetDAOBean.groupedBySentiment(topic);
    }

    @Override
    public List<Tweet> byTopic(final String topic) {
        return tweetDAOBean.byTopic(topic);
    }

    @Override
    public List<Tweet> byTopic(final String topic, final Integer count) {
        return tweetDAOBean.byTopic(topic, count);
    }
}
