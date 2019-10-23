package maman11;

public class FoodItem {
    private final String name;
    private final long catalogueNumber;
    private int quantity;
    private Date productionDate;
    private Date expiryDate;
    private final int minTemperature;
    private final int maxTemperature;
    private  int price;

    public FoodItem(String name, long catalogueNumber, int quantity, Date productionDate, Date expiryDate, int minTemperature, int maxTemperature, int price) {
        this.name = name;
        this.catalogueNumber = catalogueNumber;
        this.quantity = quantity;
        if(expiryDate.before(productionDate)){ this.expiryDate = productionDate.tomorrow(); }
        else{this.expiryDate = expiryDate;}
        this.productionDate = productionDate;
        if(minTemperature > maxTemperature){
            this.minTemperature = maxTemperature;
            this.maxTemperature = minTemperature;
        }
        else {
            this.minTemperature = minTemperature;
            this.maxTemperature = maxTemperature;
        }
        this.price = price;
    }
    
    public FoodItem(FoodItem other){
        this.name = other.name;
        this.catalogueNumber = other.catalogueNumber;
        this.quantity = other.quantity;
        this.expiryDate = other.expiryDate;
        this.productionDate = other.productionDate;
        this.minTemperature = other.minTemperature;
        this.maxTemperature = other.maxTemperature;
        this.price = other.price;
    }

    public String getName() {
        return name;
    }

    public long getCatalogueNumber() {
        return catalogueNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int n) {
        this.quantity = n;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date d) {
        this.productionDate = d;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date d) {
        this.expiryDate = d;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int n) {
        this.price = n;
    }
    
    public boolean equals(FoodItem other){
        boolean res = false;
        if(this.name.equals(other.name) &&
                this.catalogueNumber == other.catalogueNumber &&
                this.productionDate.equals(other.productionDate) &&
                this.expiryDate.equals(other.expiryDate) &&
                this.minTemperature == other.minTemperature &&
                this.maxTemperature == other.maxTemperature){
            res = true;
        }
        return res;
        }

    public boolean isFresh(Date d){
        boolean res = false;
        if(this.productionDate.before(d)){
            if(this.expiryDate.after(d) || this.expiryDate.equals(d)){
                res = true;
            }
        }
        return res;
    }

    public String toString(){
        return "FoodItem: "+this.name+"\tProductionDate: "+this.productionDate.toString()+"\tExpiryDate: "
                +this.expiryDate.toString()+"\tQuantity: "+this.quantity;
    }

    public boolean olderFoodItem(FoodItem other){
        return other.productionDate.after(this.productionDate);
    }

    public int howManyItems(int amount){
        int count = 0;
        while (this.quantity>0 && amount >= this.price){
            amount =  amount -this.price;
            this.quantity = this.quantity -1;
            count++;
        }
        return count;
    }

    public boolean isCheaper(FoodItem other){
        return other.price > this.price;
    }
}

