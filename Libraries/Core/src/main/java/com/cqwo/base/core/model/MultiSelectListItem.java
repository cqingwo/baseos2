package com.cqwo.base.core.model;

import java.util.ArrayList;
import java.util.List;

public class MultiSelectListItem {

    public SelectListItem item;

    public List<SelectListItem> itemList = new ArrayList<>();

    public MultiSelectListItem() {

    }

    public MultiSelectListItem(SelectListItem item) {
        this.item = item;
    }

    public MultiSelectListItem(SelectListItem item, List<SelectListItem> itemList) {
        this.item = item;
        this.itemList = itemList;
    }
}
