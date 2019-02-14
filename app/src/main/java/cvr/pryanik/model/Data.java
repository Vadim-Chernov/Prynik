package cvr.pryanik.model;

import java.util.List;
@lombok.Data
public class Data {
    private Integer id;
    private String name;
    private Data data;
    private String text;
    private String url;
    private int selectedId;
    private List<Data> variants;


}