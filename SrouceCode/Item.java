package SrouceCode;

/**
 *  PURPOSE:        this class is the base for Items in the game
 *                  This class follows the patterns set by WorldObjects
 *                  extend this class to classes of items that you want in the game
 *                  Example of classes to extend this would be: 'apple', 'plate', 'cups'
 *                  anything that would be an object in the world
 *
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 */


public abstract class Item implements WorldObject {

    private String name;
    private double weight;
    private int buyValue;
    private int sellValue;



    /**
     * constructor for Item class
     * Defaults value of name is "Unknown item"
     *          value of weight is 1.0
     *          value of buyValue is 2
     *          value of sellValue is 1
     */
    public Item (){
        this("Unknown item");
    }

    /**
     * constructor for Item class
     * @param name: is what the name of the item is.
     * Defaults value of weight is 1.0
     *          value of buyValue is 2
     *          value of sellValue is 1
     */
    public Item(String name){
        this(name, 1.0);
    }

    /**
     * constructor for Item class
     * @param name: is the name of the item
     * @param weight: is the weight of the item.
     * Defaults value of buyValue will be 2
     *          Value of sellValue will be 1
     */
    public Item(String name, double weight){
        this(name, weight, 2, 1);
    }

    /**
     * Designated constructor for Item class
     * @param name: is the name of the item
     * @param weight: is the weight of the item.
     * @param buyValue: is how much the item is to buy
     * @param sellValue: is how much the item sells for
     */
    public Item(String name,double weight, int buyValue,int sellValue){
        this.name = name;
        this.weight = weight;
        this.buyValue = buyValue;
        this.sellValue = sellValue;
    }


    /**
     *
     * @return Weight: is how much the item weighs
     */
    @Override
    public double getWeight(){
        return weight;
    }


    /**
     *
     * @return name: is the name of the item
     */
    @Override
    public String getName(){
        return name;
    }


    /**
     *
     * @return value: is how much the item is worth
     */
    @Override
    public int getBuyValue(){
        return buyValue;
    }


    /**
     *
     * @return value: is how much the item is worth
     */
    @Override
    public int getSellValue(){
        return sellValue;
    }

    /**
     * @param object: is another object you want to compater to this item
     * @return boolean: if the 2 items are equals. based on name and buy Value
     */
    @Override
    public boolean equals(Object object){
        boolean R = false;

        if(getName().equals(((WorldObject)object).getName()) && getBuyValue() == ((WorldObject)object).getBuyValue()){
            R = true;
        }

        return R;
    }

    /**
     *
     * @return All fields of an Item
     */
    @Override
    public String toString(){
        return "Name: " + this.getName() + ", " + this.description() +  "\nWeight: " + this.getWeight() +
                " BuyValue: " + this.getBuyValue() + " SellValue:" + this.getSellValue();
    }


    /**
     *
     *
     * @return a string that describes the item
     */
    @Override
    abstract public String description();

    /**
     * the method that is used by the use command 
     * it will allow the player to "use" the item in some way in a room
     *
     * @param room: the room you want to use this item in
     */
    @Override
    abstract public void use(Room room);
}
