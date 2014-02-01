/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shivam Tiwari
 */
import Crawler.GlobalCrawlerControl;
import Crawler.PreferentialCrawlerControl;

import java.util.Scanner;

public class MainClass {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        //Scanner Object
        Scanner scanObj = new Scanner(System.in);
        
        //required variables
        String storageFolder;
        int numOfCrawlers;
        int politeness;
        int maxDepth;
        int maxPages;
        String seed;
        String preferentialURL;
        
        System.out.println("Enter address of a folder to store temporary configurational files");
        storageFolder = scanObj.next();
        
        System.out.println("Enter the number of crawlers you wish to create");
        numOfCrawlers = scanObj.nextInt();
        
        System.out.println("Enter politeness delay");
        politeness = scanObj.nextInt();
        
        System.out.println("Enter maximum depth of crawl");
        maxDepth = scanObj.nextInt();
        
        System.out.println("Enter maximum number of pages you wish to crawl");
        maxPages = scanObj.nextInt();
        
        System.out.println("Enter the URL you wish to start crawling");
        seed = scanObj.next();
        
        //Preferential crawler
        System.out.println("Initializing Preferential Crawler");
        PreferentialCrawlerControl preferentialCrawler;
        preferentialCrawler = new PreferentialCrawlerControl(storageFolder,numOfCrawlers,politeness,maxDepth,maxPages,seed);
        
        //Global Crawler
        System.out.println("Initializing Global Crawler");
        GlobalCrawlerControl globalCrawler;
        globalCrawler = new GlobalCrawlerControl(storageFolder,numOfCrawlers,politeness,maxDepth,maxPages,seed);
    }
}