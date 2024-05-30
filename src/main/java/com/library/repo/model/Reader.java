package com.library.repo.model;

public class Reader {
    long id;
    String name;
    short age;
    int bookCount;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public short getAge() {
        return age;
    }

    public int getBookCount() {
        return bookCount;
    }


    public static final class ReaderBuilder {
        private long id;
        private String name;
        private short age;
        private int bookCount;

        ReaderBuilder() {
        }

        public static ReaderBuilder aReader() {
            return new ReaderBuilder();
        }

        public ReaderBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public ReaderBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ReaderBuilder withAge(short age) {
            this.age = age;
            return this;
        }

        public ReaderBuilder withBookCount(int bookCount) {
            this.bookCount = bookCount;
            return this;
        }

        public Reader build() {
            Reader reader = new Reader();
            reader.id = this.id;
            reader.age = this.age;
            reader.bookCount = this.bookCount;
            reader.name = this.name;
            return reader;
        }
    }
}
