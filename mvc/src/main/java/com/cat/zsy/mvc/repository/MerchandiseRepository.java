package com.cat.zsy.mvc.repository;

import com.cat.zsy.mvc.domain.Merchandise;
import com.cat.zsy.mvc.dto.MerchandiseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchandiseRepository extends JpaRepository<Merchandise, Long> {

    @Query(
            value = "SELECT new com.cat.zsy.mvc.dto.MerchandiseDTO (" +
                    "ms.MerchandiseStore.merchandise.id, ms.MerchandiseStore.merchandise.name, ms.MerchandiseStore.merchandise.code, ms.MerchandiseStore.merchandise.type.name, " +
                    "ms.MerchandiseStore.store.name, " +
                    "ms.specification, ms.price) " +
                    "FROM MerchandiseSpecification ms " +
                    "WHERE ms.MerchandiseStore.merchandise.name LIKE %:name% AND ms.MerchandiseStore.merchandise.code LIKE %:code%",
            countQuery = "SELECT COUNT(ms.id) FROM MerchandiseSpecification ms " +
                    "WHERE ms.MerchandiseStore.merchandise.name LIKE %:name% AND ms.MerchandiseStore.merchandise.code LIKE %:code%"
    )
    Page<MerchandiseDTO> findDTO(@Param("name") String name, @Param("code") String code, Pageable pageable);

    @Query(
            value = "SELECT new com.cat.zsy.mvc.dto.MerchandiseDTO (" +
                    "ms.MerchandiseStore.merchandise.id, ms.MerchandiseStore.merchandise.name, ms.MerchandiseStore.merchandise.code, ms.MerchandiseStore.merchandise.type.name, " +
                    "ms.MerchandiseStore.store.name, " +
                    "ms.specification, ms.price) " +
                    "FROM MerchandiseSpecification ms " +
                    "WHERE ms.MerchandiseStore.merchandise.name LIKE %:name% AND ms.MerchandiseStore.merchandise.code LIKE %:code% " +
                    "AND ms.MerchandiseStore.store.id IN (:stores)",
            countQuery = "SELECT COUNT(ms.id) FROM MerchandiseSpecification ms " +
                    "WHERE ms.MerchandiseStore.merchandise.name LIKE %:name% AND ms.MerchandiseStore.merchandise.code LIKE %:code% " +
                    "AND ms.MerchandiseStore.store.id IN (:stores)"
    )
    Page<MerchandiseDTO> findDTOFilterByStores(@Param("name") String name, @Param("code") String code, @Param("stores") List<Long> stores, Pageable pageable);

}
