package ru.nightmare.code.tree;

public class Token {
    LexicalType type;
    String value;
}

enum Type {
    string,
    integer,
    real,
    bool,
    object,
}
