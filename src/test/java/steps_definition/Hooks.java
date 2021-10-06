package steps_definition;

import base_class.BaseSteps;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks
{
    @Before
    public void BeforeAllTest(Scenario _scenario) throws Throwable
    {
        BaseSteps.OpenBrowser();
        BaseSteps.scenario = _scenario;
    }

    @After
    public void AfterAllTest() throws Throwable
    {
        if (BaseSteps.scenario.isFailed())
            BaseSteps.screenShotNow();
        BaseSteps.CloseBrowser();
    }
}
