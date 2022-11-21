package com.AltenAcadamy.Ruslan.bookStore.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.NonNull;

@Entity
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    private UUID id;

    @Column
    @NonNull
    private String title;

    @Column
    @NonNull
    private String description;

    @Column
    @NonNull
    private int releaseYear;
}
