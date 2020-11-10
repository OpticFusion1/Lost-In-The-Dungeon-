package SrouceCode;

import java.util.HashMap;
/**
 *  PURPOSE:        this class allows to have limits on objects that a container is holding
 *                  with this class you are able to add, remove, and update limits
 *                  You are also able to ask if you are allowed to add an item based on any limits you have set for it
 *                  
 *                  special note: limits are set on a class level for the items. not indivual items them-self
 *                  example: if you set a limits on an apple object for 3, you can only hold 3 apples even if each apple is different!
 * 
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 */
public class Limit {
    
    private HashMap<String, int[]> limits;
    
    
    /**
     * Designated constructor for Limit Class
     */
    public Limit(){
        limits = new HashMap<String, int[]>();
    }
    
    
    /**
     * this method will set a limit for an object you send it 
     * NOTE: if you send a limit for an item that already has a limit, it will override that prev value
     * 
     * @param object: the object you want the limit on 
     * @param current: what is the current number of this objects in the container
     * @param limit: is the max number of that item you want to be hold by the container
     */
    public void set(String object, int current, int limit){
        int[] newLimit = {current, limit};
        limits.put(object, newLimit);
    }
            
    
    /**
     * this method will remove a limit that is set for an object
     * NOTE: if not limit is found, will return null
     * 
     * @param object: the object you want to remove a limit from
     * @return limit[]: is an int[] of size 2 that holds
     *                  [0]: the current number of that objects in the container
     *                  [1]: the max allowed for that limit
     */
    public int[] remove(String object){
        return limits.remove(object);
    }
            
    
    /**
     * this method will get the max amount allowed for a object in the container
     * 
     * @param object: the object you want to see the limit on 
     * @return limit: the max number of that object the container can hold
     */
    public int getLimit (String object){
        return limits.get(object)[1];
    }

    
    /**
     * this method will update the number of current objects held by the container 
     * 
     * @param object: the object you want to change the limit on 
     * @param current: is the number that is currently held by the container for that object 
     */
    public void updateCurrent(String object, int current){
        if(limits.containsKey(object)){
            int[] temp = this.remove(object);
            int[] updateLimit = {current, temp[1]};
            limits.put(object,updateLimit);
        }
        
    }
    
    
    /**
     * this method will let you know if you are able to add an time based on the limit that is set for that item
     * 
     * @param object: the object you want to see if you can add
     * @return answer: if you are allowed to add the object to that container 
     */
    public boolean ableToAdd(String object){
        boolean answer = true;
        
        if (limits.get(object) != null){
            int[] temp = limits.get(object);
            
            if(temp[0] >= temp[1]){
            answer = false;
            }
        }
        
        return answer;
    }
}
