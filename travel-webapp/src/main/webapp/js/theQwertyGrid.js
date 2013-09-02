/**
 * Author	: Karan Gujral
 * Team		: NRG^2 (N - Narasimha, R - Rawat, G - Ghai, G - Gujral)
 * Version	: 1.0
 * Web-site	: http://www.theqwerty.in
 * Wiki		: http://www.theqwerty.in/grid
 */


// global variables 
var _theQwertyGrid_table;
var _theQwertyGrid_rowStart;
var _theQwertyGrid_rowEnd;
var _theQwertyGrid_pageSize;
var _theQwertyGrid_data;
var _theQwertyGrid_displayData;
var _theQwertyGrid_cols;
var _theQwertyGrid_sortInAsc;
var _theQwertyGrid_PK = new Array();
var _theQwertyGrid_tableProps;
//end of global variables






/**
 * initialising various table properties
 */
		function theQwertyGrid_init(_tableProps) {
			_theQwertyGrid_tableProps = _tableProps;
			_tableProps.wrapperId = typeof(_tableProps.wrapperId) === "undefined" ? "body" : "#"+_tableProps.wrapperId;
			_tableProps.paging = typeof(_tableProps.paging) === "undefined" ? false :  _tableProps.paging;
			_tableProps.pageSize = typeof(_tableProps.pageSize) === "undefined" ? [10,20,30] :  _tableProps.pageSize;
			_tableProps.style = typeof(_tableProps.style) === "undefined" ? "" :  _tableProps.style;
			var _indexPK = 0;
			for(var i=0; i<_tableProps.cols.length; i++) {
				_tableProps.cols[i].sortable = typeof(_tableProps.cols[i].sortable) === "undefined" ? false :  _tableProps.cols[i].sortable;
				_tableProps.cols[i].PK = typeof(_tableProps.cols[i].PK) === "undefined" ? false :  _tableProps.cols[i].PK;
				if(_tableProps.cols[i].PK == true) {
					_theQwertyGrid_PK[_indexPK ++] = i;
				} 
				_tableProps.cols[i].type = (typeof(_tableProps.cols[i].type) === "undefined") || (_tableProps.cols[i].type != "string" && _tableProps.cols[i].type != "int") ? "string" :  _tableProps.cols[i].type;
			}
			_tableProps.controls = typeof(_tableProps.controls) === "undefined" ? (new Array()) : _tableProps.controls;
			for(var i=0; i<_tableProps.controls.length; i++) {
				_tableProps.controls[i].type = typeof(_tableProps.controls[i].type) === "undefined" ? "button" :  _tableProps.controls[i].type;
				_tableProps.controls[i].func = typeof(_tableProps.controls[i].func) === "undefined" ? "alertMe" :  _tableProps.controls[i].func;
				_tableProps.controls[i].caption = typeof(_tableProps.controls[i].caption) === "undefined"  ? "control" :  _tableProps.controls[i].caption;
				_tableProps.controls[i].headerCaption = typeof(_tableProps.controls[i].headerCaption) === "undefined"  ? _tableProps.controls[i].caption :  _tableProps.controls[i].headerCaption;
			}
			_theQwertyGrid_rowStart = 0;
			_theQwertyGrid_pageSize = _tableProps.pageSize[0];
			_theQwertyGrid_rowEnd = _theQwertyGrid_rowStart + _theQwertyGrid_pageSize;
			_theQwertyGrid_data = _tableProps.data;
			_theQwertyGrid_displayData = _theQwertyGrid_data;
			_theQwertyGrid_cols = _tableProps.cols;
			_theQwertyGrid_sortInAsc = true;
			
			theQwertyGrid_createTable(_tableProps);
			theQwertyGrid_prevNextDisable();
			
		}
// ------------------------------------------------------------------------------------------------------
// Creating table DOM
// ------------------------------------------------------------------------------------------------------
		
/**
 * creates the table's header
 */
		function theQwertyGrid_tableHeader (_tableProps){
			var thead = jQuery("<thead>");
			var tbody = jQuery("<tbody>");
			tbody.attr("id","theQwertyGrid_rows");
			tbody.attr("align","center");
			tbody.attr("valign","middle");
			var theadTr = jQuery("<tr>");
			
			for(var i=0; i< _tableProps.headerCols.length; i++) {
				if(_tableProps.cols[i].sortable) {
					var sortFunc="";
					if(_tableProps.cols[i].type == "string") {
						sortFunc = "theQwertyGrid_sortString";
					}
					else if(_tableProps.cols[i].type == "int") {
						sortFunc = "theQwertyGrid_sortInt";
					}
					theadTr.append(jQuery("<th>").append("<a onclick=\""+sortFunc+"(\'"+_tableProps.cols[i].name+"\')\">"+_tableProps.headerCols[i]+"</a>"));
				}
				else {
					theadTr.append(jQuery("<th>").append(_tableProps.headerCols[i]));
				}
				
			}
			for(var i=0; i<_tableProps.controls.length; i++) {
				theadTr.append(jQuery("<th>").append(_tableProps.controls[i].headerCaption));
			}
			thead.append(theadTr);
			_theQwertyGrid_table.append(thead);
			_theQwertyGrid_table.append(tbody);
		}
/**
 * creates table's footer
 */
		function theQwertyGrid_tableFooter(_tableProps) {
			var tfoot = jQuery("<tfoot>");
			var tr = jQuery("<tr>");
			var td = jQuery("<td colspan="+(parseInt(_tableProps.headerCols.length)+parseInt(_tableProps.controls.length))+" align=\"right\">");
			
			/**
			 * if paging was set to true by the user
			 * then adding corresponding controls
			 */
			if(_tableProps.paging){
				var controls = "Page Size: <select class=\"theQwertyGrid_controls\" onchange=\"theQwertyGrid_setPageSize(this.options[this.selectedIndex].value);\">";
				for(var i=0; i<_tableProps.pageSize.length; i++) {
					controls+=("<option>"+_tableProps.pageSize[i]+"</option>");
				}
				controls+="</select>";
				controls+=" Paging:\
							<input class=\"theQwertyGrid_controls\" type=\"button\" id=\"theQwertyGrid_prev\" value=\"prev\" onclick=\"theQwertyGrid_prevPage()\"/>\
							<input class=\"theQwertyGrid_controls\" type=\"button\" id=\"theQwertyGrid_next\" value=\"next\" onclick=\"theQwertyGrid_nextPage()\"/>";
				td.append(controls);
				
				//calling paging functions
				theQwertyGrid_setPageSize(_tableProps.pageSize[0]);
			}
			//---------------------- End of IF --------------------------
			else{
				td.append("&copy;&nbsp;<a href='http://www.theqwerty.in'>theQwerty</a> NRG^2");
			}
			tr.append(td);
			tfoot.append(tr);
			_theQwertyGrid_table.append(tfoot);
		}
/**
 * creates actual table DOM
 */
		function theQwertyGrid_createTable(_tableProps) {
			_theQwertyGrid_table = jQuery("<table>");
			_theQwertyGrid_table.attr("id","theQwertyGrid");
			_theQwertyGrid_table.attr("style",_tableProps.style);
			theQwertyGrid_tableHeader(_tableProps);
			theQwertyGrid_tableFooter(_tableProps);
			jQuery(_tableProps.wrapperId).append(_theQwertyGrid_table);
			
			theQwertyGrid_addRows(_theQwertyGrid_displayData, _tableProps);
		}
		
/**
 * add rows to table body
 */
		function theQwertyGrid_addRows (data, tableProps) {
			var PKVals;
			var tbody = jQuery("#theQwertyGrid_rows");
			for (var i = 0; i < data.length; i++) {
	        	var tr = jQuery("<tr>").attr("id","theQwertyGrid_row"+i);
	   			for(var j=0; j< _theQwertyGrid_cols.length; j++) {
	   				tr.append(jQuery("<td>").text(data[i][_theQwertyGrid_cols[j].name]));
	        	}
	   			PKVals = "'"+data[i][_theQwertyGrid_cols[0].name]+"'";
	   			for(var j=1; j< _theQwertyGrid_PK.length; j++) {
	   				PKVals += ", '"+data[i][_theQwertyGrid_cols[_theQwertyGrid_PK[j]].name]+"'";
	        	}
	   			for(var j=0; j< tableProps.controls.length; j++) {
	   				tr.append(jQuery("<td>").html("<input class=\"theQwertyGrid_controls\" type=\""+tableProps.controls[j].type+"\" value=\""+tableProps.controls[j].caption+"\" onclick=\""+tableProps.controls[j].func+"("+PKVals+")\"/>"));
	        	}
	   			tbody.append(tr);
	        }
		}

// ------------------------------------------------------------------------------------------------------
// End of Creation of table DOM functions
// ------------------------------------------------------------------------------------------------------
	

		
// ------------------------------------------------------------------------------------------------------
// Paging functions
// ------------------------------------------------------------------------------------------------------

/**
 * selects a subset of data according to the page size selected
 * and fills the grid
 */
		function theQwertyGrid_setPageSize(size) {
			_theQwertyGrid_pageSize = parseInt(size);
			var temp = [];
			_theQwertyGrid_rowEnd = _theQwertyGrid_rowStart + _theQwertyGrid_pageSize;
			if(_theQwertyGrid_rowEnd >= _theQwertyGrid_data.length) {
				_theQwertyGrid_rowEnd = _theQwertyGrid_data.length;
			}
			for(var i=_theQwertyGrid_rowStart; i<_theQwertyGrid_rowEnd; i++) {
				temp.push(_theQwertyGrid_data[i]);
			}
			_theQwertyGrid_displayData = temp;
			theQwertyGrid_prevNextDisable();
			theQwertyGrid_reFillTable(_theQwertyGrid_displayData);
		}
		
/**
 * shows the previous page of grid
 */		
		function theQwertyGrid_prevPage () {
			_theQwertyGrid_rowEnd = _theQwertyGrid_rowStart;
			_theQwertyGrid_rowStart = _theQwertyGrid_rowEnd - _theQwertyGrid_pageSize < 0 ?
									  0 : _theQwertyGrid_rowEnd - _theQwertyGrid_pageSize;
			theQwertyGrid_setPageSize(_theQwertyGrid_pageSize);
		}
		
/**
 * shows the previous page of grid
 */		
		function theQwertyGrid_nextPage () {
			_theQwertyGrid_rowStart = _theQwertyGrid_rowEnd;
			_theQwertyGrid_rowEnd = _theQwertyGrid_rowStart + _theQwertyGrid_pageSize > _theQwertyGrid_data.length ?
									_theQwertyGrid_data.length : _theQwertyGrid_rowStart + _theQwertyGrid_pageSize;
			theQwertyGrid_setPageSize(_theQwertyGrid_pageSize);
		}
/**
 * disables or enables the prev and next buttons.
 */
		function theQwertyGrid_prevNextDisable() {
			if(_theQwertyGrid_rowStart <= 0) {
				jQuery("#theQwertyGrid_prev").attr("disabled","disabled");
			}
			if(_theQwertyGrid_rowEnd < _theQwertyGrid_data.length) {
				jQuery("#theQwertyGrid_next").removeAttr("disabled");
			}
			if(_theQwertyGrid_rowStart > 0) {
				jQuery("#theQwertyGrid_prev").removeAttr("disabled");
			}
			if(_theQwertyGrid_rowEnd >= _theQwertyGrid_data.length) {
				jQuery("#theQwertyGrid_next").attr("disabled","disabled");
			}
		}
// ------------------------------------------------------------------------------------------------------
// End of paging functions
// ------------------------------------------------------------------------------------------------------

		
// ------------------------------------------------------------------------------------------------------
// Sorting functions
// ------------------------------------------------------------------------------------------------------

/**
 * controls the integer sorting.
 */
		function theQwertyGrid_sortInt(key) {
			if(_theQwertyGrid_sortInAsc) {
				_theQwertyGrid_sortInAsc = false;
				_theQwertyGrid_displayData.sort(function(a,b) {
					return a[key] - b[key];
				});
			}
			else {
				_theQwertyGrid_sortInAsc = true;
				_theQwertyGrid_displayData.sort(function(b,a) {
					return a[key] - b[key];
				});
			}
			theQwertyGrid_reFillTable(_theQwertyGrid_displayData);
			
		}
/**
 * Controls the String sorting functions
 */
		function theQwertyGrid_sortString(key) {
			if(_theQwertyGrid_sortInAsc) {
				_theQwertyGrid_sortInAsc = false;
				_theQwertyGrid_displayData.sort(function(a,b){
					return a[key] > b[key] ? 1 : b[key] > a[key] ? -1 : 0;
				});
			}
			else {
				_theQwertyGrid_sortInAsc = true;
				_theQwertyGrid_displayData.sort(function(b,a){
					return a[key] > b[key] ? 1 : b[key] > a[key] ? -1 : 0;
				});
			}
			theQwertyGrid_reFillTable(_theQwertyGrid_displayData);
		}

// ------------------------------------------------------------------------------------------------------
// End of sorting functions
// ------------------------------------------------------------------------------------------------------

		
		
// ------------------------------------------------------------------------------------------------------
// Utility functions
// ------------------------------------------------------------------------------------------------------

/**
 * remove all rows from table body
 */
		function theQwertyGrid_clearAllRows() {
			jQuery("#theQwertyGrid_rows tr").remove();
		}
/**
 * removes all rows and inserts new data passed as argument
 */
		function theQwertyGrid_reFillTable(data) {
			theQwertyGrid_clearAllRows();
			theQwertyGrid_addRows(data, _theQwertyGrid_tableProps);
		}
// ------------------------------------------------------------------------------------------------------
// End of utility functions
// ------------------------------------------------------------------------------------------------------
		
//defining the name-space
var theQwerty={};

theQwerty.grid =
	function (_tableProps) {
	//start of function body
	jQuery("#theQwertyGrid").remove();
	theQwertyGrid_init(_tableProps);
};
    
