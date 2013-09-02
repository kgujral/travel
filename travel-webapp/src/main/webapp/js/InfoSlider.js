/**
 * InfoSlider
 * @version		1.0.0
 * @MooTools version 1.1
 * @author		Constantin Boiangiu
 * Copyright Youjoomla LLC
 */
var InfoSlider=new Class({initialize:function(a){this.options=Object.extend({navigation:{container:null,elements:null,outer:null,visibleItems:0},slides:{container:null,elements:null,infoContainer:null,infoContainerPosition:null,startFx:{opacity:1},endFx:{opacity:0}},startElem:null,autoSlide:null},a||{});this.navElements=$(this.options.navigation.container).getElements(this.options.navigation.elements);this.slides=$(this.options.slides.container).getElements(this.options.slides.elements);this.navScroll=new Fx.Scroll(this.options.navigation.outer,{wait:false,duration:800,transition:Fx.Transitions.Quad.easeInOut});this.correction=Math.round(this.options.navigation.visibleItems/2.00001);this.start()},start:function(){this.currentElem=this.options.startElem?this.options.startElem-1:0;this.slides.each(function(a,c){a.setStyles({display:"block",position:"absolute",left:0,top:0,opacity:(c==this.currentElem?1:0)});if(c!==this.currentElem){a.setStyles(this.options.slides.endFx)}this.slides[c]["fx"]=new Fx.Styles(a,{duration:700,transition:Fx.Transitions.linear,wait:false});if(this.options.slides.infoContainer&&this.options.slides.infoContainerPosition){var d=a.getElement(this.options.slides.infoContainer);var b=new Fx.Style(d,this.options.slides.infoContainerPosition,{duration:500,wait:false});b.set(-500);this.slides[c]["infoFx"]=b;a.addEvent("mouseover",function(){b.start(0)});a.addEvent("mouseout",function(){b.start(-500)})}if(this.options.autoSlide){a.addEvent("mouseover",function(){$clear(this.period)}.bind(this));a.addEvent("mouseout",function(){this.period=this.rotate.bind(this).periodical(this.options.autoSlide)}.bind(this))}}.bind(this));this.navElements.each(function(b,a){if(a==this.currentElem){this.navScroll.toElement(b);b.addClass(this.options.navigation.selectedClass)}b.addEvent("click",function(c){new Event(c).stop();this.changeSlide(a);if(this.options.autoSlide){$clear(this.period);this.period=this.rotate.bind(this).periodical(this.options.autoSlide)}}.bind(this))}.bind(this));if(this.options.autoSlide){this.period=this.rotate.bind(this).periodical(this.options.autoSlide)}$(this.options.navigation.container).addEvent("mousewheel",function(b){b=new Event(b);b.stop();var a=this.currentElem-b.wheel;if(b.wheel>0&&a<0){a=this.navElements.length-1}if(b.wheel<0&&a>this.navElements.length-1){a=0}$clear(this.period);this.period=this.rotate.bind(this).periodical(this.options.autoSlide);this.changeSlide(a)}.bind(this))},changeSlide:function(a){if(a==this.currentElem){return}this.slides[this.currentElem]["fx"].start(this.options.slides.endFx);this.slides[a]["fx"].start(this.options.slides.startFx);this.navElements[this.currentElem].removeClass(this.options.navigation.selectedClass);this.navElements[a].addClass(this.options.navigation.selectedClass);var b=a-this.correction<0?0:a-this.correction;this.navScroll.toElement(this.navElements[b]);this.currentElem=a},rotate:function(){var a=this.currentElem+1<this.navElements.length?this.currentElem+1:0;this.changeSlide(a)}});