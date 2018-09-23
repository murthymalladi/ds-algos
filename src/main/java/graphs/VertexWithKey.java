package graphs;

/**
 * Created by dmalladi on 8/15/2018.
 */
public class VertexWithKey {
    int id;
    int key;
    int parent;
    public VertexWithKey(int id,int key,int parent) {
        this.id = id;
        this.key = key;
        this.parent = parent;
    }

    public int getKey() {
        return key;
    }

    public int getParent() {
        return parent;
    }

    public int getId() {
        return id;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public String toString() {
        return id + " - > " + key;
    }

}
