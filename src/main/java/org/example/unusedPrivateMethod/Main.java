package org.example.unusedPrivateMethod;

import static java.util.Collections.emptyMap;
import static java.util.Collections.emptySet;

import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {
        Library library = new Library(emptySet());
        Map<String, Map<String, String>> map = new Main().run(library);
        System.out.println(map);
    }

    private Map<
        String,
        Map<String, String>
        > run(Library library) {
        return library
            .books()
            .stream()
            .map(
                book ->
                    book
                        .lenders()
                        .stream()
                        .collect(
                            Collectors.toMap(
                                Lender::name,
                                lender ->
                                    Map.of(
                                        book.title(),
                                        lender.status()
                                    )
                            )
                        )
            )
            .reduce(this::reduceBooksAndLenderStatusByLender)
            .orElse(emptyMap());
    }

    private Map<
        String,
        Map<String, String>
        > reduceBooksAndLenderStatusByLender(
        Map<String, Map<String, String>> previousMap,
        Map<String, Map<String, String>> nextMap
    ) {
        previousMap.putAll(nextMap);
        return previousMap;
    }
}

record Library(Collection<Book> books) {}
record Book(String title, Collection<Lender> lenders) {}
record Lender(String name, String status) {}
