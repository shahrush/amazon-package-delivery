import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PackageClass {

    private String size;
    private Boolean fragile;
    private Date sendDate;
    private Boolean prime;
    private String nextCity;
    private String origin;
    private String weight;
    private Map<String, Integer> sizeMap;

    public PackageClass(List<String> attributes) throws ParseException {
        initializeSizeMap();
        SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy hh:mmaa", Locale.getDefault());
        this.size = attributes.get(0).split(":")[1];
        this.fragile = Boolean.parseBoolean(attributes.get(1).split(":")[1]);
        this.sendDate =  format.parse(attributes.get(2).split(":",2)[1]);
        this.prime = Boolean.parseBoolean(attributes.get(3).split(":")[1]);
        this.nextCity = attributes.get(4).split(":")[1];
        this.origin = attributes.get(5).split(":")[1];
        this.weight = attributes.get(6).split(":")[1];
    }

    public PackageClass(String size, Boolean fragile, Date sendDate, Boolean prime, String nextCity, String origin, String weight){

        initializeSizeMap();
        this.size = size;
        this.fragile = fragile;
        this.sendDate = sendDate;
        this.prime = prime;
        this.nextCity =  nextCity;
        this.origin = origin;
        this.weight = weight;
    }

    public void initializeSizeMap(){
        sizeMap = new HashMap<>();
        sizeMap.put("Small", 1);
        sizeMap.put("Medium", 2);
        sizeMap.put("Large", 3);
        sizeMap.put("XL", 4);
    }

    public int getSizePriority() {
        return this.sizeMap.get(this.size);
    }

    public String getSize() { return this.size; }

    public Boolean isFragile() {
        return this.fragile;
    }

    public Date getSendDate() { return this.sendDate; }

    public Boolean isPrime() {
        return this.prime;
    }

    public String getNextCity() {
        return this.nextCity;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String getWeight() {
        return this.weight;
    }

    public void setFragile(Boolean fragile) {
        this.fragile = fragile;
    }

    public void setNextCity(String nextCity) {
        this.nextCity = nextCity;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setPrime(Boolean prime) {
        this.prime = prime;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
