package com.botko3.ramen.Repo;

import com.botko3.ramen.Model.RamenShop;
import com.botko3.ramen.Model.RamenShopProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RamenShopRepo extends JpaRepository<RamenShop,Integer>{


    @Query("SELECT e FROM RamenShop e ")
    List<RamenShopProjection> findByAll();

    @Query("SELECT e FROM RamenShop e where REPLACE(e.area,' ','')LIKE %:areaNoSpace% ")
    List<RamenShopProjection> findByAreaIgnoreCaseContaining (@Param("areaNoSpace") String areaNoSpace);

    @Query("SELECT i FROM RamenShop i WHERE :value BETWEEN i.minPrice AND i.maxPrice")
    List<RamenShopProjection> findItemsByValueRange(@Param("value") Integer value);

    @Query("SELECT k FROM RamenShop k WHERE k.id = :id")
    List<RamenShopProjection> findByItemID(@Param("id") Integer id);


    @Query("SELECT a FROM RamenShop a where REPLACE(a.area,' ','')LIKE %:areaNoSpace% AND :value BETWEEN a.minPrice AND a.maxPrice")
    List<RamenShopProjection> findByPriceAndArea(@Param("value") Integer value,@Param("areaNoSpace") String areaNoSpace);





}
