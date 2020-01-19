package maman15;

public class Polynom {
    PolyNode _head;

    //Defining Constructors:
    /** Creates a Polynom Object and setting it's head to null
     Default Constructor
     */
    public Polynom() {
        this._head = null;
    }
    /** sets p to be the _head
     @param p The first PolyNode of the Polynom
     */
    public Polynom(PolyNode p)
    {
        this._head=p;
    }

    /**
     * Add PolyNode p to this polynome without breaking order(sorted polynom)
     * time complexity: O(n) (n= number of nodes)
     * Space complexity: O(1)
     * @param p PolyNode to add
     * @return this Polynom
     */
    public Polynom addNode(PolyNode p)
    {
        if(this.isEmpty()) { // in case polynom is empty
            this._head = p;
            return this;
        }
        PolyNode x = this._head;
        if(x.getPower()<p.getPower()) // in case all polynom coefficients are smaller then p
        {
            p.setNext(x);
            this._head = p; // make p the new head
            return this;
        }
        while(x.getNext()!=null && p.getPower()<x.getPower())
        {
            x=x.getNext(); // traverse along the polynom until getNext is null or you reached a smaller or equal power
        }
        if (p.getPower()==x.getPower()) {
            x.setCoefficient(x.getCoefficient() + p.getCoefficient());
            return this;
        }
        x.setNext(p); // in case p has the smallest power
        return this;
    }

    /**
     * multiply a given number to this polynome
     * time complexity: O(n) (n= number of nodes)
     * Space complexity: O(1)
     * @param num number to multiply the polynom
     * @return this Polynom
     */
    public Polynom multByScalar(int num)
    {
        if(isEmpty())
            return this;
        PolyNode x = this._head;
        while(x!=null) {
            x.setCoefficient(num * x.getCoefficient());
            x=x.getNext();
        }
        return this;
    }

    /**
     * Add Polynom other to this polynome without breaking order(sorted polynom)
     * time complexity: O(n*m) (n= number of nodes in this polynom,m=number of nodes in other polynom)
     * Space complexity: O(1)
     * @param other other Polynom
     * @return this Polynom
     */
    public Polynom addPol(Polynom other)
    {
        if(other.isEmpty())
            return this;
        PolyNode x = other.getHead();
        while(x!=null) {
            this.addNode(x);
            x = x.getNext();
        }
        return this;
    }

    /**
     * multiply other Polynom  to this polynome without breaking order(sorted polynom).
     * @param other other Polynom
     * @return this Polynom
     */
    public Polynom multPol(Polynom other)
    {
        if(this.isEmpty()||other.isEmpty())
            return this;
        PolyNode x = this._head,y=other.getHead();  //set pointers
        Polynom polyTemp= new Polynom(); // new  result polynom
        while(x!=null)
        {
            while (y!=null)
            {
                double coefficient=y.getCoefficient()*x.getCoefficient();
                int power= y.getPower()+x.getPower();
                polyTemp.addNode(new PolyNode(power,coefficient));
                y=y.getNext();
            }
            y=other.getHead();
            x=x.getNext();
        }
        this.setHead(polyTemp.getHead());
        return this;
    }

    /**
     * Get the differential of a this Polynom
     * @return this Polynom
     */
    public Polynom differential()
    {
        if(this.isEmpty())
            return this;
        PolyNode x = this._head;
        while(x!=null)
        {
            if (x.getPower()==0) // set Polynode to zero in power is 0
                x.setCoefficient(0);
            else{
                x.setCoefficient(x.getPower()*x.getCoefficient());
                x.setPower(x.getPower()-1);
            }
            x=x.getNext();
        }
        return this;
    }
    /** String method to represent the Polynom
     * @return String representation of Polynom
     */
    public String toString()
    {
        if(this.isEmpty())
            return "";
        StringBuilder pol = new StringBuilder(this._head.toString());
        if(this._head.getNext()==null)
            return pol.toString();
        PolyNode x = this._head.getNext();
        while(x!=null)
        {
            if(x.getCoefficient()==0)
                break;
            if(x.getCoefficient()<0)
                pol.append(x.toString());
            else
                pol.append("+").append(x.toString());
            x = x.getNext();
        }
        return pol.toString();
    }

    /**
     * checks if this Polynom is empty
     * @return boolean
     */
    private boolean isEmpty()
    {
        return this._head==null;
    }
    /** a Get method for _head var
     * @return Returns the Head of the Polynom
     */
    public PolyNode getHead() {
        return _head;
    }
    /** a Set method for _head var
     * @param p The Head of the PolyNom
     */
    public void setHead(PolyNode p) {
        this._head = p;
    }
}
