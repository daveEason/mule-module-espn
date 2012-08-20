/**
 * This file was automatically generated by the Mule Development Kit
 */
package org.mule.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.construct.Flow;
import org.mule.tck.AbstractMuleTestCase;
import org.mule.tck.FunctionalTestCase;

import java.util.HashMap;
import java.util.Map;

public class espnConnectorTest extends FunctionalTestCase
{
    @Override
    protected String getConfigResources()
    {
        return "mule-config.xml";
    }

    /**
     * ESPN Athletes API
     */

    @Test
    public void testGetAthletes() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");

        runFlowWithPayloadAndExpectJSON("getAthletes", "success",  msg, "status");
    }

    @Test
    public void testGetAthletes_ByGroup() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");
        msg.put("group","1");

        runFlowWithPayloadAndExpectJSON("getAthletes_ByGroup", "success",  msg, "status");
    }

    @Test
    public void testGetAthletes_ByAthleteId() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");
        msg.put("athleteId","31662");

        runFlowWithPayloadAndExpectJSON("getAthletes_ByAthleteId", "success",  msg, "status");
    }

    @Test
    public void testGetAthletes_ByDates() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");
        msg.put("athleteId","31662");
        msg.put("dates","2012");

        runFlowWithPayloadAndExpectJSON("getAthletes_ByDates", "success",  msg, "status");
    }

    @Test
    public void testGetTeams() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");

        runFlowWithPayloadAndExpectJSON("getTeams", "success", msg, "status");
    }

//    Currently this information is not publicly on ESPN API - Skipping test for now!
//    @Test
//    public void testGetTeams_ByTeamId() throws Exception
//    {
//        Map msg = new HashMap();
//        msg.put("resource","sports/baseball/mlb");
//        msg.put("teamId","2");
//
//        runFlowWithPayloadAndExpectJSON("getTeams_ByTeamId", "success",  msg, "status");
//    }

    /**
     * ESPN Headlines API
     */

    @Test
    public void testGetNews() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");

        runFlowWithPayloadAndExpectJSON("getNews","success", msg, "status");
    }

    @Test
    public void testGetNews_ByNewsId() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");
        msg.put("newsId","8256331");

        runFlowWithPayloadAndExpectJSON("getNews_ByNewsId","success", msg, "status");
    }

    @Test
    public void testGetNewsHeadlines() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");

        runFlowWithPayloadAndExpectJSON("getNewsHeadlines","success", msg, "status");
    }

    @Test
    public void testGetNewsHeadlinesTop() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");

        runFlowWithPayloadAndExpectJSON("getNewsHeadlinesTop","success", msg, "status");
    }

    @Test
    public void testGetAthletesNews() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");
        msg.put("athleteId","31662");

        runFlowWithPayloadAndExpectJSON("getAthletesNews","success", msg, "status");
    }

    @Test
    public void testGetTeamsNews() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");
        msg.put("teamId","2");

        runFlowWithPayloadAndExpectJSON("getTeamsNews","success", msg, "status");
    }

    /**
    * Run the flow specified by name and assert equality on the expected output
    *
    * @param flowName The name of the flow to run
    * @param expect The expected output
    */
    protected <T> void runFlowAndExpect(String flowName, T expect) throws Exception
    {
        Flow flow = lookupFlowConstruct(flowName);
        MuleEvent event = AbstractMuleTestCase.getTestEvent(null);
        MuleEvent responseEvent = flow.process(event);

        assertEquals(expect, responseEvent.getMessage().getPayload());
    }

    /**
     * Run the flow specified by name and assert equality on the expected output
     *
     * @param flowName The name of the flow to run
     * @param expect The expected output
     * @param keyName The JSON key identifier used for comparison
     */
    protected <T> void runFlowAndExpectJSON(String flowName, T expect, T keyName) throws Exception
    {
        Flow flow = lookupFlowConstruct(flowName);
        MuleEvent event = AbstractMuleTestCase.getTestEvent(null);
        MuleEvent responseEvent = flow.process(event);

        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> response = mapper.readValue((String) responseEvent.getMessage().getPayload(), Map.class);

        assertEquals(expect, response.get(keyName));
    }


    /**
    * Run the flow specified by name using the specified payload and assert
    * equality on the expected output
    *
    * @param flowName The name of the flow to run
    * @param expect The expected output
    * @param payload The payload of the input event
    */
    protected <T, U> void runFlowWithPayloadAndExpect(String flowName, T expect, U payload) throws Exception
    {
        Flow flow = lookupFlowConstruct(flowName);
        MuleEvent event = AbstractMuleTestCase.getTestEvent(payload);
        MuleEvent responseEvent = flow.process(event);

        assertEquals(expect, responseEvent.getMessage().getPayload());
    }

    /**
     * Run the flow specified by name using the specified payload and assert
     * equality on the expected output
     *
     * @param flowName The name of the flow to run
     * @param expect The expected output
     * @param payload The payload of the input event
     */
    protected <T, U> void runFlowWithPayloadAndExpectJSON(String flowName,  T expect, U payload, T keyName) throws Exception
    {
        Flow flow = lookupFlowConstruct(flowName);
        MuleEvent event = AbstractMuleTestCase.getTestEvent(payload);
        MuleEvent responseEvent = flow.process(event);

        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> response = mapper.readValue((String) responseEvent.getMessage().getPayload(), Map.class);

        assertEquals(expect, response.get(keyName));

    }


    /**
     * Retrieve a flow by name from the registry
     *
     * @param name Name of the flow to retrieve
     */
    protected Flow lookupFlowConstruct(String name)
    {
        return (Flow) AbstractMuleTestCase.muleContext.getRegistry().lookupFlowConstruct(name);
    }

}
