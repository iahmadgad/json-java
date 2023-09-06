package iahmadgad.json;

/*
 * Java JSON Handler
 */

import java.util.ArrayList;
import java.util.List;

/**
 * JSONArray Class.
 * <p>
 * JSONArray is an array contains an ordered sequence of values, 
 * values can only be integers, doubles, booleans, or nested JSONObjects & JSONArrays, but it can't be chars or any other type.
 * 
 * @author iAhmadGad
 * @version 0.3
 * @since 0.3
*/

public class JSONArray 
{
	/**
	 * The main ArrayList that stores JSONArray values.
	 */
	private ArrayList<Object> node;
	
	/**
	 * The main Constructor which initialises a new JSONArray.
	 */
	public JSONArray()
	{
		node = new ArrayList<Object>();
	}
	
	/**
	 * The Constructor which creates a new JSONArray from a text.
	 * @param Source JSON string (text)
	 */
	public JSONArray(String text)
	{
		node = new JSONParser(text).getArrayList();
	}
	
	/**
	 * The Constructor which creates a new JSONArray from a Java array (with valid values only as mentioned above).
	 * @param Source Java Array
	 */
	public <T> JSONArray(T[] array)
	{
		node = new Converter().toJSONArray(array).getNode();
	}
	
	/**
	 * The Constructor which creates a new JSONArray from a Java list (with valid values only as mentioned above).
	 * @param Source Java List
	 */
	public <T> JSONArray(List<T> list)
	{
		node = new Converter().toJSONArray(list).getNode();
	}
	
	/**
	 * Converts JSONArray to a Java array.
	 * @return An array of objects (only valid)
	 */
	public Object[] toArray()
	{
		return node.toArray();
	}
	
	/**
	 * Converts JSONArray to a Java String array.
	 * @return An array of Strings
	 */
	public String[] toStringArray()
	{
		return new Converter().toStringArray(this);
	}
	
	/**
	 * Converts JSONArray to a Java boolean array.
	 * @return An array of booleans
	 */
	public boolean[] toBooleanArray()
	{
		return new Converter().toBooleanArray(this);
	}
	
	/**
	 * Converts JSONArray to a Java int array.
	 * @return An array of ints
	 */
	public int[] toIntArray()
	{
		return new Converter().toIntArray(this);
	}
	
	/**
	 * Converts JSONArray to a Java double array.
	 * @return An array of doubles
	 */
	public double[] toDoubleArray()
	{
		return new Converter().toDoubleArray(this);
	}
	
	/**
	 * Converts JSONArray to a Java list.
	 * @return A list of Objects (only valid)
	 */
	public List<Object> toList()
	{
		return new Converter().toList(this);
	}
	
	/**
	 * Converts JSONArray to a Java String list.
	 * @return A list of Strings
	 */
	public List<String> toStringList()
	{
		return new Converter().toStringList(this);
	}
	
	/**
	 * Converts JSONArray to a Java boolean String list.
	 * @return A list of booleans
	 */
	public List<Boolean> toBooleanList()
	{
		return new Converter().toBooleanList(this);
	}
	
	/**
	 * Converts JSONArray to a Java Integer list.
	 * @return A list of Integers
	 */
	public List<Integer> toIntegerList()
	{
		return new Converter().toIntegerList(this);
	}
	
	/**
	 * Converts JSONArray to a Java Double list.
	 * @return A list of Doubles
	 */
	public List<Double> toDoubleList()
	{
		return new Converter().toDoubleList(this);
	}
	
	/**
	 * Returns the main ArrayList that stores JSONArray values.
	 * @return {@link #node}
	 */
	public ArrayList<Object> getNode()
	{
		return node;
	}
	
	protected void setNode(ArrayList<Object> array)
	{
		this.node = array; 
	}
	
	/**
	 * Returns the size of the main ArrayList that stores JSONArray values.
	 * @return the size of the main ArrayList
	 */
	public int size()
	{
		return node.size();
	}
	
	/**
	 * Converts the JSONArray to a Java array.
	 * @param Java array
	 * @return An array of the same type
	 */
	public <T> T[] toArray(T[] a)
	{
		return node.toArray(a);
	}
	
	/**
	 * Appends the specified value to the end of the JSONArray.
	 * @param value
	 */
	public void add(Object value)
	{
		if(Validator.isValid(value)) node.add(value);
	}
	
	/**
	 * Replaces the value in the specified position with the the specified value
	 * @param index, value
	 */
	public void set(int index, Object value)
	{
		if(Validator.isValid(value)) node.set(index, value);
	}
	
	/**
	 * Gets Object in this index.
	 * @param index
	 * @return Object
	 */
	public Object get(int index)
	{
		return node.get(index);
	}
	
	/**
	 * Gets String in this index.
	 * @param index
	 * @return String
	 */
	public String getString(int index)
	{
		return (String) node.get(index);
	}
	
	/**
	 * Gets boolean in this index.
	 * @param index
	 * @return boolean
	 */
	public boolean getBoolean(int index)
	{
		return (boolean) node.get(index);
	}
	
	/**
	 * Gets int in this index.
	 * @param index
	 * @return int
	 */
	public int getInt(int index)
	{
		return (int) node.get(index);
	}
	
	/**
	 * Gets double in this index.
	 * @param index
	 * @return double
	 */
	public double getDouble(int index)
	{
		return (double) node.get(index);
	}
	
	/**
	 * Gets JSONObject in this index.
	 * @param index
	 * @return JSONObject
	 */
	public JSONObject getJSONObject(int index)
	{
		return (JSONObject) node.get(index);
	}
	
	/**
	 * Gets JSONArray in this index.
	 * @param index
	 * @return JSONArray
	 */
	public JSONArray getJSONArray(int index)
	{
		return (JSONArray) node.get(index);
	}
	
	/**
	 * Gets Object in this pointer.
	 * @param pointer
	 * @return Object
	 */
	public Object get(JSONPointer pointer)
	{
		pointer.setNode(this);
		return pointer.getPointee();
	}
	
	/**
	 * Gets String in this pointer.
	 * @param pointer
	 * @return String
	 */
	public String getString(JSONPointer pointer)
	{
		pointer.setNode(this);
		return (String) pointer.getPointee();
	}
	
	/**
	 * Gets boolean in this pointer.
	 * @param pointer
	 * @return boolean
	 */
	public boolean getBoolean(JSONPointer pointer)
	{
		pointer.setNode(this);
		return (boolean) pointer.getPointee();
	}
	
	/**
	 * Gets int in this pointer.
	 * @param pointer
	 * @return int
	 */
	public int getInt(JSONPointer pointer)
	{
		pointer.setNode(this);
		return (int) pointer.getPointee();
	}
	
	/**
	 * Gets double in this pointer.
	 * @param pointer
	 * @return double
	 */
	public double getDouble(JSONPointer pointer)
	{
		pointer.setNode(this);
		return (double) pointer.getPointee();
	}
	
	/**
	 * Gets JSONObject in this pointer.
	 * @param pointer
	 * @return JSONObject
	 */
	public JSONObject getJSONObject(JSONPointer pointer)
	{
		pointer.setNode(this);
		return (JSONObject) pointer.getPointee();
	}
	
	/**
	 * Gets JSONArray in this pointer.
	 * @param pointer
	 * @return JSONArray
	 */
	public JSONArray getJSONArray(JSONPointer pointer)
	{
		pointer.setNode(this);
		return (JSONArray ) pointer.getPointee();
	}
}
