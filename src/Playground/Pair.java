package Playground;

public class Pair<Key, Value> {

    public final Key key;
    public final Value value;
    public Pair(Key arg1, Value arg2){
        this.key = arg1;
        this.value = arg2;
    }

    public Key getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }
}
