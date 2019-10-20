package maman11;


public class Date {
    private int int_day;
    private int int_month;
    private int int_year;
    public Date(Date other){
        this.int_day = other.getDay();
        this.int_month = other.getMonth();
        this.int_year = other.getYear();
    }
    private Date(int day, int month, int year){
        if(this.checkDate(day, month, year)){
            this.int_day = day;
            this.int_month = month;
            this.int_year = year;
        }
        else{
            this.int_day = 1;
            this.int_month = 1;
            this.int_year = 2000;
        }
    }
    private boolean checkDate(int day, int month, int year){
        boolean res = true;
        if(year<0 || String.valueOf(year).length() != 4){
            res = false;
        }
        else {
            if (month > 12 || month < 1) {
                res = false;
            }
            else {
                int[] monthswith31 = {1,3,5,7,8,10,12};
                int[] monthswith30 = {4,6,9,11};

                if (day > 31 || day < 1) {
                    res = false;
                }
                else{
                    if(month == 2){
                        if(day > 29){
                            res =  false;
                        }
                        if(day == 29){
                            if (year%4 != 0){res = false;}
                        }
                    }
                    if(this.isInList(monthswith30, month)){
                        if(day>30){res = false;}
                    }
                    }

            }
        }
        return res;
    }
    private boolean isInList(int[] arr, int month){
        boolean res = false;
        for (int value : arr) {
            if (value == month) {
                res = true;
                break;
            }
        }
        return res;
    }
    private int calcDays(Date other) {
        int sum = 0;
        int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
            if (this.after(other)) {
                sum += this.getDay() + (months[other.getMonth() - 1] - other.getDay());
                for (int i = other.getMonth(); i < this.getMonth()-2; i++)
                    sum += months[i];
            } else {
                sum += other.getDay() + (months[this.getMonth() - 1] - this.getDay());
                for (int i = this.getMonth(); i < other.getMonth()-2; i++)
                    sum += months[i];
            }
        return sum;
    }
    private int getDay() {
        return int_day;
    }
    public void setDay(int dayToSet) {
        if(checkDate(dayToSet, this.int_month,this.int_year)) {
            this.int_day = dayToSet;
        }
    }
    private int getMonth() {
        return int_month;
    }
    public void setMonth(int mountToSet) {
        if(checkDate(this.int_day, mountToSet,this.int_year)) {
            this.int_month = mountToSet;
        }
    }
    private int getYear() {
        return int_year;
    }
    public void setYear(int yearToSet) {
        if(checkDate(this.int_day, this.int_month,yearToSet)) {
            this.int_year = yearToSet;
        }
    }
    private boolean after(Date other){
        return other.before(this);
    }
    private boolean before(Date other){
        boolean res = false;
        if(this.int_year < other.getYear()){
            res = true;
        }
        if(this.int_year == other.getYear()){
            if(this.int_month < other.getMonth()){
                res = true;
            }
            if(this.int_month == other.getMonth()){
                if(this.int_day < other.getDay()){res = true;}
            }
        }
        return res;
    }
    private int difference(Date other){
        int sum = 0;
        int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
        if(this.equals(other)){ return sum;}
        else if(this.getMonth() == other.getMonth()) {
            sum += Math.abs(this.getDay()-other.getDay()) +  (365*Math.abs(this.getYear()-other.getYear()));
        }
        else{
            if (this.getYear() == other.getYear()) {sum += this.calcDays(other);}
            else if(Math.abs(this.getYear()-other.getYear()) > 1){
                sum += this.calcDays(other) + (365*Math.abs(this.getYear()-other.getYear()));
            }
            else{
                if(this.after(other)){
                    sum+=this.calcDays(new Date(1,1,this.getYear())) +
                            other.calcDays(new Date(31,1,other.getYear()));
                }
                else{
                    sum+=other.calcDays(new Date(1,1,other.getYear())) +
                            this.calcDays(new Date(31,1,this.getYear()));
                }
            }
        }
        return sum;
    }
    private boolean equals(Date other){
        boolean res = true;
        if(this.int_day != other.getDay()){res= false;}
        if(this.int_month != other.getMonth()){res= false;}
        if(this.int_year != other.getYear()){res= false;}
        return res;
    }
    public Date tomorrow(){
        int[] monthswith31 = {1,3,5,7,8,10,12};
        int[] monthswith30 = {4,6,9,11};
        int other_day;
        int other_month;
        int other_year;
        if(this.equals(new Date(31,12,this.getYear()))){
            other_day = 1;
            other_month = 1;
            other_year = this.getYear() + 1;
        }
        else if(this.isInList(monthswith30, this.getMonth()) && this.getDay() == 30){
            other_day = 1;
            other_month = this.getMonth() + 1;
            other_year = this.getYear();
        }
        else if(this.isInList(monthswith31, this.getMonth()) && this.getDay() == 31){
            other_day = 1;
            other_month = this.getMonth() + 1;
            other_year = this.getYear();
        }
        else if(this.getMonth() == 2 && (this.getDay() == 28 || this.getDay() == 29)){
            other_day = 1;
            other_month = this.getMonth() + 1;
            other_year = this.getYear();
        }
        else{
            other_day = this.getDay() + 1;
            other_month = this.getMonth();
            other_year = this.getYear();
        }
        return new Date(other_day,other_month,other_year);
    }
    public String toString() {
        return this.getDay() + " / " + this.getMonth() + " / " + this.getYear();
    }

    public static void main(String[] args) {
        Date date1 = new Date(30,1,2001);
        Date date2 = new Date(26,2,2001);
        System.out.println(date1.after(date1));
    }
}
