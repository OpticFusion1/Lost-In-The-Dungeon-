package SrouceCode;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
/**
 *  PURPOSE:        this class allows to have an inventory for any class
 *                  this inventory can hold WorlObject's. Think of this class like a backpack. you can put items in and take items out
 *                  An inventory is special because it can have limit's of how many of a WorldObject it can hold.
 *                  and also have a maximum weight tied to the total number of WorldObjects its holding.
 *
 *                  inventory follows the base set up by the Container interface
 *
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 */
public class Inventory implements Container<WorldObject> {


    private List<WorldObject> objects;
    private Limit limits;
    private double currentWeight;
    private double MaxWeight;


     /**
     * Designated constructor for Inventory Class
     * Defaults currentWeight: 0
     *          MaxWeight: 0
     */
    public Inventory(){
        objects = new LinkedList<WorldObject>();
        limits = new Limit();
        currentWeight = 0;
        MaxWeight = 50.0;
    }


     /**
     * this method will add an object to the inventory
     * will update the limit and weight as needed
     *
     * @param object: is the object you want to add to the inventory
     */
    @Override
    public boolean add(WorldObject object) {
        boolean added = false;
        //checks to see if objec it going past a limit
        if (limits.ableToAdd(object.getClass().getName())){
            // checks if weight is going to be ok
            if (this.updateWeight(object.getWeight())){
                objects.add(object);
                limits.updateCurrent(object.getClass().getName(), this.count(object));
                added = true;
            }
            else{
               System.out.println("You can not pick up this item, it will put you over your maximum weight to carry.");
            }
        }
        else{
            System.out.println("You have reached the limit of the number of this item you can hold.");
        }
        
        return added;
    }

    /**
     * Removes the first object held by the inventory 
     * @return the object remvoed
     */
    public WorldObject remove(){
        
        WorldObject removed = objects.remove(0);
        
        if (!(objects.remove(removed) == false)){
            this.updateWeight((removed.getWeight() * -1.0));
            limits.updateCurrent(removed.getClass().getName(), this.count(removed));
        }
        
        return removed;
    }
    
    
     /**
     * this method will remove an object from the inventory
     * It will also update the limits and the current weight of the inventory
     *
     * @param object: the object you want to remove from the inventory
     */
    @Override
    public WorldObject remove(WorldObject object) {

        if (objects.remove(object) == false)
            System.out.println("Seems as though you do not have that item in your inventory");
        else{
            objects.remove(object);
            this.updateWeight((object.getWeight() * -1.0));
            limits.updateCurrent(object.getClass().getName(), this.count(object));
        }
        return object;
    }


    /**
    * this method will remove an object from the inventory
    * It will also update the limits and the current weight of the inventory
    *
    * @param object: the object you want to remove from the inventory
    */
    @Override
    public WorldObject remove(String object){

        WorldObject removed = null;
        for (WorldObject current : objects){
            if (current.getName().equalsIgnoreCase(object)){
                int index = objects.indexOf(current);
                removed = objects.get(index);
                break;
            }
        }

        return this.remove(removed);
    }


     /**
     * this method will see if the inventory has an item
     *
     * @param object: the object you want to see is in the inventory
     * @return boolean: True- the item is in the inventory, false- item is not in inventory
     */
    @Override
    public boolean contain(WorldObject object) {
        return objects.contains(object);
    }


    /**
    * this method will see if the inventory has an item
    *
    * @param object: the object you want to see is in the inventory
    * @return boolean: True- the item is in the inventory, false- item is not in inventory
    */
    public boolean contain(String object) {

        boolean found = false;
        for (WorldObject current : objects){
            if (current.getName().equalsIgnoreCase(object)){
                found = true;
                break;
            }
        }
        
        return found;
    }


     /**
     * This method will set a limit for a object
     * NOTE: if you are sending a limit for an object that already has a limit, it will overwrite the old limit with the new
     *
     * @param object: the object you want to set a limit on
     * @param limit: the max number of that object you want the inventory to hold
     */
    @Override
    public void setLimit(WorldObject object, int limit) {

       limits.set(object.getClass().getName(), this.count(object), limit);
    }


    /**
     * this method will remove a limit for a object
     *
     * @param object: the object you want to remove a limit for
     */
    public void removeLimit(WorldObject object){
        limits.remove(object.getClass().getName());
    }


     /**
      * this method returns the number of objects you have in the inventory
      *
      * @return count: the number of objects in the inventory
     */
    @Override
    public int count() {
        return objects.size();
    }


    /**
     * this method returns the number of a object in the inventory
     *
     * @param object: the object you want to see how many you have in the inventory
     * @return count: the number of that object in the inventory
    */
    public int count(WorldObject object){

        int amount = 0;

        for(int i =0; i < objects.size(); i++){
            if(objects.get(i).equals(object))
                amount = amount + 1;
        }
        return amount;
    }


     /**
     * this method will set the max weight the inventory can hold
     *
     * @param max: the max weight you want the inventory to be
     */
    public void setMaxWeight(double max){
        this.MaxWeight = max;
    }


     /**
     * this method will get the max weight for the inventory
     *
     * @return max: the max weight this inventory can hold
     */
    public double getMaxWeight(){
        return this.MaxWeight;
    }


     /**
     * this method will get the current weight the inventory is holding
     *
     * @return current: the current weight the inventory is holding
     */
    public double getCurrentWeight(){
        return this.currentWeight;
    }


     /**
     * this method will update the current weight of the inventory
     * NOTE: if you want the current weight to decreese, you can to send a - value
     *
     * @param newWeight: the weight you are adding or taking away from the current weight
     * @return answer: boolean, if the weight was able to be added based on the max weight in the inventory
     */
    private boolean updateWeight(double newWeight){
        boolean answer = false;

        if((this.getCurrentWeight() + newWeight) <= getMaxWeight()){
            this.currentWeight = this.currentWeight + newWeight;
            answer = true;
        }

        return answer;
    }



     /**
     *
     * @return a name of all items held in this container
     */
    @Override
    public String toString(){
        String names = "";
        ListIterator listIt = objects.listIterator();

        while(listIt.hasNext()){
            names = names + listIt.next().toString() + ",\n";
        }

        return names;
    }


}
