package greedy;

/**
 *
 * @author alex aldaco
 */
public class Req {
    private String id;
    private int start, end;

    public Req() {

    }

    public Req(String id, int start, int end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return id + "[start(" + start + "), end(" + end + ")]";
    }

}
