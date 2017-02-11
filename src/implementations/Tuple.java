package implementations;

/**
 * Created by yasir_mukhtar on 1/26/17.
 */
public class Tuple<T> {
    private T t1,t2;

    public Tuple(T t1) {
        this.t1 = t1;
    }

    public T getT1() {
        return t1;
    }

    public void setT1(T t1) {
        this.t1 = t1;
    }
}
