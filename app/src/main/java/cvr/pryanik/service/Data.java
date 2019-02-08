package cvr.pryanik.service;

import java.util.List;

//@lombok.Data
public class Data {
    private Integer id;
    private String name;
    private Data data;
    private String text;
    private String url;
    private int selectedId;
    private List<Data> variants;

    public Integer getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(Integer selectedId) {
        this.selectedId = selectedId;
    }

    public List<Data> getVariants() {
        return variants;
    }

    public void setVariants(List<Data> variants) {
        this.variants = variants;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

}