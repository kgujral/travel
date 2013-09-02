/*
 ** Copyright 2006 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package in.theqwerty.travel.webapp.actions;

import in.theqwerty.travel.webapp.cache.ApplicationCache;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 */
public class IndexAction extends ActionSupport {

	private String midDeals;
	private String sliderDeals;
	private String rightDeals;

	public String getRightDeals() {
		return rightDeals;
	}

	public void setRightDeals(String rightDeals) {
		this.rightDeals = rightDeals;
	}

	public String getSliderDeals() {
		return sliderDeals;
	}

	public void setSliderDeals(String sliderDeals) {
		this.sliderDeals = sliderDeals;
	}

	public String getMidDeals() {
		return midDeals;
	}

	public void setMidDeals(String midDeals) {
		this.midDeals = midDeals;
	}

	@Override
	public String execute() throws Exception {
		Gson gson = new Gson();
		midDeals = gson.toJson(ApplicationCache.FEATURED_DEALS);
		sliderDeals = gson.toJson(ApplicationCache.SLIDER_DEALS);
		rightDeals = gson.toJson(ApplicationCache.LATEST_DEALS);
		return SUCCESS;
	}
	
    /**
	 * Auto-generated
	 */
	private static final long serialVersionUID = 2264024219756530974L;
}
