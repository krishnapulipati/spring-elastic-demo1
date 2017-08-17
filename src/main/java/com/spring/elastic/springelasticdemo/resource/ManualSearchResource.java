package com.spring.elastic.springelasticdemo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.elastic.springelasticdemo.builder.SearchQueryBuilder;
import com.spring.elastic.springelasticdemo.model.Users;

@RestController
@RequestMapping("/rest/search/manual")
public class ManualSearchResource {

	@Autowired
    private SearchQueryBuilder searchQueryBuilder;	

    @GetMapping(value = "/{text}")
    public List<Users> getAll(@PathVariable final String text) {
        return searchQueryBuilder.getAll(text);
    }
}
