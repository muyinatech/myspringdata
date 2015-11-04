package com.muyinatech.myspringdata.mongodb;

import com.mongodb.MongoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.net.UnknownHostException;
import java.util.Date;

import static org.springframework.data.mongodb.core.query.Criteria.where;

public class MongoApp {

    private static final Logger LOG = LoggerFactory.getLogger(MongoApp.class);

    public static void main(String[] args) throws UnknownHostException {
        MongoOperations mongoOps = new MongoTemplate(new MongoClient(), "mymongodb");
        mongoOps.insert(new Customer("Joe", "Bloggs"));

        Customer customer = mongoOps.findOne(new Query(where("firstName").is("Joe")), Customer.class);

        LOG.info(customer.toString());

        mongoOps.dropCollection("customer");

//        mongoOps.insert(new BlogPost("My Blog Post", "Here is my blog post", new Date()));
//        mongoOps.insert(new BlogPost("Day Trip To The Beach", "It was a sunny day", new Date()));
//        mongoOps.insert(new BlogPost("First time in London", "This is a very large city", new Date()));
//        mongoOps.insert(new BlogPost("My Blog Post", "Another blog post", new Date()));

        //mongoOps.remove(new Query(where("title").is("Day Trip To The Beach")), BlogPost.class);

       // mongoOps.updateFirst(new Query(where("title").is("Day Trip To The Beach")), Update.update("content", "It was a cloudy day"), BlogPost.class);
      //  BlogPost blogPost = mongoOps.findOne(new Query(where("title").is("My Blog Post")), BlogPost.class);
//        LOG.info(blogPost.toString());

        mongoOps.findAll(BlogPost.class);


        //mongoOps.dropCollection("blogPost");
    }
}
