package com.ugrcyo.first.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "post")
@Data
public class post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique = true,nullable = false)
    private Long Id;

    @Column(name = "title",length = 200)
    private String title;

    @Column(name = "text",length = 500)
    private String text;
}
