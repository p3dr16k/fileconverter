/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.p3dr16k;

/**
 *
 * @author patrick
 */
public class Utils 
{
    public static int searchString(String[] array, String value)
    {
        for (int i = 0; i < array.length; i++) 
        {
            if(array[i].equals(value))
            {
                return i;
            }
        }
        return -1;
    }
    
    public static void printArray(String[] array, String separator)
    {
        for(int i = 0; i < array.length; i++)
        {
            if(i == (array.length - 1))
            {
                System.out.print(array[i]);
            }
            else
            {
                System.out.print(array[i] + separator);
            }
        }
        System.out.println("");
    }
}
