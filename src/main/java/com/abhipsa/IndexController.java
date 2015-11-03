/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abhipsa;

import java.util.Random;
import javax.annotation.PostConstruct;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author user
 */
@Controller
@RequestMapping(value = "/circle")
public class IndexController {
    
    

    private Logger logger = Logger.getLogger(IndexController.class);

    private SessionFactory sf=null;
    @PostConstruct
    private void init(){
        Configuration cfg = new Configuration();
        sf = cfg.buildSessionFactory();
    }
//    Configuration cfg = new Configuration();
    // cfg.configure();
//    SessionFactory sf = cfg.buildSessionFactory();

//    CircleData circledata = new CircleData();
//    List<CircleStructure> circleDatabase = circledata.listCircleData();
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    @ResponseBody
//    public List<CircleStructure> getAllCircle() {
//
//        logger.info("This is an info log entry get");
//        logger.error("This is an error log entry");
//        return circleDatabase;
//    }
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public CircleStructure getCircle(@PathVariable("id") int id) {
//
//
//        for (CircleStructure circleData : circleDatabase) {
//            if (id == circleData.id) {
//                return circleData;
//
//            }
//        }
//        return null;
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    @ResponseBody
//    public CircleStructure putCircle(@PathVariable("id") int id, @RequestBody CircleStructure circle) {
//
//        System.out.println(circle);
//        for (CircleStructure circleData : circleDatabase) {
//            if (id == circleData.id) {
//
//                circleData.setName(circle.name);
//                return circleData;
//            }
//        }
//        return null;
//    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public CircleStructure postCircle(@RequestBody CircleStructure circleWithoutId) {

        System.out.println(circleWithoutId);
        logger.info("This is an info log entry post");
        logger.info(circleWithoutId);
        Session hsession = sf.openSession();
        Transaction tx = hsession.beginTransaction();
        
        CircleStructure circleNew = new CircleStructure();
        circleNew.setName(circleWithoutId.getName());
        
        Random random = new Random(System.currentTimeMillis());
        circleNew.setId(random.nextInt());
        hsession.save(circleNew);
        
        tx.commit();
        return circleNew;


    }
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    @ResponseBody
//    public CircleStructure delCircle(@PathVariable("id") int id) {
//
//       for (CircleStructure circleData : circleDatabase) {
//            if (id == circleData.id) {
//
//             circleDatabase.remove(circleData);
//              return circleData;
//
//                }
//        }
//        return null;
//
//    }
}
