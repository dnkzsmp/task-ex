package com.example.shortclicker.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortUrlsRepository extends JpaRepository<ShortUrls, Integer> {
    ShortUrls findFirstByOrderByIdDesc();
    ShortUrls findShortUrlsByUrl(String url);
}
