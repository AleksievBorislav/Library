package com.library.repo.model;

import java.math.BigDecimal;

public class Book {
    long bookID;
    String title;
    int pageCount;

    public BigDecimal getPrice() {
        return price;
    }

    public int getReadersCount() {
        return readersCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getTitle() {
        return title;
    }

    public long getBookID() {
        return bookID;
    }

    int readersCount;
    BigDecimal price;

    public static final class BookBuilder {
        private long bookID;
        private String title;
        private int pageCount;
        private int readersCount;
        private BigDecimal price;

        BookBuilder() {
        }

        public static BookBuilder aBook() {
            return new BookBuilder();
        }

        public BookBuilder withBookID(long bookID) {
            this.bookID = bookID;
            return this;
        }

        public BookBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder withPageCount(int pageCount) {
            this.pageCount = pageCount;
            return this;
        }

        public BookBuilder withReadersCount(int readersCount) {
            this.readersCount = readersCount;
            return this;
        }

        public BookBuilder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Book build() {
            Book book = new Book();
            book.bookID = this.bookID;
            book.readersCount = this.readersCount;
            book.pageCount = this.pageCount;
            book.price = this.price;
            book.title = this.title;
            return book;
        }
    }
}
