package com.example.smallbusinessmanagementsystem.utilities;

import com.example.smallbusinessmanagementsystem.model.Vartotojas;

public class CurrentVartotojas {
    private static final CurrentVartotojas INSTANCE = new CurrentVartotojas();
    private Vartotojas vartotojas;
    public static CurrentVartotojas getInstance() {
        return INSTANCE;
    }

    public Vartotojas getVartotojas() {
        return vartotojas;
    }

    public void setVartotojas(Vartotojas vartotojas) {
        this.vartotojas = vartotojas;
    }
}
