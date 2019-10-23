package maman11;

public class Stock {
    private final int MAX_ITEMS = 100;
    private int _noOfItems;
    private FoodItem[] _stock;
    public Stock(){
        this._stock = new FoodItem[this.MAX_ITEMS];
        this._noOfItems = 0;
    }

    public int getNoOfItems() {
        return this._noOfItems;
    }

    public boolean addItem(FoodItem newItem){
        boolean res = true;
        boolean inStock = this.findItem(newItem);
        if(this._noOfItems == 100 && !inStock){
                res = false;
            }
        else if(!inStock){
            this._stock[_noOfItems] = newItem;
            this._noOfItems++;
        }
        this.sortStock();
        return res;
    }

    public String order(int amount){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<this._noOfItems;i++){
            int amountInStock = 0;
            for(int j = 0;j<this._noOfItems;j++){
                if( this._stock[j].getName().equals( this._stock[i].getName())) {
                    amountInStock+=  this._stock[j].getQuantity();
                }
            }
            if(amountInStock < amount){
                sb.append( this._stock[i].getName()).append(", ");
            }
        }
        String out = sb.toString();
        if(!out.equals("")){
            out= out.substring(0, out.length() - 2);
        }
        return out;
    }

    public int howMany(int temp){
        int amount = 0;
        for(int i = 0;i<this._noOfItems;i++){
            if((this._stock[i].getMinTemperature() <= temp) && (temp <= this._stock[i].getMaxTemperature())){
                amount++;
            }
        }
        return amount;
    }

    public void removeAfterDate(Date d){
        int numOfItemsRemoved = 0;
        for(int i=0;i<this._noOfItems;i++){
            if(!this._stock[i].isFresh(d)){
                this._stock[i] = null;
                numOfItemsRemoved++;
            }
        }
        if(this._noOfItems > numOfItemsRemoved) {
            this.sortStock();
        }
        this._noOfItems =  this._noOfItems - numOfItemsRemoved;
    }

    public FoodItem mostExpensive(){
        FoodItem maxItem = null;
        if(this._noOfItems == 0){
            return null;
        }
        else{
            int max = this._stock[0].getPrice();
            for (int i = 0;i<this._noOfItems;i++){
                if(this._stock[i].getPrice()>= max){
                    maxItem = this._stock[i];
                    max = this._stock[i].getPrice();
                }
            }
        }
        return maxItem;
    }

    public int howManyPieces(){
        int count = 0;
        for(int i = 0;i<this._noOfItems;i++){
            count+= this._stock[i].getQuantity();
        }
        return count;
    }

    public  void updateStock(String[] itemsList){
        for(String item: itemsList){
            for(int i=0;i<this._noOfItems;i++){
                if(this._stock[i].getName().equals(item)){
                    if(this._stock[i].getQuantity() == 1){
                        this._stock[i] = null;
                        this.sortStock();
                        this._noOfItems --;
                    }
                    else{
                        this._stock[i].setQuantity(this._stock[i].getQuantity()-1);
                    }
                }
            }
        }

    }

    public int getTempOfStock(){
        if(this._noOfItems == 0){
            return Integer.MAX_VALUE;
        }
        else{
            int[] tempValues = this.getMinAndMaxTemp();
            for(int i=tempValues[0];i<=tempValues[1];i++){
                if(this.howMany(i) == this._noOfItems){
                    return i;
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    private void sortStock() {
        // method for sorting _stock array after every action that modifies it using bubble sort algorithm.
        boolean sorted = false;
        if (this._noOfItems == 1) {
            // array of one is already sorted.
            sorted = true;
        }
        FoodItem temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < this._noOfItems - 1; i++) {
                if (this._stock[i] == null) {
                    this._stock[i] = this._stock[i + 1];
                    this._stock[i + 1] = null;
                    sorted = false;
                }
                else if (this._stock[i + 1] != null) {
                    if (this._stock[i].getCatalogueNumber() > this._stock[i + 1].getCatalogueNumber()) {
                        temp = this._stock[i];
                        this._stock[i] = this._stock[i + 1];
                        this._stock[i + 1] = temp;
                        sorted = false;
                    }


                }
                else {
                    break;
                }
            }
        }
    }

    private  boolean findItem(FoodItem newItem){
        // finds if the the item is already in _stock, if so ,will update quantity.
        boolean res = false;
        for (int i = 0;i<this._noOfItems;i++) {
            if(newItem.equals(this._stock[i])){
                this._stock[i].setQuantity(this._stock[i].getQuantity()+newItem.getQuantity());
                res =  true;
            }
        }
        return res;
    }

    private int[] getMinAndMaxTemp(){
        // return the min and max temp in all of the store ,[min,max].
        int min = this._stock[0].getMinTemperature();
        int max = this._stock[0].getMaxTemperature();
        for(int i=0;i<this._noOfItems;i++){
            if(this._stock[i].getMinTemperature()<min){
                min = this._stock[i].getMinTemperature();
            }
            if(this._stock[i].getMaxTemperature()>max){
                max = this._stock[i].getMaxTemperature();
            }
        }
        return new int[]{min, max};
    }
}

