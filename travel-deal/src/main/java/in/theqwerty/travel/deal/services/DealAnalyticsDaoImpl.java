package in.theqwerty.travel.deal.services;

import in.theqwerty.travel.core.services.GenericDaoImpl;
import in.theqwerty.travel.deal.api.DealAnalyticsDao;
import in.theqwerty.travel.deal.domain.DealAnalytics;

import org.springframework.stereotype.Repository;

@Repository("dealAnalyticsDao")
public class DealAnalyticsDaoImpl extends GenericDaoImpl<Long, DealAnalytics> implements DealAnalyticsDao {

}
