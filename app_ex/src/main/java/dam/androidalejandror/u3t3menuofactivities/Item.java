package dam.androidalejandror.u3t3menuofactivities;

import java.io.Serializable;

public class Item implements Serializable {
    private String version, api, name, year, wiki;
    private int icon;

    public Item() {
    }

    public Item(String cantante, String nacionalidad, String androidVer, int imgCantante) {
        this.version = cantante;
        this.api = nacionalidad;
        this.name = androidVer;
        this.icon = imgCantante;
    }

    public Item(String version, String api, String name,int icon,String year,String wiki) {
        this.version = version;
        this.api = api;
        this.name = name;
        this.icon = icon;
        this.year = year;
        this.wiki = wiki;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getWiki() {
        return wiki;
    }

    public void setWiki(String wiki) {
        this.wiki = wiki;
    }

    @Override
    public String toString() {
        return "Item{" +
                "version='" + version + '\'' +
                ", api='" + api + '\'' +
                ", name='" + name + '\'' +
                ", icon=" + icon +
                '}';
    }
}
