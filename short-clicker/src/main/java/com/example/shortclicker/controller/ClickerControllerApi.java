package com.example.shortclicker.controller;

import com.example.shortclicker.database.LongUrls;
import com.example.shortclicker.database.LongUrlsRepository;
import com.example.shortclicker.database.ShortUrls;
import com.example.shortclicker.database.ShortUrlsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1")
public class ClickerControllerApi {
    @Autowired
    LongUrlsRepository longUrlsRepository;
    @Autowired
    ShortUrlsRepository shortUrlsRepository;

    @GetMapping
    public ResponseEntity<String> getLongUrl(@RequestParam(name = "url") String url) {
        url = url.replace("https://", "");
        ShortUrls shortUrl = shortUrlsRepository.findShortUrlsByUrl(url);
        if (shortUrl != null) {
            LongUrls longUrl = longUrlsRepository.findLongUrlsById(shortUrl.getLongUrlId());
            return new ResponseEntity<>(longUrl.getUrl(), HttpStatus.OK);
        }
        return new ResponseEntity<>("https://localhost:8080/main", HttpStatus.NOT_FOUND);
    }
}
