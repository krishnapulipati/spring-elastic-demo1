package com.spring.elastic.springelasticdemo.load;

import com.spring.elastic.springelasticdemo.model.Users;
import com.spring.elastic.springelasticdemo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Loaders {


    @Autowired
    ElasticsearchOperations operations;

    @Autowired
    UsersRepository usersRepository;

    @PostConstruct
    @Transactional
    public void loadAll(){
        operations.putMapping(Users.class);
        //System.out.println("loading data");
        usersRepository.save(getData());

        //System.out.println("loading complected");
    }

    private List<Users> getData(){

        List<Users> usersses = new ArrayList<>();
        usersses.add(new Users("Ajay",123L,"Accounting",12000L));
        usersses.add(new Users("Vijay",133L,"Finance",17000L));
        usersses.add(new Users("Suresh",143L,"HR",22000L));
        usersses.add(new Users("Mahesh",125L,"Cosulting",32000L));
        return usersses;
    }

}
