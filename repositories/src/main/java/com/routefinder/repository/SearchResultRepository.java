package com.routefinder.repository;


import com.routefinder.model.SearchResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by karpukdm on 26.03.16.
 */

public interface SearchResultRepository extends JpaRepository<SearchResult, Integer> {

}
