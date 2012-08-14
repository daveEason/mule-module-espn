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

    @Test
    public void testGetListBaseballAthletes() throws Exception
    {
        runFlowAndExpectJSON("getListBaseballAthletes","status","success");
    }

    @Test
    public void testGetBaseballAthlete() throws Exception
    {
        Map msg = new HashMap();
        msg.put("playerId","31662");

        runFlowWithPayloadAndExpectJSON("getBaseballAthlete", "status",  msg, "success");
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
    protected <T> void runFlowAndExpectJSON(String flowName, T keyName, T expect) throws Exception
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
    protected <T, U> void runFlowWithPayloadAndExpectJSON(String flowName, T keyName, U payload, T expect) throws Exception
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
