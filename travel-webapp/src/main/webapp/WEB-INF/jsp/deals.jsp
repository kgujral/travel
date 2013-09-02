<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
<%@taglib prefix="s" uri="/struts-tags" %>

<html>

<head>
	<title>All Deals</title>
	<style type="text/css">
	
	.news_item_f .yjtbot_ln {
	background: url(images/bot_ln2.gif) no-repeat left bottom;
	
	}
	
	.news_item_f .yjtbot_rn {
	background: url(images/bot_rn2.gif) no-repeat right bottom;
	padding: 20px 10px;
	overflow: hidden;
	}
	
	.news_item_f .yjttop_ln {
	background: url(images/top_ln2.gif) no-repeat left top;
	}
	
	.news_item_f .yjttop_rn {
	background: url(images/top_rn2.gif) no-repeat right top;
	}
	
	.contentheading {
		height: 30px;		
	}
	</style>
</head>
<body>
<script>
	var pageSize = 9;
	var currentPage = 1;
	var totalPages = 0;
</script>
<div id="holder">
<!-- Start of deals -->
<div id="midblock" style="width: 100%;">
<div class="insidem">
<div class="frontpage_default">

<div id="searchCat" style="margin-bottom: 20px">
<h2>Quick search</h2>
Name: <s:textfield id="catName" />
Price Range: <s:select id="catPrice" list="#{'0':'(any)', '1000':'Upto Rs.1,000','3000':'Upto Rs.3,000','5000':'Upto Rs.5,000','10000':'Upto Rs.10,000',
'99999999':'Above Rs.10,000'}"></s:select>
Category: <s:select id="catCategory" list="categories" listKey="id" listValue="dealType"></s:select>
<input type="button" value="Search" id="searchDeals" onclick="searchDeals()"/>
<div style="float: right">
<span><input type="button" class="prevButton" onclick="prevPage()" value="Prev"/></span> Page <span class="currentPage">1</span> of <span class="totalPages">0</span> <span><input type="button" class="nextButton" onclick="nextPage()" value="Next"/></span>
</div>
</div>
<hr/>
<div style="margin-left: 30px"><img src="images/allDeals.png"></img></div>

<table class="blog" cellpadding="0" cellspacing="0" width="100%">
	<tr>
		<td valign="top">
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td id="midDeals" valign="top" class="article_column">
						
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<div id="searchCat_bottom" style="margin-bottom: 30px">
<div style="float: right">
<span><input type="button" class="prevButton" onclick="prevPage()" value="Prev"/></span> Page <span class="currentPage">1</span> of <span class="totalPages">0</span> <span><input type="button" class="nextButton" onclick="nextPage()" value="Next"/></span>
</div>
</div>
</div>
</div>
</div>
<!-- end of deals -->

</div>


<script>
	function rightDeals(heading, imgUrl, shortDesc, readMoreUrl) {
		var div = jQuery("#rightDeals");
		div.append("<div class=\"yjnewsflash\"><a href=\""+readMoreUrl+"\"><img src=\""+imgUrl+"\" border=\"0\" height=\"47px\"	align=\"left\" title=\""+heading+"\" width=\"65px\" alt=\""+heading+"\" /></a><div class=\"yjnf_descr\"><a class=\"yjnewsflash_title\" href=\""+readMoreUrl+"\">"+heading+"</a><br /><p>"+shortDesc+"</p></div><span class=\"yjnsreadon\"><a class=\"yjns_rm\"	href=\""+readMoreUrl+"\">more</a></span></div>");
	}
	
	function sliderDeals(heading, imgUrl, shortDesc, longDesc, readMoreUrl) {
		var ul = jQuery("#navigator");
		ul.append("<li class=\"element\"><div class=\"inner\" style=\"width: 380px;\"><img src=\""+imgUrl+"\" border=\"0\" title=\""+heading+"\" alt=\""+heading+"\" /> <span class=\"title\">"+heading+"</span><p class=\"desc\" style=\"width: 260px;\">"+shortDesc+"</p></div></li>");
		
		var div = jQuery("#slides");
		div.append("<div class=\"slide\" style=\"height: 300px; width: 580px;\"><a href=\""+readMoreUrl+"\"	title=\""+heading+"\"><img src=\""+imgUrl+"\" border=\"0\" title=\""+heading+"\" alt=\""+heading+"\" /></a><div class=\"long_desc\" style=\"height: 300px;\"><h1>"+heading+"</h1>"+longDesc+" <a href=\""+readMoreUrl+"\" title=\""+heading+"\">See more details</a></div></div>");
	}
	function midDeals(heading, imgUrl, shortDesc, longDesc, oldPrice, price, readMoreUrl) {
		var td = jQuery("#midDeals");
		td.append("<div style=\"float:left; width: 30%; margin: 10px\">"
		+"<div class=\"news_item_f\">"
		+"<div class=\"yjtmid_ln\">"
		+"<div class=\"yjtmid_rn\">"
		+"<div class=\"yjttop_ln\">"
		+"<div class=\"yjttop_rn\">"
		+"<div class=\"yjtbot_ln\">"
		+"<div class=\"yjtbot_rn\">"
		+"<div class=\"newsitem_text\">"
		+"<a href=\""+readMoreUrl+"\"><h2 class=\"contentheading\">"+heading+"</h2></a><p style=\"float: left;\">"
		+"<a href=\""+readMoreUrl+"\"><img class=\"border\" src=\""+imgUrl+"\" border=\"0\" alt=\""+heading+"\" width=\"100\" height=\"75\" /></a></p>"
		+"<p>"+shortDesc+"</p><p class=\"price\">"
		+"<span class=\"old\">Original Price: Rs. "+oldPrice+"</span><br/>"
		+"You Pay: Rs. "+price+"/-</p><p><a style=\"float:right;width: 56px;\" class=\"order\" href=\""+readMoreUrl+"\">Book</a></p>"
		+"</div></div></div></div></div></div></div></div></div>");
	}
	
	function fillMidDeals(midDealsList) {
		var td = jQuery("#midDeals");
		if(midDealsList.length == 0) {
			td.html("<h3 style=\"margin-left: 30px;\">Sorry no Data matched your search!</h3>");
		}
		else {
			td.html("");
			var i;
			for(i=0; i<midDealsList.length;i++) {
				var deal = midDealsList[i];
				var longDesc = deal.longDesc;
				if(longDesc.length > 302) {
					longDesc = longDesc.substring(0,302)+"...";
				}
				var shortDesc = deal.shortDesc;
				if(shortDesc.length > 72) {
					shortDesc = shortDesc.substring(0,72)+"...";
				}
				midDeals(deal.name, deal.imgUrl,shortDesc, longDesc, deal.oldPrice, deal.dealPrice, "deal.html?id="+deal.id);
			}
		}
	}
	jQuery(document).ready(function() {
		jQuery("#adverts1").hide();
		currentPage = 1;
		ajaxCall(1);
	});
	
	function searchDeals() {
		currentPage = 1;
		ajaxCall(1);
	}
	
	function paging() {
		jQuery(".totalPages").text(totalPages);
		jQuery(".currentPage").text(currentPage);
	}
	function nextPage() {
		currentPage ++ ;
		if(currentPage <= totalPages) {
			ajaxCall(currentPage);
		}
		else {
			currentPage --;
		}
		validatePagination();
	}

	function prevPage() {
		currentPage -- ;
		if(currentPage >= 1) {
			ajaxCall(currentPage);
		}
		else {
			currentPage ++;
		}
		validatePagination();
	}

	function validatePagination() {
		if(currentPage >= totalPages) {
			jQuery(".nextButton").attr("disabled","true");
		}
		else {
			jQuery(".nextButton").removeAttr("disabled");
		}
		if(currentPage <= 1) {
			jQuery(".prevButton").attr("disabled","true");
		}
		else {
			jQuery(".prevButton").removeAttr("disabled");
		}
	}
	
	function ajaxCall(currentPage) {
		var name = jQuery("#catName").val();
		var price = jQuery("#catPrice").val();
		var category = jQuery("#catCategory").val();
		var td = jQuery("#midDeals");
		td.html("<img src=\"images/loading.gif\" />");
		jQuery.ajax({
			   type: "POST",
			   url: "allDeals.html",
			   data: "name="+name+"&price="+price+"&id="+category+"&pageNumber="+currentPage+"&pageSize="+pageSize,
			   dataType: "json",
			   success: function(msg){
				   fillMidDeals(msg.dealmins);
				   Cufon.replace('.contentheading');
				   Cufon.replace('.price');
				   totalPages = Math.ceil(msg.rowCount/pageSize);
				   paging();
				   validatePagination();
			   }
		});
	}
</script>

</body>

</html>
	