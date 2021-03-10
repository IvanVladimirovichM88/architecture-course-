package ru.geekbrains.erpsystem.data;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MultiPartData extends SimplePartData implements Serializable {

    private List<Long> simplePartsId = new ArrayList<>();

    private List<Long> multiPartsId = new ArrayList<>();

    private List<SimplePartData> simplePartDataList = new ArrayList<>();

    private List<MultiPartData> multiPartDataList = new ArrayList<>();


}
