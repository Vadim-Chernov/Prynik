package cvr.pryanik.service;

import java.util.List;


public class JsonRootBean {

    private List<Data> data;
    private List<String> view;

    public void setData(List<Data> data) {
        this.data = data;
    }

    public List<Data> getData() {
        return data;
    }

    public void setView(List<String> view) {
        this.view = view;
    }

    public List<String> getView() {
        return view;
    }

}