/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import models.Group;

/**
 *
 * @author sergio
 */
@Local
public interface GroupDAOBeanLocal {

    List<Group> all();

    Group byName(final String name);
    
}
