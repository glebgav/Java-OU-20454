package maman15;

public class PolyNode {
    int _power;
    double _coefficient;
    PolyNode _next;

    //Defining Constructors:
    /** Creates a PolyNode Object
     * @param power The power of the PolyNode Object
     * @param coefficient The coefficient of the PolyNode Object
     */
    public PolyNode(int power, double coefficient)
    {
        if(power<0)
        {
            this._power=0;
            this._coefficient=0;
        }
        else{
            this._power=power;
            this._coefficient=coefficient;
        }
        this._next=null;
    }
    /** Creates a PolyNode Object
     * @param power The power of the PolyNode Object
     * @param coefficient The coefficient of the PolyNode Object
     * @param next The Next PolyNode of the PolyNode Object
     */
    public PolyNode(int power, double coefficient, PolyNode next)
    {
        if(power<0)
        {
            this._power=0;
            this._coefficient=0;
        }
        else{
            this._power=power;
            this._coefficient=coefficient;
        }
        this._next=next;

    }
    /** Creates a PolyNode Object
     * @param p Creates a PolyNode with the values of PolyNode n
     */
    public PolyNode(PolyNode p)
    {
        this._power = p.getPower();
        this._coefficient = p.getCoefficient();
        this._next = null;

    }

    /** a Get method for _power var
     * @return Returns the Power of the PolyNode
     */
    public int getPower() {
        return _power;
    }
    /** a Set method for _power var
     * @param power The Power of the PolyNode
     */
    public void setPower(int power) {
        this._power = power;
    }
    /** a Get method for _coefficient var
     * @return Returns the Coefficient of the PolyNode
     */
    public double getCoefficient() {
        return _coefficient;
    }
    /** a Set method for _coefficient var
     * @param coefficient The Coefficient of the PolyNode
     */
    public void setCoefficient(double coefficient) {
        this._coefficient = coefficient;
    }
    /** a Get method for _next var
     * @return Returns the Next Node of the PolyNode
     */
    public PolyNode getNext() {
        return _next;
    }
    /** a Set method for _next var
     * @param next The next Node of the PolyNode
     */
    public void setNext(PolyNode next) {
        this._next = next;
    }

    /**
     * @return string representation of PolyNode object
     */
    public String toString()
    {
        if(this._power==0 && this._coefficient!=0) {
            if (this._coefficient == -1)
                return "-1";
            if (this._coefficient == 1)
                return "1";
            else return String.format("%.1f",this._coefficient);
        }
        else if(this._coefficient==0)
            return "";
        else if(this._coefficient <0)
        {
            if (this._power==1&&this._coefficient==-1)
                return "-x";
            if(this._power==1)
                return String.format("%.1fx",this._coefficient);
            if (this._coefficient==-1)
                return String.format("-x^%d",this._power);
            return String.format("%.1fx^%d",this._coefficient,this._power);
        }
        else
        {
            if (this._power==1&&this._coefficient==1)
                return "x";
            if(this._power==1)
                return String.format("%.1fx",this._coefficient);
            if (this._coefficient==1)
                return String.format("x^%d",this._power);
            return String.format("%.1fx^%d",this._coefficient,this._power);
        }
    }
}
