package maman15;

public class PolyNode {
    int _power;
    double _coefficient;
    PolyNode _next;
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
    public PolyNode(PolyNode p)
    {
        this._power = p._power;
        this._coefficient = p._coefficient;
        this._next = p._next;

    }

    public int getPower() {
        return _power;
    }

    public void setPower(int power) {
        this._power = power;
    }

    public double getCoefficient() {
        return _coefficient;
    }

    public void setCoefficient(double coefficient) {
        this._coefficient = coefficient;
    }

    public PolyNode getNext() {
        return _next;
    }

    public void setNext(PolyNode next) {
        this._next = next;
    }
    public String toString()
    {
        if(this._power==0 && this._coefficient!=0) {
            if (this._coefficient == -1)
                return "-1";
            if (this._coefficient == 1)
                return "1";
            else return String.valueOf(_coefficient);
        }
        else if(this._coefficient==0)
            return "";
        else if(this._coefficient == -1)
        {
            if (this._power % 2 == 0)
                return String.format("x^%d",this._power);
            return String.format("-x^%d",this._power);
        }
        else if(this._coefficient==1 && this._power!=1)
            return String.format("x^%d",this._power);
        else if(this._power==1)
        {
           return String.format("%fe", this._coefficient);
        }
        else return String.format("%fx^%d",this._coefficient,this._power);

    }
}
