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
     * Major League Baseball (MLB)
     */

    @Test
    public void testGetAthletes_MLB() throws Exception
    {
        runFlowAndExpectJSON("getAthletes_MLB","success","status");
    }

    @Test
    public void testGetAthletes_MLB_ByGroup() throws Exception
    {
        Map msg = new HashMap();
        msg.put("group","1");

        runFlowWithPayloadAndExpectJSON("getAthletes_MLB_ByGroup", "success",  msg, "status");
    }

    @Test
    public void testGetAthletes_MLB_ByPlayerId() throws Exception
    {
        Map msg = new HashMap();
        msg.put("playerId","31662");

        runFlowWithPayloadAndExpectJSON("getAthletes_MLB_ByPlayerId", "success",  msg, "status");
    }

    @Test
    public void testGetAthletes_MLB_ByDates() throws Exception
    {
        Map msg = new HashMap();
        msg.put("playerId","31662");
        msg.put("dates","2012");

        runFlowWithPayloadAndExpectJSON("getAthletes_MLB_ByDates", "success",  msg, "status");
    }

    @Test
    public void testGetTeams_MLB() throws Exception
    {
        runFlowAndExpectJSON("getTeams_MLB", "success", "status");
    }

    @Test
    public void testGetTeams_MLB_ByTeamId() throws Exception
    {
        Map msg = new HashMap();
        msg.put("teamId","2");

        runFlowWithPayloadAndExpectJSON("getTeams_MLB_ByTeamId", "success",  msg, "status");
    }

    /**
     * National Basketball Association (NBA)
     */

    @Test
    public void testGetAthletes_NBA() throws Exception
    {
        runFlowAndExpectJSON("getAthletes_NBA","success","status");
    }

    @Test
    public void testGetAthletes_NBA_ByGroup() throws Exception
    {
        Map msg = new HashMap();
        msg.put("group","1");

        runFlowWithPayloadAndExpectJSON("getAthletes_NBA_ByGroup", "success",  msg, "status");
    }

    @Test
    public void testGetAthletes_NBA_ByPlayerId() throws Exception
    {
        Map msg = new HashMap();
        msg.put("playerId","31662");

        runFlowWithPayloadAndExpectJSON("getAthletes_NBA_ByPlayerId", "success",  msg, "status");
    }

    @Test
    public void testGetAthletes_NBA_ByDates() throws Exception
    {
        Map msg = new HashMap();
        msg.put("playerId","31662");
        msg.put("dates","2012");

        runFlowWithPayloadAndExpectJSON("getAthletes_NBA_ByDates", "success",  msg, "status");
    }

    @Test
    public void testGetTeams_NBA() throws Exception
    {
        runFlowAndExpectJSON("getTeams_NBA", "success", "status");
    }

    @Test
    public void testGetTeams_NBA_ByTeamId() throws Exception
    {
        Map msg = new HashMap();
        msg.put("teamId","2");

        runFlowWithPayloadAndExpectJSON("getTeams_NBA_ByTeamId", "success",  msg, "status");
    }

    /**
     * National Basketball Association (NBA)
     */

    @Test
    public void testGetAthletes_NFL() throws Exception
    {
        runFlowAndExpectJSON("getAthletes_NFL","success","status");
    }

    @Test
    public void testGetAthletes_NFL_ByGroup() throws Exception
    {
        Map msg = new HashMap();
        msg.put("group","1");

        runFlowWithPayloadAndExpectJSON("getAthletes_NFL_ByGroup", "success",  msg, "status");
    }

    @Test
    public void testGetAthletes_NFL_ByPlayerId() throws Exception
    {
        Map msg = new HashMap();
        msg.put("playerId","31662");

        runFlowWithPayloadAndExpectJSON("getAthletes_NFL_ByPlayerId", "success",  msg, "status");
    }

    @Test
    public void testGetAthletes_NFL_ByDates() throws Exception
    {
        Map msg = new HashMap();
        msg.put("playerId","31662");
        msg.put("dates","2012");

        runFlowWithPayloadAndExpectJSON("getAthletes_NFL_ByDates", "success",  msg, "status");
    }

    @Test
    public void testGetTeams_NFL() throws Exception
    {
        runFlowAndExpectJSON("getTeams_NFL", "success", "status");
    }

    @Test
    public void testGetTeams_NFL_ByTeamId() throws Exception
    {
        Map msg = new HashMap();
        msg.put("teamId","2");

        runFlowWithPayloadAndExpectJSON("getTeams_NFL_ByTeamId", "success",  msg, "status");
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
