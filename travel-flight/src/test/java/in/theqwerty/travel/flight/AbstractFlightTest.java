package in.theqwerty.travel.flight;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;


@ContextConfiguration(locations = { "classpath:flight-test.xml" })
public class AbstractFlightTest extends AbstractTransactionalJUnit4SpringContextTests{

	@Before
	public void setUp() {
		if (StringUtils.isNotEmpty(getDataSetFile())){
			executeSqlScript(getDataSetFile(), false);
		}
	}
	
	private String getDataSetFile() {
		return "";
	}
	
	@Test
	public void should() {
	}
	
}
