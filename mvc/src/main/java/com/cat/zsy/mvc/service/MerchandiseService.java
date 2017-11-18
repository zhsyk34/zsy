package com.cat.zsy.mvc.service;

import com.cat.zsy.mvc.repository.MerchandiseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MerchandiseService {
    private final MerchandiseRepository merchandiseRepository;

}
