package com.routefinder.service.impl;

import com.routefinder.model.FavoriteRoute;
import com.routefinder.model.SearchResult;
import com.routefinder.repository.SearchResultRepository;
import com.routefinder.service.SearchResultService;
import com.routefinder.service.common.impl.GenericServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by karpukdm on 29.03.16.
 */
@Service
@Transactional
public class SearchResultServiceImpl extends GenericServiceImpl<SearchResult, Integer, SearchResultRepository>
        implements SearchResultService {


    @Override
    public Page<SearchResult> findLastRecords(Pageable pageable) {
        return repository.findAll(pageable);
    }

}
