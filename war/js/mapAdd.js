
	  function init() {
	  /*
		map = new OpenLayers.Map("basicMap");
		var mapnik         = new OpenLayers.Layer.OSM();
		var fromProjection = new OpenLayers.Projection("EPSG:4326");   // Transform from WGS 1984
		var toProjection   = new OpenLayers.Projection("EPSG:900913"); // to Spherical Mercator Projection
		var position       = new OpenLayers.LonLat(-1.5533581,47.2183506).transform( fromProjection, toProjection);
		var zoom           = 13; 
 
		map.addLayer(mapnik);
		map.setCenter(position, zoom );
		*/
		
	map = new OpenLayers.Map({
        div: "basicMap",
        controls: [
			new OpenLayers.Control.TouchNavigation({
                dragPanOptions: {
                    enableKinetic: true
                }
            }),
            new OpenLayers.Control.Zoom(),
			new OpenLayers.Control.Navigation({mouseWheelOptions: {interval: 400}})],
		fractionalZoom: true
    });
    map.addLayer(new OpenLayers.Layer.OSM());
 
    var lonLat = new OpenLayers.LonLat(-1.5533581,47.2183506).transform(
            new OpenLayers.Projection("EPSG:4326"), // transform from WGS 1984
            map.getProjectionObject() // to Spherical Mercator Projection
          );
 
    var zoom=13;
 /*
    var markers = new OpenLayers.Layer.Markers( "Markers" );
    map.addLayer(markers);
	
	var size = new OpenLayers.Size(70,70);
	var offset = new OpenLayers.Pixel(-(size.w/2), -size.h);
	var icon = new OpenLayers.Icon('img/marker.png', size, offset);
	
	markers.addMarker(new OpenLayers.Marker(lonLat,icon));
	markers.addMarker(new OpenLayers.Marker(new OpenLayers.LonLat(-1.561259,47.239074).transform(
            new OpenLayers.Projection("EPSG:4326"), // transform from WGS 1984
            map.getProjectionObject() // to Spherical Mercator Projection
          ),new OpenLayers.Icon('img/marker.png', size, offset)));

 //OpenLayers.Control.PanPanel and OpenLayers.Control.ZoomPanel
*/
 
	var size = new OpenLayers.Size(70,70);
	var offset = new OpenLayers.Pixel(-(size.w/2), -size.h);
	var icon = new OpenLayers.Icon('img/marker.png', size, offset);
	 
	var markers = new OpenLayers.Layer.Markers( "Markers" );
	marker = new OpenLayers.Marker(lonLat,icon) ;
	markers.addMarker(marker);
	map.addLayer(markers);
	
	map.events.register("click", map , function(e){
	var opx = map.getLayerPxFromViewPortPx(e.xy) ;
	marker.map = map ;
	marker.moveTo(opx) ;
	var position = map.getLonLatFromViewPortPx(e.xy).transform(new OpenLayers.Projection("EPSG:900913"), new OpenLayers.Projection("EPSG:4326"));
	document.getElementById("add_latitude").value=position.lat;
	document.getElementById("add_longitude").value=position.lon;
	});


    map.addControls([
	new OpenLayers.Control.PanPanel(),
	new OpenLayers.Control.ZoomPanel()/*,
            new OpenLayers.Control.Navigation(),
            new OpenLayers.Control.PanZoomBar(null, null, 100, 50)*/
    ]);
	
	
    map.setCenter (lonLat, zoom);
	    var vectorLayer = new OpenLayers.Layer.Vector("Overlay");
    
    epsg4326 =  new OpenLayers.Projection("EPSG:4326"); //WGS 1984 projection
    projectTo = map.getProjectionObject(); //The map projection (Spherical Mercator)
    // Define markers as "features" of the vector layer:
	 var feature = new OpenLayers.Feature.Vector(
            new OpenLayers.Geometry.Point(-1.561259,47.239074).transform(epsg4326, projectTo),
            {description:'<center>Probl&egrave;me de signalisation<br><i>Bd Gabriel Lauriol</i></center>'} ,
            {externalGraphic: 'img/marker.png', graphicHeight: 70, graphicWidth: 70, graphicXOffset:-35, graphicYOffset:-70  }
        );    
    vectorLayer.addFeatures(feature);
    var feature = new OpenLayers.Feature.Vector(
            new OpenLayers.Geometry.Point(-1.5533581,47.2183506).transform(epsg4326, projectTo),
            {description:'This is the value of<br>the description attribute'} ,
            {externalGraphic: 'img/marker.png', graphicHeight: 70, graphicWidth: 70, graphicXOffset:-35, graphicYOffset:-70  }
        );    
    vectorLayer.addFeatures(feature);



   
    map.addLayer(vectorLayer);
 
    
    //Add a selector control to the vectorLayer with popup functions
    var controls = {
      selector: new OpenLayers.Control.SelectFeature(vectorLayer, { onSelect: createPopup, onUnselect: destroyPopup })
    };

    function createPopup(feature) {
      feature.popup = new OpenLayers.Popup.FramedCloud("pop",
          feature.geometry.getBounds().getCenterLonLat(),
          null,
          '<div class="markerContent">'+feature.attributes.description+'</div>',
          null,
          true,
          function() { controls['selector'].unselectAll(); }
      );
      //feature.popup.closeOnMove = true;
      map.addPopup(feature.popup);
    }

    function destroyPopup(feature) {
      feature.popup.destroy();
      feature.popup = null;
    }
    
    map.addControl(controls['selector']);
    controls['selector'].activate();
      
	  }