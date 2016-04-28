package com.routefinder.service;

import com.routefinder.model.SearchResult;
import com.routefinder.service.common.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by karpukdm on 29.03.16.
 */
public interface SearchResultService extends GenericService<SearchResult, Integer> {

    Page<SearchResult> findLastRecords(Pageable pageable);
}
