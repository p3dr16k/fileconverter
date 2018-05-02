/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.p3dr16k;

import com.opencsv.CSVIterator;
import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author patrick
 */
public class CsvConverter 
{    
    private String filepath;
    private final CSVReader reader;
    private String separator;

    public CsvConverter(String filepath, String separator) throws FileNotFoundException 
    {
        this.filepath = filepath;
        reader = new CSVReader(new FileReader(filepath));
        this.separator = separator;
    }

    public String getFilepath() 
    {
        return filepath;
    }

    public void setFilepath(String filepath) 
    {
        this.filepath = filepath;
    }      

    public CSVReader getReader() 
    {
        return reader;
    }

    public String getSeparator()
    {
        return separator;
    }

    public void setSeparator(String separator)
    {
        this.separator = separator;
    }   
    
    public int[] getIndexHeader(String fields) throws IOException
    {
        String[] fieldsArray = fields.split(separator);
        int[] result = new int[fieldsArray.length];
        CSVIterator iterator  = new CSVIterator(reader);
        String[] header = iterator.next();
        int i = 0;
        for(String s: fieldsArray)
        {
            result[i] = Utils.searchString(header, s);
            i++;
        }
        return result;
    }
    
    public void printFilteredValues(String fields) throws IOException
    {
        boolean firstRow = true;
        String[] nextline;
        String[] fieldsArray = fields.split(separator);
        String[] tmp = new String[fieldsArray.length];
        int[] indexes = this.getIndexHeader(fields);
                
        while((nextline = reader.readNext()) != null)
        {
            if(firstRow)
            {
                System.out.println(fields);
                firstRow = false;
            }
            else
            {
                int j = 0;
                for(int i : indexes)
                {
                    tmp[j] = nextline[i];
                    j++;
                }
                Utils.printArray(tmp, separator);
            }
        }
    }
}
