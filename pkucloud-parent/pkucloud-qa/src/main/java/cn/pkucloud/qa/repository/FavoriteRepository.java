package cn.pkucloud.qa.repository;

import cn.pkucloud.qa.entity.Favorite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface FavoriteRepository extends PagingAndSortingRepository<Favorite, String> {
    Page<Favorite> findByUidAndType(String uid, String type, Pageable pageable);

    List<Favorite> findByUidAndType(String uid, String type);

    Favorite findByUidAndTypeAndOid(String uid, String type, String oid);
}
