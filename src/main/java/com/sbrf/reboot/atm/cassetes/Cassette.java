package com.sbrf.reboot.atm.cassetes;

import java.util.List;

public class Cassette<B extends Banknote>{
    private List<B> banknotes;

    public Cassette(List<B> banknotes) {
        this.banknotes = banknotes;
    }

    public int getCountBanknotes() {
        return banknotes.size();
    }
}
