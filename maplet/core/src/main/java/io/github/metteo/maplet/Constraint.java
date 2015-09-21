package io.github.metteo.maplet;

public interface Constraint<T> {

    /**
     * @param input
     * @return output
     */
    public T constrain(T input);
    
    /**
     * Human readable description of this constraint
     * @return
     */
    public String toString();
}
