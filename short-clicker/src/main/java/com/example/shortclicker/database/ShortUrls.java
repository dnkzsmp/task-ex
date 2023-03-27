package com.example.shortclicker.database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "shorturls")
@RequiredArgsConstructor
@Getter
@Setter
public class ShortUrls {
    @Id
    private Integer id;

    @Column(name = "url")
    private String url;

    @Column(name = "longurl_id")
    private Integer longUrlId;
}
