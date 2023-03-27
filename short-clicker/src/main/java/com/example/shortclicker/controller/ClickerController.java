package com.example.shortclicker.controller;

import com.example.shortclicker.database.LongUrls;
import com.example.shortclicker.database.LongUrlsRepository;
import com.example.shortclicker.database.ShortUrls;
import com.example.shortclicker.database.ShortUrlsRepository;
import com.example.shortclicker.utility.UrlSubmit;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClickerController {
    @Autowired
    LongUrlsRepository longUrlsRepository;

    @Autowired
    ShortUrlsRepository shortUrlsRepository;

    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("urlSubmit", new UrlSubmit());
        return "main";
    }

    @PostMapping("/main")
    public String mainSubmit(@ModelAttribute UrlSubmit urlSubmit, Model model) {
        LongUrls longUrlObj = longUrlsRepository.findLongUrlsByUrl(urlSubmit.getUrl());
        ShortUrls shortUrls = null;
        if (longUrlObj != null) {
            shortUrls = new ShortUrls();
            shortUrls.setUrl("/" + RandomStringUtils.random(10, true, true));
            shortUrls.setLongUrlId(longUrlObj.getId());
            ShortUrls lastShortUrl = shortUrlsRepository.findFirstByOrderByIdDesc();
            shortUrls.setId(lastShortUrl.getId() + 1);
            shortUrlsRepository.save(shortUrls);
        }
        model.addAttribute("urlSubmit", urlSubmit);
        model.addAttribute("shortUrl", shortUrls);
        return "main";
    }
}
