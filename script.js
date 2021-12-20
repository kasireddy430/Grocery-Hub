var map;
var resultset = [];
function initMap() {

  // MAP
  map = new google.maps.Map(document.getElementById('map'), {
    center: { lat: 41.881832, lng: -87.623177 },
    zoom: 10
  });


  var locationInput = document.getElementById('ciudad');
  var autocomplete = new google.maps.places.Autocomplete(locationInput);

  const geocoder = new google.maps.Geocoder();
  // MARKER
  var marker = new google.maps.Marker({
    map: map,

  });



  var searchArea = '';

  // CIRCLE
  var circle = new google.maps.Circle({
    // center: searchArea,
    radius: parseFloat(document.getElementById("distance").value) * 1609.3, //convert miles to meters
    strokeColor: "#7ED9C3",
    strokeOpacity: 0.8,
    strokeWeight: 2,
    fillColor: '#7ED9C3',
    fillOpacity: 0.4
  });
  circle.setMap(null);

  // PLACE CHANGED FUNCTION
  autocomplete.addListener('place_changed',
    function() {
      var place = autocomplete.getPlace();
      if (!place.geometry) {
        return;
      }

      if (place.geometry.viewport) {
        map.fitBounds(place.geometry.viewport);
        map.setZoom(9);
      } else {
        map.setCenter(place.geometry.location);
        map.setZoom(9);
      }

      var service = new google.maps.places.PlacesService(map);

      // Set the position of the marker using the place ID and location.
      searchArea = place.geometry.location;
      marker.setPlace({
        placeId: place.place_id,
        location: place.geometry.location

      });
      marker.setVisible(true);


      // Coordinates
      var latLng = marker.getPlace().location;
      var lat = latLng.lat().toFixed(6);
      var lng = latLng.lng().toFixed(6);
      getCoords(lat, lng);


      // Clear last circle
      circle.setMap(null);

      // Draw a circle around the radius
      circle = new google.maps.Circle({
        center: searchArea,
        radius: parseFloat(document.getElementById("distance").value) * 1609.3, //convert miles to meters
        strokeColor: "#7ED9C3",
        strokeOpacity: 0.8,
        strokeWeight: 2,
        fillColor: '#7ED9C3',
        fillOpacity: 0.4
      });
      circle.setMap(map);

      // Perform search over radius
      var request = {
        location: searchArea,
        // radius: parseFloat(document.getElementById("distance").value) * 1609.3, //convert miles to meters
        keyword: "BestBuy",
        rankBy: google.maps.places.RankBy.DISTANCE
      };

      service.nearbySearch(request, callback);
    });

  // COORDINATES
  function getCoords(lat, lng) {

    // Reference input html element with id=”lat”.
    var coords_lat = document.getElementById('lat');

    // Update latitude text box.
    coords_lat.value = lat;

    // Reference input html element with id=”lng”.
    var coords_lng = document.getElementById('lng');

    // Update longitude text box.
    coords_lng.value = lng;
  }
}
google.maps.event.addDomListener(window, "load", initMap);

function callback(results, status) {
  if (status === google.maps.places.PlacesServiceStatus.OK) {
    for (var i = 0; i < results.length; i++) {
      createMarker(results[i],i);
    }
  }
}

function createMarker(place,i) {
  var placeLoc = place.geometry.location;
  
  console.log("address"+i);
  if (i<7){
      resultset.push(place.vicinity);
      document.getElementById("address"+i).innerHTML=place.vicinity
  }
  // document.getElementById("address"+i).innerHTML=place.vicinity
  var marker = new google.maps.Marker({
    map: map,
    position: place.geometry.location
  });

  var infowindow = new google.maps.InfoWindow({
    content: name
  });

  google.maps.event.addListener(marker, 'click', function() {
    infowindow.setContent(place.name);
    infowindow.open(map, marker);
  });
  
}

function change(x){
  console.log(x);
  console.log(resultset);
  sessionStorage.setItem("storeaddress",resultset[x]);
  
  getzip(resultset[x])
}

function getzip(lawda){
  
  var geocoder;
  geocoder = new google.maps.Geocoder()
  var address = lawda;

  geocoder.geocode( { 'address': address}, function(results, status) {
    if (status == 'OK') {
        zipcoder = (results[0]['address_components'][7]['long_name']);
        console.log(zipcoder); 
        denddem(zipcoder)
    } else {
      alert('Geocode was not successful for the following reason: ' + status);
    }
  });
  
}

function denddem(zipcoder){

  var name = zipcoder;
  $.ajax({
  url     : 'Foodslist',
  method     : 'GET',
  data     : {name : name},
  success    : function(resultText){
    console.log('sucessfull');
  },
  error : function(jqXHR, exception){
  console.log('Error occured!!');
  }
  });

}



