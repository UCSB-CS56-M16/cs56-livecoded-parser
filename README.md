# Livecoded Parser #

This parser was livecoded in class between Tuesday and Wednesday (July 12-13 2016).
The parser handles the following grammar:

```
digit ::= '0' | '1' | '2' | '3' | '4' | '5' | '6' | '8' | '9'
int ::= digit digit*
op ::= '+' | '-'
term ::= int | int op term
```

...with `term` being the toplevel production.
Blends tokenization with parsing; its input is simply a `String`.
Assumes that the input string contains only tokens from the above.

This is more correctly a recognizer as opposed to a parser.
That is, it returns whether or not an input can be parsed (as a `boolean`), as opposed to producing an AST.

While relatively simple, this demonstrates all the core concepts in parsing; more complex grammars merely means the code gets longer, without adding in any fundamentally new ideas.
