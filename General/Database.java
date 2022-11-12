package General;

import java.util.*;
import java.io.*;

public abstract class Database 
{
    protected ArrayList<Record> records;
    protected String filename;

    public abstract Record createRecordFrom(String line);

    public Database(String filename)
    {
        this.filename=filename;
        records = new ArrayList<Record>();
        readFromFile();
    }

    public void readFromFile()
    {
        records.clear();
        File f = new File(filename);
        try (Scanner sc = new Scanner(f)) 
        {
            String str; 
            while (sc.hasNextLine())
            {
                str=sc.nextLine();
                records.add(createRecordFrom(str));
            }
        } 
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ArrayList<Record> returnAllRecords()
    {
        return records;
    }

    public boolean contains(String key)
    {
        for (int i=0;i< records.size();i++)
        {
            if (records.get(i).getSearchKey().equals(key))
            {
                return true;
            }
        }
        return false;
    }

    public Record getRecord(String key)
    {
        for(int i = 0; i < records.size(); i++)
        {
            if(records.get(i).getSearchKey().equals(key))
            return records.get(i);
        }
        return null;
    }

    public void insertRecord(Record record)
    {
        records.add(record);
    }

    public void deleteRecord(String key)
    {
        for (int i = 0; i < records.size(); i++)
        {
            if(records.get(i).getSearchKey().equals(key))
            {
                records.remove(i);
                return;
            }
        }
    }

    public void saveToFile()
    {
        try (FileWriter fw = new FileWriter(filename)) {
            PrintWriter pw=new PrintWriter(fw);

            for(int i=0;i< records.size();i++)
            {
                pw.println(records.get(i).lineRepresentation());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
