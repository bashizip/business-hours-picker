package com.bashizip.bhlib;

import java.io.Serializable;
import java.util.Objects;

public abstract class BasePojo implements Serializable {
    public String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasePojo)) return false;
        BasePojo basePojo = (BasePojo) o;
        return Objects.equals(id, basePojo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
