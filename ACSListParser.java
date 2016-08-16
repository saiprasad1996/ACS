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
 * API is CREATED BY SAI PRASAD<br/>
 * ACSListParser stands for Ampersand Colon Separated List. The information about the datastructure and its implementation can be found out at saiprasadm.tk
 *
 * @author SAI PRASAD
 * @version 1 Beta
 * @apiNote This api works only for 3 informations in a dataset.
 * @implNote The further development for generalised api will be published on my website
 */
public class ACSListParser {
    private ArrayList<HashMap<Integer, String>> parsedInfo;
    private String formattedText;
    private int numberOfDataSets = 0;
    private String infoArray[];

    /**
     * @param formattedText ACSListParser formatted text from which information to be extracted.
     */
    public ACSListParser(String formattedText) {
        this.formattedText = formattedText;
        parsedInfo = new ArrayList<>();

    }

    /**
     * This method returns the ArrayList with HashMap, with Integer as Key and String Value.
     *
     * @return ArrayList with information from the ACSListParser formatted text
     */
    public ArrayList<HashMap<Integer, String>> getParsedInfo() {

        formattedText = formattedText.substring(formattedText.indexOf('[') + 1, formattedText.indexOf(']'));
        this.infoArray = formattedText.split("&:&");
        numberOfDataSets = infoArray.length;
        //System.out.println(numberOfDataSets);
        //System.out.println("Datasets : " + formattedText);
        for (String s : infoArray) {
            s = s.substring(s.indexOf('{') + 1, s.indexOf('}'));
            String subStr[] = s.split(",");
            int i = 0;
            HashMap<Integer, String> data = new HashMap<>();
            for (String ss : subStr) {
                data.put(i, ss);
                //      System.out.print(ss + " ");
                i++;
            }
            parsedInfo.add(data);
        }

        return parsedInfo;
    }

    /**
     * ACSFormatted text which is given as Input
     *
     * @return gets formatted text
     */
    public String getFormattedText() {
        return formattedText;
    }

    /**
     * Setter for ACSListParser formatted Text
     *
     * @param formattedText ACSListParser formatted text
     */
    public void setFormattedText(String formattedText) {
        this.formattedText = formattedText;
    }




    /**
     * @return Integer with value equals to the number of datasets available in the ACSListParser
     */
    public int getDataSetsNumber() {
        formattedText = formattedText.substring(formattedText.indexOf('[') + 1, formattedText.indexOf(']'));
        String infoArray[] = formattedText.split("&:&");
        numberOfDataSets = infoArray.length;

        return numberOfDataSets;
    }



}
