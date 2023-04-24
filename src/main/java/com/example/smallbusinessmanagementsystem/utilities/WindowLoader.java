package com.example.smallbusinessmanagementsystem.utilities;

public class WindowLoader {
    private static final WindowLoader INSTANCE = new WindowLoader();

    private boolean tabPardavimai = false;
    private boolean tabSandelis = false;
    private boolean tabTvarkarastis = false;
    private boolean tabKlientai = false;
    private boolean tabKonfiguracija = false;
    private boolean tabFinansai = false;
    private boolean tabStatistika = false;

    private boolean tabKonfiguracijaDarbuotojai = false;
    private boolean tabKonfiguracijaProduktai = false;
    private boolean tabKonfiguracijaZymes = false;
    private boolean tabStatistikaFinansai = false;
    private boolean tabStatistikaKlientai = false;
    private boolean tabStatistikaProduktai = false;
    private boolean tabStatistikaZymes = false;

    public static WindowLoader getInstance()
    {
        return INSTANCE;
    }

    public boolean isTabPardavimai() {
        return tabPardavimai;
    }

    public void setTabPardavimai(boolean tabPardavimai) {
        this.tabPardavimai = tabPardavimai;
    }

    public boolean isTabSandelis() {
        return tabSandelis;
    }

    public void setTabSandelis(boolean tabSandelis) {
        this.tabSandelis = tabSandelis;
    }

    public boolean isTabTvarkarastis() {
        return tabTvarkarastis;
    }

    public void setTabTvarkarastis(boolean tabTvarkarastis) {
        this.tabTvarkarastis = tabTvarkarastis;
    }

    public boolean isTabKlientai() {
        return tabKlientai;
    }

    public void setTabKlientai(boolean tabKlientai) {
        this.tabKlientai = tabKlientai;
    }

    public boolean isTabKonfiguracija() {
        return tabKonfiguracija;
    }

    public void setTabKonfiguracija(boolean tabKonfiguracija) {
        this.tabKonfiguracija = tabKonfiguracija;
    }

    public boolean isTabFinansai() {
        return tabFinansai;
    }

    public void setTabFinansai(boolean tabFinansai) {
        this.tabFinansai = tabFinansai;
    }

    public boolean isTabStatistika() {
        return tabStatistika;
    }

    public void setTabStatistika(boolean tabStatistika) {
        this.tabStatistika = tabStatistika;
    }

    public boolean isTabKonfiguracijaDarbuotojai() {
        return tabKonfiguracijaDarbuotojai;
    }

    public void setTabKonfiguracijaDarbuotojai(boolean tabKonfiguracijaDarbuotojai) {
        this.tabKonfiguracijaDarbuotojai = tabKonfiguracijaDarbuotojai;
    }

    public boolean isTabKonfiguracijaProduktai() {
        return tabKonfiguracijaProduktai;
    }

    public void setTabKonfiguracijaProduktai(boolean tabKonfiguracijaProduktai) {
        this.tabKonfiguracijaProduktai = tabKonfiguracijaProduktai;
    }

    public boolean isTabKonfiguracijaZymes() {
        return tabKonfiguracijaZymes;
    }

    public void setTabKonfiguracijaZymes(boolean tabKonfiguracijaZymes) {
        this.tabKonfiguracijaZymes = tabKonfiguracijaZymes;
    }

    public boolean isTabStatistikaFinansai() {
        return tabStatistikaFinansai;
    }

    public void setTabStatistikaFinansai(boolean tabStatistikaFinansai) {
        this.tabStatistikaFinansai = tabStatistikaFinansai;
    }

    public boolean isTabStatistikaKlientai() {
        return tabStatistikaKlientai;
    }

    public void setTabStatistikaKlientai(boolean tabStatistikaKlientai) {
        this.tabStatistikaKlientai = tabStatistikaKlientai;
    }

    public boolean isTabStatistikaProduktai() {
        return tabStatistikaProduktai;
    }

    public void setTabStatistikaProduktai(boolean tabStatistikaProduktai) {
        this.tabStatistikaProduktai = tabStatistikaProduktai;
    }

    public boolean isTabStatistikaZymes() {
        return tabStatistikaZymes;
    }

    public void setTabStatistikaZymes(boolean tabStatistikaZymes) {
        this.tabStatistikaZymes = tabStatistikaZymes;
    }
}
