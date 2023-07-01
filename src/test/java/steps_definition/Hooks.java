package steps_definition;

import base_class.BaseSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

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
