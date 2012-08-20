/**
 * This file was automatically generated by the Mule Development Kit
 */
package org.mule.module;

import org.apache.commons.httpclient.HttpClient;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;
import org.mule.api.annotations.rest.*;

import java.io.IOException;

/**
 * Cloud Connector
 *
 * @author MuleSoft, Inc.
 */
@Connector(name="espn", schemaVersion="1.0-SNAPSHOT")
public abstract class espnConnector
{
    public static final String BASE_URI = "http://api.espn.com/v1";

    @RestHttpClient
    private HttpClient httpClient;

    /**
     * Configurable
     */
    @Configurable
    @RestUriParam("apiKey")
    private String apiKey;

    public espnConnector()
    {
        httpClient = new HttpClient();
    }

    /**
     * Set property
     *
     * @param apiKey - ESPN API key (see developer.espn.com for access to their APIs)
     */
    public void setApiKey(String apiKey)
    {
        this.apiKey = apiKey;
    }

    public String getApiKey()
    {
        return this.apiKey;
    }

    /**
     * Set property
     *
     * @param httpClient
     */

    public void setHttpClient(HttpClient httpClient){
        this.httpClient = httpClient;
    }

    public HttpClient getHttpClient(){
        return this.httpClient;
    }

    /* ESPN Athletes API -  http://developer.espn.com/docs/athletes */

    /**
     * getAthletes
     *
     * {@sample.xml ../../../doc/espn-connector.xml.sample espn:get-athletes}
     *
     * @param resource - ESPN resource (i.e. /sports/baseball/mlb)
     * @param athleteId - ESPN player id
     * @param dates - ESPN dates values (year) for requested data (i.e. 2011, 2012, etc...)
     * @param group - ESPN group (integer) allows filtering by "group" or division
     * @param enable - ESPN optional flag to enable specific info (comma separated string) valid values: stats/logos/notes/competitors
     * @param seasonType - ESPN season type accepts pre/reg/post for preseason, regular and postseason respectively
     * @param language - ESPN lang - valid values include 'en' (English) and 'es' (Spanish)
     * @return String - JSON string representing athlete data
     * @throws IOException
     *
     */
    @Processor
    @RestCall(uri = BASE_URI + "/{resource}/athletes/{athleteId}/dates/{dates}?apikey={apiKey}", method = HttpMethod.GET)
    public abstract String getAthletes(@RestUriParam("resource") String resource,
                                       @Optional @Default("") @RestUriParam("athleteId") String athleteId,
                                       @Optional @Default("") @RestUriParam("dates") String dates,
                                       @Optional @Default("") @RestQueryParam("groups") String group,
                                       @Optional @Default("") @RestQueryParam("enable") String enable,
                                       @Optional @Default("reg") @RestQueryParam("seasontype") String seasonType,
                                       @Optional @Default("en") @RestQueryParam("lang") String language) throws IOException;

    /* ESPN Teams API -  http://developer.espn.com/docs/teams */

    /**
     * getTeams
     *
     * {@sample.xml ../../../doc/espn-connector.xml.sample espn:get-teams}
     *
     * @param resource - ESPN resource (i.e. /sports/baseball/mlb)
     * @param teamId - ESPN team identifier
     * @return String - JSON string representing team data
     * @throws IOException
     *
     */
    @Processor
    @RestCall(uri = BASE_URI + "/{resource}/athletes/teams/{teamId}?apikey={apiKey}", method = HttpMethod.GET)
    public abstract String getTeams(@RestUriParam("resource") String resource,
                                    @Optional @Default("") @RestUriParam("teamId") String teamId) throws IOException;

    /* ESPN Headlines API - http://developer.espn.com/docs/headlines */

    /**
     * getNews
     *
     * {@sample.xml ../../../doc/espn-connector.xml.sample espn:get-news newsId="#[message.payload[newsId]]"}
     *
     * @param resource - ESPN resource (i.e. /espnw)
     * @return String - JSON stream of all news for current date.
     * @throws IOException
     *
     */
    @Processor
    @RestCall(uri = BASE_URI + "/{resource}/news?apikey={apiKey}", method = HttpMethod.GET)
    public abstract String getNews(@RestUriParam("resource") String resource) throws IOException;

    /**
     * getNewsById
     *
     * {@sample.xml ../../../doc/espn-connector.xml.sample espn:get-news-by-id newsId="#[message.payload[newsId]]"}
     *
     * @param resource - ESPN resource (i.e. /espnw)
     * @param newsId - ESPN specific story identifier
     * @return String - JSON stream of all news for current date.
     * @throws IOException
     *
     */
    @Processor
    @RestCall(uri = BASE_URI + "/{resource}/news/{newsId}?apikey={apiKey}", method = HttpMethod.GET)
    public abstract String getNewsById(@RestUriParam("resource") String resource,
                                   @Optional @Default("") @RestUriParam("newsId") String newsId) throws IOException;

    /**
     * getNewsHeadlines
     *
     * {@sample.xml ../../../doc/espn-connector.xml.sample espn:get-news-headlines}
     *
     * @param resource - ESPN resource (i.e. /espnw)
     * @return String - JSON Top stories as chosen by ESPN editorial staff.
     * @throws IOException
     *
     */
    @Processor
    @RestCall(uri = BASE_URI + "/{resource}/news/headlines?apikey={apiKey}", method = HttpMethod.GET)
    public abstract String getNewsHeadlines(@RestUriParam("resource") String resource) throws IOException;

    /**
     * getNewsHeadlinesTop
     *
     * {@sample.xml ../../../doc/espn-connector.xml.sample espn:get-news-headlines-top}
     *
     * @param resource - ESPN resource (i.e. /espnw)
     * @return String - JSON top stories as shown on ESPN.com home page. Only applicable to /sports resource.
     * @throws IOException
     *
     */
    @Processor
    @RestCall(uri = BASE_URI + "/{resource}/news/headlines/top?apikey={apiKey}", method = HttpMethod.GET)
    public abstract String getNewsHeadlinesTop(@RestUriParam("resource") String resource) throws IOException;

    /**
     * getAthletesNews
     *
     * {@sample.xml ../../../doc/espn-connector.xml.sample espn:get-athletes-news}
     *
     * @param resource - ESPN resource (i.e. /espnw)
     * @param athleteId - ESPN identifier for a particular player/athlete.
     * @return String - JSON stories about a particular player/athlete.
     * @throws IOException
     *
     */
    @Processor
    @RestCall(uri = BASE_URI + "/{resource}/athletes/{athleteId}/news?apikey={apiKey}", method = HttpMethod.GET)
    public abstract String getAthletesNews(@RestUriParam("resource") String resource,
                                           @RestUriParam("athleteId") String athleteId) throws IOException;

    /**
     * getTeamsNews
     *
     * {@sample.xml ../../../doc/espn-connector.xml.sample espn:get-teams-news}
     *
     * @param resource - ESPN resource (i.e. /espnw)
     * @param teamId - ESPN identifier for a particular team.
     * @return String - JSON stories about a particular player/athlete.
     * @throws IOException
     *
     */
    @Processor
    @RestCall(uri = BASE_URI + "/{resource}/teams/{teamId}/news?apikey={apiKey}", method = HttpMethod.GET)
    public abstract String getTeamsNews(@RestUriParam("resource") String resource,
                                        @RestUriParam("teamId") String teamId) throws IOException;


}
