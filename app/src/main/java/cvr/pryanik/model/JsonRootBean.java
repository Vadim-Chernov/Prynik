package cvr.pryanik.model;

import java.util.List;

import cvr.pryanik.model.Data;

@lombok.Data

public class JsonRootBean {

    private List<Data> data;
    private List<String> view;


}