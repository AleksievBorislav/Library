package com.library.repo.model;

import java.sql.Time;

public class Borrowings {
    long bookId;
    long readerId;
    Time borrowTime;

    public long getBookId() {
        return bookId;
    }

    public long getReaderId() {
        return readerId;
    }

    public Time getBorrowTime() {
        return borrowTime;
    }

    public static final class BorrowingsBuilder {
        private long bookId;
        private long readerId;
        private Time borrowTime;

        BorrowingsBuilder() {
        }

        public static BorrowingsBuilder aBorrowings() {
            return new BorrowingsBuilder();
        }

        public BorrowingsBuilder withBookId(long bookId) {
            this.bookId = bookId;
            return this;
        }

        public BorrowingsBuilder withReaderId(long readerId) {
            this.readerId = readerId;
            return this;
        }

        public BorrowingsBuilder withBorrowTime(Time borrowTime) {
            this.borrowTime = borrowTime;
            return this;
        }

        public Borrowings build() {
            Borrowings borrowings = new Borrowings();
            borrowings.bookId = this.bookId;
            borrowings.borrowTime = this.borrowTime;
            borrowings.readerId = this.readerId;
            return borrowings;
        }
    }
}
