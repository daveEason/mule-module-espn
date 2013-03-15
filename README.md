
NOTE: THIS PROJECT HAS BEEN MOVED TO https://github.com/mulesoft/espn-connector.git

-----------------------------------------------------

WELCOME
=======
Welcome to the Mule ESPN API Connector

./pom.xml:
A maven project descriptor that describes how to build this module.

./LICENSE.md:
The open source license text for this project.

TESTING
=======

This  project also contains test classes that can be run as part of a test
suite.

Import Connector into Mule Studio (via Eclipse update site)
-----------------------------------------------------------

1. Refer to documentation - Installing additional connectors:

        http://www.mulesoft.org/documentation/display/current/Additional+Cloud+Connectors

2. Add the Mule (Beta) connectors Eclipse Update site:
        - MuleStudio > Help > Install New Software...
        - Click "Add" and enter, Name=Mule Beta Connectors, Location=http://repository.mulesoft.org/connectors/beta/1

3. Install Espn Connector from 'Community' (Beta):
        - Expand the 'Community' drop down menu
        - Select "Mule ESPN Cloud Connector Mule Studio Extension", then Click 'Next'
        - Review and Accept license details, then Click 'Finish'

4. Your newly installed ESPN Connector should be available from the 'Cloud Connectors' palette
        - You may need to restart Mule Studio before the connector is displayed.

Manually build ESPN connector
-----------------------------

1. Clone repository locally (git clone ...)

2. The ESPN Connector build process requires that your API key be set as an environment variable:
        - export ESPN_ACCESS_KEY=InsertEspnApiKeyHere
        - Note: If you don't have an api key you can get a developer account here: http://developer.espn.com/

3. Building Connector (see 'Building Your Connector' link provided):

        http://www.mulesoft.org/documentation/display/DEVKIT/Your+First+Cloud+Connector

ADDITIONAL RESOURCES
====================
Everything you need to know about getting started with Mule can be found here:
http://www.mulesoft.org/documentation/display/MULE3INTRO/Home

There further useful information about extending Mule here:
http://www.mulesoft.org/documentation/display/DEVKIT/Home

Remember if you get stuck you can try getting help on the Mule user list:
http://www.mulesoft.org/email-lists

Also, MuleSoft, the company behind Mule, offers 24x7 support options:
http://www.mulesoft.com/enterprise-subscriptions-and-support

Enjoy your Mule ride!

The Mule Team
