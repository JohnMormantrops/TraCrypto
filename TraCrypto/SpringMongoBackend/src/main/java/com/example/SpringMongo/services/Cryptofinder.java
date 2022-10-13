package com.example.SpringMongo.services;



import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.SpringMongo.models.Crypto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Cryptofinder {

    static int rank;

    public static void main(String[] args) throws IOException {
        System.out.println("HHHHAMAMMAMM");
        // TODO Auto-generated method stub
        scrapeCoins();
    }
    public static List<Crypto> scrapeCoins() throws IOException {

        System.out.println("HHHHAMAMMAMM");
        Document doc = Jsoup.connect("https://coinmarketcap.com/").get();// this url takes you to a new random wiki page each click .get method gets data

        //Elements CoinNames = doc.getElementsByClass("sc-16r8icm-0 escjiH");
        Elements CoinNames = doc.select("tr"); //get p elements loop through them and append them to the txt string

        List<Crypto> cryptoList = new ArrayList<Crypto>();

        for(Element e: CoinNames) {

            Crypto c = orgCrypto(e);
            cryptoList.add(c);
        }
        rank = 0;
        cryptoList.remove(0);
        return cryptoList;
    }
    static Crypto orgCrypto(Element e){
        String text = e.text();
        Pattern pattern1 = Pattern.compile("(.*(?=[A-Z]{3}))");
        Pattern pattern2 = Pattern.compile("([A-Z]{3}\s|[A-Z]{4}\s)");
        Pattern pattern3 = Pattern.compile("(\\$[0-9]+(\\.[0-9][0-9])?$|\\$[0-9]+?(\\,)?[0-9]+(\\.[0-9][0-9]){1}|\\$.*(?=(\\s)))");

        //Pattern pattern = Pattern.compile("(.*?)(([A-Z]{4}|[A-Z]{3})s)(\\$)");
        Matcher matcher1 = pattern1.matcher(text);
        Matcher matcher2 = pattern2.matcher(text);
        Matcher matcher3 = pattern3.matcher(text);

        String name = "No data", ticker="No data", price="No data";

        //System.out.println(text);
        //System.out.println("rank " + rank);
        if (matcher1.find()) {
            //System.out.println("name");
            if(rank < 11){
                name = cleanUpName(matcher1.group(1));
            }else{
                name = removeTrailing(matcher1.group(1));
            }

           // System.out.println(name);
        }
        if (matcher2.find()) {
            //System.out.println("ticker");
            ticker = matcher2.group(1);
            //System.out.println(ticker);
        }
        if (matcher3.find()) {
            //System.out.println("price");
            price = matcher3.group(1);
            if(rank< 11){
                price = cleanPrice(price);
            }
            //System.out.println(price);
        }
       //System.out.println();
        Crypto c;
        rank++;
        return new Crypto(rank-1, name, ticker, price);
    }
    static String cleanUpName(String name){
        //System.out.println(Arrays.toString(name.split(" ")));
        return name.split(" ")[1];
    }
    static String removeTrailing(String name){
        boolean remove =false;

        //System.out.println("removing func");
        for(int i = 0; i < name.length(); i ++){

//            System.out.println(name);
//            System.out.println(name.charAt(i));
            if (Character.isLowerCase(name.charAt(i))) {
                remove = true;
            }
            if(Character.isUpperCase(name.charAt(i)) && remove==true){
                return name.substring(0, i);
            }
        }
        return name;
    }

    static String cleanPrice(String price){

        for(int i = 0; i<price.length(); i++){
            if(price.charAt(i) == ' '){
                return price.substring(0, i);
            }
        }

        return price;
    }

}








//the div containrer
//sc-16r8icm-0 escjiH
//sc-16r8icm-0 escjiH

//name
//sc-16r8icm-0 sc-1teo54s-1 dNOTPP
//sc-1eb5slv-0 iworPT

///price
//sc-131di3y-0 cLgOOr

//sc-131di3y-0 cLgOOr

//class coin-logo
//https://s2.coinmarketcap.com/static/img/coins/64x64/1.png


