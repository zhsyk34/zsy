package com.cat.zsy.hb.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Book")
@AttributeOverrides({
        @AttributeOverride(
                name = "book.name",
                column = @Column(name = "book_name")
        ),
        @AttributeOverride(
                name = "paper.name",
                column = @Column(name = "paper_name")
        )
})

@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private Publisher book;

    private Publisher paper;

}