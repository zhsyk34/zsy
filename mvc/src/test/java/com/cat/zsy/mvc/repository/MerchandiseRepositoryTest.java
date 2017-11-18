package com.cat.zsy.mvc.repository;

import com.cat.zsy.mvc.dto.MerchandiseDTO;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;

public class MerchandiseRepositoryTest extends InitContext {
    @Test
    public void findDTOFilterByStores() throws Exception {
        PageRequest pageable = PageRequest.of(0, 10);
        Page<MerchandiseDTO> data = merchandiseRepository.findDTOFilterByStores("", "", Arrays.asList(11L, 12L, 13L), pageable);
        data.forEach(System.out::println);
    }

    @Test
    public void findDTOFilterByStoreList() throws Exception {
    }

    @Test
    public void findDTOAll() throws Exception {
        PageRequest pageable = PageRequest.of(0, 10);
        Page<MerchandiseDTO> data = merchandiseRepository.findDTO("水果", "", pageable);
        data.forEach(System.out::println);
    }

}