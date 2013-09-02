package in.theqwerty.travel.deal.dao;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;


@ContextConfiguration(locations = { "classpath:dealApplicationContext-Test.xml" })
public class AbstractDealTest extends AbstractTransactionalJUnit4SpringContextTests{

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
