<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
<%@taglib prefix="s" uri="/struts-tags" %>

<html>

<head>
	<title>Home</title>
</head>


<body>
<s:hidden name="midDeals" id="hiddenMidDeals" />
<s:hidden name="sliderDeals" id="hiddenSliderDeals" />
<s:hidden name="rightDeals" id="hiddenRightDeals" />
<div id="holder">

<!-- Start of deals -->
<div id="midblock" style="width: 64%;">
<div class="insidem">
<div class="frontpage_default">
<table class="blog" cellpadding="0" cellspacing="0">
	<tr>
		<td valign="top">
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td id="midDeals" valign="top" width="100%" class="article_column">
						
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</div>
</div>
</div>
<!-- end of deals -->

<!-- Start of right content -->
<div id="rightblock" style="width: 36%;">
<div class="insider">

<!-- Start of 5 star deals -->
<div class="yjsquare_yj1">
<div class="yjsquare_out_yj1">
<div class="title_d">
	<div class="title_l">
		<div class="title_r">
			<h3><span>Latest Deals</span></h3>
		</div>
	</div>
</div>

<div id="rightDeals" class="yjsquare_in">


</div>
</div>
</div>
<!-- End of right 5 star deals -->



</div>
</div>
<!-- End of right Content -->
</div>


<script>
	
	function rightDeals(heading, imgUrl, oldPrice, newPrice, readMoreUrl) {
		var div = jQuery("#rightDeals");
		div.append("<div class=\"yjnewsflash\"><a href=\""+readMoreUrl+"\"><img src=\""+imgUrl+"\" border=\"0\" height=\"47px\"	align=\"left\" title=\""+heading+"\" width=\"65px\" alt=\""+heading+"\" /></a><div class=\"yjnf_descr\"><a class=\"yjnewsflash_title\" href=\""+readMoreUrl+"\">"+heading+"</a><br /><p class=\"rprice\"><span class=\"old\">Original Price: Rs. "+oldPrice+"</span></p><p class=\"rprice\">You Pay: Rs. "+newPrice+"/-</p></div><span class=\"yjnsreadon\"><a class=\"yjns_rm\" href=\""+readMoreUrl+"\">more</a></span></div>");
	}
	
	function sliderDeals(heading, imgUrl, shortDesc, longDesc, readMoreUrl) {
		var ul = jQuery("#navigator");
		ul.append("<li class=\"element\"><div class=\"inner\" style=\"width: 380px;\"><img src=\""+imgUrl+"\" border=\"0\" title=\""+heading+"\" alt=\""+heading+"\" /> <span class=\"title\">"+heading+"</span><p class=\"desc\" style=\"width: 260px;\">"+shortDesc+"</p></div></li>");
		
		var div = jQuery("#slides");
		div.append("<div class=\"slide\" style=\"height: 300px; width: 580px;\"><a href=\""+readMoreUrl+"\"	title=\""+heading+"\"><img src=\""+imgUrl+"\" border=\"0\" title=\""+heading+"\" alt=\""+heading+"\" /></a><div class=\"long_desc\" style=\"height: 300px;\"><h1>"+heading+"</h1>"+longDesc+" <a href=\""+readMoreUrl+"\" title=\""+heading+"\">See more details</a></div></div>");
	}
	
	function midDeals(heading, imgUrl, longDesc, oldPrice, price, readMoreUrl) {
		var td = jQuery("#midDeals");
		td.append("<div class=\"news_item_f\"><div class=\"yjtmid_ln\"><div class=\"yjtmid_rn\"><div class=\"yjttop_ln\"><div class=\"yjttop_rn\"><div class=\"yjtbot_ln\"><div class=\"yjtbot_rn\"><div class=\"newsitem_text\"><p style=\"float: left;\"><a href=\""+readMoreUrl+"\"><img class=\"border\" src=\""+imgUrl+"\" border=\"0\" alt=\""+heading+"\" width=\"200\" height=\"150\" /></a></p><a href=\""+readMoreUrl+"\"><h2 style=\"padding: 20px\" class=\"contentheading\">"+heading+"</h2></a><p>"+longDesc+"</p><p class=\"price\"><span class=\"old\">Original Price: Rs. "+oldPrice+"</span><br/>You Pay: Rs. "+price+"/-</p><p><a class=\"order\" href=\""+readMoreUrl+"\">Book Now</a></p></div><a href=\""+readMoreUrl+"\" class=\"readon\"><span> Read more...</span> </a></div></div></div></div></div></div></div><span class=\"article_separator\">&nbsp;</span>");
	}
	jQuery(document).ready(function() {
		enableSlider();
		jQuery("#adverts1").show();
		var midDealsList = JSON.parse(jQuery("#hiddenMidDeals").val());
		var i;
		for(i=0; i<midDealsList.length;i++) {
			var deal = midDealsList[i];
			var longDesc = deal.longDesc;
			if(longDesc.length > 302) {
				longDesc = longDesc.substring(0,302)+"...";
			}
			midDeals(deal.name, deal.imgUrl, longDesc, deal.oldPrice, deal.dealPrice, "deal.html?id="+deal.id);
		}
		
		var sliderDealsList = JSON.parse(jQuery("#hiddenSliderDeals").val());
		for(i=0; i<sliderDealsList.length;i++) {
			var deal = sliderDealsList[i];
			var shortDesc = deal.shortDesc;
			if(shortDesc.length > 72) {
				shortDesc = shortDesc.substring(0,72)+"...";
			}
			var longDesc = deal.longDesc;
			if(longDesc.length > 302) {
				longDesc = longDesc.substring(0,302)+"...";
			}
			sliderDeals(deal.name, deal.imgUrl, shortDesc, longDesc, "deal.html?id="+deal.id);
		}
		
		var rightDealsList = JSON.parse(jQuery("#hiddenRightDeals").val());
		for(i=0; i<rightDealsList.length;i++) {
			var deal = rightDealsList[i];
			rightDeals(deal.name, deal.imgUrl, deal.oldPrice, deal.dealPrice, "deal.html?id="+deal.id);
		}
		
	});
</script>

</body>

</html>
	