package com.github.p3dr16k;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author patrick
 */
public class Fileconverter 
{
    public static void main(String[] args) 
    {
        try 
        {
            if(args.length != 3)
            {
                System.err.println("Wrong number of arguments");
                System.exit(-1);
            }
            CsvConverter csvConverter = new CsvConverter(args[0], args[1]);
            csvConverter.printFilteredValues(args[2]);
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Fileconverter.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Fileconverter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
