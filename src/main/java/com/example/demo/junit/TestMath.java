package com.example.demo.junit;

import java.util.List;

public class TestMath {
    public Integer addAllIn(List<Integer> list)
    {
        return list.stream().reduce((x, y) -> x+y).get();
    }
}
