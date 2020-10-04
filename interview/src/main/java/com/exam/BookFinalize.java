package com.exam;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/18 22:03
 */
public class BookFinalize {

    public static void main(String[] args) {
        Book novel = new Book(true);
        novel.checkIn();

        new Book(true);

        System.gc();
    }
}


class Book {

    boolean checkedOut = false;

    Book(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    void checkIn() {
        checkedOut = true;
    }

    @Override
    protected void finalize() throws Throwable {
        if (checkedOut) {
            System.out.println("Error: checked out.");
        }
    }
}
