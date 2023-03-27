package com.example.shortclicker.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LongUrlsRepository extends JpaRepository<LongUrls, Integer> {
    LongUrls findLongUrlsByUrl(String url);
    LongUrls findLongUrlsById(Integer id);
}
