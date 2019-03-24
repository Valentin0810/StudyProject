package com.varvashevich.entity;

import java.io.Serializable;

public interface BaseEntity <T extends Serializable> {

    T getId();
}