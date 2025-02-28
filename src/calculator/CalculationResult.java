package calculator;

public class CalculationResult<T> {
    public String expression;
    public T result;

    CalculationResult(String expression, T result){
        this.expression = expression;
        this.result = result;
    }
}
