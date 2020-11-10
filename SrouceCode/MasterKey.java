package SrouceCode;

/**
 *  PURPOSE:        this class is the master key for all locks in the game
 *                  This class follows the key interface
 *    
 * 
 * About:           this is a master key
 *                  it can unlock any lock in the game
 *                  you can give it locks that the key can unlock but is unnessary 
 *                  
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 */
public class MasterKey extends Key
{

      /**
     * constructor for Master Key class
     * Defaults value of name is "Master Key"
     *          value of weight is 0.5
     *          value of buyValue is 100
     *          value of sellValue is 25
     */
    public MasterKey(){
        super("Key");
    }
    
    
    /**
     * 
     * @return String: what the key looks like
     */
    @Override
    public String description() {
      return "Unlike any key you have seen. Seems speical.";
    }
    

   /**
     * this will see if the key can unlock the lock
     * @param lock: the lock you want to try to unlock 
     * @return boolean: if  it could be unlocked
     * NOTE: will always return true
     */
    @Override
    public boolean canUnlock(Lock lock) {
        boolean result = true;
        
        return result;
    }
    
    
   
}
