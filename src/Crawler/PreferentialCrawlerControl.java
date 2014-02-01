/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Crawler;

/**
 *
 * @author Shivam Tiwari
 */
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class PreferentialCrawlerControl {
    
    private final String crawlStorageFolder;
    private final int numberOfCrawlers;
    private final int politenessDelay;
    private final int maximumDepthOfCrawl;
    private final int maxPagesToFetch;
    private final String seedToBeAdded;
    private final String preferentialDomain;
    
    /**
     *
     * @param x
     * @param y
     * @param z
     * @param a
     * @param b
     * @param c
     * @throws Exception
     */
    
    //Contructor for Global
    public PreferentialCrawlerControl(String x, int y, int z, int a, int b, String c) throws Exception{
        
        crawlStorageFolder = x + "/"+"Preferential";
        numberOfCrawlers = y;
        politenessDelay = z;
        maximumDepthOfCrawl = a;
        maxPagesToFetch = b;
        seedToBeAdded = c;
        preferentialDomain = "";
        
        CrawlConfig configObj = new CrawlConfig();
        
        configObj.setCrawlStorageFolder(crawlStorageFolder);
        
        configObj.setPolitenessDelay(politenessDelay);
        
        configObj.setMaxDepthOfCrawling(maximumDepthOfCrawl);
        
        configObj.setMaxPagesToFetch(maxPagesToFetch);
        
        PageFetcher pageFetcherObj = new PageFetcher(configObj);
        RobotstxtConfig robotstxtConfigObj = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfigObj, pageFetcherObj);
        CrawlController controller = new CrawlController(configObj, pageFetcherObj, robotstxtServer);
        
        controller.addSeed(c);
        
        controller.start(PreferentialCrawler.class, numberOfCrawlers);
    }
}