package calculator;

public enum OperatorType {
    ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/");

    private final String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public OperatorType getOpposite(String symbol) {
        if(this.symbol.equals(symbol)) {
            return this.equals(ADD) ? SUBTRACT : ADD;
        }
        return null;
    }
}

