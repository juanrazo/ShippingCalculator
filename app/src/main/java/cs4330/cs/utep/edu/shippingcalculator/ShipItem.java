package cs4330.cs.utep.edu.shippingcalculator;

/**
 * Created by juanr on 2/16/16.
 */
public class ShipItem {
    //Shipping Costants
    static final Double BASE = 3.00;
    static final Double ADDED = .50;
    static final int BASE_WEIGHT = 16;
    static final double EXTRA_OUNCES = 4.0;

    //Data Members
    private Integer mWeight;
    private Double mBaseCost;
    private Double mAddedCost;
    private Double mTotalCost;

    public ShipItem(){
        mWeight = 0;
        mAddedCost = 0.0;
        mBaseCost = BASE;
        mTotalCost = 0.0;
    }

    public void setWeight(int weight){
        mWeight = weight;
        computeCosts();
    }

    private void computeCosts(){
        mAddedCost = 0.0;
        mBaseCost = BASE;

        if(mWeight <= 0)
            mBaseCost = 0.0;
        else if(mWeight>BASE_WEIGHT)
            mAddedCost=Math.ceil((double) (mWeight - BASE_WEIGHT) / EXTRA_OUNCES) * ADDED;

        mTotalCost = mBaseCost + mAddedCost;
    }

    public Double getBaseCost(){
        return mBaseCost;
    }

    public Double getAddedCost(){
        return mAddedCost;
    }

    public Double getTotalCost(){
        return mTotalCost;
    }
}
