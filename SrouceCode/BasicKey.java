package SrouceCode;

/**
 *  PURPOSE:        this class is the basic key for any key in the game
 *                  This class follows the key interface
 *    
 * 
 * About:           this is a basic key
 *                  you give it locks that the key can unlock
 *                  
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 */
public class BasicKey extends Key
{

    
    /**
     * constructor for Basic Key class
     * Defaults value of name is "Basic Key"
     *          value of weight is 0.5
     *          value of buyValue is 10
     *          value of sellValue is 5
     */
    public BasicKey(){
        super("Key");
    }
    
    
    /**
     * constructor for Basic Key class
     * @param name: is what the name of the Key is.
     * Defaults value of weight is 1.0
     *          value of buyValue is 10
     *          value of sellValue is 5
     */
    public BasicKey(String name){
        super(name);
    }
    
    
    /**
     * 
     * @return String: what the key looks like
     */
    @Override
    public String description() {
      return "It seems to just be a basic key, i wonder what it unlocks";
    }
    

    /**
     * this will see if the key can unlock the lock
     * @param lock: the lock you want to try to unlock 
     * @return boolean: if  it could be unlocked
     */
    @Override
    public boolean canUnlock(Lock lock) {
        boolean result;
        
        if( this.getLocks().contains(lock)){
            result = true;
        }
        else{
            result = false;
        }
        
        return result;
    }
    
    
}
