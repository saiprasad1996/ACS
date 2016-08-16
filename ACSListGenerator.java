/*
 * Copyright (c) 2016. saiprasadm.tk By using this API you agree to bind with the following terms :
 * -> This source code can be used by anyone freely but must enclose this copyright notice.
 * -> You are permitted to freely copy,share or distribute this source code as far as money is not involved
 * -> Selling and buying this source code directly is illegal and must be reported to the developer @ saiprasad1606@gmail.com
 * -> This source code can be used commercially to build software upon
 */

package tk.saiprasadm.ACSList;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * ACSListGenerator class allows you to create ACSList Formatted text which can be again parsed using ACSListParser
 *
 * @author SAI PRASAD
 */
public class ACSListGenerator {
    /**
     *
     */
    private String ACSFormattedList;
    /**
     *
     */
    private ArrayList<HashMap<Integer, String>> records = new ArrayList<>();
    /**
     *
     */
    private int informationCols;

    /**
     *
     * @param informationCols
     */
    public ACSListGenerator(int informationCols){
        this.informationCols=informationCols;
    }
    public void setInformationCols(int informationCols) {
        this.informationCols = informationCols;
    }

    public void setRecords(ArrayList<HashMap<Integer, String>> records) {
        this.records = records;


    }

    /**
     *
     * @param unformattedText
     */
    public void addRecord(HashMap<Integer, String> unformattedText,int informationColumns) {
        records.add(unformattedText);
        this.informationCols=informationColumns;
    }

    /**
     *
     * @return
     */
    public String getACSFormattedList() {

        final int infoBits = informationCols, dataSetsNumber = records.size();
        StringBuilder formattedText = new StringBuilder();

        formattedText.append("[");
        int internal = 1;
        for (HashMap<Integer, String> value : records) {
            //System.out.println(value.get(0)+" "+value.get(1)+" "+value.get(2));
            formattedText.append("{");
            int i;
            for (i= 0; i < infoBits-1; i++) {
                formattedText.append(value.get(i)+",");
            }
            formattedText.append(value.get(i));
            if (internal < dataSetsNumber)
                formattedText.append("}&:&");
            else
                formattedText.append("}");

            internal++;
        }

        formattedText.append("]");
        this.ACSFormattedList=formattedText.toString();
        return formattedText.toString();

    }
}