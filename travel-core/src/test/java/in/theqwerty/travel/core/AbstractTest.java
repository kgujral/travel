package in.theqwerty.travel.core;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;


@ContextConfiguration(locations = { "classpath:applicationContext-Test.xml" })
public class AbstractTest extends AbstractTransactionalJUnit4SpringContextTests{

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
