package ru.nightmare.code.tree;

public class LexicalToken {
    LexicalType type;
    String value;

}

enum LexicalType {
    type,
    name,
    set,
    call,
    body_start,
    body_end,
    arg_start,
    arg_end,
    comment_start,
    comment_end,
    arg_separator,
    line_end,
    referencing,
    expression,
    operator,
}
