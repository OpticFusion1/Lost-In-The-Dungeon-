package SrouceCode;

/**
 *  this direction enum class models itself after the cardinal directions
 *
 *  this Enum class is mostly used to set exits for rooms and is used by the 
 *  "go" command to match the possible exits for the rooms 
 *
 *  we use a Enum class for this to restrict any other programmers to make sure
 *  the right possible directions are entered when setting exits for rooms
 *
 *
 * @author Peter N Keres (2019)
 * @version 1.0 (April 2019)
 */


public enum Direction {

    NORTH, EAST, SOUTH, WEST
}
