package java_fx.rental_system2.model;

import java.util.ArrayList;
import java.util.List;

public class RentalSystem {
    private List<Property> properties;

    public RentalSystem() {
        this.properties = new ArrayList<>();
        loadData();
    }

    private void loadData() {
        this.properties.add(new Property("1","300 here",10,200.00,500.00));
        this.properties.add(new Property("2","301 here",11,201.00,501.00));
        this.properties.add(new Property("3","302 here",12,202.00,502.00));
        this.properties.add(new Property("4","303 here",13,203.00,503.00));
    }

    public List<Property> getProperties() {
        return properties;
    }

    public String getAllProperties() {
    String info = "";
    for (Property p:properties){
        info += p.toString()+"\r\n";
    }
    return info;
    }
}
