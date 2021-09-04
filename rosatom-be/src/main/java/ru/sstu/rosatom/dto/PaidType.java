package ru.sstu.rosatom.dto;

enum PaidType {
    FZ_44("FZ_44"),
    FZ_223("FZ_223");

    String name;

    PaidType(String name) {
        this.name = name;
    }
}
