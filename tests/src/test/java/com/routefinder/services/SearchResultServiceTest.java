package com.routefinder.services;

import com.routefinder.common.GenericServiceTest;
import com.routefinder.model.SearchResult;
import com.routefinder.service.SearchResultService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 31.03.16.
 */
@Transactional
public class SearchResultServiceTest extends GenericServiceTest<SearchResult, Integer, SearchResultService> {
    @Override
    protected SearchResult getEntity() {
        return entityGenerator.getPlannerEntity();
    }
}
