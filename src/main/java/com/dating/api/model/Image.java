package com.dating.api.model;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @NotNull
    private byte[] data;

    @NotNull
    private String fileName;

    @NotNull
    private String fileType;

    @NotNull
    private Long fileSize;

}
