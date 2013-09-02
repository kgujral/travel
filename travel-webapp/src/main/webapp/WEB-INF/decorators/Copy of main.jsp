
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb">

<head>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="robots" content="index, follow" />
<meta name="keywords" content="joomla, Joomla" />
<meta name="description"
	content="Joomla! - the dynamic portal engine and content management system" />
<meta name="generator"
	content="Joomla! 1.5 - Open Source Content Management" />
<title>Joomla Travel Template</title>

<link rel="stylesheet" href="css/stylesheet.css" type="text/css"></link>
<link rel="stylesheet" href="css/stylesheet_003.css" type="text/css" />
<link rel="stylesheet" href="css/form_css.css" type="text/css" />
<link rel="stylesheet" href="css/stylesheet_left.css" type="text/css" />
<link rel="stylesheet" href="css/stylesheet_002.css" type="text/css" />

<script type="text/javascript" src="js/mootools.js"></script>
<script type="text/javascript" src="js/caption.js"></script>
<script type="text/javascript" src="js/YJNF5.js"></script>
<script type="text/javascript" src="js/SendForm.js"></script>
<script type="text/javascript" src="js/InfoSlider.js"></script>
<script type="text/javascript">
	window.addEvent('domready', function() {
		new YJNF5({
			outerContainer : 'yjnf5_co',
			innerContainer : 'yjnf5_ci',
			innerElements : '.yjnewsflash5',
			navLinks : {
				upLink : 'up',
				downLink : 'down'
			},
			highlightClass : 'yjnf5_h'
		});
	});
	window.addEvent('domready', function() {
		new InfoSlider({
			navigation : {
				container : 'navigator',
				elements : '.element',
				outer : 'navigator_outer',
				selectedClass : 'selected_left',
				visibleItems : 3
			},
			slides : {
				container : 'slides',
				elements : '.slide',
				infoContainer : '.long_desc',
				infoContainerPosition : 'right',
				startFx : {
					'opacity' : [ 0, 1 ],
					'top' : [ 0, 0 ],
					'left' : [ 0, 0 ],
					'width' : [ 580, 580 ],
					'height' : [ 300, 300 ]
				},
				endFx : {
					'opacity' : 0,
					'top' : 100,
					'left' : 200,
					'width' : 200,
					'height' : 100
				}
			},
			startElem : 2,
			autoSlide : 5000
		});
	});
</script>
<style type="text/css">
div.reservation fieldset.personal-data {
	height: 202px;
	overflow: hidden;
}
</style>
<!--[if lt IE 8]> <style type="text/css">
		div.reservation fieldset.personal-data{
			height:213px;
			overflow:hidden;
		}
		div.reservation fieldset textarea{
			margin:3px 0 0 0;
		}
		</style>
		<![endif]-->
<style type="text/css">
#slides .slide {
	visibility: hidden;
}
</style>

<link href="css/template.css" rel="stylesheet" type="text/css" />
<link href="css/orange.css" rel="stylesheet" type="text/css" />

<link rel="shortcut icon" href="" />

<script type="text/javascript">
	window.addEvent('domready', function() {
		new SmoothScroll({
			duration : 1000
		});
	});
</script>

<!--[if IE 6]>
<link href="http://joomla1.5.youjoomla.info/youtravel/templates/youtravel/css/ifie.php" rel="stylesheet" type="text/css" />
<style type="text/css">
#horiznav_d ul li ul{
width:975px;
}
</style>
<![endif]-->
<!--[if lte IE 8]>
<style type="text/css">
.title_r h3{
padding:2px 0px 0 5px;
}
.search,.yjlivecont{
padding:0;
}
</style>
<![endif]-->

<!--[if lte IE 8]>
		<script type="text/javascript">
		sfHover = function() {
			var sfEls = document.getElementById("horiznav_d").getElementsByTagName("LI");
			for (var i=0; i<sfEls.length; i++) {
				sfEls[i].onmouseover=function() {
					this.className+=" sfHover";
				}
				sfEls[i].onmouseout=function() {
					this.className=this.className.replace(new RegExp(" sfHover\\b"), "");
				}
			}
		}
		if (window.attachEvent) window.attachEvent("onload", sfHover);
		</script>
<![endif]-->
<script type="text/javascript" src="js/dropd.js"></script>

<script src="js/cufon-yui.js" type="text/javascript"></script>

<script src="js/Museo_700_600.font.js" type="text/javascript"></script>

<script type="text/javascript">
	Cufon.replace('h1,h2,h3,h4,.price', {
		fontFamily : 'Museo 700'
	});
</script>

<!--[if IE 6]>
<style type="text/css">
#navigator li.selected_left{
background: url(images/orange/pointer_selected_ie.gif) right  no-repeat;
}
#navigator li.selected_right{
background: url(images/orange/pointer_selected_ie_r.gif) left  no-repeat;
}
</style>
<![endif]-->
<decorator:head />
</head>

<body id="color">
	<div id="top_bg">
		<div id="holdthem" style="font-size: 16px; width: 975px;">
			<!--top menu-->
			<div id="top_menu_d" style="font-size: 11px;">
				<div style="height: 70px;" id="horiznav_d">
					<ul class="menunavd">
						<li id="current" class="active"><a href="#"> <span>Home</span>
						</a></li>
						<li><a href="#"> <span>Flights</span> </a></li>
						<li><a href="#"> <span>Hotels</span> </a></li>
						<li><a href="#"> <span>Contact Us</span> </a></li>
					</ul>
				</div>
			</div>
			<!-- end top menu -->
			<div id="centertop" style="font-size: 11px; width: 975px;">
				<!-- notices -->
				<!--end  notices -->
				<!--header-->
				<div id="header">
					<div id="logo" class="png">
						<div id="tags">
							<h1>
								<a href="#" title="Suchi Travels">Around the world</a>
							</h1>
						</div>
						<!-- end tags -->
					</div>
					<!-- end logo -->
					<!-- <div id="banner" style="width: 468px;">
						<img src="images/baner460.gif"
							alt="bannerimage" border="0" />
					</div> -->
					<!-- end banner -->
					<!-- <div id="inset">
						http://www.Youjoomla.com  Yj Live Live Search  for Joomla 1.5 starts here
						<div class="yjlivecont">
							<form method="get"
								action="http://joomla1.5.youjoomla.info/youtravel/index.php">
								<input type="text" name="searchword" id="LiveSearch"
									style="width: 360px;" value="Your Travel Search"
									onfocus="this.value='';"
									onblur="if(this.value==''){this.value='Your Travel Search';}"
									class="yj_inputbox" /> <input type="submit" value="search"
									class="button" /> <input type="hidden" name="option"
									value="com_search" /> <input type="hidden" name="ordering"
									value="" /> <input type="hidden" name="searchphrase"
									value="all" />
							</form>
						</div>
						http://www.Youjoomla.com  Yj Live Live Search  for Joomla 1.0 ends here
					</div> -->
					<!-- end banner -->
				</div>
				<!-- end header -->
			</div>
			<!-- end centartop-->

			<!-- BOTTOM PART OF THE SITE LAYOUT -->
			<div id="centerbottom" style="font-size: 11px; width: 975px;">
				<div id="advert1">
					<div class="yjtmid_l">
						<div class="yjtmid_r">
							<div class="yjttop_l">
								<div class="yjttop_r">
									<div class="yjtbot_l">
										<div class="yjtbot_r">
											<div id="adverts">
												<div id="adverts1">
													<div class="insidead">
														<div class="yjsquare">
															<div class="yjsquare_out">
																<div class="yjsquare_in">
																	<!-- Slider starts here -->
																	<div id="YJT_container"
																		style="height: 300px; width: 960px;">
																		navigator
																		<div id="navigator_outer"
																			style="height: 300px; width: 430px;">
																			<ul id="navigator">
																				<li class="element">
																					<div class="inner" style="width: 380px;">
																						<img src="images/sandy_lane.jpg" border="0"
																							title="Sandy Lane, Barbados " alt="" /> <span
																							class="title">Sandy Lane, Barbados</span>
																						<p class="desc" style="width: 260px;">Lorem
																							ipsum dolor sit amet, consectetur adipiscing
																							elit. Fusce ut odio justo. Sed quis massa sed
																							tellus molestie vulputate nec ac massa. Sed
																							elementum</p>
																					</div>
																				</li>
																				<li class="element">
																					<div class="inner" style="width: 380px;">
																						<img src="images/tutrtle_island.jpg" border="0"
																							title="Turtle Island ,Fiji " alt="" /> <span
																							class="title">Turtle Island ,Fiji</span>
																						<p class="desc" style="width: 260px;">Lorem
																							ipsum dolor sit amet, consectetur adipiscing
																							elit. Fusce ut odio justo. Sed quis massa sed
																							tellus molestie vulputate nec ac massa. Sed
																							elementum</p>
																					</div>
																				</li>
																				<li class="element">
																					<div class="inner" style="width: 380px;">
																						<img src="images/tunnel_beach.jpg" border="0"
																							title="Tunnel Beach " alt="" /> <span
																							class="title">Tunnel Beach</span>
																						<p class="desc" style="width: 260px;">Lorem
																							ipsum dolor sit amet, consectetur adipiscing
																							elit. Fusce ut odio justo. Sed quis massa sed
																							tellus molestie vulputate nec ac massa. Sed
																							elementum</p>
																					</div>
																				</li>
																				<li class="element">
																					<div class="inner" style="width: 380px;">
																						<img src="images/choco_hills.jpg" border="0"
																							title="Choco Hills " alt="" /> <span
																							class="title">Choco Hills</span>
																						<p class="desc" style="width: 260px;">Lorem
																							ipsum dolor sit amet, consectetur adipiscing
																							elit. Fusce ut odio justo. Sed quis massa sed
																							tellus molestie vulputate nec ac massa. Sed
																							elementum</p>
																					</div>
																				</li>
																				<li class="element">
																					<div class="inner" style="width: 380px;">
																						<img src="images/paritutu.jpg" border="0"
																							title="Paritutu Rock " alt="" /> <span
																							class="title">Paritutu Rock</span>
																						<p class="desc" style="width: 260px;">Lorem
																							ipsum dolor sit amet, consectetur adipiscing
																							elit. Fusce ut odio justo. Sed quis massa sed
																							tellus molestie vulputate nec ac massa. Sed
																							elementum</p>
																					</div>
																				</li>
																				<li class="element">
																					<div class="inner" style="width: 380px;">
																						<img src="images/egypt.jpg" border="0"
																							title="Discover Egypt " alt="" /> <span
																							class="title">Discover Egypt</span>
																						<p class="desc" style="width: 260px;">Lorem
																							ipsum dolor sit amet, consectetur adipiscing
																							elit. Fusce ut odio justo. Sed quis massa sed
																							tellus molestie vulputate nec ac massa. Sed
																							elementum</p>
																					</div>
																				</li>
																				<li class="element">
																					<div class="inner" style="width: 380px;">
																						<img src="images/eden_rock.jpg" border="0"
																							title="Eden Rock " alt="" /> <span class="title">Eden
																							Rock</span>
																						<p class="desc" style="width: 260px;">Lorem
																							ipsum dolor sit amet, consectetur adipiscing
																							elit. Fusce ut odio justo. Sed quis massa sed
																							tellus molestie vulputate nec ac massa. Sed
																							elementum</p>
																					</div>
																				</li>
																			</ul>
																		</div>
																		end of navigator, start slides
																		<div id="slides" style="height: 300px; width: 580px;">
																			<div class="slide"
																				style="height: 300px; width: 580px;">
																				<a
																					href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/37-exotic-destinations/62-sandy-lane-barbados.html"
																					title=""><img src="images/sandy_lane.jpg"
																					border="0" title="Sandy Lane, Barbados " alt="" />
																				</a>

																				<div class="long_desc" style="height: 300px;">

																					<h1>Sandy Lane, Barbados</h1>

																					Lorem ipsum dolor sit amet, consectetur adipiscing
																					elit. Fusce ut odio justo. Sed quis massa sed
																					tellus molestie vulputate nec ac massa. Sed
																					elementum lacus ligula. Sed risus sem, dignissim
																					vitae accumsan vel, venenatis vel massa.
																					Pellentesque habitant morbi tristique senectus et
																					netus et malesuada <a
																						href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/37-exotic-destinations/62-sandy-lane-barbados.html"
																						title="">See more details</a>

																				</div>

																			</div>

																			<div class="slide"
																				style="height: 300px; width: 580px;">

																				<a
																					href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/37-exotic-destinations/60-turtle-island-fiji.html"
																					title=""><img src="images/tutrtle_island.jpg"
																					border="0" title="Turtle Island ,Fiji " alt="" />
																				</a>

																				<div class="long_desc" style="height: 300px;">

																					<h1>Turtle Island ,Fiji</h1>

																					Lorem ipsum dolor sit amet, consectetur adipiscing
																					elit. Fusce ut odio justo. Sed quis massa sed
																					tellus molestie vulputate nec ac massa. Sed
																					elementum lacus ligula. Sed risus sem, dignissim
																					vitae accumsan vel, venenatis vel massa.
																					Pellentesque habitant morbi tristique senectus et
																					netus et malesuada <a
																						href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/37-exotic-destinations/60-turtle-island-fiji.html"
																						title="">See more details</a>

																				</div>

																			</div>

																			<div class="slide"
																				style="height: 300px; width: 580px;">

																				<a
																					href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/37-exotic-destinations/57-tunnel-beach.html"
																					title=""><img src="images/tunnel_beach.jpg"
																					border="0" title="Tunnel Beach " alt="" /> </a>

																				<div class="long_desc" style="height: 300px;">

																					<h1>Tunnel Beach</h1>

																					Lorem ipsum dolor sit amet, consectetur adipiscing
																					elit. Fusce ut odio justo. Sed quis massa sed
																					tellus molestie vulputate nec ac massa. Sed
																					elementum lacus ligula. Sed risus sem, dignissim
																					vitae accumsan vel, venenatis vel massa.
																					Pellentesque habitant morbi tristique senectus et
																					netus et malesuada <a
																						href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/37-exotic-destinations/57-tunnel-beach.html"
																						title="">See more details</a>

																				</div>

																			</div>

																			<div class="slide"
																				style="height: 300px; width: 580px;">

																				<a
																					href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/37-exotic-destinations/59-choco-hills.html"
																					title=""><img src="images/choco_hills.jpg"
																					border="0" title="Choco Hills " alt="" /> </a>

																				<div class="long_desc" style="height: 300px;">

																					<h1>Choco Hills</h1>

																					Lorem ipsum dolor sit amet, consectetur adipiscing
																					elit. Fusce ut odio justo. Sed quis massa sed
																					tellus molestie vulputate nec ac massa. Sed
																					elementum lacus ligula. Sed risus sem, dignissim
																					vitae accumsan vel, venenatis vel massa.
																					Pellentesque habitant morbi tristique senectus et
																					netus et malesuada <a
																						href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/37-exotic-destinations/59-choco-hills.html"
																						title="">See more details</a>

																				</div>

																			</div>

																			<div class="slide"
																				style="height: 300px; width: 580px;">

																				<a
																					href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/37-exotic-destinations/58-paritutu-rock.html"
																					title=""><img src="images/paritutu.jpg"
																					border="0" title="Paritutu Rock " alt="" /> </a>

																				<div class="long_desc" style="height: 300px;">

																					<h1>Paritutu Rock</h1>

																					Lorem ipsum dolor sit amet, consectetur adipiscing
																					elit. Fusce ut odio justo. Sed quis massa sed
																					tellus molestie vulputate nec ac massa. Sed
																					elementum lacus ligula. Sed risus sem, dignissim
																					vitae accumsan vel, venenatis vel massa.
																					Pellentesque habitant morbi tristique senectus et
																					netus et malesuada <a
																						href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/37-exotic-destinations/58-paritutu-rock.html"
																						title="">See more details</a>

																				</div>

																			</div>

																			<div class="slide"
																				style="height: 300px; width: 580px;">

																				<a
																					href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/37-exotic-destinations/65-discover-egypt.html"
																					title=""><img src="images/egypt.jpg" border="0"
																					title="Discover Egypt " alt="" /> </a>

																				<div class="long_desc" style="height: 300px;">

																					<h1>Discover Egypt</h1>

																					Lorem ipsum dolor sit amet, consectetur adipiscing
																					elit. Fusce ut odio justo. Sed quis massa sed
																					tellus molestie vulputate nec ac massa. Sed
																					elementum lacus ligula. Sed risus sem, dignissim
																					vitae accumsan vel, venenatis vel massa.
																					Pellentesque habitant morbi tristique senectus et
																					netus et malesuada <a
																						href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/37-exotic-destinations/65-discover-egypt.html"
																						title="">See more details</a>

																				</div>

																			</div>

																			<div class="slide"
																				style="height: 300px; width: 580px;">

																				<a
																					href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/37-exotic-destinations/61-eden-rock.html"
																					title=""><img src="images/eden_rock.jpg"
																					border="0" title="Eden Rock " alt="" /> </a>

																				<div class="long_desc" style="height: 300px;">

																					<h1>Eden Rock</h1>

																					Lorem ipsum dolor sit amet, consectetur adipiscing
																					elit. Fusce ut odio justo. Sed quis massa sed
																					tellus molestie vulputate nec ac massa. Sed
																					elementum lacus ligula. Sed risus sem, dignissim
																					vitae accumsan vel, venenatis vel massa.
																					Pellentesque habitant morbi tristique senectus et
																					netus et malesuada <a
																						href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/37-exotic-destinations/61-eden-rock.html"
																						title="">See more details</a>

																				</div>

																			</div>



																		</div>

																	</div>





																</div>



															</div>

														</div>





													</div>
												</div>

												<div id="adverts2"	style="border-top: 1px solid #DEDBD1; display: none">
													<div class="insidead">
														<div class="yjsquare_book">

															<div class="yjsquare_out_book">













																<div class="yjsquare_in">
																	<div id="yj_booking">
																		<div id="send_responses" class="messages"></div>
																		<!-- reservation form begin -->
																		<form id="ReservationForm" name="yjbooking"
																			method="post" action="/youtravel/">

																			<div class="yjformfields" style="width: 25%;">
																				<div class="reservation">
																					<div class="cB">
																						<div class="cBt">
																							<div></div>
																						</div>
																						<fieldset class="destination_pack_legend">
																							<legend id="destination_pack_legend">
																								<span> Choose your destination:</span>
																							</legend>
																							<div>
																								<label for="destination_pack"
																									id="destination_pack_label">
																									Destination Package:</label> <select
																									name="destination_pack" id="destination_pack">
																									<option value="Clearwater Beach, Tampa Bay">Clearwater
																										Beach, Tampa Bay</option>
																									<option value="Honolulu Diamond Head">Honolulu
																										Diamond Head</option>
																									<option value="Kalamata Resort">Kalamata
																										Resort</option>

																								</select>
																							</div>
																						</fieldset>
																						<div class="cBb">
																							<div></div>
																						</div>
																					</div>
																				</div>
																				<div class="reservation">
																					<div class="cB">
																						<div class="cBt">
																							<div></div>
																						</div>
																						<fieldset>
																							<legend id="accomodation_legend">
																								<span> Accommodation:</span>
																							</legend>
																							<div>
																								<label for="type_of_room"
																									id="type_of_room_label"> Type of room:</label>
																								<select name="type_of_room" id="type_of_room">
																									<option value="single">single</option>
																									<option value="double">double</option>
																									<option value="apartment">apartment</option>
																								</select>
																							</div>
																							<div>
																								<label for="number_of_guests"
																									id="number_of_guests_label"> Number of
																									Guests:</label> <input type="text"
																									name="number_of_guests" id="number_of_guests"
																									size="3" maxlength="3" value=""
																									class="required validate-numeric" />

																							</div>
																						</fieldset>
																						<div class="cBb">
																							<div></div>
																						</div>
																					</div>
																				</div>
																			</div>
																			<div class="yjformfields" style="width: 25%;">
																				<div class="reservation">
																					<div class="cB">
																						<div class="cBt">
																							<div></div>
																						</div>
																						<fieldset>
																							<legend>
																								<span> Check-in:</span>
																							</legend>
																							<div>
																								<label for="day_of_arrival"
																									id="day_of_arrival_label"> Day:</label> <select
																									name="day_of_arrival" id="day_of_arrival">

																									<option value="1">1</option>
																									<option value="2">2</option>
																									<option value="3">3</option>
																									<option value="4">4</option>
																									<option value="5">5</option>
																									<option value="6">6</option>
																									<option value="7">7</option>
																									<option value="8">8</option>
																									<option value="9">9</option>
																									<option value="10">10</option>
																									<option value="11">11</option>
																									<option value="12">12</option>
																									<option value="13">13</option>
																									<option value="14">14</option>
																									<option value="15">15</option>
																									<option value="16">16</option>
																									<option value="17">17</option>
																									<option value="18">18</option>
																									<option value="19">19</option>
																									<option value="20">20</option>
																									<option value="21">21</option>
																									<option value="22">22</option>
																									<option value="23">23</option>
																									<option value="24">24</option>
																									<option value="25">25</option>
																									<option value="26">26</option>
																									<option value="27">27</option>
																									<option value="28">28</option>
																									<option value="29">29</option>
																									<option value="30">30</option>
																									<option value="31">31</option>

																								</select>
																							</div>
																							<div>
																								<label for="month_of_arrival"
																									id="month_of_arrival_label"> Month:</label> <select
																									name="month_of_arrival" id="month_of_arrival">
																									<option value=" January">January</option>
																									<option value=" February">February</option>
																									<option value=" March">March</option>
																									<option value=" April">April</option>
																									<option value=" May">May</option>
																									<option value=" June">June</option>
																									<option value=" July">July</option>
																									<option value=" August">August</option>
																									<option value=" September">September</option>
																									<option value=" October">October</option>
																									<option value=" November">November</option>
																									<option value=" December">December</option>

																								</select>
																							</div>
																							<div>
																								<label for="year_of_arrival"
																									id="year_of_arrival_label"> Year:</label> <select
																									name="year_of_arrival" id="year_of_arrival">
																									<option value="2011">2011</option>
																									<option value="2012">2012</option>
																									<option value="2013">2013</option>
																									<option value="2014">2014</option>
																									<option value="2015">2015</option>
																									<option value="2016">2016</option>
																									<option value="2017">2017</option>
																								</select>
																							</div>
																						</fieldset>
																						<div class="cBb">
																							<div></div>
																						</div>
																					</div>
																				</div>
																				<div class="reservation">
																					<div class="cB">
																						<div class="cBt">
																							<div></div>
																						</div>
																						<fieldset>
																							<legend>
																								<span> Check-out:</span>
																							</legend>
																							<div>
																								<label for="day_of_departure"
																									id="day_of_departure_label"> Day:</label> <select
																									name="day_of_departure" id="day_of_departure">
																									<option value="1">1</option>
																									<option value="2">2</option>
																									<option value="3">3</option>
																									<option value="4">4</option>
																									<option value="5">5</option>
																									<option value="6">6</option>
																									<option value="7">7</option>
																									<option value="8">8</option>
																									<option value="9">9</option>
																									<option value="10">10</option>
																									<option value="11">11</option>
																									<option value="12">12</option>
																									<option value="13">13</option>
																									<option value="14">14</option>
																									<option value="15">15</option>
																									<option value="16">16</option>
																									<option value="17">17</option>
																									<option value="18">18</option>
																									<option value="19">19</option>
																									<option value="20">20</option>
																									<option value="21">21</option>
																									<option value="22">22</option>
																									<option value="23">23</option>
																									<option value="24">24</option>
																									<option value="25">25</option>
																									<option value="26">26</option>
																									<option value="27">27</option>
																									<option value="28">28</option>
																									<option value="29">29</option>
																									<option value="30">30</option>
																									<option value="31">31</option>

																								</select>
																							</div>
																							<div>
																								<label for="month_of_departure"
																									id="month_of_departure_label"> Month:</label> <select
																									name="month_of_departure"
																									id="month_of_departure">
																									<option value=" January">January</option>
																									<option value=" February">February</option>
																									<option value=" March">March</option>
																									<option value=" April">April</option>
																									<option value=" May">May</option>
																									<option value=" June">June</option>
																									<option value=" July">July</option>
																									<option value=" August">August</option>
																									<option value=" September">September</option>
																									<option value=" October">October</option>
																									<option value=" November">November</option>
																									<option value=" December">December</option>

																								</select>
																							</div>
																							<div>
																								<label for="year_of_departure"
																									id="year_of_departure_label"> Year:</label> <select
																									name="year_of_departure" id="year_of_departure">
																									<option value="2011">2011</option>
																									<option value="2012">2012</option>
																									<option value="2013">2013</option>
																									<option value="2014">2014</option>
																									<option value="2015">2015</option>
																									<option value="2016">2016</option>
																									<option value="2017">2017</option>
																								</select>
																							</div>
																						</fieldset>
																						<div class="cBb">
																							<div></div>
																						</div>
																					</div>
																				</div>
																			</div>
																			<div class="yjformfields" style="width: 25%;">
																				<div class="reservation">
																					<div class="cB">
																						<div class="cBt">
																							<div></div>
																						</div>
																						<fieldset class="personal-data">
																							<legend class="personal_data">
																								<span> Personal Information:</span>
																							</legend>
																							<div class="move">
																								<label for="first_name" id="first_name_label">
																									Name:</label>
																								<div class="perdatam">
																									<input type="text" name="first_name"
																										id="first_name" value="" class="required" />
																								</div>

																							</div>
																							<div class="move">
																								<label for="surname" id="surname_label">
																									Surname:</label>
																								<div class="perdatam">
																									<input type="text" name="surname" id="surname"
																										value="" class="required" />
																								</div>

																							</div>
																							<div class="move">
																								<label for="email" id="email_label">
																									E-mail:</label>
																								<div class="perdatam">
																									<input type="text" name="email" id="email"
																										value="" class="required validate-email" />
																								</div>

																							</div>
																							<div class="move">
																								<label for="phone" id="phone_label">
																									Phone:</label>
																								<div class="perdatam">
																									<input type="text" name="phone" id="phone"
																										value="" class="required validate-numeric" />
																								</div>

																							</div>
																						</fieldset>
																						<div class="cBb">
																							<div></div>
																						</div>
																					</div>
																				</div>
																			</div>
																			<div class="yjformfields" style="width: 25%;">
																				<div class="reservation">
																					<div class="cB">
																						<div class="cBt">
																							<div></div>
																						</div>
																						<fieldset class="personal-data">
																							<legend>
																								<span> Additional Information:</span>
																							</legend>
																							<div class="move2">
																								<textarea name="additional_info"
																									id="additional_info" cols="" rows=""></textarea>
																							</div>

																							<label for="captcha_ver" id="captcha_ver_label">
																								Captcha result</label> <input type="text"
																								name="captcha_ver" id="captcha_ver" value=""
																								class="required validate-numeric" />
																							<div class="captch_img">
																								<img
																									src="http://joomla1.5.youjoomla.info/youtravel/modules/mod_yj_booking/captcha.php"
																									alt="verification" id="captcha_image" /> <a
																									href="#" title="refresh captcha"
																									id="captcha_refresh"></a>
																							</div>

																							<div class="form_butt">
																								<input type="submit" name="salji"
																									id="submit_button" value=" Check Availability" />

																								<a id="reset_button" href="#"
																									onclick="document.yjbooking.reset();return false">
																									Reset</a>

																							</div>
																						</fieldset>
																						<div class="cBb">
																							<div></div>
																						</div>
																					</div>
																				</div>
																				<div class="display-none">
																					<input type="hidden" id="date" /> <input
																						type="hidden" name="Subject"
																						value="RESERVATION INFORMATION" /> <input
																						type="text" id="generatedantispamcode"
																						name="generatedantispamcode" /> <input
																						type="text" id="submittedantispamcode"
																						name="submittedantispamcode" />
																					<textarea id="reservation_information"
																						name="RESERVATION_INFORMATION" cols="" rows=""></textarea>
																				</div>
																			</div>
																		</form>
																	</div>
																</div>



															</div>

														</div>





													</div>
												</div>
											</div>

										</div>

									</div>

								</div>

							</div>

						</div>

					</div>

				</div>
				<!-- end advert 1-->
				<div id="main">

					<div class="yjtmid_l">

						<div class="yjtmid_r">

							<div class="yjttop_l">

								<div class="yjttop_r">

									<div class="yjtbot_l">

										<div class="yjtbot_r">

											<!--MAIN LAYOUT HOLDER -->

											<div id="holder">

												<!-- messages -->



												<!-- end messages -->

												<!-- pathway -->

												<!-- end pathway -->

												<!-- MID BLOCK WITH TOP AND BOTTOM MODULE POSITION -->

												<div id="midblock" style="width: 64%;">

													<div class="insidem">



														<!-- component -->

														<div class="frontpage_default">

															<table class="blog" cellpadding="0" cellspacing="0">



																<tr>

																	<td valign="top">

																		<table width="100%" cellpadding="0" cellspacing="0">

																			<tr>

																				<td valign="top" width="100%" class="article_column">



																					<div class="news_item_f">

																						<div class="yjtmid_ln">

																							<div class="yjtmid_rn">

																								<div class="yjttop_ln">

																									<div class="yjttop_rn">

																										<div class="yjtbot_ln">

																											<div class="yjtbot_rn">





																												<h2 class="contentheading">Clearwater
																													Beach, Tampa Bay</h2>









																												<div class="newsitem_text">

																													<p>
																														<img class="border"
																															src="images/sunspree.gif" border="0"
																															alt="sunspree" width="565" height="93" />
																													</p>

																													<p>Lorem ipsum dolor sit amet,
																														consectetur adipiscing elit. Sed lacinia
																														lobortis porta. Phasellus lacinia
																														fringilla ipsum, sed bibendum metus tempor
																														quis. Quisque sem purus, ultrices ac
																														rhoncus eget, molestie non libero. Donec
																														vestibulum tristique risus quis auctor.
																														Mauris sed libero eu leo tristique retium
																													</p>

																													<p class="price">$499.00</p>

																													<p>
																														<a class="order" href="#">Book Now</a>
																													</p>

																												</div>







																												<a
																													href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/35-resorts/52-clearwater-beach-tampa-bay.html"
																													class="readon"><span> Read
																														more...</span> </a>





																											</div>

																										</div>

																									</div>

																								</div>

																							</div>

																						</div>

																					</div> <!--end news item --> <span
																					class="article_separator">&nbsp;</span>



																					<div class="news_item_f">

																						<div class="yjtmid_ln">

																							<div class="yjtmid_rn">

																								<div class="yjttop_ln">

																									<div class="yjttop_rn">

																										<div class="yjtbot_ln">

																											<div class="yjtbot_rn">





																												<h2 class="contentheading">Honolulu
																													Diamond Head</h2>









																												<div class="newsitem_text">

																													<p>
																														<img class="border"
																															src="images/diamondhead.gif" border="0"
																															alt="diamondhead" width="565" height="93" />
																													</p>

																													<p>Lorem ipsum dolor sit amet,
																														consectetur adipiscing elit. Sed lacinia
																														lobortis porta. Phasellus lacinia
																														fringilla ipsum, sed bibendum metus tempor
																														quis. Quisque sem purus, ultrices ac
																														rhoncus eget, molestie non libero. Donec
																														vestibulum tristique risus quis auctor.
																														Mauris sed libero eu leo tristique retium
																													</p>

																													<p class="price">$399.00</p>

																													<p>
																														<a class="order" href="#">Book Now </a>
																													</p>

																												</div>







																												<a
																													href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/35-resorts/51-honolulu-diamond-head.html"
																													class="readon"><span> Read
																														more...</span> </a>





																											</div>

																										</div>

																									</div>

																								</div>

																							</div>

																						</div>

																					</div> <!--end news item --> <span
																					class="article_separator">&nbsp;</span> <!-- <div class="news_item_f">

																						<div class="yjtmid_ln">

																							<div class="yjtmid_rn">

																								<div class="yjttop_ln">

																									<div class="yjttop_rn">

																										<div class="yjtbot_ln">

																											<div class="yjtbot_rn">





																												<h2 class="contentheading">Kalamata
																													Resort</h2>









																												<div class="newsitem_text">

																													<p>
																														<img class="border"
																															src="images/kalamata.gif"
																															border="0" alt="kalamata" width="565"
																															height="93" />
																													</p>

																													<p>Lorem ipsum dolor sit amet,
																														consectetur adipiscing elit. Sed lacinia
																														lobortis porta. Phasellus lacinia
																														fringilla ipsum, sed bibendum metus tempor
																														quis. Quisque sem purus, ultrices ac
																														rhoncus eget, molestie non libero. Donec
																														vestibulum tristique risus quis auctor.
																														Mauris sed libero eu leo tristique retium
																													</p>

																													<p class="price">$899.00</p>

																													<p>
																														<a class="order" href="#">Book Now</a>
																													</p>

																												</div>







																												<a
																													href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/35-resorts/50-kalamata-resort.html"
																													class="readon"><span> Read
																														more...</span>
																												</a>





																											</div>

																										</div>

																									</div>

																								</div>

																							</div>

																						</div>

																					</div>
																					end news item <span
																					class="article_separator">&nbsp;</span> --></td>



																			</tr>

																		</table>
																	</td>

																</tr>



															</table>

														</div>

														<!-- end component -->

														<!-- top module-->

														<div id="bottommodule"></div>

														<!-- end top module-->

														<!-- bottom module position -->

														<!-- 														<div id="bottommodules">



															<div id="user1" style="width: 50%">
																<div class="insidebo">
																	<div class="yjsquare">

																		<div class="yjsquare_out">





																			<div class="title_d">
																				<div class="title_l">
																					<div class="title_r">

																						<h3>
																							<span>New Destination</span>
																						</h3>

																					</div>
																				</div>
																			</div>









																			<div class="yjsquare_in">
																				<h3>Relax on the Beach</h3>

																				<img style="margin: 5px 10px 0px 0px; float: left;"
																					alt="userimage"
																					src="images/userimage.gif"
																					height="65" width="97" /> Lorem ipsum dolor sit
																				amet, consectetur adipiscing elit. Quisque in orci
																				vel diam molestie blandit tincidunt vitae lectus.
																				Donec in varius erat. Suspendisse ac justo neque, eu
																				rhoncus ante. Vivamus pellentesque risus a dolor
																				posuere pellentesque. Vestibulum accum <br />
																				<a href="#" class="readon"><span>More</span>
																				</a>
																			</div>



																		</div>

																	</div>





																</div>
															</div>

															<div id="user2" style="width: 50%">
																<div class="insidebo">
																	<div class="yjsquare">

																		<div class="yjsquare_out">





																			<div class="title_d">
																				<div class="title_l">
																					<div class="title_r">

																						<h3>
																							<span>Best Resort</span>
																						</h3>

																					</div>
																				</div>
																			</div>









																			<div class="yjsquare_in">
																				<h3>Voted best Resort</h3>

																				<img style="margin: 5px 10px 0px 0px; float: left;"
																					alt="userimage"
																					src="images/userimage.gif"
																					height="65" width="97" /> Lorem ipsum dolor sit
																				amet, consectetur adipiscing elit. Quisque in orci
																				vel diam molestie blandit tincidunt vitae lectus.
																				Donec in varius erat. Suspendisse ac justo neque, eu
																				rhoncus ante. Vivamus pellentesque risus a dolor
																				posuere pellentesque. Vestibulum accum <br />
																				<a href="#" class="readon"><span>More</span>
																				</a>
																			</div>



																		</div>

																	</div>





																</div>
															</div>
														</div> -->

														<!-- end module position -->

													</div>
													<!-- end mid block insidem class -->

												</div>
												<!-- end mid block div -->

												<!-- END MID BLOCK -->

												<!-- right block -->

												<div id="rightblock" style="width: 36%;">

													<div class="insider">

														<div class="yjsquare_yj1">

															<div class="yjsquare_out_yj1">





																<div class="title_d">
																	<div class="title_l">
																		<div class="title_r">

																			<h3>
																				<span>5 Stars Deals</span>
																			</h3>

																		</div>
																	</div>
																</div>









																<div class="yjsquare_in">
																	<!-- http://www.Youjoomla.com  Youjoomla Newslash Module V3 for Joomla 1.5 starts here -->





																	<div class="yjnewsflash">
																		<a
																			href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/36-5-stars-hotels/56-langham-hotel-london.html"><img
																			src="images/lang.jpg" border="0" height="47px"
																			align="left" title="Langham Hotel, London "
																			width="65px" alt="" /> </a>
																		<div class="yjnf_descr">
																			<a class="yjnewsflash_title"
																				href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/36-5-stars-hotels/56-langham-hotel-london.html">Langham
																				Hotel, London</a><br />
																			<p>Lorem ipsum dolor si...</p>
																		</div>
																		<span class="yjnsreadon"><a class="yjns_rm"
																			href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/36-5-stars-hotels/56-langham-hotel-london.html">more</a>
																		</span>
																	</div>
																	<div class="yjnewsflash">
																		<a
																			href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/36-5-stars-hotels/55-mezzatorre-resort-and-spa.html"><img
																			src="images/mez2.jpg" border="0" height="47px"
																			align="left" title="Mezzatorre Resort and Spa "
																			width="65px" alt="" /> </a>
																		<div class="yjnf_descr">
																			<a class="yjnewsflash_title"
																				href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/36-5-stars-hotels/55-mezzatorre-resort-and-spa.html">Mezzatorre
																				Resort and Spa</a><br />
																			<p>Lorem ipsum dolor si...</p>
																		</div>
																		<span class="yjnsreadon"><a class="yjns_rm"
																			href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/36-5-stars-hotels/55-mezzatorre-resort-and-spa.html">more</a>
																		</span>
																	</div>
																	<div class="yjnewsflash">
																		<a
																			href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/36-5-stars-hotels/54-cristallo-palace-hotel.html"><img
																			src="images/cs1.jpg" border="0" height="47px"
																			align="left" title="Cristallo Palace Hotel "
																			width="65px" alt="" /> </a>
																		<div class="yjnf_descr">
																			<a class="yjnewsflash_title"
																				href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/36-5-stars-hotels/54-cristallo-palace-hotel.html">Cristallo
																				Palace Hotel</a><br />
																			<p>Lorem ipsum dolor si...</p>
																		</div>
																		<span class="yjnsreadon"><a class="yjns_rm"
																			href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/36-5-stars-hotels/54-cristallo-palace-hotel.html">more</a>
																		</span>
																	</div>
																	<div class="yjnewsflash">
																		<a
																			href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/36-5-stars-hotels/53-grand-hotel-wien.html"><img
																			src="images/ghv2.jpg" border="0" height="47px"
																			align="left" title="Grand Hotel Wien " width="65px"
																			alt="" /> </a>
																		<div class="yjnf_descr">
																			<a class="yjnewsflash_title"
																				href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/36-5-stars-hotels/53-grand-hotel-wien.html">Grand
																				Hotel Wien</a><br />
																			<p>Lorem ipsum dolor si...</p>
																		</div>
																		<span class="yjnsreadon"><a class="yjns_rm"
																			href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/36-5-stars-hotels/53-grand-hotel-wien.html">more</a>
																		</span>
																	</div>






																</div>



															</div>

														</div>





														<!-- <div class="yjsquare_yj2">

															<div class="yjsquare_out_yj2">





																<div class="title_d">
																	<div class="title_l">
																		<div class="title_r">

																			<h3>
																				<span>Polls</span>
																			</h3>

																		</div>
																	</div>
																</div>









																<div class="yjsquare_in">

																	<h4>Joomla! is used for?</h4>

																	<form name="form2" method="post" action="index.php"
																		class="poll">

																		<fieldset>

																			<input type="radio" name="voteid" id="voteid1"
																				value="1" alt="1" /> <label for="voteid1">

																				Community Sites </label> <br /> <input type="radio"
																				name="voteid" id="voteid2" value="2" alt="2" /> <label
																				for="voteid2"> Public Brand Sites </label> <br /> <input
																				type="radio" name="voteid" id="voteid3" value="3"
																				alt="3" /> <label for="voteid3"> eCommerce
																			</label> <br /> <input type="radio" name="voteid"
																				id="voteid4" value="4" alt="4" /> <label
																				for="voteid4"> Blogs </label> <br /> <input
																				type="radio" name="voteid" id="voteid5" value="5"
																				alt="5" /> <label for="voteid5"> Intranets
																			</label> <br /> <input type="radio" name="voteid"
																				id="voteid6" value="6" alt="6" /> <label
																				for="voteid6"> Photo and Media Sites </label> <br />

																			<input type="radio" name="voteid" id="voteid7"
																				value="7" alt="7" /> <label for="voteid7">

																				All of the Above! </label> <br />

																		</fieldset>

																		<div class="pollbuttons">

																			<input type="submit" name="task_button"
																				class="button" value="Vote" /> <input type="button"
																				name="option" class="button" value="Results"
																				onclick="document.location.href='/youtravel/component/poll/14-joomla-is-used-for.html'" />

																		</div>



																		<input type="hidden" name="option" value="com_poll" />

																		<input type="hidden" name="id" value="14" /> <input
																			type="hidden" name="task" value="vote" /> <input
																			type="hidden" name="1ce548e65180bb317667f17dd6474f34"
																			value="1" />
																	</form>

																</div>



															</div>

														</div> -->





														<!-- <div class="yjsquare_yj3">

															<div class="yjsquare_out_yj3">





																<div class="title_d">
																	<div class="title_l">
																		<div class="title_r">

																			<h3>
																				<span>Main Menu</span>
																			</h3>

																		</div>
																	</div>
																</div>









																<div class="yjsquare_in">
																	<table width="100%" border="0" cellpadding="0"
																		cellspacing="0">
																		<tr>
																			<td><a href="/youtravel/home.html"
																				class="mainlevel" id="active_menu">Home</a>
																			</td>
																		</tr>
																		<tr>
																			<td><a href="/youtravel/joomla-overview.html"
																				class="mainlevel">Joomla! Overview</a>
																			</td>
																		</tr>
																		<tr>
																			<td><a href="/youtravel/typography.html"
																				class="mainlevel">Typography Styles</a>
																			</td>
																		</tr>
																		<tr>
																			<td><a href="/youtravel/extras.html"
																				class="mainlevel">Extras</a>
																			</td>
																		</tr>
																		<tr>
																			<td><a href="#" class="mainlevel">CSS
																					Styles</a>
																			</td>
																		</tr>
																		<tr>
																			<td><a href="/youtravel/menu-types.html"
																				class="mainlevel">Menu Types</a>
																			</td>
																		</tr>
																		<tr>
																			<td><a href="http://www.youjoomla.com/join"
																				class="mainlevel">Purchase</a>
																			</td>
																		</tr>
																		<tr>
																			<td><a href="/youtravel/faq.html"
																				class="mainlevel">FAQ</a>
																			</td>
																		</tr>
																	</table>
																</div>



															</div>

														</div> -->





														<!-- <div class="yjsquare">

															<div class="yjsquare_out">













																<div class="yjsquare_in">
																	<p style="text-align: center;">
																		<a title="Adds" href="#"><img alt="adspace"
																			src="images/adspace.gif"
																			height="128" width="309" />
																		</a>
																	</p>
																</div>



															</div>

														</div> -->







													</div>

												</div>

												<!-- end right block -->

											</div>
											<!-- end holder div -->

											<!-- END BOTTOM PART OF THE SITE LAYOUT -->

										</div>

									</div>

								</div>

							</div>

						</div>

					</div>

				</div>
				<!-- end main-->

				<div id="bottoms">

					<div class="yjtmid_l">

						<div class="yjtmid_r">

							<div class="yjttop_l">

								<div class="yjttop_r">

									<div class="yjtbot_l">

										<div class="yjtbot_r">



											<div id="bottomsin">



												<div id="user3" style="width: 22%">
													<div class="insidebs">
														<div class="yjsquare">

															<div class="yjsquare_out">





																<div class="title_d">
																	<div class="title_l">
																		<div class="title_r">

																			<h3>
																				<span>User Resources</span>
																			</h3>

																		</div>
																	</div>
																</div>









																<div class="yjsquare_in">
																	<ul>

																		<li><a href="#">Joomla! Home </a></li>

																		<li><a href="#">Joomla! Forums </a></li>

																		<li><a href="#">Joomla! Help </a></li>

																		<li><a href="#">YouFashion Home </a></li>

																		<li><a href="#">YouJoomla Home </a></li>

																		<li><a href="#">YouJoomla Forum</a></li>

																	</ul>
																</div>



															</div>

														</div>





													</div>
												</div>

												<div id="user4" style="width: 22%">
													<div class="insidebs">
														<div class="yjsquare">

															<div class="yjsquare_out">





																<div class="title_d">
																	<div class="title_l">
																		<div class="title_r">

																			<h3>
																				<span>Support Center</span>
																			</h3>

																		</div>
																	</div>
																</div>









																<div class="yjsquare_in">
																	<ul>

																		<li><a href="#">Site Map </a></li>

																		<li><a href="#">Search Terms </a></li>

																		<li><a href="#">Advanced Search </a></li>

																		<li><a href="#">Terms of Use </a></li>

																		<li><a href="#">About Us </a></li>

																		<li><a href="#">Contact Us</a></li>

																	</ul>
																</div>



															</div>

														</div>





													</div>
												</div>

												<div id="user5" style="width: 22%">
													<div class="insidebs">
														<div class="yjsquare">

															<div class="yjsquare_out">





																<div class="title_d">
																	<div class="title_l">
																		<div class="title_r">

																			<h3>
																				<span>News Letter</span>
																			</h3>

																		</div>
																	</div>
																</div>









																<div class="yjsquare_in">
																	Enter your email address to subscribe to our mailing
																	list:
																	<form action="#">
																		<input class="inputbox" name="newsletter" size="23"
																			type="text" /> <input class="button" value="Submit"
																			type="button" />
																	</form>

																	<p>We take your privacy very seriously. We will
																		never share your contact information.</p>
																</div>



															</div>

														</div>





													</div>
												</div>

												<div id="user6" style="width: 34%">
													<div class="insidebs">
														<div class="yjsquare_yjnf5">

															<div class="yjsquare_out_yjnf5">













																<div class="yjsquare_in">
																	<!-- http://www.Youjoomla.com  Youjoomla Newslash Module V5 for Joomla 1.5 starts here -->

																	<div id="YJ_NewsFlash5">

																		<!--nav links -->

																		<div class="yjnf5_nav">

																			<div class="yjmf5_nav_b">

																				<a href="#" id="up">up</a> <a href="#" id="down">down</a>
																			</div>

																		</div>

																		<!-- module content -->

																		<div id="yjnf5_co" style="height: 200px;">

																			<div id="yjnf5_ci">

																				<div class="yjnewsflash5">
																					<a class="yjnewsflash_title5"
																						href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/35-resorts/52-clearwater-beach-tampa-bay.html">Clearwater
																						Beach, Tampa Bay</a><br />
																					<div class="nfimgpos5">
																						<a
																							href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/35-resorts/52-clearwater-beach-tampa-bay.html"><img
																							src="images/sunspree.gif" border="0"
																							height="50px" align="left"
																							title="Clearwater Beach, Tampa Bay " width="50px"
																							alt="" /> </a>
																					</div>

																					Lorem ipsum dolor sit amet, consectetu...<span
																						class="yjnsreadon5"><a class="yjns_rm5"
																						href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/35-resorts/52-clearwater-beach-tampa-bay.html">more</a>
																					</span>
																					<div class="clear">
																						<!--clear-->
																					</div>
																				</div>
																				<div class="yjnewsflash5">
																					<a class="yjnewsflash_title5"
																						href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/35-resorts/51-honolulu-diamond-head.html">Honolulu
																						Diamond Head</a><br />
																					<div class="nfimgpos5">
																						<a
																							href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/35-resorts/51-honolulu-diamond-head.html"><img
																							src="images/diamondhead.gif" border="0"
																							height="50px" align="left"
																							title="Honolulu Diamond Head " width="50px"
																							alt="" /> </a>
																					</div>

																					Lorem ipsum dolor sit amet, consectetu...<span
																						class="yjnsreadon5"><a class="yjns_rm5"
																						href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/35-resorts/51-honolulu-diamond-head.html">more</a>
																					</span>
																					<div class="clear">
																						<!--clear-->
																					</div>
																				</div>
																				<div class="yjnewsflash5">
																					<a class="yjnewsflash_title5"
																						href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/35-resorts/50-kalamata-resort.html">Kalamata
																						Resort</a><br />
																					<div class="nfimgpos5">
																						<a
																							href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/35-resorts/50-kalamata-resort.html"><img
																							src="images/kalamata.gif" border="0"
																							height="50px" align="left"
																							title="Kalamata Resort " width="50px" alt="" />
																						</a>
																					</div>

																					Lorem ipsum dolor sit amet, consectetu...<span
																						class="yjnsreadon5"><a class="yjns_rm5"
																						href="/youtravel/joomla-overview/more-about-joomla/the-news/travel-guide/35-resorts/50-kalamata-resort.html">more</a>
																					</span>
																					<div class="clear">
																						<!--clear-->
																					</div>
																				</div>
																			</div>
																			<!-- close  YJ_NewsFlash_5_content_inner-->

																		</div>
																		<!-- close YJ_NewsFlash_5_content_outer-->

																	</div>
																	<!--close YJ_NewsFlash5-->
																</div>



															</div>

														</div>





													</div>
												</div>
											</div>



										</div>

									</div>

								</div>

							</div>

						</div>

					</div>

				</div>
				<!-- end bottoms-->
			</div>
			<!-- end centerbottom-->

			<!-- footer -->

			<div id="footer" style="font-size: 11px; width: 975px;">

				<div id="youjoomla">

					<div id="cp">

						Copyright &copy; 2011 <a href="http://www.theqwerty.in"
							title="Team NRG^2">Suchi Travels.</a>&nbsp;&nbsp;All rights
						reserved.<br />
						<a href="http://www.theqwerty.in" title="theQwerty">Custom
							Design by Team NRG^2</a><br />
					</div>

				</div>

			</div>

			<!-- end footer -->

		</div>
		<!-- end holdthem-->

	</div>
	<!-- end top_bg-->

	<script type="text/javascript">
		Cufon.now();
	</script>

</body>

</html>
