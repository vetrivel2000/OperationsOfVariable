package logical;

import java.util.HashMap;
import java.util.Map;

public class LogicalLayer {
    HashMap<Character,Integer> data=new HashMap<>();
    HashMap<Character,Integer> temporary;
    public void setData(char variableName, int value)
    {
        data.put(variableName,value);
    }
    public HashMap<Character, Integer> getData() {
        return data;
    }
    public void unSetData(char variableName)
    {
        data.remove(variableName);
    }
    public void updateData(char variableName, int value)
    {
        data.replace(variableName,value);
    }
    public int countValues(int value)
    {
        int count= 0;
        for (Map.Entry<Character,Integer> entry:data.entrySet())
        {
            if(entry.getValue()==value)
            {
                count++;
            }
        }
        return count;
    }
    public void beginTransaction()
    {
        temporary = new HashMap<>();
        temporary.putAll(data);
    }
    public void rollbackTransaction()
    {
        data.clear();
        data.putAll(temporary);
    }
    public void commitTransaction()
    {
        data.putAll(temporary);
    }
}
