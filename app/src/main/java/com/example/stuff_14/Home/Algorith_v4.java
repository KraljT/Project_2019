package com.example.stuff_14.Home;

import android.util.Log;

import java.util.ArrayList;

import java.util.ArrayList;

public class Algorith_v4 {

    public StringBuilder bits = new StringBuilder();
    public String username;

    public StringBuilder getBits() {
        return bits;
    }

    public void setBits(StringBuilder bits) {
        this.bits = bits;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void Pravila(StringBuilder biti, ArrayList<Integer> stevila )
    {
        int nic = 0;
        FirstNumber(biti,stevila.get(0));
        for(Integer i = 1; i<stevila.size();i++)
        {
            if((stevila.get(i) >=-30 && stevila.get(i) < 0) || (stevila.get(i) > 0 && stevila.get(i) <=30) ){
                Razlika(biti,stevila.get(i));
                //  System.out.println("klicala razlika");
            }

            if(stevila.get(i) == 0)
            {
                nic++;
                if(i== stevila.size()-1)
                {
                    Ponovitev(biti,nic);
                    // System.out.println("klicala ponovitev");
                    Konec(biti);
                    // System.out.println("klicala konec");
                    break;
                }
                if(stevila.get(i+1) != 0)
                {
                    if(nic % 8 == 0)
                    {
                        Ponovitev(biti,nic);
                        //System.out.println("klicala ponovitev");
                    }
                    else {
                        Ponovitev(biti, nic);
                        // System.out.println("klicala ponovitev");

                    }
                    nic = 0;
                }
            }
            if(stevila.get(i) < -30){
                AbolutnoKodiranje(biti,stevila.get(i));
                // System.out.println("klicala aboslutno");
            }

            if(i == stevila.size()-1)
            {
                Konec(biti);
                // System.out.println("klicala konec");
            }

        }
    }
    public void FirstNumber(StringBuilder biti ,Integer stevilo)
    {
        String firstBinNumber = Integer.toBinaryString(stevilo); //dodelaj za 8 bitov !!
        for(int i = firstBinNumber.length(); i<8;i++)
        {
            biti.append("0");
        }
        biti.append(firstBinNumber);
    }
    public void Razlika(StringBuilder biti, Integer stevilo)
    {
        //biti = biti + " " + "00"; //razlika
        biti.append(" " + "00");
        switch (stevilo) {
            case -2:
                biti.append(" " + Const.razlika_interval1+ " " + Const.min2);
                break;
            case -1:
                biti.append(" " + Const.razlika_interval1 +" " +Const.min1);
                break;
            case 1:
                biti.append(" " + Const.razlika_interval1+ " " + Const.plus1);
                break;
            case 2:
                biti.append(" " + Const.razlika_interval1 +" "+ Const.plus2);
                break;
            /////////////////////////////////////////prvi interval
            case -6:
                biti.append(" " + Const.razlika_interval2 +" " + Const.min6);
                break;
            case -5:
                biti.append(" " + Const.razlika_interval2 +" " + Const.min5);
                break;
            case -4:
                biti.append(" " + Const.razlika_interval2 +" " +Const.min4);
                break;
            case -3:
                biti.append(" " + Const.razlika_interval2 +" " + Const.min3);
                break;
            case 3:
                biti.append(" " + Const.razlika_interval2 +" " + Const.plus3);
            case 4:
                biti.append(" " + Const.razlika_interval2 +" " + Const.plus4);
                break;
            case 5:
                biti.append(" " + Const.razlika_interval2 +" " + Const.plus5);
                break;
            case 6:
                biti.append(" " + Const.razlika_interval2 +" " + Const.plus6);
                break;
            ///////////////////////////////////////////////drugi interval
            case -14:
                biti.append(" " + Const.razlika_interval3 + " " + Const.min14);
                break;
            case -13:
                biti.append(" " + Const.razlika_interval3 + " " + Const.min13);
                break;
            case -12:
                biti.append(" " + Const.razlika_interval3 + " " + Const.min12);
                break;
            case -11:
                biti.append(" " + Const.razlika_interval3 + " " + Const.min11);
                break;
            case -10:
                biti.append(" " + Const.razlika_interval3 + " " + Const.min10);
                break;
            case -9:
                biti.append(" " + Const.razlika_interval3 + " " + Const.min9);
                break;
            case -8:
                biti.append(" " + Const.razlika_interval3 + " " + Const.min8);
                break;
            case -7:
                biti.append(" " + Const.razlika_interval3 + " " + Const.min7);
                break;
            case 7:
                biti.append(" " + Const.razlika_interval3 + " " + Const.plus7);
                break;
            case 8:
                biti.append(" " + Const.razlika_interval3 + " " + Const.plus8);
                break;
            case 9:
                biti.append(" " + Const.razlika_interval3 + " " + Const.plus9);
                break;
            case 10:
                biti.append(" " + Const.razlika_interval3 + " " + Const.plus10);
                break;
            case 11:
                biti.append(" " + Const.razlika_interval3 + " " + Const.plus11);
                break;
            case 12:
                biti.append(" " + Const.razlika_interval3 + " " + Const.plus12);
                break;
            case 13:
                biti.append(" " + Const.razlika_interval3 + " " + Const.plus13);
                break;
            case 14:
                biti.append(" " + Const.razlika_interval3 + " " + Const.plus14);
                break;
            ///////////////////////////////////////////tretji interval
            case -30:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.min30);
                break;
            case -29:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.min29);
                break;
            case -28:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.min28);
                break;
            case -27:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.min27);
                break;
            case -26:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.min26);
                break;
            case -25:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.min25);
                break;
            case -24:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.min24);
                break;
            case -23:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.min23);
                break;
            case -22:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.min22);
                break;
            case -21:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.min21);
                break;
            case -20:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.min20);
                break;
            case -19:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.min19);
                break;
            case -18:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.min18);
                break;
            case -17:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.min17);
                break;
            case -16:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.min16);
                break;
            case -15:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.min15);
                break;
            case 15:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.plus15);
                break;
            case 16:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.plus16);
                break;
            case 17:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.plus17);
                break;
            case 18:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.plus18);
                break;
            case 19:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.plus19);
                break;
            case 20:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.plus20);
                break;
            case 21:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.plus21);
                break;
            case 22:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.plus22);
                break;
            case 23:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.plus23);
                break;
            case 24:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.plus24);
                break;
            case 25:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.plus25);
                break;
            case 26:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.plus26);
                break;
            case 27:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.plus27);
                break;
            case 28:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.plus28);
                break;
            case 29:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.plus29);
                break;
            case 30:
                biti.append(" " + Const.razlika_interval4 +" "+ Const.plus30);
                break;
            default:
                biti.append("error_razlika");
                break;
        }
    }
    public void Ponovitev(StringBuilder biti,int nic)
    {
        //biti = biti + " " + "01";
        biti.append(" "+ "01");
        switch (nic)
        {
            case 1:
                biti.append(Const.nic1);
                break;
            case 2:
                biti.append(Const.nic2);
                break;
            case 3:
                biti.append(Const.nic3);
                break;
            case 4:
                biti.append(Const.nic4);
                break;
            case 5:
                biti.append(Const.nic5);
                break;
            case 6:
                biti.append(Const.nic6);
                break;
            case 7:
                biti.append(Const.nic7);
                break;
            case 8:
                biti.append(Const.nic8);
                break;
            default:
                biti.append("error_ponovitev");
                break;
        }

    }
    public void AbolutnoKodiranje(StringBuilder biti, Integer stevilo)
    {
        //biti = biti + " " + "10";
        biti.append(" "+"10");
        if(stevilo < 0)
        {
            stevilo = stevilo * -1;
            String temp_bin =  Integer.toBinaryString(stevilo);
            // biti = biti + "1";
            biti.append("1");
            for(int i = temp_bin.length(); i<8;i++)
            {
                //biti = biti + "0";
                biti.append("0");

            }
            //biti  = biti + temp_bin;
            biti.append(temp_bin);
        }
        else
        {
            String temp_bin =  Integer.toBinaryString(stevilo);
            //biti = biti + "0";
            biti.append("0");
            for(int i = temp_bin.length(); i<8;i++)
            {
                //biti = biti + "0";
                biti.append("0");
            }
            //biti  = biti + temp_bin;
            biti.append(temp_bin);
        }

    }
    public void Konec(StringBuilder biti) { biti.append(" 11"); }

    public void ConvertToInt()
    {
        ArrayList<Integer> st = new  ArrayList<Integer>();
        ArrayList<Integer> st_novi = new  ArrayList<Integer>();
        int temp =0;
        for (int i = 0; i<username.length();i++)
        {
            temp = username.charAt(i);
            st.add(temp);
        }
        temp = 0;
        System.out.println("ASCII = "+ st.toString());

        for(Integer i = 1;i<st.size();i++)
        {
            temp = st.get(i) - st.get(i-1);
            st_novi.add(temp);
        }
        System.out.println("Convert ASCII = "+st_novi.toString());
        Pravila(bits,st_novi);

    }
    public String ToString()
    {
         return "Koncni niz = " + bits + "\n";
    }
}
