package edu.ucsb.cs56.pconrad.parsing;

public class Parser {
    // begin instance variables
    private final String input;
    private int position;
    // end instance variables
    
    public Parser(final String input) {
        this.input = input;
    }

    public char tokenAt(final int position)
        throws ParseException {
        if (position < 0 || position >= input.length()) {
            throw new ParseException("expected token");
        } else {
            return input.charAt(position);
        }
    }
    
    public int parseDigit(final int position) throws ParseException {
        final char c = tokenAt(position);
        if (Character.isDigit(c)) {
            return position + 1;
        } else {
            throw new ParseException("Expected digit: " + c);
        }
    }

    public int parseInteger(final int position)
        throws ParseException {
        int newPosition = parseDigit(position);
        try {
            while (true) {
                newPosition = parseDigit(newPosition);
            }
        } catch (ParseException e) {}

        return newPosition;
    }

    public int parseOperator(final int position) throws ParseException {
        switch (tokenAt(position)) {
        case '+':
        case '-':
            return position + 1;
        default:
            throw new ParseException("Expected operator");
        }
    }
    
    public int parseTerm(final int position) throws ParseException {
        int newPosition = parseInteger(position);
        try {
            final int tempPosition = parseOperator(newPosition);
            newPosition = parseTerm(tempPosition);
        } catch (ParseException e) {}

        return newPosition;
    }
    
    public boolean parse() {
        boolean retval = true;
        try {
            final int pos = parseTerm(0);
            if (pos < input.length()) {
                throw new ParseException("Characters left");
            }
        } catch (ParseException e) {
            retval = false;
        }
        return retval;
    }
}

